package com.ihappy.store.domain.dto.request.store;


import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by chenying on 2018/8/27.
 */
public class CompanyStoreAdminDeleteReqDTO extends ICallRequestBaseDTO {

    @FieldComment(value = "门店id")
    private Long storeId;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (storeId == null) {
            throw new StoreException(StoreErrorCodeEnum.
                    STORE_ID_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_ID_IS_NULL.getErrMsg());
        }
        if (this.getLoginCompId() ==null ||this.getLoginPersonId() ==null ||
                this.getLoginCompId() <=0 || this.getLoginPersonId() <=0 ){
            throw new StoreException(StoreErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }
}
