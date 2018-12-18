package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoUpdateReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 12:56
 */
@Deprecated
public class CompanyPrintConfigWriteServiceClient implements CompanyPrintConfigWriteService {

    private CompanyPrintConfigWriteService companyPrintConfigWriteService;

    @Override
    public Result<String> updateCompanyPrintConfig(CompanyPrintConfigInfoUpdateReqDTO companyPrintConfigInfoUpdateReqDTO) {
        companyPrintConfigInfoUpdateReqDTO.validation();
        return companyPrintConfigWriteService.updateCompanyPrintConfig(companyPrintConfigInfoUpdateReqDTO);
    }
}
