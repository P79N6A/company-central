package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

public class SysCompanyRoleInfoTypeClientFuncListQueryRespDTO extends ICallResponseBaseDTO {
    private SysCompanyRoleConfigRoleListQueryRespDTO roleInfo;
    private List<SysCompanyRoleConfigRoleInfoMenuRespDTO> menu;

    public SysCompanyRoleConfigRoleListQueryRespDTO getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(SysCompanyRoleConfigRoleListQueryRespDTO roleInfo) {
        this.roleInfo = roleInfo;
    }

    public List<SysCompanyRoleConfigRoleInfoMenuRespDTO> getMenu() {
        return menu;
    }

    public void setMenu(List<SysCompanyRoleConfigRoleInfoMenuRespDTO> menu) {
        this.menu = menu;
    }
}
