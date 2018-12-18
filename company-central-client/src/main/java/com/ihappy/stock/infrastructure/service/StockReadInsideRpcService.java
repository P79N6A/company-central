package com.ihappy.stock.infrastructure.service;

import com.ihappy.stock.domain.dto.request.stock.StockMapByUserInfoQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/23.
 * 仓库查询内部Rpc
 */
@Deprecated
public interface StockReadInsideRpcService {
    /**
     * 根据用户id 公司id获取 门店id-仓库列表 Map
     * isPublic 是否公共仓库  1：公共仓库  0：非公共仓库  null:全部
     * forbidden 禁用 1 禁用 0未禁用  null:全部
     * @return
     */
    Result<StockListByStoreIdsQueryRespDTO> getStockMapByUserInfo(StockMapByUserInfoQueryReqDTO reqDTO);
}
