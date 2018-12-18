package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.partner.PartnerLastContactTimeReqDTO;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoInsideAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/20.
 */
@Deprecated
@Transfer(value = "com.ihappy.partner.infrastructure.service.PartnerWriteInsideRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface PartnerWriteInsideRpcService {
    /**
     * 更新往来时间
     * @param reqDTO
     * @return
     */
    Result<String>  lastContactTime(PartnerLastContactTimeReqDTO reqDTO);

    /**
     *  新增或者查询供应商信息
     * @param reqDTO
     * @return
     */
    Result<ProviderInfoInsideAddRespDTO>  addOrQueryProvider(ProviderInfoInsideAddReqDTO reqDTO);
}
