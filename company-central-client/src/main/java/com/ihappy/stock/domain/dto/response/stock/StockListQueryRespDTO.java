package com.ihappy.stock.domain.dto.response.stock;

import com.ihappy.company.domain.dto.response.StoreStockListRespDTO;
import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;


/**
 * Created by sunjd on 2018/4/13.
 */
public class StockListQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -1369397039649076625L;
    /**
     * 公共仓库
     */
    private StoreStockListRespDTO publicStock;
    /**
     * 门店仓库列表
     */
    private List<StoreStockListRespDTO> storeStocks;

    public StoreStockListRespDTO getPublicStock() {
        return publicStock;
    }

    public void setPublicStock(StoreStockListRespDTO publicStock) {
        this.publicStock = publicStock;
    }

    public List<StoreStockListRespDTO> getStoreStocks() {
        return storeStocks;
    }

    public void setStoreStocks(List<StoreStockListRespDTO> storeStocks) {
        this.storeStocks = storeStocks;
    }
}
