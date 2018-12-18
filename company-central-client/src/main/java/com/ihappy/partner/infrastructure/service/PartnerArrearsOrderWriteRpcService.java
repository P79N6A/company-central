package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.partner.PartnerArrearsOrderAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerArrearsOrderAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/18.
 * 内部调用
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.PartnerWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface PartnerArrearsOrderWriteRpcService {
    /**
     * 添加欠款订单-内部调用
     * @param req
     * @return
     */
    Result<PartnerArrearsOrderAddRespDTO> addPartnerArrearsOrder(PartnerArrearsOrderAddReqDTO req);
}
