package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerLevelInsideRpcService;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/3.
 */
@Deprecated
public class PartnerLevelInsideRpcServiceClient implements PartnerLevelInsideRpcService {
    private PartnerLevelInsideRpcService partnerLevelInsideRpcService;

    public PartnerLevelInsideRpcService getPartnerLevelInsideRpcService() {
        return partnerLevelInsideRpcService;
    }

    public void setPartnerLevelInsideRpcService(PartnerLevelInsideRpcService partnerLevelInsideRpcService) {
        this.partnerLevelInsideRpcService = partnerLevelInsideRpcService;
    }

    @Override
    public Result<PartnerLevelReferenceCountRespDTO> updateReferenceCount(PartnerLevelReferenceCountReqDTO reqDTO) {
        reqDTO.validation();
        return partnerLevelInsideRpcService.updateReferenceCount(reqDTO);
    }
}
