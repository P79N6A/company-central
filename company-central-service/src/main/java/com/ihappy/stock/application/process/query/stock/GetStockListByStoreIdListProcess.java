package com.ihappy.stock.application.process.query.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.domain.dto.request.stock.StockListByStoreIdsQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/5/18.
 */
public class GetStockListByStoreIdListProcess extends DefaultQueryProcess<StockListByStoreIdsQueryReqDTO,StockListByStoreIdsQueryRespDTO> {
    @Autowired
    private StockService stockService;

    @Override
    public void process(Context<StockListByStoreIdsQueryReqDTO, StockListByStoreIdsQueryRespDTO> context) {
        StockListByStoreIdsQueryReqDTO reqDTO = context.getParam();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("compId",reqDTO.getCompId());
        paramMap.put("storeIds",reqDTO.getStoreIds());
        if (reqDTO.getIsPublic() != null){
            paramMap.put("isPublic",reqDTO.getIsPublic());
        }
        List<CompanyStockModel> stockModels = stockService.findStockListByStoreIdList(paramMap);
        StockListByStoreIdsQueryRespDTO respDTO = new StockListByStoreIdsQueryRespDTO();
        Map<Long,List<StockRespDTO>> storeStocks = new HashMap<Long,List<StockRespDTO>>();
        for (CompanyStockModel obj : stockModels){
            StockRespDTO stockRespDTO = CompanyStockFactory.modelToStockRespDTO(obj);
            if (storeStocks.get(stockRespDTO.getStoreId()) == null){
                List<StockRespDTO> stockRespDTOList = new ArrayList<StockRespDTO>();
                stockRespDTOList.add(stockRespDTO);
                storeStocks.put(stockRespDTO.getStoreId(),stockRespDTOList);
            }else {
                storeStocks.get(stockRespDTO.getStoreId()).add(stockRespDTO);
            }
        }
        respDTO.setStoreStocks(storeStocks);
        context.getResult().setModule(respDTO);
    }
}
