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
 * *@created by zhangmengdan
 * *@created at 2018/11/1 9:29
 * *@content
 **/
public class PartnerReadGatewayServiceClient implements PartnerReadGatewayService {
    private PartnerReadGatewayService partnerReadGatewayService;

    @Override
    public Result<RetailCustomerQueryRespDTO> findRetailCustomer(RetailCustomerQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadGatewayService.findRetailCustomer(reqDTO);
    }

    @Override
    public Result<Page<RetailCustomerQueryPageRespDTO>> findRetailCustomerPage(RetailCustomerQueryPageReqDTO reqDTO) {
        reqDTO.validation();
        return partnerReadGatewayService.findRetailCustomerPage(reqDTO);
    }

    @Override
    public Result<Boolean> queryShouldPartnerBeNotified(PartnerInfoQueryReqDTO partnerInfoQueryReqDTO) {
        partnerInfoQueryReqDTO.validation();
        return partnerReadGatewayService.queryShouldPartnerBeNotified(partnerInfoQueryReqDTO);
    }
}
