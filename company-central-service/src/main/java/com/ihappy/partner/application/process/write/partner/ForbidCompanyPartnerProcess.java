package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.CompanyPartnerDelReqDTO;
import com.ihappy.partner.domain.dto.response.partner.CompanyPartnerDelRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.trade.service.order.OrderBuyerReadRpcService;
import com.ihappy.trade.service.order.OrderSellerReadRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/6.
 */
public class ForbidCompanyPartnerProcess extends DefaultProcess<CompanyPartnerDelReqDTO, CompanyPartnerDelRespDTO> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private OrderBuyerReadRpcService orderBuyerReadRpcServiceClient;
    @Autowired
    private OrderSellerReadRpcService orderSellerReadRpcServiceClient;

    @Override
    public void process(Context<CompanyPartnerDelReqDTO, CompanyPartnerDelRespDTO> context) {
        CompanyPartnerDelReqDTO companyPartnerDelReqDTO = context.getParam();
        final long partnerId = companyPartnerDelReqDTO.getPartnerId();
        final long loginPersonId = companyPartnerDelReqDTO.getLoginPersonId();


        CompanyPartnerModel model = BaseInfoCompanyPartnerFactory.reqDTOToModel(companyPartnerDelReqDTO);
        CompanyPartnerModel companyPartnerModel = companyPartnerService.queryPartner(model);
        if (companyPartnerModel == null){
            throw new CompanyException(CompanyErrorCodeEnum.RETAIL_CUSTOMER_IS_NOT_EXISTS);
        }
        BaseinfoCompanyPartner retailCustomer = companyPartnerModel.getDO();
        if (null == retailCustomer) {
            throw new CompanyException(PartnerErrorCodeEnum.
                    RETAIL_CUSTOMER_IS_NOT_EXISIT.getErrCode(),
                    PartnerErrorCodeEnum.RETAIL_CUSTOMER_IS_NOT_EXISIT.getErrMsg());
        }
        if(!companyPartnerModel.isRetailCustomer()){
            throw new CompanyException(PartnerErrorCodeEnum.
                    RETAIL_CUSTOMER_IS_NOT_EXISIT.getErrCode(),
                    PartnerErrorCodeEnum.RETAIL_CUSTOMER_IS_NOT_EXISIT.getErrMsg());
        }

        CompanyPartnerDelRespDTO companyPartnerDelRespDTO = new CompanyPartnerDelRespDTO();
        //如果会员是启用状态，禁用
        if (retailCustomer.getForbidden() == 0) {
            BaseinfoCompanyPartner baseInfoCompanyPartner = new BaseinfoCompanyPartner();
            baseInfoCompanyPartner.setPartnerId(partnerId);
            baseInfoCompanyPartner.setUpdatedPersonId(loginPersonId);
            baseInfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
            Integer res = baseinfoCompanyPartnerMapper.forbidRetailCustomer(baseInfoCompanyPartner);
            if (res != 1) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        DISABLE_RETAIL_CUSTOMER.getErrCode(),
                        PartnerErrorCodeEnum.DISABLE_RETAIL_CUSTOMER.getErrMsg());
            }
            if (res == 1) {
                companyPartnerDelRespDTO.setMessage("禁用成功");
            }
            context.getResult().setModule(companyPartnerDelRespDTO);
        }else {
            companyPartnerDelRespDTO.setMessage("已经禁用");
            context.getResult().setModule(companyPartnerDelRespDTO);
        }

    }
}
