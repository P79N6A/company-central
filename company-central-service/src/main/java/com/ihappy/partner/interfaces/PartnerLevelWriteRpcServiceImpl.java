package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerLevelWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/26.
 */
@Deprecated
public class PartnerLevelWriteRpcServiceImpl implements PartnerLevelWriteRpcService {
    @Autowired
    private IProcess addPartnerLevelProcess;
    @Autowired
    private IProcess updatePartnerLevelProcess;
    @Autowired
    private IProcess delPartnerLevelProcess;

    @Override
    public Result<PartnerLevelAddRespDTO> addPartnerLevel(PartnerLevelAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerLevelAddRespDTO>(), Action.ADD_PARTNER_LEVEL);
        addPartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updatePartnerLevel(PartnerLevelUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_PARTNER_LEVEL);
        updatePartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> delPartnerLevel(PartnerLevelDelReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.DEL_PARTNER_LEVEL);
        delPartnerLevelProcess.start(context);
        return context.getResult();
    }
}
