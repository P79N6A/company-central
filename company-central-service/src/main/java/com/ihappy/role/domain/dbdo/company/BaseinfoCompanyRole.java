package com.ihappy.role.domain.dbdo.company;

public class BaseinfoCompanyRole {
    private Integer limit;
    private Integer offset;
    /**
     *
     * 角色id
     */
    private Long roleId;

    /**
     *
     * 角色名称
     */
    private String roleName;

    /**
     *
     * 角色编号
     */
    private String roleNo;

    /**
     *
     * 角色简介
     */
    private String roleMemo;

    /**
     *
     *角色权限
     */
    private String roleRights;

    /**
     *
     * 排序
     */
    private Integer roleSort;

    /**
     *
     * 公司id
     */
    private Integer compId;

    /**
     *创建时间
     */
    private Long createdAt;

    /**
     *
     * 更新时间
     */
    private Long updatedAt;

    /**
     *
     * 创建人
     */
    private Long createdPersonId;

    /**
     *
     * 更新人
     */
    private Long updatedPersonId;

    /**
     * 是否删除
     *
     */
    private Integer isDeleted;

    /**
     * 0 表示不隐藏 1表示隐藏
     */
    private Integer isHide;
    /**
     * 是否系统默认添加   0：非默认   1：默认
     */
    private Integer isDefault;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo == null ? null : roleMemo.trim();
    }

    public String getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(String roleRights) {
        this.roleRights = roleRights == null ? null : roleRights.trim();
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }
}