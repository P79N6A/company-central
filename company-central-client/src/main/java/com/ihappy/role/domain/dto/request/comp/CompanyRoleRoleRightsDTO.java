package com.ihappy.role.domain.dto.request.comp;

public class CompanyRoleRoleRightsDTO {
    /**
     * 企业业务分类id，和对应菜单1对多，必须选择的所属企业分类id
     */
     private Integer ctId;
    /**
     * 默认移动端
     */
    private Integer clId;
    /**
     * 功能权限
     */
    private String func;

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
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

    public Integer getCtId() {
        return ctId;
    }
}
