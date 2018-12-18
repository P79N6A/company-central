package com.ihappy.stock.application.process.write.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.bo.stock.StockBO;
import com.ihappy.stock.domain.dto.request.stock.ClearStockInventoryingReqDTO;
import com.ihappy.stock.exception.StockException;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/10/29.
 */
public class ClearStockInventoryingProcess extends DefaultProcess<ClearStockInventoryingReqDTO, String> {
    @Autowired
    private StockService stockService;

    @Override
    public void process(Context<ClearStockInventoryingReqDTO, String> context) {
        ClearStockInventoryingReqDTO reqDTO = context.getParam();
        StockBO bo = new StockBO();
        bo.setCompId(reqDTO.getCompId().intValue());
        bo.setStockChangeIds(reqDTO.getStockChangeIds());
        bo.setStockIds(reqDTO.getStockIds());
        Integer res = stockService.clearStockInventorying(bo);
        if (res != null && res >= 0){
            context.getResult().setModule("成功");
        }else {
            throw new StockException(StockErrorCodeEnum.
                    CLEAR_STOCK_INVENTORYING_ERROR.getErrCode(),
                    StockErrorCodeEnum.CLEAR_STOCK_INVENTORYING_ERROR.getErrMsg());
        }
    }
}
