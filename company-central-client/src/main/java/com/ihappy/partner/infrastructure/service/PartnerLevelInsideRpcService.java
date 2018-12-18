package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/3.
 * 会员等级 内部调用rpc
 */
@Deprecated
@Transfer(value = "com.ihappy.partner.infrastructure.service.PartnerLevelInsideRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface PartnerLevelInsideRpcService {
    /**
     * 会员等级引用计数回调
     * @param reqDTO
     * @return
     */
    Result<PartnerLevelReferenceCountRespDTO> updateReferenceCount(PartnerLevelReferenceCountReqDTO reqDTO);
}
