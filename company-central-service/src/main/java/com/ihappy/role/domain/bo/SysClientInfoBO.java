package com.ihappy.role.domain.bo;

public class SysClientInfoBO {
    /**
     * 客户端ID
     */
    private Integer clId;
    /**
     * 是否删除
     */
    private Integer isDeleted;

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
