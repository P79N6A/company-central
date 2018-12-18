package com.ihappy.store.domain.bo.store;

import java.util.List;

public class QueryStoreListByCompIdAndStoreIdsBO {
    private Integer compId;
    private List<Long> storeIds;
    private Integer available;
    /**
     * 门店禁用过滤条件，是否过滤：null 是
     */
    private Integer filterForbidden;

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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

    public Integer getFilterForbidden() {
        return filterForbidden;
    }

    public void setFilterForbidden(Integer filterForbidden) {
        this.filterForbidden = filterForbidden;
    }
}
