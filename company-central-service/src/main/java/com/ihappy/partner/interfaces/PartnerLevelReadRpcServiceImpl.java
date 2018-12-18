package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerLevelReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/26.
 */
@Deprecated
public class PartnerLevelReadRpcServiceImpl implements PartnerLevelReadRpcService {
    @Autowired
    private IProcess queryPartnerLevelProcess;
    @Autowired
    private IProcess queryPartnerLevelListProcess;


    @Override
    public Result<PartnerLevelQueryRespDTO> findPartnerLevel(PartnerLevelQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerLevelQueryRespDTO>(), Action.QUERY_PARTNER_LEVEL);
        queryPartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<PartnerLevelQueryRespDTO>> findPartnerLevelList(PartnerLevelListQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<PartnerLevelQueryRespDTO>>(), Action.QUERY_PARTNER_LEVEL_LIST);
        queryPartnerLevelListProcess.start(context);
        return context.getResult();
    }
}
