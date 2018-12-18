package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/25.
 * 补全公司数据接口
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.BackdoorRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyCompletionInfoWriteRpcService {
    /**
     * 填充公司数据
     * @param reqDTO
     * @return
     */
    Result<String> completionInfo(CompanyCompletionInfoReqDTO reqDTO);
}
