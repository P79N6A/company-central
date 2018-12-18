package com.ihappy.role.infrastructure.service.inside.impl;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.role.domain.bo.RoleRightsBO;
import com.ihappy.role.domain.bo.SysCompanyRoleBO;
import com.ihappy.role.domain.bo.SysCompanyRoleConfigBO;
import com.ihappy.role.domain.dbdo.sys.SysCompanyFunc;
import com.ihappy.role.domain.dbdo.sys.SysCompanyRole;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleInfoQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleAndFuncQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.RoleRightsMenuListQueryRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.sys.SysCompanyFuncMapper;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.sys.SysCompanyRoleMapper;
import com.ihappy.role.infrastructure.service.CompanyRoleReadService;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by sunjd on 2018/4/4.
 */
public class SysCompanyRoleServiceImpl implements SysCompanyRoleService {
    @Autowired
    private SysCompanyRoleMapper sysCompanyRoleMapper;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private SysCompanyFuncMapper sysCompanyFuncMapper;
    @Autowired
    private CompanyRoleReadService companyRoleReadService;

    @Override
    public List<SysCompanyRoleModel> findSysRoleListByRoleIdList(List<Long> roleIdList) {
        List<SysCompanyRole> sysCompanyRoles = sysCompanyRoleMapper.selectByPrimaryKeyList(roleIdList);
        List<SysCompanyRoleModel> models = new ArrayList<>();
        if (CollectionUtils.isEmpty(sysCompanyRoles)) {
            return models;
        }
        sysCompanyRoles.forEach((obj) -> {
            models.add(new SysCompanyRoleModel(obj));
        });
        return models;
    }

    @Override
    public List<SysCompanyRole> findAllSysRoleListByRoleIdList() {
        return sysCompanyRoleMapper.selectAllList();
    }

    @Override
    public List<CompanyRoleBO> findAllSysRoleListByCtIds(String ctIds) {
        if (StringUtils.isEmpty(ctIds)) {
            return new ArrayList<>();
        }
        List<String> ctIdList = Arrays.asList(ctIds.split(","));
        List<SysCompanyRole> allSysCompanyRoles = sysCompanyRoleMapper.selectAllList();
        List<CompanyRoleBO> allCompanyRoleBO = CompanyRoleFactory.sysCompanyRoleListToCompanyRoleBOList(allSysCompanyRoles);
        List<CompanyRoleBO> res = new ArrayList<CompanyRoleBO>();
        Boolean exitFor = false;
        for (CompanyRoleBO obj : allCompanyRoleBO) {
            exitFor = false;
            if (!CollectionUtils.isEmpty(obj.getRoleRightsList())) {
                for (RoleRightsBO roleRightsBO : obj.getRoleRightsList()) {
                    for (String ctid : ctIdList) {
                        if (ctid.equals(roleRightsBO.getCtId())) {
                            obj.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
                            obj.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                            res.add(obj);
                            exitFor = true;
                            break;
                        }
                    }
                    if (exitFor) break;
                }
            }
        }
        return res;
    }

    @Override
    public List<CompanyRoleBO> findAllSysRoleListByCompIds(List<Long> compIds) {
        if (CollectionUtils.isEmpty(compIds)) {
            return new ArrayList<>();
        }
        List<Integer> ids = new ArrayList<Integer>();
        compIds.forEach((obj) -> {
            ids.add(Integer.valueOf(obj.toString()));
        });
        List<CompanyModel> companyModels = companyInfoService.queryCompanyInfoListByIds(ids);
        if (CollectionUtils.isEmpty(companyModels)) {
            return new ArrayList<>();
        }
        Set<String> ctIds = new HashSet<String>();
        for (CompanyModel obj : companyModels) {
            ctIds.add(obj.getDO().getCtIds());
        }
        return findAllSysRoleListByCtIds(String.join(",", ctIds));
    }

    @Override
    public List<SysCompanyRoleModel> findSysCompanyRoleConfigList(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        List<SysCompanyRoleModel> list = new ArrayList<>();
        List<SysCompanyRole> roles = sysCompanyRoleMapper.selectSysCompanyRoleConfigList(sysCompanyRoleConfigBO);
        if (!CollectionUtils.isEmpty(roles)) {
            for (SysCompanyRole sysCompanyRole : roles) {
                if (sysCompanyRole != null) {
                    list.add(new SysCompanyRoleModel(sysCompanyRole));
                }
            }
        }
        return list;
    }

    @Override
    public List<SysCompanyRoleModel> findSysCompanyRoleList(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        List<SysCompanyRoleModel> list = new ArrayList<>();
        List<SysCompanyRole> roles = sysCompanyRoleMapper.selectSysCompanyRoleList(sysCompanyRoleConfigBO);
        if (!CollectionUtils.isEmpty(roles)) {
            for (SysCompanyRole sysCompanyRole : roles) {
                if (sysCompanyRole != null) {
                    list.add(new SysCompanyRoleModel(sysCompanyRole));
                }
            }
        }
        return list;
    }

    @Override
    public Integer findSysCompanyRoleConfigListRoleCount(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        Integer roleCount = sysCompanyRoleMapper.selectSysCompanyRoleConfigListRoleCount(sysCompanyRoleConfigBO);
        if (roleCount == null) {
            return null;
        }
        return roleCount;
    }

    @Override
    public SysCompanyRoleModel findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        SysCompanyRole roleInfo = sysCompanyRoleMapper.selectSysCompanyRoleConfigRoleInfoByRoleId(sysCompanyRoleConfigBO);
        if (roleInfo == null) {
            return null;
        }
        return new SysCompanyRoleModel(roleInfo);
    }

    @Override
    public Integer editSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        Integer updateRoleInfo = sysCompanyRoleMapper.updateSysCompanyRoleConfigRoleInfoByRoleId(sysCompanyRoleConfigBO);
        if (updateRoleInfo == null || updateRoleInfo <= 0) {
            return null;
        }
        return updateRoleInfo;
    }

    @Override
    public Integer removeSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        Integer deleteRole = sysCompanyRoleMapper.deleteSysCompanyRoleConfigRoleInfoByRoleId(sysCompanyRoleConfigBO);
        return deleteRole;
    }

    @Override
    public Integer addSysCompanyRoleConfigRole(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        Integer addSysCompanyRole = sysCompanyRoleMapper.addSysCompanyRoleConfigRole(sysCompanyRoleConfigBO);
        if (addSysCompanyRole == null || addSysCompanyRole <= 0) {
            return null;
        }
        return addSysCompanyRole;
    }

    @Override
    public SysCompanyRoleModel checkSysCompanyRoleNameIsOrNotExisit(SysCompanyRoleConfigBO sysCompanyRoleConfigBO) {
        SysCompanyRole checkName = sysCompanyRoleMapper.checkSysCompanyRoleNameIsOrNotExisit(sysCompanyRoleConfigBO);
        if (checkName == null) {
            return null;
        }
        return new SysCompanyRoleModel(checkName);
    }

    @Override
    public List<SysCompanyRoleModel> findSyCompanyRoleList(SysCompanyRoleBO sysCompanyRoleBO) {
        List<SysCompanyRoleModel> sysCompanyRoleModelList = new ArrayList<>();
        List<SysCompanyRole> sysCompanyRolesList = sysCompanyRoleMapper.selectSyCompanyRoleList(sysCompanyRoleBO);
        for (SysCompanyRole sysCompanyRole : sysCompanyRolesList) {
            sysCompanyRoleModelList.add(new SysCompanyRoleModel(sysCompanyRole));
        }
        return sysCompanyRoleModelList;
    }

    @Override
    public SysCompanyRoleModel finsSysCompanyRoleInfo(SysCompanyRoleBO sysCompanyRoleBO) {
        SysCompanyRole roleInfo = sysCompanyRoleMapper.selectSysCompanyRoleInfo(sysCompanyRoleBO);
        if (roleInfo == null) {
            return null;
        }
        return new SysCompanyRoleModel(roleInfo);
    }

    @Override
    public List<SysCompanyRoleModel> findRoleListByCondition(SysCompanyRoleBO sysCompanyRoleBO) {
        List<SysCompanyRoleModel> sysCompanyRoleModelList = new ArrayList<>();
        List<SysCompanyRole> sysCompanyRoleList = sysCompanyRoleMapper.queryRoleListByCondition(sysCompanyRoleBO);
        CompanyModel companyModel =    //根据公司id查询公司信息
                companyInfoService.selectCompanyInfo(BaseinfoCompanyFactory.sysCompanyRoleBOToCompanyInfoByCompIdQuery(sysCompanyRoleBO));
        if (companyModel == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }
        for (SysCompanyRole sysCompanyRole:sysCompanyRoleList ){
            sysCompanyRoleModelList.add(new SysCompanyRoleModel(sysCompanyRole));
        }
        return sysCompanyRoleModelList;
    }
}



