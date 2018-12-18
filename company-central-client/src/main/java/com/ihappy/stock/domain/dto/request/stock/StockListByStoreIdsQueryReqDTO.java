package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.stock.exception.StockException;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by sunjd on 2018/5/17.
 */
public class StockListByStoreIdsQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 3750671098537897746L;
    /**
     * 企业id
     */
    private Long compId;
    /**
     * 是否公共仓库  1：公共仓库  0：非公共仓库  null:全部
     */
    private Integer isPublic;
    /**
     * 门店id列表
     */
    private List<Long> storeIds;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public void validation() {
        if (CollectionUtils.isEmpty(storeIds)) {
            throw new StockException(StoreErrorCodeEnum.
                    STORE_ID_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_ID_IS_NULL.getErrMsg());
        }
        if (compId == null) {
            throw new StockException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
    }
}
