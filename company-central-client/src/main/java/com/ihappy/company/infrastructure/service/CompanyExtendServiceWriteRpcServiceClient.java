package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/6/28.
 */
@Deprecated
public class CompanyExtendServiceWriteRpcServiceClient implements CompanyExtendServiceWriteRpcService {
    private CompanyExtendServiceWriteRpcService companyExtendServiceWriteRpcService;

    public CompanyExtendServiceWriteRpcService getCompanyExtendServiceWriteRpcService() {
        return companyExtendServiceWriteRpcService;
    }

    public void setCompanyExtendServiceWriteRpcService(CompanyExtendServiceWriteRpcService companyExtendServiceWriteRpcService) {
        this.companyExtendServiceWriteRpcService = companyExtendServiceWriteRpcService;
    }

    @Override
    public Result<CompanyExtendServiceAddRespDTO> addCompanyExtendServiceJournal(CompanyExtendServiceAddReqDTO req) {
        req.validation();
        return companyExtendServiceWriteRpcService.addCompanyExtendServiceJournal(req);
    }
}
