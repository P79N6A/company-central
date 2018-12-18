package com.ihappy.store.domain.dto.request.store;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/10/18.
 */
public class CompStorePayInfoPageQueryReqDTO extends ICallRequestBaseQuery {

    @FieldComment(value = "门店id", defaultValue = "", required = true)
    private Long storeId;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginCompId() < 0L || getLoginPersonId() == null || getLoginPersonId() < 0L
                || this.getLimit() == null || this.getOffset() == null) {
            throw new StoreException(StoreErrorCodeEnum.ILLEGAL_PARAMETER);
        }
        if (storeId == null || storeId <= 0L) {
            throw new StoreException(StoreErrorCodeEnum.STORE_ID_IS_NULL);
        }
    }
}
