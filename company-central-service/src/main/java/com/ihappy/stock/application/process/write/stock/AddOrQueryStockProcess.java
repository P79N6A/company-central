package com.ihappy.stock.application.process.write.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.IsDeletedEnum;
import com.ihappy.company.common.enumtype.IsPublicEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.request.stock.StockAddReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by sunjd on 2018/7/31.
 */
public class AddOrQueryStockProcess extends DefaultProcess<StockAddReqDTO, StockRespDTO> {
    @Autowired
    private StockService stockService;
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;

    @Override
    public void process(Context<StockAddReqDTO, StockRespDTO> context) {
        StockAddReqDTO reqDTO = context.getParam();
        Integer queryType = reqDTO.getQueryType();
        if (reqDTO.getLoginCompId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (queryType != null && queryType == 1){
            queryPublicStock(reqDTO,context);
            return;
        }else {
            addOrQueryStock(reqDTO,context);
            return;
        }
    }

    private void queryPublicStock(StockAddReqDTO reqDTO,Context<StockAddReqDTO, StockRespDTO> context){
        BaseinfoCompanyStore storeParam = new BaseinfoCompanyStore();
        storeParam.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        storeParam.setIsPublic(IsPublicEnum.PUBLIC.getKey());
        storeParam.setIsDeleted(IsDeletedEnum.NOT_DELETED.getKey());
        List<CompanyStoreModel> storeModels = companyStoreService.selectStoreByCondition(storeParam);
        if (!CollectionUtils.isEmpty(storeModels)){
            for (CompanyStoreModel store : storeModels){
                BaseinfoCompanyStock stockParam = new BaseinfoCompanyStock();
                stockParam.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
                stockParam.setStoreId(store.getStoreId());
                stockParam.setIsPublic(IsPublicEnum.PUBLIC.getKey());
                List<CompanyStockModel> stockModels = stockService.findByConditionSelective(new CompanyStockModel(stockParam));
                if (!CollectionUtils.isEmpty(stockModels)){
                    CompanyStockModel stock = stockModels.get(0);
                    context.getResult().setModule(CompanyStockFactory.modelToStockRespDTO(stock,store.getDO().getStoreName()));
                    return;
                }
            }
            throw new CompanyException(StoreErrorCodeEnum.
                    NO_PUBLIC_STORE.getErrCode(),
                    StoreErrorCodeEnum.NO_PUBLIC_STORE.getErrMsg());
        }else {
            throw new CompanyException(StoreErrorCodeEnum.
                    NO_PUBLIC_STORE.getErrCode(),
                    StoreErrorCodeEnum.NO_PUBLIC_STORE.getErrMsg());
        }
    }

    private void addOrQueryStock(StockAddReqDTO reqDTO,Context<StockAddReqDTO, StockRespDTO> context){
        String storeName = "";
        BaseinfoCompanyStore storeParam = new BaseinfoCompanyStore();
        storeParam.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        storeParam.setStoreId(reqDTO.getStoreId());
        storeParam.setIsDeleted(IsDeletedEnum.NOT_DELETED.getKey());
        List<CompanyStoreModel> storeModels = companyStoreService.selectStoreByCondition(storeParam);
        if (!CollectionUtils.isEmpty(storeModels)){
            storeName = storeModels.get(0).getDO().getStoreName();
        }

        BaseinfoCompanyStock stockParam = new BaseinfoCompanyStock();
        stockParam.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        stockParam.setStockName(reqDTO.getStockName());
        stockParam.setStoreId(reqDTO.getStoreId());
        List<CompanyStockModel> stockModels = stockService.findByConditionSelective(new CompanyStockModel(stockParam));
        if (!CollectionUtils.isEmpty(stockModels)){
            context.getResult().setModule(CompanyStockFactory.modelToStockRespDTO(stockModels.get(0),storeName));
            return;
        }else {
            stockParam.setStockId((DistributedPrimaryKeyFactory.generateCompanyStockId(stockParam.getCompId())));
            stockParam.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
            stockParam.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
            stockParam.setCreatedPersonId(reqDTO.getLoginPersonId());
            stockParam.setUpdatedPersonId(reqDTO.getLoginPersonId());
            Integer num = baseinfoCompanyStockMapper.insertSelective(stockParam);
            if (num < 0){
                throw new CompanyException(StockErrorCodeEnum.
                        ADD_STOCK_ERROR.getErrCode(),
                        StockErrorCodeEnum.ADD_STOCK_ERROR.getErrMsg());
            }
            context.getResult().setModule(CompanyStockFactory.baseinfoCompanyStock2StockRespDTO(stockParam,storeName));
            return;
        }
    }
}
