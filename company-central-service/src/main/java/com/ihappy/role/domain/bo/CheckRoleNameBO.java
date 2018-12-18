package com.ihappy.role.domain.bo;

public class CheckRoleNameBO {
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 描述
     */
    private String roleMemo;
    /**
     * 1-隐藏，0-不隐藏 默认1
     */
    private Integer isHide;
    /**
     * 公司角色权限 {1:’1,2,3,4’,2:’2,3,4,5’}
     */
    private String roleRights;

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

    public String getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(String roleRights) {
        this.roleRights = roleRights;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
