package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.partner.CompanyPartnerDelReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerInfoEnableReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.CompanyPartnerDelRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerInfoEnableRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 9:33
 * *@content
 **/
public class PartnerWriteGatewayServiceClient implements PartnerWriteGatewayService {
    private PartnerWriteGatewayService partnerWriteGatewayService;
    @Override
    public Result<RetailCustomerAddRespDTO> addRetailCustomer(RetailCustomerAddReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteGatewayService.addRetailCustomer(reqDTO);
    }

    @Override
    public Result<RetailCustomerUpdateRespDTO> updateRetailCustomer(RetailCustomerUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteGatewayService.updateRetailCustomer(reqDTO);
    }

    @Override
    public Result<CompanyPartnerDelRespDTO> forbidCompanyPartner(CompanyPartnerDelReqDTO companyPartnerDelReqDTO) {
        companyPartnerDelReqDTO.validation();
        return partnerWriteGatewayService.forbidCompanyPartner(companyPartnerDelReqDTO);
    }
    @Override
    public Result<RetailCustomerInfoEnableRespDTO> unforbidCompanyPartner(RetailCustomerInfoEnableReqDTO retailCustomerInfoEnableReqTO) {
        retailCustomerInfoEnableReqTO.validation();
        return partnerWriteGatewayService.unforbidCompanyPartner(retailCustomerInfoEnableReqTO);
    }


}
