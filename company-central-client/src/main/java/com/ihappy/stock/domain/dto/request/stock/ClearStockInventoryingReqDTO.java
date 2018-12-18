package com.ihappy.stock.domain.dto.request.stock;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.exception.StockException;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.List;

/**
 * Created by sunjd on 2018/10/29.
 */
public class ClearStockInventoryingReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -5691112118859787015L;
    @FieldComment(value = "公司id",required = true,defaultValue = "")
    private Long compId;

    @FieldComment(value = "仓库id列表",required = false,defaultValue = "")
    private List<Long> stockIds;

    @FieldComment(value = "盘点单id列表",required = true,defaultValue = "")
    private List<Long> stockChangeIds;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public List<Long> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Long> stockIds) {
        this.stockIds = stockIds;
    }

    public List<Long> getStockChangeIds() {
        return stockChangeIds;
    }

    public void setStockChangeIds(List<Long> stockChangeIds) {
        this.stockChangeIds = stockChangeIds;
    }

    @Override
    public void validation() {
        if (compId == null || compId == 0L) {
            throw new StockException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
            CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (stockChangeIds == null || stockChangeIds.size() == 0) {
            throw new StockException(StockErrorCodeEnum.
                    STOCK_CHANGE_IS_NULL.getErrCode(),
                    StockErrorCodeEnum.STOCK_CHANGE_IS_NULL.getErrMsg());
        }
    }
}
