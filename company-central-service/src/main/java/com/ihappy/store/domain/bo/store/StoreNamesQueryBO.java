package com.ihappy.store.domain.bo.store;

import java.util.List;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 15:43
 * *@content
 **/
public class StoreNamesQueryBO {
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 门店id
     */
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
