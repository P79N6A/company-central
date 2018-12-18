package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

public class CompanyRoleAndFuncQueryRespDTO extends ICallResponseBaseDTO {

    /**
     * 角色详情
     */
    private CompanyRoleInfoQueryRespDTO roleInfo;
    /**
     * 角色权限
     */
    private List<RoleRightsMenuListQueryRespDTO> menuList;

    public CompanyRoleInfoQueryRespDTO getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(CompanyRoleInfoQueryRespDTO roleInfo) {
        this.roleInfo = roleInfo;
    }

    public List<RoleRightsMenuListQueryRespDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<RoleRightsMenuListQueryRespDTO> menuList) {
        this.menuList = menuList;
    }

}
