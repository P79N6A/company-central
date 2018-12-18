package com.ihappy.communal.infrastructure.service.outside.item;

import com.ihappy.item.domain.dto.request.goodsstock.ItemStoreGoodsStockQuery;
import com.ihappy.item.domain.dto.response.goodsstock.ItemStoreGoodsStockInfoRespDTO;

import java.util.List;

/**
 * Created by chenying on 2018/8/28.
 */
public interface ItemGoodsStockOutSideService {
    /**
     *  门店下库存信息列表
     * @param itemStoreGoodsStockQuery
     * @return
     */
   List<ItemStoreGoodsStockInfoRespDTO> queryItemStoreGoodsStock(ItemStoreGoodsStockQuery itemStoreGoodsStockQuery,boolean throwException);

}
