package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/6.
 */
@Deprecated
public class CompanyVerifyReadRpcServiceClient implements CompanyVerifyReadRpcService {
    private CompanyVerifyReadRpcService companyVerifyReadRpcService;

    public CompanyVerifyReadRpcService getCompanyVerifyReadRpcService() {
        return companyVerifyReadRpcService;
    }

    public void setCompanyVerifyReadRpcService(CompanyVerifyReadRpcService companyVerifyReadRpcService) {
        this.companyVerifyReadRpcService = companyVerifyReadRpcService;
    }

    @Override
    public Result<CompanyInfoVerifyReadRespDTO> findVerifyCompanyInfo(CompanyInfoVerifyReadReqDTO reqDTO) {
        reqDTO.validation();
        return companyVerifyReadRpcService.findVerifyCompanyInfo(reqDTO);
    }
}
