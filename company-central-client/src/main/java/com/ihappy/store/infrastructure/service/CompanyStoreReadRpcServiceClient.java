package com.ihappy.store.infrastructure.service;

import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.request.weshop.WeshopDetailQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopListQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopShareReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitDetailListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.*;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopIndexDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopListQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopShareRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;


/**
 * @program: company-central
 * @description: 门店信息查询
 * @author: 汪正
 * @create: 2018-07-30 13:37
 **/
public class CompanyStoreReadRpcServiceClient implements CompanyStoreReadRpcService {

    private CompanyStoreReadRpcService companyStoreReadRpcService;

    public CompanyStoreReadRpcService getCompanyStoreReadRpcService() {
        return companyStoreReadRpcService;
    }

    public void setCompanyStoreReadRpcService(CompanyStoreReadRpcService companyStoreReadRpcService) {
        this.companyStoreReadRpcService = companyStoreReadRpcService;
    }

    @Override
    public Result<StoreInfoQueryRespDTO> queryStoreInfoByStoreName(StoreInfoQueryReqDTO storeInfoQueryReqDTO) {
        storeInfoQueryReqDTO.validation();
        return companyStoreReadRpcService.queryStoreInfoByStoreName(storeInfoQueryReqDTO);
    }
    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        companyStoreListQueryReqDTO.validation();
        return companyStoreReadRpcService.findStoreListByCompIdAndStoreIds(companyStoreListQueryReqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListWithPublicByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        companyStoreListQueryReqDTO.validation();
        return companyStoreReadRpcService.findStoreListWithPublicByCompIdAndStoreIds(companyStoreListQueryReqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListByUser(CompanyStoreListByUserQueryReqDTO companyStoreListByUserQueryReqDTO) {
        companyStoreListByUserQueryReqDTO.validation();
        return companyStoreReadRpcService.findStoreListByUser(companyStoreListByUserQueryReqDTO);
    }

    @Override
    public Result<StorePrintIpAndPortQueryRespDTO> findPrintIpAndPort(StoreQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadRpcService.findPrintIpAndPort(reqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreInfoByInfoQuery(StoreInfoByInfoQuery storeInfoByInfoQuery) {
        return companyStoreReadRpcService.findStoreInfoByInfoQuery(storeInfoByInfoQuery);
    }

    @Override
    public Result<WeshopShareRespDTO> shareWeshop(WeshopShareReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadRpcService.shareWeshop(reqDTO);
    }

    @Override
    public Result<List<StoreQueryRespDTO>> queryStoreList(StoreQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadRpcService.queryStoreList(reqDTO);
    }

    @Override
    public Result<List<UserInfoRespDTO>> queryStoreManager(StoreManagerQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadRpcService.queryStoreManager(reqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> queryAllStoreByCompId(CompanyStoreListQueryReqDTO reqDTO) {
        return companyStoreReadRpcService.queryAllStoreByCompId(reqDTO);
    }

    @Override
    public Result<List<SalePerformanceRespDTO>> querySalePerformanceByCondition(SalePerformanceReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadRpcService.querySalePerformanceByCondition(reqDTO);
    }

    @Override
    public Result<StorePerformanceRespDTO> queryStorePerformance(StorePerformanceReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadRpcService.queryStorePerformance(reqDTO);
    }

    @Override
    public Result<List<WeshopListQueryRespDTO>> findWeshopByPage(WeshopListQueryReqDTO weshopListQueryReqDTO) {
        weshopListQueryReqDTO.validation();
        return companyStoreReadRpcService.findWeshopByPage(weshopListQueryReqDTO);
    }

    @Override
    public Result<WeshopDetailQueryRespDTO> findWeshopDetail(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO) {
        weshopDetailQueryReqDTO.validation();
        return companyStoreReadRpcService.findWeshopDetail(weshopDetailQueryReqDTO);
    }

    @Override
    public Result<WeshopDetailQueryRespDTO> findWeshopDetailWithoutLogin(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO) {
        weshopDetailQueryReqDTO.validation();
        return companyStoreReadRpcService.findWeshopDetailWithoutLogin(weshopDetailQueryReqDTO);
    }

    @Override
    public Result<WeshopIndexDetailQueryRespDTO> queryWeshopVisitDetailList(WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO) {
        weshopVisitDetailListQueryReqDTO.validation();
        return companyStoreReadRpcService.queryWeshopVisitDetailList(weshopVisitDetailListQueryReqDTO);
    }
}
