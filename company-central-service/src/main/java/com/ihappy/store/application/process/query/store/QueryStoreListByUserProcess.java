package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.CompanyWhiteBlackEnum;
import com.ihappy.company.common.enumtype.ExpireStatusEnum;
import com.ihappy.company.common.enumtype.IsDeletedEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.enumtype.CompanyRoleEnum;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.store.domain.bo.store.CheckCompanyStoreUsingBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListByUserQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.StoreInfoRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sunjd on 2018/4/16.
 */
public class QueryStoreListByUserProcess extends DefaultQueryProcess<CompanyStoreListByUserQueryReqDTO, List<CompanyStoreListQueryRespDTO>> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private CompanyRoleService companyRoleService;

    @Override
    public void process(Context<CompanyStoreListByUserQueryReqDTO, List<CompanyStoreListQueryRespDTO>> context) {
        CompanyStoreListByUserQueryReqDTO companyStoreListByUserQueryReqDTO = context.getParam();
        Long personId = companyStoreListByUserQueryReqDTO.getLoginPersonId();
        Integer compId = Integer.parseInt(companyStoreListByUserQueryReqDTO.getLoginCompId().toString());
        Integer isPublic = companyStoreListByUserQueryReqDTO.getIsPublic();
        Integer forbidden = companyStoreListByUserQueryReqDTO.getForbidden();
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        if (company == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }
        //通过redis获取用户信息
        BaseinfoPersonCompanyOrgRespDTO userinfo = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(Long.parseLong(compId.toString()), personId, ConfigCenterUtil.ENV);
        if (userinfo == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    GET_USER_INFO_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.GET_USER_INFO_ERROR.getErrMsg());
        }
        //门店id列表
        List<Long> storeIds = new ArrayList<Long>();
        //门店列表
        List<CompanyStoreModel> stores = null;
        CompanyRoleEnum companyRoleEnum = companyRoleService.findCompanyRoleInfoByPersonInfo(userinfo, compId);
        if (companyRoleEnum == null) {
            throw new CompanyException(CompanyErrorCodeEnum.GET_USER_INFO_ERROR);
        }
        //本公司超级管理员
        if (companyRoleEnum.isBOSSorPARTNER()) {
            BaseinfoCompanyStore param = new BaseinfoCompanyStore();
            param.setCompId(compId);
            param.setIsPublic(isPublic);
            param.setIsDeleted(IsDeletedEnum.NOT_DELETED.getKey());
            param.setForbidden(forbidden);
            param.setStoreNameSearch(companyStoreListByUserQueryReqDTO.getStoreNameSearch());
            stores = companyStoreService.selectStoreByCondition(param);
        } else {
            List<StoreInfoRespDTO> storeInfoRespDTO = userinfo.getStoreInfoList();
            if (!CollectionUtils.isEmpty(storeInfoRespDTO)) {
                for (StoreInfoRespDTO obj : storeInfoRespDTO) {
                    storeIds.add(Long.parseLong(obj.getStoreId() + ""));
                }
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("compId", compId);
                map.put("storeIds", storeIds);
                map.put("isPublic", isPublic);
                map.put("storeNameSearch", companyStoreListByUserQueryReqDTO.getStoreNameSearch());
                map.put("forbidden",forbidden);
                stores = companyStoreService.findStoreListByCompIdAndStoreIds(map);
            } else {
                //用户无门店权限
            }
        }
        List<CompanyStoreListQueryRespDTO> companyStoreListQueryRespDTOs = CompanyStoreFactory.modelListToRespDTOList(stores);
        Collections.sort(companyStoreListQueryRespDTOs, new Comparator<CompanyStoreListQueryRespDTO>() {
            @Override
            public int compare(CompanyStoreListQueryRespDTO n1, CompanyStoreListQueryRespDTO n2) {
                Integer a = n1.getIsPublic();
                Integer b = n2.getIsPublic();
                return b.compareTo(a);
            }
        });

        if (companyStoreListByUserQueryReqDTO.getUsing()!= null && companyStoreListByUserQueryReqDTO.getUsing() == 0) {
            companyStoreListQueryRespDTOs = companyStoreListQueryRespDTOs.stream().filter(obj -> {
                CheckCompanyStoreUsingBO checkCompanyStoreUsingBO = new CheckCompanyStoreUsingBO();
                checkCompanyStoreUsingBO.setCreatedAt(obj.getCreatedAt());
                checkCompanyStoreUsingBO.setExpireDateLong(obj.getExpireDate());
                checkCompanyStoreUsingBO.setExpireStatusEnum(ExpireStatusEnum.getTbcpNatureEnum(obj.getExpireStatus()));
                checkCompanyStoreUsingBO.setCompanyWhiteBlackEnum(CompanyWhiteBlackEnum.getCompanyStatusEnum(company.getStatus()));
                return companyStoreService.isCompanyStoreUsing(checkCompanyStoreUsingBO);
            }).collect(Collectors.toList());
        }


        context.getResult().setModule(companyStoreListQueryRespDTOs);
    }
}