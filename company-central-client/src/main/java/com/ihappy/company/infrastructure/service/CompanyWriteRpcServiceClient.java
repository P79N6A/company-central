package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExpireStatusUpdateReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.FactoryInfoConfigReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoAddRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/1.
 */
public class CompanyWriteRpcServiceClient implements CompanyWriteRpcService{
    private CompanyWriteRpcService companyWriteRpcService;

    public CompanyWriteRpcService getCompanyWriteRpcService() {
        return companyWriteRpcService;
    }

    public void setCompanyWriteRpcService(CompanyWriteRpcService companyWriteRpcService) {
        this.companyWriteRpcService = companyWriteRpcService;
    }

    @Override
    public Result<String> updateCompanyPayRemark(CompanyInfoUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return companyWriteRpcService.updateCompanyPayRemark(reqDTO);
    }

    @Override
    public Result<String> updateCompanyStatus(CompanyStatusReqDTO companyStatusReqDTO) {
        companyStatusReqDTO.validation();
        return companyWriteRpcService.updateCompanyStatus(companyStatusReqDTO);
    }

    @Override
    public Result<String> updateCompanyInfo(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
        companyInfoUpdateReqDTO.validation();
        return companyWriteRpcService.updateCompanyInfo(companyInfoUpdateReqDTO);
    }

    @Override
    public Result<Void> updateCompanyInfoByRpc(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
        companyInfoUpdateReqDTO.validation();
        return companyWriteRpcService.updateCompanyInfoByRpc(companyInfoUpdateReqDTO);
    }

    @Override
    public Result<CompanyInfoAddRespDTO> addCompanyInfo(CompanyInfoAddReqDTO companyInfoAddReqDTO) {
        companyInfoAddReqDTO.validation();
        return companyWriteRpcService.addCompanyInfo(companyInfoAddReqDTO);
    }

    @Override
    public Result<CompanyInfoAddRespDTO> addCompanyInfoByRpc(CompanyInfoAddByRpcReqDTO companyInfoAddByRpcReqDTO) {
        companyInfoAddByRpcReqDTO.validation();
        return companyWriteRpcService.addCompanyInfoByRpc(companyInfoAddByRpcReqDTO);
    }

    @Override
    public Result<Void> updateCompanyExpireStatus(CompanyExpireStatusUpdateReqDTO companyExpireStatusUpdateReqDTO) {
        return companyWriteRpcService.updateCompanyExpireStatus(companyExpireStatusUpdateReqDTO);
    }


    @Override
    public Result<Void> updateFactoryInfo(FactoryInfoConfigReqDTO factoryInfoConfigReqDTO) {
        factoryInfoConfigReqDTO.validation();
        return companyWriteRpcService.updateFactoryInfo(factoryInfoConfigReqDTO);
    }

    @Override
    public Result<CompanyBrandAddRespDTO> addCompanyBrand(CompanyBrandAddReqDTO companyBrandAddReqDTO) {
        companyBrandAddReqDTO.validation();
        return companyWriteRpcService.addCompanyBrand(companyBrandAddReqDTO);
    }

    @Override
    public Result<CompanyBrandAddInsideRespDTO> addCompanyBrandInside(CompanyBrandAddInsideReqDTO companyBrandAddInsideReqDTO) {
        companyBrandAddInsideReqDTO.validation();
        return companyWriteRpcService.addCompanyBrandInside(companyBrandAddInsideReqDTO);
    }

    @Override
    public Result<String> delCompanyBrand(CompanyBrandDelReqDTO companyBrandDelReqDTO) {
        companyBrandDelReqDTO.validation();
        return companyWriteRpcService.delCompanyBrand(companyBrandDelReqDTO);
    }

    @Override
    public Result<String> delCompanyBrands(CompanyBrandsDelReqDTO companyBrandsDelReqDTO) {
        companyBrandsDelReqDTO.validation();
        return companyWriteRpcService.delCompanyBrands(companyBrandsDelReqDTO);
    }
    @Override
    public Result<CompanyExtendServiceAddRespDTO> addCompanyExtendServiceJournal(CompanyExtendServiceAddReqDTO req) {
        req.validation();
        return companyWriteRpcService.addCompanyExtendServiceJournal(req);
    }
    @Override
    public Result<String> updateCompanyPrintConfig(CompanyPrintConfigInfoUpdateReqDTO companyPrintConfigInfoUpdateReqDTO) {
        companyPrintConfigInfoUpdateReqDTO.validation();
        return companyWriteRpcService.updateCompanyPrintConfig(companyPrintConfigInfoUpdateReqDTO);
    }
    @Override
    public Result<CompanyInfoVerifyRespDTO> verifyCompanyInfo(CompanyInfoVerifyReqDTO reqDTO) {
        reqDTO.validation();
        return companyWriteRpcService.verifyCompanyInfo(reqDTO);
    }

    @Override
    public Result<CompanyInfoVerifyAddRespDTO> addVerifyCompanyInfo(CompanyInfoVerifyAddReqDTO reqDTO) {
        reqDTO.validation();
        return companyWriteRpcService.addVerifyCompanyInfo(reqDTO);
    }

    @Override
    public Result<String> updateCompanyPrintMode(CompanyPrintModeUpdateReqDTO companyPrintModeUpdateReqDTO) {
        companyPrintModeUpdateReqDTO.validation();
        return companyWriteRpcService.updateCompanyPrintMode(companyPrintModeUpdateReqDTO);
    }
}
