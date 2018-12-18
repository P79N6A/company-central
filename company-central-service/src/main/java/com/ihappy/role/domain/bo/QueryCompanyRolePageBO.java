package com.ihappy.role.domain.bo;

public class QueryCompanyRolePageBO {
    /**
     * 公司ID
     */
    private Integer compId;

    /**
     *限制条数
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

    private String roleNo;

    private Integer isDeleted;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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
}
