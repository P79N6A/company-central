package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.CompanyInfoAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/6.
 * PC端企业认证 查询接口
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyVerifyReadRpcService {
    /**
     * 查询企业认证信息
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoVerifyReadRespDTO> findVerifyCompanyInfo(CompanyInfoVerifyReadReqDTO reqDTO);
}
