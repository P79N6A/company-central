package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerLevelReadRpcService;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/26.
 */
@Deprecated
public class PartnerLevelReadRpcServiceClient implements PartnerLevelReadRpcService {
    private PartnerLevelReadRpcService partnerLevelReadRpcService;

    public PartnerLevelReadRpcService getPartnerLevelReadRpcService() {
        return partnerLevelReadRpcService;
    }

    public void setPartnerLevelReadRpcService(PartnerLevelReadRpcService partnerLevelReadRpcService) {
        this.partnerLevelReadRpcService = partnerLevelReadRpcService;
    }

    @Override
    public Result<PartnerLevelQueryRespDTO> findPartnerLevel(PartnerLevelQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerLevelReadRpcService.findPartnerLevel(reqDTO);
    }

    @Override
    public Result<List<PartnerLevelQueryRespDTO>> findPartnerLevelList(PartnerLevelListQueryReqDTO reqDTO) {
        reqDTO.validation();
        return partnerLevelReadRpcService.findPartnerLevelList(reqDTO);
    }
}
