package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.service.outside.user.UserInfoOutSideService;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.request.user.UserInfoReqDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.enumtype.CompanyRoleEnum;
import com.ihappy.role.domain.bo.QueryCompanyRolePageBO;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.store.domain.dto.request.store.StoreManagerQueryReqDTO;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/11/1.
 */
public class QueryStoreManagerProcess extends DefaultQueryProcess<StoreManagerQueryReqDTO, List<UserInfoRespDTO>> {
    @Autowired
    private UserInfoOutSideService userInfoOutSideService;
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Override
    public void process(Context<StoreManagerQueryReqDTO, List<UserInfoRespDTO>> context) {
        StoreManagerQueryReqDTO reqDTO = context.getParam();
        List<UserInfoRespDTO> respDTOS = new ArrayList<UserInfoRespDTO>();
        if (reqDTO.getType() == 1){
            QueryCompanyRolePageBO queryCompanyRolePageBO = new QueryCompanyRolePageBO();
            queryCompanyRolePageBO.setCompId(reqDTO.getCompId().intValue());
            queryCompanyRolePageBO.setRoleNo(CompanyRoleEnum.SHOP_MANAGER.getKey().toString());
            List<CompanyRoleModel> companyRoleModels = companyRoleService.findCompRoleByCondition(queryCompanyRolePageBO);

            List<Long> roleIds = new ArrayList<Long>();
            roleIds.add(CompanyRoleEnum.SHOP_MANAGER.getKey().longValue());
            if (!CollectionUtils.isEmpty(companyRoleModels)){
                companyRoleModels.forEach((obj)->{
                    roleIds.add(obj.getDO().getRoleId());
                });
            }
            if (!CollectionUtils.isEmpty(roleIds)){
                UserInfoReqDTO userInfoReqDTO = new UserInfoReqDTO();
                userInfoReqDTO.setCompId(reqDTO.getCompId());
                userInfoReqDTO.setDeletedFlag(0);
                userInfoReqDTO.setStoreIdList(Arrays.asList(reqDTO.getStoreId()));
                userInfoReqDTO.setRoleIdList(roleIds);
                respDTOS = userInfoOutSideService.queryPersonInfoOrgBaseList(userInfoReqDTO,true);
            }
            if (CollectionUtils.isEmpty(respDTOS)){
                CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
                companyInfoByCompIdQuery.setCompId(reqDTO.getCompId().intValue());
                CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
                if (companyModel != null){
                    BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(reqDTO.getCompId(),companyModel.getDO().getAdminPersonId(), ConfigCenterUtil.ENV);
                    if (orgRespDTO != null){
                        UserInfoRespDTO userInfoRespDTO = new UserInfoRespDTO();
                        userInfoRespDTO.setCompId(reqDTO.getCompId());
                        userInfoRespDTO.setPersonId(orgRespDTO.getPersonId());
                        userInfoRespDTO.setPersonName(orgRespDTO.getPersonName());
                        userInfoRespDTO.setAvatar(orgRespDTO.getAvatar());
                        userInfoRespDTO.setPersonMobile(orgRespDTO.getMobile());
                        respDTOS.add(userInfoRespDTO);
                    }
                }
            }
        }
        context.getResult().setModule(respDTOS);
    }
}
