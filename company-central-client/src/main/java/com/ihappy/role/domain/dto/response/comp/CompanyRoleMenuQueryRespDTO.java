package com.ihappy.role.domain.dto.response.comp;

import java.util.List;


public class CompanyRoleMenuQueryRespDTO {
    private List<CompanyRoleMenuListQueryRespDTO> menuList;

    public List<CompanyRoleMenuListQueryRespDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<CompanyRoleMenuListQueryRespDTO> menuList) {
        this.menuList = menuList;
    }
}
