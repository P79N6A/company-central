package com.ihappy.partner.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
@Deprecated
public class PartnerReadRpcServiceClient implements PartnerReadRpcService {
    private PartnerReadRpcService partnerReadRpcService;

    public PartnerReadRpcService getPartnerReadRpcService() {
        return partnerReadRpcService;
    }

    public void setPartnerReadRpcService(PartnerReadRpcService partnerReadRpcService) {
        this.partnerReadRpcService = partnerReadRpcService;
    }

    @Override
    public Result<List<ProviderInfoListQueryRespDTO>> findProviderList(ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO) {
        providerInfoListQueryReqDTO.validation();
        return partnerReadRpcService.findProviderList(providerInfoListQueryReqDTO);
    }

    @Override
    public Result<ProviderInfoQueryRespDTO> findProvider(ProviderInfoQueryReqDTO providerInfoQueryReqDTO) {
        providerInfoQueryReqDTO.validation();
        return partnerReadRpcService.findProvider(providerInfoQueryReqDTO);
    }

    @Override
    public Result<List<CustomerInfoListQueryRespDTO>> findCustomerList(CustomerInfoListQueryReqDTO customerInfoQueryReqDTO) {
        customerInfoQueryReqDTO.validation();
        return partnerReadRpcService.findCustomerList(customerInfoQueryReqDTO);
    }

    @Override
    public Result<CustomerInfoQueryRespDTO> findCustomer(CustomerInfoQueryReqDTO customerInfoQueryReqDTO) {
        customerInfoQueryReqDTO.validation();
        return partnerReadRpcService.findCustomer(customerInfoQueryReqDTO);
    }

    @Override
    public Result<DefProviderListQueryRespDTO> findDefProviderList(DefProviderListQueryReqDTO defProviderListQueryReqDTO) {
        defProviderListQueryReqDTO.validation();
        return partnerReadRpcService.findDefProviderList(defProviderListQueryReqDTO);
    }

    @Override
    public Result<DefCustomerListQueryRespDTO> findDefCustomerList(DefCustomerListQueryReqDTO defCustomerListQueryReqDTO) {
        defCustomerListQueryReqDTO.validation();
        return partnerReadRpcService.findDefCustomerList(defCustomerListQueryReqDTO);
    }

    @Override
    public Result<PartnerInfoQueryRespDTO> findPartner(PartnerInfoQueryReqDTO partnerInfoQueryReqDTO) {
        partnerInfoQueryReqDTO.validation();
        return partnerReadRpcService.findPartner(partnerInfoQueryReqDTO);
    }

    @Override
    public Result<PartnerInfoQueryRespDTO> findDefaultPartner(PartnerDefQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadRpcService.findDefaultPartner(reqDTO);
    }

    @Override
    public Result<PartnerStatisticsRespDTO> findPartnerStatistics(PartnerStatisticsReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadRpcService.findPartnerStatistics(reqDTO);
    }

    @Override
    public Result<Page<PartnerInfoQueryRespDTO>> findPartnerPage(PartnerPageReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadRpcService.findPartnerPage(reqDTO);
    }

    @Override
    public Result<List<PartnerInfoQueryRespDTO>> findPartnerList(PartnerListQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadRpcService.findPartnerList(reqDTO);
    }

    @Override
    public Result<PartnerLevelQueryRespDTO> findPartnerLevel(PartnerLevelQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadRpcService.findPartnerLevel(reqDTO);
    }

    @Override
    public Result<List<PartnerLevelQueryRespDTO>> findPartnerLevelList(PartnerLevelListQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadRpcService.findPartnerLevelList(reqDTO);
    }
}
