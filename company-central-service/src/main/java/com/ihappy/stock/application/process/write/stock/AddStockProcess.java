package com.ihappy.stock.application.process.write.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.request.stock.StockAddReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockAddRespDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by sunjd on 2018/4/13.
 */
public class AddStockProcess extends DefaultProcess<StockAddReqDTO, StockAddRespDTO> {
    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;
    @Autowired
    private StockService stockService;

    @Override
    public void process(Context<StockAddReqDTO, StockAddRespDTO> context) {
        StockAddReqDTO stockAddReqDTO = context.getParam();

        if (stockAddReqDTO.getStockName() != null && stockAddReqDTO.getLoginCompId() != null){
            //查询名称重复仓库
            BaseinfoCompanyStock stockParam = new BaseinfoCompanyStock();
            stockParam.setCompId(Integer.valueOf(stockAddReqDTO.getLoginCompId().toString()));
            stockParam.setStockName(stockAddReqDTO.getStockName());
            List<CompanyStockModel> oldStockModels = stockService.findByConditionSelective(new CompanyStockModel(stockParam));
            if (!CollectionUtils.isEmpty(oldStockModels)){
                throw new CompanyException(StockErrorCodeEnum.
                        REPETITION_STOCK_NAME_ERROR.getErrCode(),
                        StockErrorCodeEnum.REPETITION_STOCK_NAME_ERROR.getErrMsg());
            }
        }

        CompanyStockModel companyStockModel = CompanyStockFactory.stockAddReqDTOToModel(stockAddReqDTO);
        Integer res = baseinfoCompanyStockMapper.insertSelective(companyStockModel.getDO());
        if (res != 1){
            throw new CompanyException(StockErrorCodeEnum.
                    ADD_STOCK_ERROR.getErrCode(),
                    StockErrorCodeEnum.ADD_STOCK_ERROR.getErrMsg());
        }
        StockAddRespDTO stockAddRespDTO = new StockAddRespDTO();
        stockAddRespDTO.setStockId(companyStockModel.getDO().getStockId());
        context.getResult().setModule(stockAddRespDTO);
    }
}
