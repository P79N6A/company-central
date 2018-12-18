package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class CompanyRoleInfoQueryRespDTO extends ICallResponseBaseDTO {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色编号
     */
    private String roleNo;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 描述
     */
    private String roleMemo;
    /**
     * 是否隐藏 1隐藏 0不隐藏 默认1
     */
    private Integer isHide;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }
}
