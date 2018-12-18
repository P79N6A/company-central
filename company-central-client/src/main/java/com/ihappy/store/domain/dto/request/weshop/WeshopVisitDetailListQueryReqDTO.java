package com.ihappy.store.domain.dto.request.weshop;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * @program: company-central
 * @description: 门店查询 （微商铺等）
 * @author: 汪正
 * @create: 2018-05-16 14:20
 **/
public class WeshopVisitDetailListQueryReqDTO extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 5390506506983027478L;
    /**
     * 门店所属公司id
     */
    private Integer compId;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 是否具有微商铺。
     */
    private Integer isHasWeshop;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getIsHasWeshop() {
        return isHasWeshop;
    }

    public void setIsHasWeshop(Integer isHasWeshop) {
        this.isHasWeshop = isHasWeshop;
    }
}
