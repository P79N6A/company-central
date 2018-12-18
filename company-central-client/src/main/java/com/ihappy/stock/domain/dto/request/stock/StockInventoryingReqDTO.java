package com.ihappy.stock.domain.dto.request.stock;


import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;

import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/5/4.
 */
public class StockInventoryingReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 8043343994186902473L;
    /**
     * 盘点单id
     */
    private Long stockChangeId;
    /**
     * false-解锁  true-加锁
     */
    private Boolean lock;
    /**
     * 仓库id列表
     */
    private List<Long> stockIds;

    public Long getStockChangeId() {
        return stockChangeId;
    }

    public void setStockChangeId(Long stockChangeId) {
        this.stockChangeId = stockChangeId;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public List<Long> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Long> stockIds) {
        this.stockIds = stockIds;
    }

    @Override
    public void validation() {
        if (stockChangeId == null) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_CHANGE_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_CHANGE_IS_NULL.getErrMsg());
        }
        if (stockIds == null || stockIds.size() == 0) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_ID_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_ID_IS_NULL.getErrMsg());
        }
        if (lock == null) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_LOCK_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_LOCK_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
