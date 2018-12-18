package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.CompanyPartnerDelReqDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.trade.domain.dto.request.order.QueryPartnerOrderCountReqDTO;
import com.ihappy.trade.domain.dto.response.order.QueryPartnerOrderCountRespDTO;
import com.ihappy.trade.service.order.OrderBuyerReadRpcService;
import com.ihappy.trade.service.order.OrderSellerReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/6.
 */
public class DelCompanyPartnerProcess extends DefaultProcess<CompanyPartnerDelReqDTO, String> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private OrderBuyerReadRpcService orderBuyerReadRpcServiceClient;
    @Autowired
    private OrderSellerReadRpcService orderSellerReadRpcServiceClient;
    @Override
    public void process(Context<CompanyPartnerDelReqDTO, String> context) {
        CompanyPartnerDelReqDTO companyPartnerDelReqDTO = context.getParam();
        BaseinfoCompanyPartner old = baseinfoCompanyPartnerMapper.selectByPrimaryKey(companyPartnerDelReqDTO.getPartnerId());
        if (null == old){
            throw new CompanyException(PartnerErrorCodeEnum.
                    DELETE_COMPANY_PARTNER_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.DELETE_COMPANY_PARTNER_ERROR.getErrMsg());
        }
        Long orderNum = 0L;
        if (old.getPartnerType() != null){
            QueryPartnerOrderCountReqDTO queryPartnerOrderCountReqDTO = new QueryPartnerOrderCountReqDTO();
            queryPartnerOrderCountReqDTO.setCompId(Long.valueOf(old.getCompId()));
            queryPartnerOrderCountReqDTO.setPartnerId(old.getPartnerId());
            Result<QueryPartnerOrderCountRespDTO> result1 = orderSellerReadRpcServiceClient.queryPartnerOrderBuyerCount(queryPartnerOrderCountReqDTO);
            Result<QueryPartnerOrderCountRespDTO> result = orderBuyerReadRpcServiceClient.queryPartnerOrderBuyerCount(queryPartnerOrderCountReqDTO);
            if (!(result == null || result.getModule() == null || result.getModule().getCount() <= 0)){
                orderNum += result.getModule().getCount();
            }
            if (!(result1 == null || result1.getModule() == null || result1.getModule().getCount() <= 0)){
                orderNum += result1.getModule().getCount();
            }
            if (orderNum > 0){
                throw new CompanyException(PartnerErrorCodeEnum.
                        PARTENR_HAVE_ORDER.getErrCode(),
                        PartnerErrorCodeEnum.PARTENR_HAVE_ORDER.getErrMsg());
            }
        }

        CompanyPartnerModel model = BaseInfoCompanyPartnerFactory.companyPartnerDelReqDTOToModel(companyPartnerDelReqDTO);
        companyPartnerService.isCanEdit(model.getDO());
        Integer res = baseinfoCompanyPartnerMapper.delCompanyPartner(model.getDO());
        if(res != 1){
            throw new CompanyException(PartnerErrorCodeEnum.
                    DELETE_COMPANY_PARTNER_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.DELETE_COMPANY_PARTNER_ERROR.getErrMsg());
        }
        context.getResult().setModule("删除成功");
    }
}
