package com.ihappy.store.infrastructure.service;

import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.store.StorePrintIpAndPortUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/16.
 */
public class CompanyStoreWriteRpcServiceClient implements CompanyStoreWriteRpcService {
    private CompanyStoreWriteRpcService companyStoreWriteRpcService;

    public CompanyStoreWriteRpcService getCompanyStoreWriteRpcService() {
        return companyStoreWriteRpcService;
    }

    public void setCompanyStoreWriteRpcService(CompanyStoreWriteRpcService companyStoreWriteRpcService) {
        this.companyStoreWriteRpcService = companyStoreWriteRpcService;
    }

    @Override
    public Result<String> updatePrintIpAndPort(StorePrintIpAndPortUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreWriteRpcService.updatePrintIpAndPort(reqDTO);
    }
    @Override
    public Result<Boolean> updateCompanyStoreWeshopInfo(CompanyStoreUpdateReqDTO companyStoreUpdateReqDTO) {
        companyStoreUpdateReqDTO.validation();
        return companyStoreWriteRpcService.updateCompanyStoreWeshopInfo(companyStoreUpdateReqDTO);
    }

    @Override
    public Result<Boolean> updateWeshopCollection(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {
        companyWeshopCollectionReqDTO.validation();
        return companyStoreWriteRpcService.updateWeshopCollection(companyWeshopCollectionReqDTO);
    }
    @Override
    public Result<String> addWeshopVisitCount(WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO) {
        weshopVisitCountAddReqDTO.validation();
        return companyStoreWriteRpcService.addWeshopVisitCount(weshopVisitCountAddReqDTO);
    }


}
