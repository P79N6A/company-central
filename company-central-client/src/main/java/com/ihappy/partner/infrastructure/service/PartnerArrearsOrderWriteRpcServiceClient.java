package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.partner.PartnerArrearsOrderAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerArrearsOrderAddRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerArrearsOrderWriteRpcService;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/18.
 */
@Deprecated
public class PartnerArrearsOrderWriteRpcServiceClient implements PartnerArrearsOrderWriteRpcService {
    private PartnerArrearsOrderWriteRpcService partnerArrearsOrderWriteRpcService;

    public PartnerArrearsOrderWriteRpcService getPartnerArrearsOrderWriteRpcService() {
        return partnerArrearsOrderWriteRpcService;
    }

    public void setPartnerArrearsOrderWriteRpcService(PartnerArrearsOrderWriteRpcService partnerArrearsOrderWriteRpcService) {
        this.partnerArrearsOrderWriteRpcService = partnerArrearsOrderWriteRpcService;
    }

    @Override
    public Result<PartnerArrearsOrderAddRespDTO> addPartnerArrearsOrder(PartnerArrearsOrderAddReqDTO req) {
        req.validation();
        return partnerArrearsOrderWriteRpcService.addPartnerArrearsOrder(req);
    }
}
