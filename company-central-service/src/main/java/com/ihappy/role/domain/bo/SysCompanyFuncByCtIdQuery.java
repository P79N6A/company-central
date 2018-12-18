package com.ihappy.role.domain.bo;

public class SysCompanyFuncByCtIdQuery {

    /**
     * 业务类型
     * 企业业务分类id，和对应菜单1对多，必须选择的所属企业分类id
     */
    private Integer ctId;

    /**
     * 客户端id
     * 默认移动端
     */
    private Integer clientId;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
