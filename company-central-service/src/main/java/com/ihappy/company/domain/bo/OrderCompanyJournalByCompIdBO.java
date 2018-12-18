package com.ihappy.company.domain.bo;

import java.util.List;

/**
 * Created by liuhc on 2018/7/9.
 */
public class OrderCompanyJournalByCompIdBO {

    /**
     * 公司id
     */
    private Long compId;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 0:正常 1作废
     */
    private Integer isCancel;

    /**
     * 集合
     */
    private List<Integer> cancelList;

    /**
     * 来源订单号
     */
    private String sourceOrderNo;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    public List<Integer> getCancelList() {
        return cancelList;
    }

    public void setCancelList(List<Integer> cancelList) {
        this.cancelList = cancelList;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
