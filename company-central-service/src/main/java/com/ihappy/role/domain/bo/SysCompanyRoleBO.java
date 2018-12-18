package com.ihappy.role.domain.bo;

/**
 * created by zhangmengdan
 * created at 2018/8/25
 */
public class SysCompanyRoleBO {
    private Integer userId;
    /**
     * 业务分类id
     */
    private Integer ctId;
    /**
     * 客户端id
     */
    private Integer clId;
    /**
     * 是否删除 1删除 2未删除
     */
    private Integer isDeleted;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 限制条数
          */
    private Integer limit;
    /**
     * 起始位置
     */
    private Integer offset;
    /**
    *创建人
     */
    private Long createdPersonId;

    /**
     * 角色名称
     * @return
     */
    private String roleName;
    /**
     * 公司id
     */
    private Integer compId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }
}
