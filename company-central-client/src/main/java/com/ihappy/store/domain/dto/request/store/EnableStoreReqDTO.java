package com.ihappy.store.domain.dto.request.store;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/16 13:04
 * *@content
 **/
public class EnableStoreReqDTO extends ICallRequestBaseDTO {
    @FieldComment(value = "门店id",required = true)
    private Long storeId;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (storeId==null||storeId<0){
            throw new CompanyException(CompanyErrorCodeEnum.STORE_ID_IS_NULL);
        }
        if (getLoginCompId() == null || getLoginCompId() <=0L || getLoginPersonId() == null || getLoginPersonId() <= 0L){
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }
}
