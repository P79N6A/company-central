package com.ihappy.store.domain.bo.store;

import java.util.List;

/**
 * @program: company-central
 * @description: 门店查询 （微商铺等）
 * @author: 汪正
 * @create: 2018-05-16 14:20
 **/
public class CompanyStoreListQueryByStoreIdsReqBo {

    private static final long serialVersionUID = 5390506506983027478L;
    /**
     * 门店所属公司id
     */
    private Integer compId;
    /**
     * 门店id
     */
    private List<Long> storeIds;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 微商铺名称
     */
    private String weshopName;

    /**
     *   微商铺状态
     */
    private Integer weshopStatus;

    private Integer limit;

    private Integer offset;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getWeshopName() {
        return weshopName;
    }

    public void setWeshopName(String weshopName) {
        this.weshopName = weshopName;
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

    public Integer getWeshopStatus() {
        return weshopStatus;
    }

    public void setWeshopStatus(Integer weshopStatus) {
        this.weshopStatus = weshopStatus;
    }
}
