package com.ihappy.store.domain.dto.request.weshop;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * @program: company-central
 * @description: 门店查询 （微商铺等）
 * @author: 汪正
 * @create: 2018-05-16 14:20
 **/
public class WeshopListQueryReqDTO extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 5390506506983027478L;
    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 门店类型  0 直营店 1 加盟店 2 联营店
     */
    private String storeType;
    /**
     * 是否具有微商铺。
     */
    private Integer isHasWeshop;
    /**
     * 微商铺名称
     */
    private String weshopName;
    /**
     *  微商铺类型 默认全部0  已购 1   收藏 2
     */
    private Integer weshopType;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public Integer getIsHasWeshop() {
        return isHasWeshop;
    }

    public void setIsHasWeshop(Integer isHasWeshop) {
        this.isHasWeshop = isHasWeshop;
    }

    public String getWeshopName() {
        return weshopName;
    }

    public void setWeshopName(String weshopName) {
        this.weshopName = weshopName;
    }

    public Integer getWeshopType() {
        return weshopType;
    }

    public void setWeshopType(Integer weshopType) {
        this.weshopType = weshopType;
    }
}
