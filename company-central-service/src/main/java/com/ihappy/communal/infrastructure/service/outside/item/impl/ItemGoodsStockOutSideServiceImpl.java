package com.ihappy.communal.infrastructure.service.outside.item.impl;

import com.ihappy.communal.infrastructure.service.outside.item.ItemGoodsStockOutSideService;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.item.domain.dto.request.goodsstock.ItemStoreGoodsStockQuery;
import com.ihappy.item.domain.dto.response.goodsstock.ItemStoreGoodsStockInfoRespDTO;
import com.ihappy.item.infrastructure.service.ItemGoodsStockReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by chenying on 2018/8/28.
 */
public class ItemGoodsStockOutSideServiceImpl implements ItemGoodsStockOutSideService {
    Logger logger = CompanyLoggerUtil.getLogger();
    @Autowired
    private ItemGoodsStockReadRpcService itemGoodsStockReadRpcServiceClient;

    @Override
    public List<ItemStoreGoodsStockInfoRespDTO> queryItemStoreGoodsStock(ItemStoreGoodsStockQuery itemStoreGoodsStockQuery, boolean throwException) {
        try {
            Result<List<ItemStoreGoodsStockInfoRespDTO>>  result = itemGoodsStockReadRpcServiceClient.queryItemStoreGoodsStock(itemStoreGoodsStockQuery);
            if(result == null || !result.isSuccess() || result.getModule() == null || result.getModule().size() <=0){
                return null;
            }
            return result.getModule();
        } catch (Exception e) {
            logger.error("ItemGoodsStockOutSideService_queryItemStoreGoodsStock外部服务调用失败", e);
            if (throwException) {
                throw e;
            }
            return null;
        }

    }
}
