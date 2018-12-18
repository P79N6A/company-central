package com.ihappy.partner.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.partner.infrastructure.service.RetailCustomerReadRpcService;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/14.
 */
@Deprecated
public class RetailCustomerReadRpcServiceClient implements RetailCustomerReadRpcService {
    private RetailCustomerReadRpcService retailCustomerReadRpcService;

    public RetailCustomerReadRpcService getRetailCustomerReadRpcService() {
        return retailCustomerReadRpcService;
    }

    public void setRetailCustomerReadRpcService(RetailCustomerReadRpcService retailCustomerReadRpcService) {
        this.retailCustomerReadRpcService = retailCustomerReadRpcService;
    }

    @Override
    public Result<RetailCustomerQueryRespDTO> findRetailCustomer(RetailCustomerQueryReqDTO reqDTO) {
        reqDTO.validation();
        return retailCustomerReadRpcService.findRetailCustomer(reqDTO);
    }

    @Override
    public Result<Page<RetailCustomerQueryPageRespDTO>> findRetailCustomerPage(RetailCustomerQueryPageReqDTO reqDTO) {
        reqDTO.validation();
        return retailCustomerReadRpcService.findRetailCustomerPage(reqDTO);
    }
}
