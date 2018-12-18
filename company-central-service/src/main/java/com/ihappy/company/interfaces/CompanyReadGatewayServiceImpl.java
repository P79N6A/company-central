package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.sys.UpdateStatusReqDTO;
import com.ihappy.company.domain.dto.response.sys.UpdateStatusRespDTO;
import com.ihappy.company.infrastructure.service.CompanyReadGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/10/11.
 */
public class CompanyReadGatewayServiceImpl implements CompanyReadGatewayService {
    @Autowired
    private IProcess quereyUpdateStatusProcess;

    @Override
    public Result<UpdateStatusRespDTO> quereyUpdateStatus(UpdateStatusReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<UpdateStatusRespDTO>(), Action.QUEREY_UPDATE_STATUS);
        quereyUpdateStatusProcess.start(context);
        return context.getResult();
    }
}
