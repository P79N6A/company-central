package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.CompanyBrandDelReqDTO;
import com.ihappy.company.domain.model.factory.CompanyBrandFactory;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyBrandMapper;
import com.ihappy.item.domain.dto.request.goods.ItemGoodsConditionQueryDTO;
import com.ihappy.item.infrastructure.service.ItemGoodsInfoRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/4.
 */
public class DelCompanyBrandProcess extends DefaultProcess<CompanyBrandDelReqDTO, String> {
    @Autowired
    private BaseinfoCompanyBrandMapper baseinfoCompanyBrandMapper;

    @Autowired
    private ItemGoodsInfoRpcService itemGoodsInfoRpcServiceClient;

    @Override
    public void process(Context<CompanyBrandDelReqDTO, String> context) {
        CompanyBrandDelReqDTO companyBrandDelReqDTO = context.getParam();
        CompanyBrandModel companyBrandModel = CompanyBrandFactory.companyBrandDelReqDTODTOToModel(companyBrandDelReqDTO);

        ItemGoodsConditionQueryDTO itemGoodsConditionQueryDTO = new ItemGoodsConditionQueryDTO();
        itemGoodsConditionQueryDTO.setBrandId(Long.parseLong(companyBrandModel.getDO().getBrandId().toString()));
        itemGoodsConditionQueryDTO.setCompId(Long.parseLong(companyBrandModel.getDO().getCompId().toString()));
        Result<Boolean> hasGoods = itemGoodsInfoRpcServiceClient.hasCountByCondition(itemGoodsConditionQueryDTO);
        if(hasGoods.getModule()){
            throw new CompanyException(CompanyErrorCodeEnum.
                    CAN_NOT_DELETE_COMPANY_BRAND_USE_BY_GOODS.getErrCode(),
                    CompanyErrorCodeEnum.CAN_NOT_DELETE_COMPANY_BRAND_USE_BY_GOODS.getErrMsg());
        }

        Integer res = baseinfoCompanyBrandMapper.updateDeletedByBrandId(companyBrandModel.getDO());
        if(res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    DELETE_COMPANY_BRAND_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.DELETE_COMPANY_BRAND_ERROR.getErrMsg());
        }
        context.getResult().setModule("删除成功");
    }
}
