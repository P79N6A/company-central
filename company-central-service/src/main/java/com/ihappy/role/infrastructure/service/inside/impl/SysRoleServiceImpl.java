package com.ihappy.role.infrastructure.service.inside.impl;

import com.ihappy.role.domain.bo.CheckRoleNameBO;
import com.ihappy.role.domain.bo.SysRoleManageBO;
import com.ihappy.role.domain.dbdo.sys.SysRole;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.sys.SysRoleMapper;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRoleModel> findRoleListByRoleIdList(List<Long> roleIdList) {
        if (CollectionUtils.isEmpty(roleIdList)) {
            return new ArrayList<>();
        }
        List<SysRole> sysRoles = sysRoleMapper.selectByPrimaryKeyList(roleIdList);
        if (CollectionUtils.isEmpty(sysRoles)) {
            return new ArrayList<>();
        }
        List<SysRoleModel> res = new ArrayList<SysRoleModel>();
        for (SysRole obj : sysRoles) {
            res.add(new SysRoleModel(obj));
        }

        return res;
    }

    @Override
    public List<SysRoleModel> findSysRoleManagePage(SysRoleManageBO sysRoleManageBO) {
        List<SysRoleModel> list = new ArrayList<>();
        List<SysRole> roles = sysRoleMapper.selectSysRoleManagePage(sysRoleManageBO);
        if (!CollectionUtils.isEmpty(roles)) {
            for (SysRole sysRole : roles) {
                if (sysRole != null) {
                    list.add(new SysRoleModel(sysRole));
                }
            }
        }
        return list;
    }

    @Override
    public Integer findSysRoleManagePageRoleCount(SysRoleManageBO sysRoleManageBO) {
        Integer role = sysRoleMapper.selectSysRoleManagePageRoleCount(sysRoleManageBO);
        return role;
    }

    @Override
    public SysRoleModel checkSysRoleNameIsOrNotRepeat(CheckRoleNameBO checkRoleNameBO) {
        SysRole checkRoleNameIsOrNotRepeat = sysRoleMapper.selectCheckRoleNameIsOrNotRepeat(checkRoleNameBO);
        if (checkRoleNameIsOrNotRepeat == null){
            return null;
        }
        return new SysRoleModel(checkRoleNameIsOrNotRepeat);
    }

    @Override
    public SysRoleModel findSysRoleManageRoleInfoByRoleId(SysRoleManageBO sysRoleManageBO) {
        SysRole roleInfo = sysRoleMapper.selectSysRoleManageRoleInfoByRoleId(sysRoleManageBO);
        if (roleInfo == null ){
            return null;
        }
        return new SysRoleModel(roleInfo);
    }

    @Override
    public Integer addSysRoleManageRoleInfo(SysRoleManageBO sysRoleManageBO) {
        return sysRoleMapper.addSysRoleManageRoleInfo(sysRoleManageBO);
    }

    @Override
    public Integer editSysRoleManageRoleInfoByRoleId(SysRoleManageBO sysRoleManageBO) {
        Integer updateRole = sysRoleMapper.updateSysRoleManageRoleInfoByRoleId(sysRoleManageBO);
        return updateRole;
    }

    @Override
    public Integer removeSysRoleManageRoleInfoByRoleId(SysRoleManageBO sysRoleManageBO) {
        Integer removeRole = sysRoleMapper.deleteSysRoleManageRoleInfoByRoleId(sysRoleManageBO);
        return removeRole;
    }



}
