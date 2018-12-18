package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/6.
 * PC端企业认证 修改接口
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyVerifyWriteRpcService {
    /**
     * 审核公司信息
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoVerifyRespDTO> verifyCompanyInfo(CompanyInfoVerifyReqDTO reqDTO);

    /**
     * 提交认证--添加审核信息
     * @param reqDTO
     * @return
     */
    Result<CompanyInfoVerifyAddRespDTO> addVerifyCompanyInfo(CompanyInfoVerifyAddReqDTO reqDTO);
}
