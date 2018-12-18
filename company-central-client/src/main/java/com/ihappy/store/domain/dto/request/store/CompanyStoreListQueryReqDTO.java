package com.ihappy.store.domain.dto.request.store;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.store.exception.StoreException;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by sunjd on 2018/4/10.
 * 查询门店列表
 */
public class CompanyStoreListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -6613351202552702428L;
    /**
     * 公司id
     */
    @NotNull
    private Integer compId;
    /**
     * 门店id
     */
    private List<Long> storeIds;
    /**
     * 1:全部  2：过滤已过期
     */
    private Integer available;
    /**
     * 门店禁用过滤条件，是否过滤：null 是
     */
    private Integer filterForbidden;

    public Integer getFilterForbidden() {
        return filterForbidden;
    }

    public void setFilterForbidden(Integer filterForbidden) {
        this.filterForbidden = filterForbidden;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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
