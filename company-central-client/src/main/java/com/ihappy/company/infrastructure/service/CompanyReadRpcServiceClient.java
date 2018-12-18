package com.ihappy.company.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.*;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.*;
import com.ihappy.company.domain.dto.response.companyinfo.*;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 */
public class CompanyReadRpcServiceClient implements CompanyReadRpcService{

    private CompanyReadRpcService companyReadRpcService;

    public CompanyReadRpcService getCompanyReadRpcService() {
        return companyReadRpcService;
    }

    public void setCompanyReadRpcService(CompanyReadRpcService companyReadRpcService) {
        this.companyReadRpcService = companyReadRpcService;
    }

    @Override
    public Result<Page<BaseinfoCompanyRespDTO>> findBaseinfoCompanyPage(BaseinfoCompanyReqDTO baseinfoCompanyReqDTO) {
        baseinfoCompanyReqDTO.validation();
        return companyReadRpcService.findBaseinfoCompanyPage(baseinfoCompanyReqDTO);
    }

    @Override
    public Result<CompanyInfoQueryRespDTO> findCompanyInfo(CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        companyInfoQueryReqDTO.validation();
        return companyReadRpcService.findCompanyInfo(companyInfoQueryReqDTO);
    }

    @Override
    public Result<List<CompanyInfoListQueryRespDTO>> findCompanyInfoListByIds(CompanyInfoListQueryReqDTO companyInfoListQueryReqDTO) {
        companyInfoListQueryReqDTO.validation();
        return companyReadRpcService.findCompanyInfoListByIds(companyInfoListQueryReqDTO);
    }

    @Override
    public Result<CompanyInfoWithoutLoginQueryRespDTO> findCompanyInfoWithoutLogin(CompanyInfoWithoutLoginQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyReadRpcService.findCompanyInfoWithoutLogin(reqDTO);
    }

    @Override
    public Result<CompanyExpireDateQueryRespDTO> queryCompanyExpireDate(CompanyInfoByCompIdQuery companyInfoByCompIdQuery) {
        return companyReadRpcService.queryCompanyExpireDate(companyInfoByCompIdQuery);
    }

    @Override
    public Result<CompanyExpireStatusRespDTO> queryCompanyExpireStatue(CompanyExpireStatusByCompIdQuery companyExpireStatusByCompIdQuery) {
        return companyReadRpcService.queryCompanyExpireStatue(companyExpireStatusByCompIdQuery);
    }

    @Override
    public Result<Page<CompanyServiceStatusPageQueryRespDTO>> queryCompanyServiceStatusPage(CompanyServiceStatusPageQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyReadRpcService.queryCompanyServiceStatusPage(reqDTO);
    }

    @Override
    public Result<List<FactoryInfoRespDTO>> queryCompanyFactoryInfoForList(UsopRequestBaseQuery usopRequestBaseQuery) {
        return companyReadRpcService.queryCompanyFactoryInfoForList(usopRequestBaseQuery);
    }

    @Override
    public Result<FactoryInfosRespDTO> queryFactoryInfosRespDTO(UsopRequestBaseQuery usopRequestBaseQuery) {
        return companyReadRpcService.queryFactoryInfosRespDTO(usopRequestBaseQuery);
    }


    @Override
    public Result<List<FactoryInfoRespDTO>> queryCompanyFactoryInfoForListByCompId(FactoryInfoConfigQuery factoryInfoConfigQuery) {

        factoryInfoConfigQuery.validation();
        return companyReadRpcService.queryCompanyFactoryInfoForListByCompId(factoryInfoConfigQuery);
    }

    @Override
    public Result<List<CompanyBrandListQueryRespDTO>> findCompanyBrandList(CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO) {
        companyBrandListQueryReqDTO.validation();
        return companyReadRpcService.findCompanyBrandList(companyBrandListQueryReqDTO);
    }
    @Override
    public Result<CompanyPrintConfigInfoRespDTO> findCompanyPrintConfigInfo(CompanyPrintConfigInfoQueryReqDTO companyPrintConfigInfoQeuryReqDTO) {
        companyPrintConfigInfoQeuryReqDTO.validation();
        return companyReadRpcService.findCompanyPrintConfigInfo(companyPrintConfigInfoQeuryReqDTO);
    }

    @Override
    public Result<List<CompanyPrintConfigListRespDTO>> findCompanyPrintConfigList(CompanyPrintConfigListQueryReqDTO companyPrintConfigListQueryReqDTO) {
        companyPrintConfigListQueryReqDTO.validation();
        return companyReadRpcService.findCompanyPrintConfigList(companyPrintConfigListQueryReqDTO);
    }
    @Override
    public Result<CompanyInfoVerifyReadRespDTO> findVerifyCompanyInfo(CompanyInfoVerifyReadReqDTO reqDTO) {
        reqDTO.validation();
        return companyReadRpcService.findVerifyCompanyInfo(reqDTO);
    }
    @Override
    public Result<List<SysCompanyTypeInfoRespDTO>> queryAllSysCompanyType(SysCompanyTypeAllQuery sysCompanyTypeAllQuery) {
        return companyReadRpcService.queryAllSysCompanyType(sysCompanyTypeAllQuery);
    }
}
