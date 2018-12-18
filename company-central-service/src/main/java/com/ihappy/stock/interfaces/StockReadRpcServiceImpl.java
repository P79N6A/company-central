package com.ihappy.stock.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.stock.domain.dto.request.user.UserInfoOutSideByIdQuery;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.response.stock.StockBasicInfoRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.infrastructure.service.StockReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StockReadRpcServiceImpl implements StockReadRpcService {
    @Autowired
    private IProcess queryStoreStockListProcess;

    @Autowired
    private IProcess queryStockProcess;

    @Autowired
    private IProcess queryStockListByIdsProcess;

    @Autowired
    private IProcess getStockListByPersonIdProcess;

    @Autowired
    private IProcess getStockListByStoreIdListProcess;

    @Autowired
    private IProcess getStockListByConditionProcess;

    @Autowired
    private IProcess getAllStockListByStoreIdListProcess;

    @Override
    public Result<StockListQueryRespDTO> findStoreStockList(StockListQueryReqDTO stockListQueryReqDTO) {
        Context context = new Context(stockListQueryReqDTO, new Result<StockListQueryRespDTO>(), Action.QUERY_STORE_STOCK_LIST);
        queryStoreStockListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<StockRespDTO> findStock(StockQueryReqDTO stockQueryReqDTO) {
        Context context = new Context(stockQueryReqDTO, new Result<StockRespDTO>(), Action.QUERY_STOCK);
        queryStockProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StockRespDTO>> findStockListByIds(StockListByIdsQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<StockRespDTO>>(), Action.QUERY_STOCK_LIST_BY_IDS);
        queryStockListByIdsProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StockBasicInfoRespDTO>> getStockListByPersonId(UserInfoOutSideByIdQuery userInfoByIdQuery) {
        Context context = new Context(userInfoByIdQuery, new Result<List<StockBasicInfoRespDTO>>(), Action.QUERY_STOCK_LIST_BY_IDS);
        getStockListByPersonIdProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<StockListByStoreIdsQueryRespDTO> getStockListByStoreIdList(StockListByStoreIdsQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<StockListByStoreIdsQueryRespDTO>(), Action.GET_STOCK_LIST_BY_STORE_ID_LIST);
        getStockListByStoreIdListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StockRespDTO>> getStockListByCondition(StockReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<StockRespDTO>>(), Action.GET_STOCK_LIST_BY_STORE_ID_LIST);
        getStockListByConditionProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StockRespDTO>> getAllStockListByStoreIdList(StockListByStoreIdsQueryReqDTO stockListByStoreIdsQueryReqDTO) {
        Context context = new Context(stockListByStoreIdsQueryReqDTO, new Result<List<StockRespDTO>>(), Action.GET_STOCK_LIST_BY_STORE_ID_LIST);
        getAllStockListByStoreIdListProcess.start(context);
        return context.getResult();
    }
}
