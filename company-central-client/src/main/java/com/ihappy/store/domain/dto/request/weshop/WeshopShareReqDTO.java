package com.ihappy.store.domain.dto.request.weshop;

import com.ihappy.store.exception.StoreException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * Created by sunjd on 2018/7/7.
 */
public class WeshopShareReqDTO extends ICallRequestBaseQuery {
    /**
     * android:1,
     * iphone:2,
     * ipad: 3,
     * pc：4
     */
    private Integer type;
    /**
     * 公司id
     */
    private Long compId;
    /**
     * 门店id
     */
    private Long storeId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (compId == null) {
            throw new StoreException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrCode(), CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (storeId == null) {
            throw new StoreException(StoreErrorCodeEnum.STORE_ID_IS_NULL.getErrCode(), StoreErrorCodeEnum.STORE_ID_IS_NULL.getErrMsg());
        }
    }
}