package com.ihappy.store.domain.bo.store;

/**
 * Created by chenying on 2018/8/30.
 */
public class CheckStoreNameBO {
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 是否删除
     */
    private Integer deleteFlag;

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
