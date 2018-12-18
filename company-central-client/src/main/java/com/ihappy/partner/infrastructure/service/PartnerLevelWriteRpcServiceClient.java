package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerLevelWriteRpcService;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/26.
 */
@Deprecated
public class PartnerLevelWriteRpcServiceClient implements PartnerLevelWriteRpcService{
    private PartnerLevelWriteRpcService partnerLevelWriteRpcService;

    public PartnerLevelWriteRpcService getPartnerLevelWriteRpcService() {
        return partnerLevelWriteRpcService;
    }

    public void setPartnerLevelWriteRpcService(PartnerLevelWriteRpcService partnerLevelWriteRpcService) {
        this.partnerLevelWriteRpcService = partnerLevelWriteRpcService;
    }

    @Override
    public Result<PartnerLevelAddRespDTO> addPartnerLevel(PartnerLevelAddReqDTO reqDTO) {
        reqDTO.validation();
        return partnerLevelWriteRpcService.addPartnerLevel(reqDTO);
    }

    @Override
    public Result<String> updatePartnerLevel(PartnerLevelUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return partnerLevelWriteRpcService.updatePartnerLevel(reqDTO);
    }

    @Override
    public Result<String> delPartnerLevel(PartnerLevelDelReqDTO reqDTO) {
        reqDTO.validation();
        return partnerLevelWriteRpcService.delPartnerLevel(reqDTO);
    }
}
