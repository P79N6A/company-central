package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.store.domain.dto.response.store.StoreRespDTO;

import java.util.List;


/**
 * Created by sunjd on 2018/4/13.
 */
public class StoreStockListRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 7734173136720798493L;
    /**
     * 门店
     */
    private StoreRespDTO store;
    /**
     * 仓库
     */
    private List<StockRespDTO> stocks;

    public StoreRespDTO getStore() {
        return store;
    }

    public void setStore(StoreRespDTO store) {
        this.store = store;
    }

    public List<StockRespDTO> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockRespDTO> stocks) {
        this.stocks = stocks;
    }
}
