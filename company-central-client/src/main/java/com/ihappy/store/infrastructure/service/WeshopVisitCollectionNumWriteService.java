package com.ihappy.store.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * @author : zhangtengpo
 * @Description :  微商铺访问量增加接口
 * @create : 2018-06-06 16:14
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyStoreWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface WeshopVisitCollectionNumWriteService {

    Result<String> addWeshopVisitCount(WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO);

}
