package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigInfoRespDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigListRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 12:54
 */
@Deprecated
public class CompanyPrintConfigReadServiceClient implements CompanyPrintConfigReadService {

    private CompanyPrintConfigReadService companyPrintConfigReadService;

    public void setCompanyPrintConfigReadService(CompanyPrintConfigReadService companyPrintConfigReadService) {
        this.companyPrintConfigReadService = companyPrintConfigReadService;
    }

    public CompanyPrintConfigReadService getCompanyPrintConfigReadService() {
        return companyPrintConfigReadService;
    }

    @Override
    public Result<CompanyPrintConfigInfoRespDTO> findCompanyPrintConfigInfo(CompanyPrintConfigInfoQueryReqDTO companyPrintConfigInfoQeuryReqDTO) {
        companyPrintConfigInfoQeuryReqDTO.validation();
        return companyPrintConfigReadService.findCompanyPrintConfigInfo(companyPrintConfigInfoQeuryReqDTO);
    }

    @Override
    public Result<List<CompanyPrintConfigListRespDTO>> findCompanyPrintConfigList(CompanyPrintConfigListQueryReqDTO companyPrintConfigListQueryReqDTO) {
        companyPrintConfigListQueryReqDTO.validation();
        return companyPrintConfigReadService.findCompanyPrintConfigList(companyPrintConfigListQueryReqDTO);
    }
}
