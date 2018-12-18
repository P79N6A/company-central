package com.ihappy.store.domain.dto.request.weshop;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;

/**
 **/
public class CompanyWeshopCollectionReqDTO extends ICallRequestBaseDTO {

    /**
     * 登陆token
     */
    private String loginTokenId;
    /**
     *   收藏店铺ID
     */
    private Long storeId;

    /**
     *   收藏店铺ID
     */
    private Long compId;

    /**
     *   操作类型 1添加收藏，2取消收藏
     */
    private Integer operateType;

    public String getLoginTokenId() {
        return loginTokenId;
    }

    public void setLoginTokenId(String loginTokenId) {
        this.loginTokenId = loginTokenId;
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

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    @Override
    public void validation() {
        if(null == compId){
            throw new StoreException(StoreErrorCodeEnum.
                    WESHOP_COLLECTION_STORE_COMP_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.WESHOP_COLLECTION_STORE_COMP_IS_NULL.getErrMsg());
        }
        if(null == storeId){
            throw new StoreException(StoreErrorCodeEnum.
                    WESHOP_COLLECTION_STORE_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.WESHOP_COLLECTION_STORE_IS_NULL.getErrMsg());
        }
        if(null == operateType){
            throw new StoreException(CompanyErrorCodeEnum.
                    WESHOP_COLLECTION_OPERATE_TYPE_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.WESHOP_COLLECTION_OPERATE_TYPE_IS_NULL.getErrMsg());
        }

    }
}
