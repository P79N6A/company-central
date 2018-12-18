package com.ihappy.store.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalByIdQuery;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.store.domain.dto.response.store.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/11 15:26
 * @Version
 */
public class CompanyStoreReadGatewayServiceClient implements CompanyStoreReadGatewayService {
    private CompanyStoreReadGatewayService companyStoreReadGatewayService;

    @Override
    public Result<Page<StorePerformanceRespDTO>> queryStorePerformancePage(StorePerformanceReqDTO reqDTO) {
        return null;
    }

    @Override
    public Result<Page<PersonPerformanceRespDTO>> queryPersonPerformancePage(PersonPerformanceReqDTO reqDTO) {
        return null;
    }

    @Override
    public Result<CompanyStroreInfoQueryRespDTO> findStoreInfo(CompanyStroreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        companyStroreInfoQueryReqDTO.validation();
        return companyStoreReadGatewayService.findStoreInfo(companyStroreInfoQueryReqDTO);
    }

    @Override
    public Result<List<StoreListQueryRespDTO>> findStoreList(StoreListQueryReqDTO storeListQueryReqDTO) {
        storeListQueryReqDTO.validation();
        return companyStoreReadGatewayService.findStoreList(storeListQueryReqDTO);
    }

    @Override
    public Result<Page<StorePageQueryRespDTO>> queryStorePage(StorePageQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadGatewayService.queryStorePage(reqDTO);
    }

    @Override
    public Result<Page<CompStorePayInfoPageRespDTO>> queryStoreInfoPayPage(CompStorePayInfoPageQueryReqDTO compStorePayInfoPageQueryReqDTO) {
        compStorePayInfoPageQueryReqDTO.validation();
        return companyStoreReadGatewayService.queryStoreInfoPayPage(compStorePayInfoPageQueryReqDTO);
    }
    @Override
    public Result<Page<OrderCompanyJournalInfoRespDTO>> queryOrderCompanyJournalPage(OrderCompanyJournalQuery orderCompanyJournalQuery) {
        orderCompanyJournalQuery.validation();
        return companyStoreReadGatewayService.queryOrderCompanyJournalPage(orderCompanyJournalQuery);
    }

    @Override
    public Result<OrderCompanyJournalInfoRespDTO> queryOrderCompanyJournalDetail(OrderCompanyJournalByIdQuery orderCompanyJournalByIdQuery) {
        orderCompanyJournalByIdQuery.validation();
        return companyStoreReadGatewayService.queryOrderCompanyJournalDetail(orderCompanyJournalByIdQuery);
    }

    @Override
    public Result<Page<StoreServiceStatusPageQueryRespDTO>> queryStoreServiceStatusPage(StoreServiceStatusPageQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadGatewayService.queryStoreServiceStatusPage(reqDTO);
    }

    @Override
    public Result<CompanyStroreInfoQueryRespDTO> findSharingStoreInfo(SharingCompanyStoreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        companyStroreInfoQueryReqDTO.validation();
        return companyStoreReadGatewayService.findSharingStoreInfo(companyStroreInfoQueryReqDTO);
    }

    @Override
    public Result<List<StoreQueryRespDTO>> queryStoreList(StoreQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadGatewayService.queryStoreList(reqDTO);
    }
}
