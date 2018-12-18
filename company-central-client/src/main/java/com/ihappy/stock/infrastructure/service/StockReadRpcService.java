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
public interface StockReadRpcService {
    /**
     * 根据公司id和用户id 查询门店仓库列表
     * @param stockListQueryReqDTO
     * @return
     */
    Result<StockListQueryRespDTO> findStoreStockList(StockListQueryReqDTO stockListQueryReqDTO);

    /**
     * 查询单个仓库
     * @param stockQueryReqDTO
     * @return
     */
    Result<StockRespDTO> findStock(StockQueryReqDTO stockQueryReqDTO);

    /**
     * 根据id列表查询仓库列表-内部rpc调用
     * @param reqDTO
     * @return
     */
    Result<List<StockRespDTO>> findStockListByIds(StockListByIdsQueryReqDTO reqDTO);

    /**
     * 查询用户所属于的仓库
     * @param userInfoByIdQuery
     * @return
     */
    Result<List<StockBasicInfoRespDTO>> getStockListByPersonId(UserInfoOutSideByIdQuery userInfoByIdQuery);

    /**
     * 根据门店id列表 公司id 查询仓库列表
     * @return
     */
    Result<StockListByStoreIdsQueryRespDTO> getStockListByStoreIdList(StockListByStoreIdsQueryReqDTO reqDTO);

    /**
     * 根据条件查询仓库列表-内部Rpc调用
     *  此接口权限过大，不得直接对前端开放
     * @return
     */
    Result<List<StockRespDTO>> getStockListByCondition(StockReqDTO reqDTO);

    /**
     * 查询所有仓库
     * @param stockListByStoreIdsQueryReqDTO
     * @return
     */
    Result<List<StockRespDTO>> getAllStockListByStoreIdList(StockListByStoreIdsQueryReqDTO stockListByStoreIdsQueryReqDTO);
}
