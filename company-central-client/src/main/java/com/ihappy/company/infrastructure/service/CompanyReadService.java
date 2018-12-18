package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 11:21
 * *@content
 **/
public interface CompanyReadService {
    /**
     * 管理-查询公司信息
     * @param companyInfoQueryReqDTO
     * @return
     */
    Result<BaseInfoCompanyInfoQueryRespDTO> queryCompanyInfo(CompanyInfoQueryReqDTO companyInfoQueryReqDTO);

}
