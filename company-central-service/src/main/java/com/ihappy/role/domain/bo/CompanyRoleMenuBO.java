package com.ihappy.role.domain.bo;

public class CompanyRoleMenuBO {
    /**
     * 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;
    /**
     * 客户端ID
     */
    private Integer clId;
    /**
     * 业务分类ID
     */
    private Integer ctId;

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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
