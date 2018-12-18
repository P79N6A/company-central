package com.ihappy.stock.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.response.stock.StockAddRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.infrastructure.service.StockWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockWriteRpcServiceImpl implements StockWriteRpcService {
    @Autowired
    private IProcess addStockProcess;

    @Autowired
    private IProcess updateStockProcess;

    @Autowired
    private IProcess updateStockStatusProcess;

    @Autowired
    private IProcess updateStockInventoryingProcess;

    @Autowired
    private IProcess addOrQueryStockProcess;

    @Autowired
    private IProcess clearStockInventoryingProcess;

    @Override
    public Result<StockAddRespDTO> addStock(StockAddReqDTO stockAddReqDTO) {
        Context context = new Context(stockAddReqDTO, new Result<StockAddRespDTO>(), Action.ADD_STOCK);
        addStockProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateStock(StockUpdateReqDTO stockUpdateReqDTO) {
        Context context = new Context(stockUpdateReqDTO, new Result<String>(), Action.UPDATE_STOCK);
        updateStockProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateStockStatus(StockStatusReqDTO stockStatusReqDTO) {
        Context context = new Context(stockStatusReqDTO, new Result<String>(), Action.UPDATE_STOCK_STATUS);
        updateStockStatusProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StockRespDTO>> updateStockInventorying(StockInventoryingReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<StockRespDTO>>(), Action.UPDATE_STOCK_INVENTORYING);
        updateStockInventoryingProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> clearStockInventorying(ClearStockInventoryingReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.CLEAR_STOCK_INVENTORYING);
        clearStockInventoryingProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<StockRespDTO> addOrQueryStock(StockAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<StockRespDTO>>(), Action.ADD_OR_QUERY_STOCK);
        addOrQueryStockProcess.start(context);
        return context.getResult();
    }
}
