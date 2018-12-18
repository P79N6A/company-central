package com.ihappy.stock.application.process.query.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import com.ihappy.stock.domain.dto.request.stock.StockQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/13.
 */
public class QueryStockProcess extends DefaultQueryProcess<StockQueryReqDTO,StockRespDTO> {
    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;

    @Autowired
    private BaseinfoCompanyStoreMapper baseinfoCompanyStoreMapper;

    @Override
    public void process(Context<StockQueryReqDTO, StockRespDTO> context) {
        StockQueryReqDTO stockQueryReqDTO = context.getParam();
        Integer compId = Integer.parseInt(stockQueryReqDTO.userCompId().toString());
        CompanyStockModel companyStockModel = CompanyStockFactory.stockQueryReqDTOToModel(stockQueryReqDTO);
        BaseinfoCompanyStock baseinfoCompanyStock = baseinfoCompanyStockMapper.selectByPrimaryKeyAndCompId(companyStockModel.getDO());
        Long storeId = baseinfoCompanyStock.getStoreId();
        String storeName = OptConstans.PUBLIC_STOCK_NAME;
        if(storeId != null && storeId != 0){
            BaseinfoCompanyStore store = baseinfoCompanyStoreMapper.selectByPrimaryKey(storeId);
            if(store != null && store.getStoreName() != null){
                storeName = store.getStoreName();
            }
        }
        CompanyStockModel res = new CompanyStockModel(baseinfoCompanyStock);
        context.getResult().setModule(CompanyStockFactory.modelToStockRespDTO(res,storeName));
    }
}
