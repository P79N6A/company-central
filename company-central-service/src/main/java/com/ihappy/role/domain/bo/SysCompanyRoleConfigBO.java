package com.ihappy.role.domain.bo;

public class SysCompanyRoleConfigBO {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色编码
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
     * 角色权限
     */
    private String roleRights;
    /**
     * 0-否，非系统，前端显示，需要进行过滤，1-用户平台
     */
    private Integer isSys;
    /**
     * 限制条数
     */
    private Integer limit;
    /**
     * 起始位置
     */
    private Integer offset;
    /**
     * 关键词，角色名称模糊查询
     */
    private String keyWords;
    /**
     * 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;
    /**
     * 角色排序
     */
    private Integer roleSort;

    public Integer getRoleSort() {
        return roleSort;
    }

    /**
     * 创建时间
     */
    private Long createdAt;
    /**
     * 创建人
     */
    private Long createdPersonId;
    /**
     * 更新时间
     */
    private Long updatedAt;
    /**
     * 更新人
     */
    private Long updatedPersonId;
    /**
     * 是否隐藏 1 隐藏 0 不隐藏
     */
    private Integer isHide;

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsSys() {
        return isSys;
    }

    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
    }

    public String getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(String roleRights) {
        this.roleRights = roleRights;
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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
