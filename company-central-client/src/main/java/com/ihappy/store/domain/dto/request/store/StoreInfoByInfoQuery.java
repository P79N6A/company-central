package com.ihappy.store.domain.dto.request.store;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by liuhc on 2018/6/16.
 */
public class StoreInfoByInfoQuery extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 3946072931671625250L;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 企业id
     */
    private Long compId;

    /**
     * 0 门店 1 默认门店
     */
    private Integer defaultFlag;

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

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

    @Override
    public void validation() {
        if (compId == null) {
            throw new StoreException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
