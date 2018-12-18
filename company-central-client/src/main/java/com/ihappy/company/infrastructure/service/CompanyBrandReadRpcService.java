package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.CompanyBrandListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * 企业品牌查询
 * Created by sunjd on 2018/4/1.
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyBrandReadRpcService {
    /**
     * 根据企业查询品牌列表
     * @param companyBrandListQueryReqDTO
     * @return
     */
    Result<List<CompanyBrandListQueryRespDTO>> findCompanyBrandList(CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO);
}
