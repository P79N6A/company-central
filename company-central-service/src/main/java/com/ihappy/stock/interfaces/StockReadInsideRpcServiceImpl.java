package com.ihappy.stock.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.stock.domain.dto.request.stock.StockMapByUserInfoQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.stock.infrastructure.service.StockReadInsideRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/23.
 */
@Deprecated
public class StockReadInsideRpcServiceImpl implements StockReadInsideRpcService {
    @Autowired
    private IProcess getStockMapByUserInfoProcess;

    @Override
    public Result<StockListByStoreIdsQueryRespDTO> getStockMapByUserInfo(StockMapByUserInfoQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<StockListByStoreIdsQueryRespDTO>(), Action.GET_STOCK_MAP_BY_USER_INFO);
        getStockMapByUserInfoProcess.start(context);
        return context.getResult();
    }
}
