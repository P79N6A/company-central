package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 11:22
 * *@content
 **/
public class CompanyReadServiceClient implements CompanyReadService {
    @Autowired
    private CompanyReadService companyReadServic;
    @Override
    public Result<BaseInfoCompanyInfoQueryRespDTO> queryCompanyInfo(CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        companyInfoQueryReqDTO.validation();
        return companyReadServic.queryCompanyInfo(companyInfoQueryReqDTO);
    }
}
