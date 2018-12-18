package com.ihappy.company.domain.bo;

public class GetCompanyRoleFuncMenuBO {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 创建人id
     */
    private Long created_person_id;
    /**
     * 是否删除
     */
    private Integer isDeleted;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getCreated_person_id() {
        return created_person_id;
    }

    public void setCreated_person_id(Long created_person_id) {
        this.created_person_id = created_person_id;
    }
}
