package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.partner.PartnerLastContactTimeReqDTO;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoInsideAddRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerWriteInsideRpcService;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/20.
 */
@Deprecated
public class PartnerWriteInsideRpcServiceClient implements PartnerWriteInsideRpcService {
    private PartnerWriteInsideRpcService partnerWriteInsideRpcService;

    public PartnerWriteInsideRpcService getPartnerWriteInsideRpcService() {
        return partnerWriteInsideRpcService;
    }

    public void setPartnerWriteInsideRpcService(PartnerWriteInsideRpcService partnerWriteInsideRpcService) {
        this.partnerWriteInsideRpcService = partnerWriteInsideRpcService;
    }

    @Override
    public Result<String> lastContactTime(PartnerLastContactTimeReqDTO reqDTO) {
        reqDTO.validation();
        return partnerWriteInsideRpcService.lastContactTime(reqDTO);
    }

    @Override
    public Result<ProviderInfoInsideAddRespDTO> addOrQueryProvider(ProviderInfoInsideAddReqDTO reqDTO) {
        return partnerWriteInsideRpcService.addOrQueryProvider(reqDTO);
    }
}
