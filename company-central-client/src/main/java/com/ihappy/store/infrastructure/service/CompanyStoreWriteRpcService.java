package com.ihappy.store.infrastructure.service;


import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.store.StorePrintIpAndPortUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/5/16.
 * 企业门店修改
 */
public interface CompanyStoreWriteRpcService {

    /**
     * 修改门店ip和port
     */
    Result<String> updatePrintIpAndPort(StorePrintIpAndPortUpdateReqDTO reqDTO);

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

    /**
     * @author : zhangtengpo
     * @Description :  微商铺访问量增加接口
     * @create : 2018-06-06 16:14
     */
    Result<String> addWeshopVisitCount(WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO);

}
