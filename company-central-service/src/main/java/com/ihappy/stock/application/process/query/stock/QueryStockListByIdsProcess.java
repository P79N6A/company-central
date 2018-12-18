package com.ihappy.stock.application.process.query.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.stock.domain.dto.request.stock.StockListByIdsQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/5/4.
 */
public class QueryStockListByIdsProcess extends DefaultQueryProcess<StockListByIdsQueryReqDTO,List<StockRespDTO>> {
    @Autowired
    private StockService stockService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StockListByIdsQueryReqDTO, List<StockRespDTO>> context) {
        StockListByIdsQueryReqDTO reqDTO = context.getParam();
        List<CompanyStockModel> models = stockService.findStockListByIds(reqDTO.getStockIds());
        List<StockRespDTO> res = CompanyStockFactory.modelListToStockRespDTOList(models);

        //填充门店名称
        List<Long> storeIds = new ArrayList<Long>();
        for (StockRespDTO stock : res){
            storeIds.add(stock.getStoreId());
        }
        if (!CollectionUtils.isEmpty(storeIds)){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("storeIds",storeIds);
            Map<Long,CompanyStoreModel> storeModelMap = companyStoreService.selectByStoreIds(map);
            for (StockRespDTO stockRespDTO : res){
                CompanyStoreModel storeModel = storeModelMap.get(stockRespDTO.getStoreId());
                if (storeModel != null){
                    stockRespDTO.setStoreName(storeModel.getDO().getStoreName());
                }
            }
        }

        context.getResult().setModule(res);
    }
}
