package com.ihappy.store.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @program: company-central
 * @description: 门店信息更新及增加
 * @author: 汪正
 * @create: 2018-05-16 17:39
 **/
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyStoreWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyStoreWriteService {
    /**
     *  更新门店信息 （微商铺相关的信息）
     * @param companyStoreUpdateReqDTO
     * @return Result<Boolean>
     */
    Result<Boolean> updateCompanyStoreWeshopInfo(CompanyStoreUpdateReqDTO companyStoreUpdateReqDTO);

    /**
     *  更新门店信息 （微商铺相关的信息）
     * @param companyWeshopCollectionReqDTO
     * @return Result<Boolean>
     */
    Result<Boolean> updateWeshopCollection(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO);

}
