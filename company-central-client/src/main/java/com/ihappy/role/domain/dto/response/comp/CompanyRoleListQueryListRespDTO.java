package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class CompanyRoleListQueryListRespDTO extends ICallResponseBaseDTO {
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
     * 角色描述
     */
    private String roleMemo;
    /**
     * 是否隐藏 1隐藏 0不隐藏 默认1
     */
    private Integer isHide;

    /**
     * 0 不是系统角色 1是系统角色
     */
    private Integer systemFlag;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
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

    public Integer getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(Integer systemFlag) {
        this.systemFlag = systemFlag;
    }
}
