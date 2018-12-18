package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.infrastructure.service.RetailCustomerWriteRpcService;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/14.
 */
@Deprecated
public class RetailCustomerWriteRpcServiceClient implements RetailCustomerWriteRpcService {
    private RetailCustomerWriteRpcService retailCustomerWriteRpcService;

    public RetailCustomerWriteRpcService getRetailCustomerWriteRpcService() {
        return retailCustomerWriteRpcService;
    }

    public void setRetailCustomerWriteRpcService(RetailCustomerWriteRpcService retailCustomerWriteRpcService) {
        this.retailCustomerWriteRpcService = retailCustomerWriteRpcService;
    }

    @Override
    public Result<RetailCustomerAddRespDTO> addRetailCustomer(RetailCustomerAddReqDTO reqDTO) {
        reqDTO.validation();
        return retailCustomerWriteRpcService.addRetailCustomer(reqDTO);
    }

    @Override
    public Result<String> updateRetailCustomer(RetailCustomerUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return retailCustomerWriteRpcService.updateRetailCustomer(reqDTO);
    }

}
