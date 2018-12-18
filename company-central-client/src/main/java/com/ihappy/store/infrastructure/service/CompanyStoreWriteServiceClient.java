package com.ihappy.store.infrastructure.service;

import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @program: company-central
 * @description: 门店信息更新及增加实现接口
 * @author: 汪正
 * @create: 2018-05-16 17:43
 **/
@Deprecated
public class CompanyStoreWriteServiceClient implements CompanyStoreWriteService{
    private CompanyStoreWriteService companyStoreWriteService;
    @Override
    public Result<Boolean> updateCompanyStoreWeshopInfo(CompanyStoreUpdateReqDTO companyStoreUpdateReqDTO) {
        companyStoreUpdateReqDTO.validation();
        return companyStoreWriteService.updateCompanyStoreWeshopInfo(companyStoreUpdateReqDTO);
    }

    @Override
    public Result<Boolean> updateWeshopCollection(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {
        companyWeshopCollectionReqDTO.validation();
        return companyStoreWriteService.updateWeshopCollection(companyWeshopCollectionReqDTO);
    }
}
