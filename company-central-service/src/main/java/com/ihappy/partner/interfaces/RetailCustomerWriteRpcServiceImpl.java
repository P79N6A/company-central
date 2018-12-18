package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.infrastructure.service.RetailCustomerWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/14.
 */
@Deprecated
public class RetailCustomerWriteRpcServiceImpl implements RetailCustomerWriteRpcService {
    @Autowired
    private IProcess addRetailCustomerProcess;
    @Autowired
    private IProcess updateRetailCustomerProcess;

    @Override
    public Result<RetailCustomerAddRespDTO> addRetailCustomer(RetailCustomerAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<RetailCustomerAddRespDTO>(), Action.ADD_RETAIL_CUSTOMER);
        addRetailCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateRetailCustomer(RetailCustomerUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_RETAIL_CUSTOMER);
        updateRetailCustomerProcess.start(context);
        return context.getResult();
    }
}
