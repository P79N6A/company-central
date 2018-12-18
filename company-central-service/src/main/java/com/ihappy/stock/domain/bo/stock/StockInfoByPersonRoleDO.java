package com.ihappy.stock.domain.bo.stock;

/**
 * Created by Administrator on 2018/5/8.
 */
public class StockInfoByPersonRoleDO {

    private Long loginPersonId;

    private Integer loginCompId;

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getLoginPersonId() {
        return loginPersonId;
    }

    public void setLoginPersonId(Long loginPersonId) {
        this.loginPersonId = loginPersonId;
    }


    public Integer getLoginCompId() {
        return loginCompId;
    }

    public void setLoginCompId(Integer loginCompId) {
        this.loginCompId = loginCompId;
    }
}
