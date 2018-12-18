package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/25.
 */
@Deprecated
public class CompanyCompletionInfoWriteRpcServiceClient implements CompanyCompletionInfoWriteRpcService {
    private CompanyCompletionInfoWriteRpcService companyCompletionInfoWriteRpcService;

    public CompanyCompletionInfoWriteRpcService getCompanyCompletionInfoWriteRpcService() {
        return companyCompletionInfoWriteRpcService;
    }

    public void setCompanyCompletionInfoWriteRpcService(CompanyCompletionInfoWriteRpcService companyCompletionInfoWriteRpcService) {
        this.companyCompletionInfoWriteRpcService = companyCompletionInfoWriteRpcService;
    }

    @Override
    public Result<String> completionInfo(CompanyCompletionInfoReqDTO reqDTO) {
        reqDTO.validation();
        return companyCompletionInfoWriteRpcService.completionInfo(reqDTO);
    }
}
