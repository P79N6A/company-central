package com.ihappy.stock.infrastructure.service;

import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.response.stock.StockAddRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/13.
 */
public interface StockWriteRpcService {
    /**
     * 添加仓库
     * @param stockAddReqDTO
     * @return
     */
    Result<StockAddRespDTO> addStock(StockAddReqDTO stockAddReqDTO);

    /**
     * 修改仓库信息
     * @param stockUpdateReqDTO
     * @return
     */
    Result<String> updateStock(StockUpdateReqDTO stockUpdateReqDTO);

    /**
     * 修改仓库状态 禁用/启用
     * @param stockStatusReqDTO
     * @return
     */
    Result<String> updateStockStatus(StockStatusReqDTO stockStatusReqDTO);

    /**
     * 修改仓库锁定状态 返回已被锁定的仓库列表
     * @param reqDTO
     * @return
     */
    Result<List<StockRespDTO>> updateStockInventorying(StockInventoryingReqDTO reqDTO);

    /**
     * @Author sunjd
     * @Description 清除判断锁，用于锁出错时
     * @Date 16:21 2018/10/29
     * @Param []
     * @return com.ihappy.unifiedLog.module.Result<java.lang.String>
     **/
    Result<String> clearStockInventorying(ClearStockInventoryingReqDTO reqDTO);

    /**
     * 查询仓库，没有的话新增
     * @param reqDTO
     * @return
     */
    Result<StockRespDTO> addOrQueryStock(StockAddReqDTO reqDTO);
}
