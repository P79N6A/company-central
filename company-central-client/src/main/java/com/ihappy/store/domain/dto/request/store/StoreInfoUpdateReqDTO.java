package com.ihappy.store.domain.dto.request.store;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/10/19.
 */
public class StoreInfoUpdateReqDTO extends ICallRequestBaseDTO {
    @FieldComment(value = "门店id",required = true,defaultValue = "")
    private Long storeId;
    @FieldComment(value = "企业id",required = false,defaultValue = "")
    private Long compId;
    @FieldComment(value = "支付备注",required = false,defaultValue = "")
    private String payRemark;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    @Override
    public void validation() {
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (storeId == null){
            throw new StoreException(StoreErrorCodeEnum.
                    STORE_ID_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_ID_IS_NULL.getErrMsg());
        }
    }
}
