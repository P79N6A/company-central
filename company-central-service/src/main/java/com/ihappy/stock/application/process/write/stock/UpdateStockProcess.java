package com.ihappy.stock.application.process.write.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.request.stock.StockUpdateReqDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.stock.infrastructure.service.inside.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by sunjd on 2018/4/17.
 */
public class UpdateStockProcess extends DefaultProcess<StockUpdateReqDTO, String> {
    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;
    @Autowired
    private StockService stockService;

    @Override
    public void process(Context<StockUpdateReqDTO, String> context) {
        StockUpdateReqDTO stockUpdateReqDTO = context.getParam();

        if (stockUpdateReqDTO.getStockName() != null && stockUpdateReqDTO.getLoginCompId() != null){
            //查询名称重复仓库
            BaseinfoCompanyStock stockParam = new BaseinfoCompanyStock();
            stockParam.setCompId(Integer.valueOf(stockUpdateReqDTO.getLoginCompId().toString()));
            stockParam.setStockName(stockUpdateReqDTO.getStockName());
            List<CompanyStockModel> oldStockModels = stockService.findByConditionSelective(new CompanyStockModel(stockParam));
            if (!CollectionUtils.isEmpty(oldStockModels)){
                for (CompanyStockModel obj : oldStockModels){
                    if (!obj.getDO().getStockId().equals(stockUpdateReqDTO.getStockId())){
                        throw new CompanyException(StockErrorCodeEnum.
                                REPETITION_STOCK_NAME_ERROR.getErrCode(),
                                StockErrorCodeEnum.REPETITION_STOCK_NAME_ERROR.getErrMsg());
                    }
                }
            }
        }

        CompanyStockModel companyStockModel = CompanyStockFactory.stockUpdateReqDTOToModel(stockUpdateReqDTO);
        Integer res = baseinfoCompanyStockMapper.updateByPrimaryKeySelective(companyStockModel.getDO());
        if(res != 1){
            throw new CompanyException(StockErrorCodeEnum.
                    UPDATE_STOCK_ERROR.getErrCode(),
                    StockErrorCodeEnum.UPDATE_STOCK_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改仓库成功");
    }
}
