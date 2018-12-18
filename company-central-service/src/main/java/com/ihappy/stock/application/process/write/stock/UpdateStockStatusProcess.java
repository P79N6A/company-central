package com.ihappy.stock.application.process.write.stock;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.enumtype.ForbiddenEnum;
import com.ihappy.company.common.enumtype.IsPublicEnum;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.stock.common.enumtype.StockErrorCodeEnum;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.request.stock.StockStatusReqDTO;
import com.ihappy.stock.domain.model.factory.CompanyStockFactory;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/17.
 */
public class UpdateStockStatusProcess extends DefaultProcess<StockStatusReqDTO, String> {
    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;

    @Override
    public void process(Context<StockStatusReqDTO, String> context) {
        StockStatusReqDTO stockStatusReqDTO = context.getParam();
        CompanyStockModel companyStockModel = CompanyStockFactory.stockStatusReqDTOToModel(stockStatusReqDTO);
        if (ForbiddenEnum.DISABLE.getKey().equals(stockStatusReqDTO.getForbidden())){
            BaseinfoCompanyStock old = baseinfoCompanyStockMapper.selectByPrimaryKey(stockStatusReqDTO.getStockId());
            if (null != old && IsPublicEnum.PUBLIC.getKey().equals(old.getIsPublic())){
                throw new CompanyException(StockErrorCodeEnum.
                        CAN_NOT_FORBIDEN_STOCK.getErrCode(),
                        StockErrorCodeEnum.CAN_NOT_FORBIDEN_STOCK.getErrMsg());
            }
        }
        Integer res = baseinfoCompanyStockMapper.updateByPrimaryKeySelective(companyStockModel.getDO());
        if(res != 1){
            throw new CompanyException(StockErrorCodeEnum.
                    UPDATE_STOCK_ERROR.getErrCode(),
                    StockErrorCodeEnum.UPDATE_STOCK_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}