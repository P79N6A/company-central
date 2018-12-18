package com.ihappy.store.domain.dto.request.store;

import com.ihappy.store.exception.StoreException;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

/**
 * @program: company-central
 * @description: 门店信息查询请求参数
 * @author: 汪正
 * @create: 2018-07-30 13:37
 **/
public class StoreInfoQueryReqDTO  extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 3946072931671625250L;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 企业id
     */
    private Long compId;

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

    @Override
    public void validation() {
        super.validation();
        if (compId == null) {
            throw new StoreException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (StringUtil.isEmpty(storeName)) {
            throw new StoreException(StoreErrorCodeEnum.
                    STORE_NAME_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_NAME_IS_NULL.getErrMsg());
        }
    }

}
