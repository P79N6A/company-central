package com.ihappy.stock.infrastructure.service;

import com.ihappy.stock.domain.dto.request.stock.StockMapByUserInfoQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/23.
 */
@Deprecated
public class StockReadInsideRpcServiceClient implements StockReadInsideRpcService {
    private StockReadInsideRpcService stockReadInsideRpcService;
    @Override
    public Result<StockListByStoreIdsQueryRespDTO> getStockMapByUserInfo(StockMapByUserInfoQueryReqDTO reqDTO) {
        reqDTO.validation();
        return stockReadInsideRpcService.getStockMapByUserInfo(reqDTO);
    }
}
