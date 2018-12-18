package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/14.
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.PartnerWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface RetailCustomerWriteRpcService {
    /**
     * 添加零售会员
     * @param reqDTO
     * @return
     */
    Result<RetailCustomerAddRespDTO> addRetailCustomer(RetailCustomerAddReqDTO reqDTO);

    /**
     * 编辑零售会员
     * @param reqDTO
     * @return
     */
    Result<String> updateRetailCustomer(RetailCustomerUpdateReqDTO reqDTO);
}
