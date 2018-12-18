package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/28.
 * 公司服务到期时间延长接口
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyExtendServiceWriteRpcService {
    /**
     * 延长公司服务到期时间,并且生成流水
     * @param req
     * @return
     */
    Result<CompanyExtendServiceAddRespDTO> addCompanyExtendServiceJournal(CompanyExtendServiceAddReqDTO req);
}
