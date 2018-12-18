package com.ihappy.store.infrastructure.service;

import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.request.weshop.WeshopDetailQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopListQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopShareReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitDetailListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.dto.response.store.StoreInfoByLoginQueryRespDTO;
import com.ihappy.store.domain.dto.response.store.StorePrintIpAndPortQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopIndexDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopListQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopShareRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/10.
 */
@Deprecated
public class CompanyStoreReadServiceClient implements CompanyStoreReadService {
    private CompanyStoreReadService companyStoreReadService;

    public CompanyStoreReadService getCompanyStoreReadService() {
        return companyStoreReadService;
    }

    public void setCompanyStoreReadService(CompanyStoreReadService companyStoreReadService) {
        this.companyStoreReadService = companyStoreReadService;
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        companyStoreListQueryReqDTO.validation();
        return companyStoreReadService.findStoreListByCompIdAndStoreIds(companyStoreListQueryReqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListWithPublicByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        companyStoreListQueryReqDTO.validation();
        return companyStoreReadService.findStoreListWithPublicByCompIdAndStoreIds(companyStoreListQueryReqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListByUser(CompanyStoreListByUserQueryReqDTO companyStoreListByUserQueryReqDTO) {
        companyStoreListByUserQueryReqDTO.validation();
        return companyStoreReadService.findStoreListByUser(companyStoreListByUserQueryReqDTO);
    }

    @Override
    public Result<StorePrintIpAndPortQueryRespDTO> findPrintIpAndPort(StoreQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadService.findPrintIpAndPort(reqDTO);
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreInfoByInfoQuery(StoreInfoByInfoQuery storeInfoByInfoQuery) {
        return companyStoreReadService.findStoreInfoByInfoQuery(storeInfoByInfoQuery);
    }

    @Override
    public Result<WeshopShareRespDTO> shareWeshop(WeshopShareReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadService.shareWeshop(reqDTO);
    }

    @Override
    public Result<List<StoreInfoByLoginQueryRespDTO>> findStoreInfoByLogin(StoreInfoByLoginQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreReadService.findStoreInfoByLogin(reqDTO);
    }

    @Override
    public Result<List<WeshopListQueryRespDTO>> findWeshopByPage(WeshopListQueryReqDTO weshopListQueryReqDTO) {
        weshopListQueryReqDTO.validation();
        return companyStoreReadService.findWeshopByPage(weshopListQueryReqDTO);
    }

    @Override
    public Result<WeshopDetailQueryRespDTO> findWeshopDetail(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO) {
        weshopDetailQueryReqDTO.validation();
        return companyStoreReadService.findWeshopDetail(weshopDetailQueryReqDTO);
    }

    @Override
    public Result<WeshopDetailQueryRespDTO> findWeshopDetailWithoutLogin(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO) {
        weshopDetailQueryReqDTO.validation();
        return companyStoreReadService.findWeshopDetailWithoutLogin(weshopDetailQueryReqDTO);
    }

    @Override
    public Result<WeshopIndexDetailQueryRespDTO> queryWeshopVisitDetailList(WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO) {
        weshopVisitDetailListQueryReqDTO.validation();
        return companyStoreReadService.queryWeshopVisitDetailList(weshopVisitDetailListQueryReqDTO);
    }
}
