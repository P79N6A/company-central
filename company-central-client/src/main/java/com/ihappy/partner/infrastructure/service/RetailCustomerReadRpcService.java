package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.common.domain.Page;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/14.
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.PartnerReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface RetailCustomerReadRpcService {
    /**
     * 查询单个零售会员
     * @param reqDTO
     * @return
     */
    Result<RetailCustomerQueryRespDTO> findRetailCustomer(RetailCustomerQueryReqDTO reqDTO);

    /**
     * 查询零售会员分页列表
     * @param reqDTO
     * @return
     */
    Result<Page<RetailCustomerQueryPageRespDTO>> findRetailCustomerPage(RetailCustomerQueryPageReqDTO reqDTO);
}
