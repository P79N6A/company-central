package com.ihappy.stock.domain.dto.response.stock;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 3901120673185959359L;
    private Long stockId;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
}
