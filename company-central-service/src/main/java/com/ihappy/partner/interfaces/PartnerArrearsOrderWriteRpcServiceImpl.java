package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.partner.PartnerArrearsOrderAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerArrearsOrderAddRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerArrearsOrderWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/18.
 */
@Deprecated
public class PartnerArrearsOrderWriteRpcServiceImpl implements PartnerArrearsOrderWriteRpcService {
    @Autowired
    private IProcess addPartnerArrearsOrderProcess;

    @Override
    public Result<PartnerArrearsOrderAddRespDTO> addPartnerArrearsOrder(PartnerArrearsOrderAddReqDTO req) {
        Context context = new Context(req, new Result<PartnerArrearsOrderAddRespDTO>(), Action.ADD_PARTNER_ARREARS_ORDER);
        addPartnerArrearsOrderProcess.start(context);
        return context.getResult();
    }
}
