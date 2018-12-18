package com.ihappy.stock.domain.dto.response.stock;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/5/17.
 */
public class StockListByStoreIdsQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 4492490658799354341L;
    /**
     * 门店Id-仓库List map
     */
    private Map<Long,List<StockRespDTO>> storeStocks;

    public Map<Long, List<StockRespDTO>> getStoreStocks() {
        return storeStocks;
    }

    public void setStoreStocks(Map<Long, List<StockRespDTO>> storeStocks) {
        this.storeStocks = storeStocks;
    }
}
