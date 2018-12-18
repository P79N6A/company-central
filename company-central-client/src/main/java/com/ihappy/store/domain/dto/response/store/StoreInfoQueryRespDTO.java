package com.ihappy.store.domain.dto.response.store;

import java.io.Serializable;

/**
 * @program: company-central
 * @description: 门店信息查询返回参数
 * @author: 汪正
 * @create: 2018-07-30 13:40
 **/
public class StoreInfoQueryRespDTO implements Serializable {
    private static final long serialVersionUID = 3946072931671625250L;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 门店编号
     */
    private String storeNo;
    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 企业id
     */
    private Long compId;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }
}
