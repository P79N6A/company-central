package com.ihappy.store.domain.dto.request.store;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.exception.StoreException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/11/1.
 */
public class StoreManagerQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -2549983951575311121L;
    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long storeId;

    @FieldComment(value = "企业id",required = false,defaultValue = "")
    private Long compId;

    @FieldComment(value = "1-查询店长，没有则查询老板(默认)",required = false,defaultValue = "1")
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public void validation(){
        if (compId == null || compId <=0|| storeId == null || storeId <= 0){
            throw new StoreException(StoreErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }
}
