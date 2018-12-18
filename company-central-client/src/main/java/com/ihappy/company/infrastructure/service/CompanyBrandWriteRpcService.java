package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.CompanyBrandAddInsideReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandAddReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandDelReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandsDelReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/1.
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyBrandWriteRpcService {
    /**
     * 企业添加品牌
     * @param companyBrandAddReqDTO
     * @return
     */
    Result<CompanyBrandAddRespDTO> addCompanyBrand(CompanyBrandAddReqDTO companyBrandAddReqDTO);

    /**
     * 内部rpc调用新增品牌
     * @param companyBrandAddInsideReqDTO
     * @return
     */
    Result<CompanyBrandAddInsideRespDTO> addCompanyBrandInside(CompanyBrandAddInsideReqDTO companyBrandAddInsideReqDTO);
    /**
     * 删除品牌
     * @param companyBrandDelReqDTO
     * @return
     */
    Result<String> delCompanyBrand(CompanyBrandDelReqDTO companyBrandDelReqDTO);

    /**
     * 批量删除品牌
     * @param companyBrandsDelReqDTO
     * @return
     */
    Result<String> delCompanyBrands(CompanyBrandsDelReqDTO companyBrandsDelReqDTO);
}
