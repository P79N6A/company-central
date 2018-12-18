package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.partner.PartnerLastContactTimeReqDTO;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoInsideAddRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerWriteInsideRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/20.
 */
@Deprecated
public class PartnerWriteInsideRpcServiceImpl implements PartnerWriteInsideRpcService {
    @Autowired
    private IProcess updatePartnerLastContactTimeProcess;

    @Autowired
    private IProcess addOrQueryProviderInsideProcess;

    @Override
    public Result<String> lastContactTime(PartnerLastContactTimeReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_PARTNER_LAST_CONTACT_TIME);
        updatePartnerLastContactTimeProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<ProviderInfoInsideAddRespDTO> addOrQueryProvider(ProviderInfoInsideAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_PARTNER_LAST_CONTACT_TIME);
        addOrQueryProviderInsideProcess.start(context);
        return context.getResult();
    }
}
