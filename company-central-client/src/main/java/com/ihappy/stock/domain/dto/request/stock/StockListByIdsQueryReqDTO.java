package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;

import java.util.List;

/**
 * Created by sunjd on 2018/5/4.
 */
public class StockListByIdsQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 1129863142377940295L;

    private List<Long> stockIds;

    public List<Long> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Long> stockIds) {
        this.stockIds = stockIds;
    }

    @Override
    public void validation() {
        if (stockIds == null || stockIds.size() == 0) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_ID_IS_NULL.getErrMsg());
        }
    }
}
