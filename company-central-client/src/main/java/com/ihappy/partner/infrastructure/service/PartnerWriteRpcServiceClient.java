package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/1.
 */
@Deprecated
public class PartnerWriteRpcServiceClient implements PartnerWriteRpcService{
    private PartnerWriteRpcService partnerWriteRpcService;

    public PartnerWriteRpcService getPartnerWriteRpcService() {
        return partnerWriteRpcService;
    }

    public void setPartnerWriteRpcService(PartnerWriteRpcService partnerWriteRpcService) {
        this.partnerWriteRpcService = partnerWriteRpcService;
    }

    @Override
    public Result<ProviderInfoAddRespDTO> addProvider(ProviderInfoAddReqDTO providerInfoAddReqDTO) {
        providerInfoAddReqDTO.validation();
        return partnerWriteRpcService.addProvider(providerInfoAddReqDTO);
    }

    @Override
    public Result<String> updateProvider(ProviderInfoUpdateReqDTO providerInfoUpdateReqDTO) {
        providerInfoUpdateReqDTO.validation();
        return partnerWriteRpcService.updateProvider(providerInfoUpdateReqDTO);
    }

    @Override
    public Result<CustomerInfoAddRespDTO> addCustomer(CustomerInfoAddReqDTO customerInfoAddReqDTO) {
        customerInfoAddReqDTO.validation();
        return partnerWriteRpcService.addCustomer(customerInfoAddReqDTO);
    }

    @Override
    public Result<String> updateCustomer(CustomerInfoUpdateReqDTO customerInfoUpdateReqDTO) {
        customerInfoUpdateReqDTO.validation();
        return partnerWriteRpcService.updateCustomer(customerInfoUpdateReqDTO);
    }

    @Override
    public Result<String> delCompanyPartner(CompanyPartnerDelReqDTO companyPartnerDelReqDTO) {
        companyPartnerDelReqDTO.validation();
        return partnerWriteRpcService.delCompanyPartner(companyPartnerDelReqDTO);
    }

    @Override
    public Result<AddInvateRegisterPartnerRespDTO> addPartnerByInvateRegister(AddInvateRegisterPartnerReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteRpcService.addPartnerByInvateRegister(reqDTO);
    }
    @Override
    public Result<PartnerArrearsOrderAddRespDTO> addPartnerArrearsOrder(PartnerArrearsOrderAddReqDTO req) {
        req.validation();
        return partnerWriteRpcService.addPartnerArrearsOrder(req);
    }
    @Override
    public Result<PartnerLevelReferenceCountRespDTO> updateReferenceCount(PartnerLevelReferenceCountReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteRpcService.updateReferenceCount(reqDTO);
    }
    @Override
    public Result<PartnerLevelAddRespDTO> addPartnerLevel(PartnerLevelAddReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteRpcService.addPartnerLevel(reqDTO);
    }

    @Override
    public Result<String> updatePartnerLevel(PartnerLevelUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteRpcService.updatePartnerLevel(reqDTO);
    }

    @Override
    public Result<String> delPartnerLevel(PartnerLevelDelReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteRpcService.delPartnerLevel(reqDTO);
    }

    @Override
    public Result<PartnerInfoQueryRespDTO> partnerQueryOrAdd(PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO) {
        partnerQueryOrAddReqDTO.validation();
        return partnerWriteRpcService.partnerQueryOrAdd(partnerQueryOrAddReqDTO);
    }
}
