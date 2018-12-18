package com.ihappy.stock.infrastructure.service;

import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.response.stock.StockAddRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockWriteRpcServiceClient implements StockWriteRpcService {
    private StockWriteRpcService stockWriteRpcService;

    public StockWriteRpcService getStockWriteRpcService() {
        return stockWriteRpcService;
    }

    public void setStockWriteRpcService(StockWriteRpcService stockWriteRpcService) {
        this.stockWriteRpcService = stockWriteRpcService;
    }

    @Override
    public Result<StockAddRespDTO> addStock(StockAddReqDTO stockAddReqDTO) {
        stockAddReqDTO.validation();
        return stockWriteRpcService.addStock(stockAddReqDTO);
    }

    @Override
    public Result<String> updateStock(StockUpdateReqDTO stockUpdateReqDTO) {
        stockUpdateReqDTO.validation();
        return stockWriteRpcService.updateStock(stockUpdateReqDTO);
    }

    @Override
    public Result<String> updateStockStatus(StockStatusReqDTO stockStatusReqDTO) {
        stockStatusReqDTO.validation();
        return stockWriteRpcService.updateStockStatus(stockStatusReqDTO);
    }

    @Override
    public Result<List<StockRespDTO>> updateStockInventorying(StockInventoryingReqDTO reqDTO) {
        reqDTO.validation();
        return stockWriteRpcService.updateStockInventorying(reqDTO);
    }

    @Override
    public Result<String> clearStockInventorying(ClearStockInventoryingReqDTO reqDTO) {
        reqDTO.validation();
        return stockWriteRpcService.clearStockInventorying(reqDTO);
    }

    @Override
    public Result<StockRespDTO> addOrQueryStock(StockAddReqDTO reqDTO) {
        reqDTO.validation();
        return stockWriteRpcService.addOrQueryStock(reqDTO);
    }
}
