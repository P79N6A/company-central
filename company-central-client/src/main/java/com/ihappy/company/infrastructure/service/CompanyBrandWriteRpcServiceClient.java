package com.ihappy.company.infrastructure.service;

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
public class CompanyBrandWriteRpcServiceClient implements CompanyBrandWriteRpcService {
    private CompanyBrandWriteRpcService companyBrandWriteRpcService;

    public CompanyBrandWriteRpcService getCompanyBrandWriteRpcService() {
        return companyBrandWriteRpcService;
    }

    public void setCompanyBrandWriteRpcService(CompanyBrandWriteRpcService companyBrandWriteRpcService) {
        this.companyBrandWriteRpcService = companyBrandWriteRpcService;
    }

    @Override
    public Result<CompanyBrandAddRespDTO> addCompanyBrand(CompanyBrandAddReqDTO companyBrandAddReqDTO) {
        companyBrandAddReqDTO.validation();
        return companyBrandWriteRpcService.addCompanyBrand(companyBrandAddReqDTO);
    }

    @Override
    public Result<CompanyBrandAddInsideRespDTO> addCompanyBrandInside(CompanyBrandAddInsideReqDTO companyBrandAddInsideReqDTO) {
        companyBrandAddInsideReqDTO.validation();
        return companyBrandWriteRpcService.addCompanyBrandInside(companyBrandAddInsideReqDTO);
    }

    @Override
    public Result<String> delCompanyBrand(CompanyBrandDelReqDTO companyBrandDelReqDTO) {
        companyBrandDelReqDTO.validation();
        return companyBrandWriteRpcService.delCompanyBrand(companyBrandDelReqDTO);
    }

    @Override
    public Result<String> delCompanyBrands(CompanyBrandsDelReqDTO companyBrandsDelReqDTO) {
        companyBrandsDelReqDTO.validation();
        return companyBrandWriteRpcService.delCompanyBrands(companyBrandsDelReqDTO);
    }


}
