package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.domain.bo.UserInfoBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.company.infrastructure.service.inside.UserInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.item.common.util.ToolConver;
import com.ihappy.role.common.enumtype.CompanyRoleEnum;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.StoreInfoRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/6/22.
 */
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public String getUserRole(UserInfoBO userInfo) {
        if (userInfo == null){
            return "";
        }
        Long personId = userInfo.getPersonId();
        Integer compId = userInfo.getCompId();
        if (personId == null || compId == null){
            return "";
        }
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        //判断是否老板
        if (personId.equals(company.getAdminPersonId())){
            return CompanyRoleEnum.BOSS.getValue();
        }
        //查询用户权限
        BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(compId,personId, ConfigCenterUtil.ENV);
        if(orgRespDTO != null && !StringUtil.isBlank(orgRespDTO.getCompRoleIds()) && !orgRespDTO.getCompRoleIds().equals("0")){
            List<Long> roleIds = ToolConver.getStringParseLong(orgRespDTO.getCompRoleIds());
            List<CompanyRoleModel> companyRoleModels = companyRoleService.findRoleListByRoleIdList(roleIds);
            if (CollectionUtils.isEmpty(companyRoleModels)){
                return CompanyRoleEnum.STAFF.getValue();
            }
            return companyRoleModels.get(0).getDO().getRoleName();
        }
        return CompanyRoleEnum.STAFF.getValue();
    }

    @Override
    public List<Long> getUserStoreId(UserInfoBO userInfo) {
        if (userInfo == null){
            return new ArrayList<Long>();
        }
        Long personId = userInfo.getPersonId();
        Integer compId = userInfo.getCompId();
        if (personId == null || compId == null){
            return new ArrayList<Long>();
        }
        //查询用户权限
        BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(compId,personId, ConfigCenterUtil.ENV);
        List<Long> storeIds = new ArrayList<Long>();
        if (orgRespDTO != null && !CollectionUtils.isEmpty(orgRespDTO.getStoreInfoList())){
            for (StoreInfoRespDTO obj : orgRespDTO.getStoreInfoList()){
                storeIds.add(Long.valueOf(obj.getStoreId()));
            }
        }
        return storeIds;
    }
}
