package com.ihappy.partner.interfaces;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.communal.template.ServiceExecuteTemplate;
import com.ihappy.partner.domain.dto.request.partner.PartnerInfoQueryReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerReadGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/10/11.
 */

public class PartnerReadGatewayServiceImpl implements PartnerReadGatewayService {
    @Autowired
    private IProcess queryRetailCustomerProcess;

    @Autowired
    private IProcess queryRetailCustomerPageProcess;
    @Autowired
    private IProcess queryShouldPartnerBeNotifiedProcess;

    @Override
    public Result<RetailCustomerQueryRespDTO> findRetailCustomer(RetailCustomerQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<RetailCustomerQueryRespDTO>(), Action.QUERY_RETAIL_CUSTOMER);
        queryRetailCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<RetailCustomerQueryPageRespDTO>> findRetailCustomerPage(RetailCustomerQueryPageReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<Page<RetailCustomerQueryPageRespDTO>>(), Action.QUERY_RETAIL_CUSTOMER_PAGE);
        queryRetailCustomerPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Boolean> queryShouldPartnerBeNotified(PartnerInfoQueryReqDTO partnerInfoQueryReqDTO) {
        return ServiceExecuteTemplate.executeCommon(queryShouldPartnerBeNotifiedProcess, partnerInfoQueryReqDTO,
                Boolean.class, Action.QUERY_PARTNER);
    }
}
