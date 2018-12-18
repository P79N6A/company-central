package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerLevelInsideRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/3.
 */
@Deprecated
public class PartnerLevelInsideRpcServiceImpl implements PartnerLevelInsideRpcService {
    @Autowired
    private IProcess updateReferenceCountProcess;
    @Override
    public Result<PartnerLevelReferenceCountRespDTO> updateReferenceCount(PartnerLevelReferenceCountReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerLevelReferenceCountRespDTO>(), Action.UPDATE_REFERENCE_COUNT);
        updateReferenceCountProcess.start(context);
        return context.getResult();
    }
}
