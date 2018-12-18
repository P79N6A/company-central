package com.ihappy.store.domain.dto.request.store;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/11 14:41
 * @Version
 */
public class CompanyStroreInfoQueryReqDTO extends ICallRequestBaseQuery {
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
        if (getLoginCompId() == null || getLoginCompId() < 0L || getLoginPersonId() == null || getLoginPersonId() < 0L) {
            throw new StoreException(StoreErrorCodeEnum.ILLEGAL_PARAMETER);
        }
        if (storeId == null || storeId <= 0L) {
            throw new StoreException(StoreErrorCodeEnum.STORE_ID_IS_NULL);
        }
    }
}
