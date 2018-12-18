package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.CompanyBrandListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/1.
 */
@Deprecated
public class CompanyBrandReadRpcServiceClient implements CompanyBrandReadRpcService {
    private CompanyBrandReadRpcService companyBrandReadRpcService;

    public CompanyBrandReadRpcService getCompanyBrandReadRpcService() {
        return companyBrandReadRpcService;
    }

    public void setCompanyBrandReadRpcService(CompanyBrandReadRpcService companyBrandReadRpcService) {
        this.companyBrandReadRpcService = companyBrandReadRpcService;
    }

    @Override
    public Result<List<CompanyBrandListQueryRespDTO>> findCompanyBrandList(CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO) {
        companyBrandListQueryReqDTO.validation();
        return companyBrandReadRpcService.findCompanyBrandList(companyBrandListQueryReqDTO);
    }
}
