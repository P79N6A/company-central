package com.ihappy.stock.application.process.query.stock;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.request.stock.StockListByStoreIdsQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhc on 2018/10/31.
 */
public class GetAllStockListByStoreIdListProcess extends DefaultQueryProcess<StockListByStoreIdsQueryReqDTO,List<StockRespDTO>> {

    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;

    @Override
    public void process(Context<StockListByStoreIdsQueryReqDTO, List<StockRespDTO>> context) {
        StockListByStoreIdsQueryReqDTO storeIdsQueryReqDTO = context.getParam();

        Map<String,Object> paraMap = new HashMap<String,Object>();
        paraMap.put("compId",storeIdsQueryReqDTO.getCompId());
        paraMap.put("storeIds",storeIdsQueryReqDTO.getStoreIds());
        List<BaseinfoCompanyStock> stockList = baseinfoCompanyStockMapper.selectStockListByConditon(paraMap);
        List<StockRespDTO> dtoList = new ArrayList<>();
        if(!CollectionUtil.isEmpty(stockList)){
            List<CompanyStockModel> modelList = new ArrayList<>();
            for(BaseinfoCompanyStock stock : stockList){
                modelList.add(new CompanyStockModel(stock));
            }
            dtoList = CompanyStockFactory.modelListToStockRespDTOList(modelList);
        }
        context.getResult().setModule(dtoList);
    }
}
