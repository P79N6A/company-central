package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/6.
 */
@Deprecated
public class CompanyVerifyWriteRpcServiceClient implements CompanyVerifyWriteRpcService {
    private CompanyVerifyWriteRpcService companyVerifyWriteRpcService;

    public CompanyVerifyWriteRpcService getCompanyVerifyWriteRpcService() {
        return companyVerifyWriteRpcService;
    }

    public void setCompanyVerifyWriteRpcService(CompanyVerifyWriteRpcService companyVerifyWriteRpcService) {
        this.companyVerifyWriteRpcService = companyVerifyWriteRpcService;
    }

    @Override
    public Result<CompanyInfoVerifyRespDTO> verifyCompanyInfo(CompanyInfoVerifyReqDTO reqDTO) {
        reqDTO.validation();
        return companyVerifyWriteRpcService.verifyCompanyInfo(reqDTO);
    }

    @Override
    public Result<CompanyInfoVerifyAddRespDTO> addVerifyCompanyInfo(CompanyInfoVerifyAddReqDTO reqDTO) {
        reqDTO.validation();
        return companyVerifyWriteRpcService.addVerifyCompanyInfo(reqDTO);
    }
}
