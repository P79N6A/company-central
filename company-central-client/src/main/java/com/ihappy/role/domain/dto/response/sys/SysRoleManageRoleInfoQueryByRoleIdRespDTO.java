package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

public class SysRoleManageRoleInfoQueryByRoleIdRespDTO extends ICallResponseBaseDTO {
    /**
     * 角色信息
     */
    private SysRoleManageRoleInfo roleInfo;
    /**
     * 角色菜单
     */
    private List<SysRoleManageRoleMenu> memu;

    public SysRoleManageRoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(SysRoleManageRoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    public List<SysRoleManageRoleMenu> getMemu() {
        return memu;
    }

    public void setMemu(List<SysRoleManageRoleMenu> memu) {
        this.memu = memu;
    }
}
