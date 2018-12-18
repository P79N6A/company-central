package com.ihappy.stock.infrastructure.service;

import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.request.user.UserInfoOutSideByIdQuery;
import com.ihappy.stock.domain.dto.response.stock.StockBasicInfoRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockReadRpcServiceClient implements StockReadRpcService {
    private StockReadRpcService stockReadRpcService;

    public StockReadRpcService getStockReadRpcService() {
        return stockReadRpcService;
    }

    public void setStockReadRpcService(StockReadRpcService stockReadRpcService) {
        this.stockReadRpcService = stockReadRpcService;
    }

    @Override
    public Result<StockListQueryRespDTO> findStoreStockList(StockListQueryReqDTO stockListQueryReqDTO) {
        stockListQueryReqDTO.validation();
        return stockReadRpcService.findStoreStockList(stockListQueryReqDTO);
    }

    @Override
    public Result<StockRespDTO> findStock(StockQueryReqDTO stockQueryReqDTO) {
        stockQueryReqDTO.validation();
        return stockReadRpcService.findStock(stockQueryReqDTO);
    }

    @Override
    public Result<List<StockRespDTO>> findStockListByIds(StockListByIdsQueryReqDTO reqDTO) {
        reqDTO.validation();
        return stockReadRpcService.findStockListByIds(reqDTO);
    }

    @Override
    public Result<List<StockBasicInfoRespDTO>> getStockListByPersonId(UserInfoOutSideByIdQuery userInfoByIdQuery) {
        return stockReadRpcService.getStockListByPersonId(userInfoByIdQuery);
    }

    @Override
    public Result<StockListByStoreIdsQueryRespDTO> getStockListByStoreIdList(StockListByStoreIdsQueryReqDTO reqDTO) {
        reqDTO.validation();
        return stockReadRpcService.getStockListByStoreIdList(reqDTO);
    }

    @Override
    public Result<List<StockRespDTO>> getStockListByCondition(StockReqDTO reqDTO) {
        reqDTO.validation();
        return stockReadRpcService.getStockListByCondition(reqDTO);
    }

    @Override
    public Result<List<StockRespDTO>> getAllStockListByStoreIdList(StockListByStoreIdsQueryReqDTO stockListByStoreIdsQueryReqDTO) {
        return stockReadRpcService.getAllStockListByStoreIdList(stockListByStoreIdsQueryReqDTO);
    }
}
