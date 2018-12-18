package com.ihappy.company.domain.bo;

public class SysCompanyTypeBO {
    /**
     * 0-否，非系统，前端显示，需要进行过滤，1-用户平台 默认0
     */
    private Integer isSys;
    /**
     * 是否
     */
    private Integer isDeleted;
    /**
     * 业务分类id
     */
    private Integer ctId;
    /**
     * 客户端id
     */
    private Integer clId;

    public Integer getIsSys() {
        return isSys;
    }

    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
