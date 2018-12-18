package com.ihappy.stock.application.process.write.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.bo.stock.StockBO;
import com.ihappy.stock.domain.dto.request.stock.StockInventoryingReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/5/4.
 */
public class UpdateStockInventoryingProcess extends DefaultProcess<StockInventoryingReqDTO, List<StockRespDTO>> {
    @Autowired
    private StockService stockService;
    @Override
    public void process(Context<StockInventoryingReqDTO, List<StockRespDTO>> context) {
        StockInventoryingReqDTO reqDTO = context.getParam();
        List<CompanyStockModel> models = stockService.findStockListByIds(reqDTO.getStockIds());
        List<StockRespDTO> res = new ArrayList<StockRespDTO>();
        List<Long> stockIds = new ArrayList<Long>();
        if(CollectionUtils.isEmpty(models)){
            throw new CompanyException(StockErrorCodeEnum.
                    NO_STOCK.getErrCode(),
                    StockErrorCodeEnum.NO_STOCK.getErrMsg());
        }
        //判断解锁or加锁
        if(reqDTO.getLock()){
            for(CompanyStockModel obj : models){
                if (obj.getDO().getInventorying() != null && obj.getDO().getInventorying() != 0){
                    res.add(CompanyStockFactory.modelToStockRespDTO(obj));
                }else {
                    stockIds.add(obj.getDO().getStockId());
                }
            }
            //有重复锁时直接返回,不再加锁
            if (res.size() > 0){
                context.getResult().setModule(res);
                return;
            }
        }else {
            for(CompanyStockModel obj : models){
                if(obj.getDO().getInventorying() != 0 && !obj.getDO().getInventorying().equals(reqDTO.getStockChangeId())) {
                    res.add(CompanyStockFactory.modelToStockRespDTO(obj));
                }else if (obj.getDO().getInventorying().equals(reqDTO.getStockChangeId())){
                    stockIds.add(obj.getDO().getStockId());
                }
            }
            //解锁
            reqDTO.setStockChangeId(0L);
        }
        StockBO stockBO = new StockBO();
        stockBO.setStockIds(stockIds);
        stockBO.setInventorying(reqDTO.getStockChangeId());
        Integer count = stockService.updateStockInventorying(stockBO);
        if (count != stockIds.size()){
            throw new CompanyException(StockErrorCodeEnum.
                    UPDATE_STOCK_INVENTORYING_ERROR.getErrCode(),
                    StockErrorCodeEnum.UPDATE_STOCK_INVENTORYING_ERROR.getErrMsg());
        }
        context.getResult().setModule(res);
    }
}
