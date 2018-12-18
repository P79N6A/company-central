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
public class SharingCompanyStoreInfoQueryReqDTO extends CompanyStroreInfoQueryReqDTO {
    @FieldComment(value = "公司ID", defaultValue = "", required = true)
    private Long compId;

    @Override
    public void validation() {
        if (getCompId() == null || getCompId() < 0L) {
            throw new StoreException(StoreErrorCodeEnum.ILLEGAL_PARAMETER);
        }
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }
}
