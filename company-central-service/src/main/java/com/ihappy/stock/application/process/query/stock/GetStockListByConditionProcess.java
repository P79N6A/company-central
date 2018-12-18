package com.ihappy.stock.application.process.query.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.stock.domain.dto.request.stock.StockReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/8/6.
 */
public class GetStockListByConditionProcess extends DefaultQueryProcess<StockReqDTO,List<StockRespDTO>> {
    @Autowired
    private StockService stockService;
    @Autowired
    private CompanyStoreService companyStoreService;
    @Override
    public void process(Context<StockReqDTO, List<StockRespDTO>> context) {
        StockReqDTO reqDTO = context.getParam();
        Map<String,Object> map = reqDTO.toMap();
        List<CompanyStockModel> models = stockService.findStockListByConditonWithStoreInfo(map);
        List<StockRespDTO> respDTOS = new ArrayList<StockRespDTO>();
        for (CompanyStockModel obj : models){
            BaseinfoCompanyStock stock = obj.getDO();
            StockRespDTO respDTO = new StockRespDTO();

            respDTO.setCompId(stock.getCompId());
            respDTO.setStockId(stock.getStockId());
            respDTO.setStockName(stock.getStockName());
            respDTO.setStoreId(stock.getStoreId());
            respDTO.setIsPublic(stock.getIsPublic());
            respDTO.setStoreName(stock.getStoreName());
            respDTOS.add(respDTO);
        }
        context.getResult().setModule(respDTOS);
    }
}
