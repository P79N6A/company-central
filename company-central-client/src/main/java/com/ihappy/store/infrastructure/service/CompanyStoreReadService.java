package com.ihappy.store.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
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
 * 企业门店查询
 * Created by sunjd on 2018/4/10.
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyStoreReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface CompanyStoreReadService {
    /**
     * 查询门店列表
     * @param companyStoreListQueryReqDTO
     * @return List<CompanyStoreListQueryRespDTO>
     */
    Result<List<CompanyStoreListQueryRespDTO>> findStoreListByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO);

    /**
     *
     * @param companyStoreListQueryReqDTO
     * @return
     */
    Result<List<CompanyStoreListQueryRespDTO>> findStoreListWithPublicByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO);

    /**
     * 企业用户查询门店列表
     * @param companyStoreListByUserQueryReqDTO
     * @return
     */
    Result<List<CompanyStoreListQueryRespDTO>> findStoreListByUser(CompanyStoreListByUserQueryReqDTO companyStoreListByUserQueryReqDTO);

     /**
       * @Description: 分页条件查询微商铺(全部, 已收藏)
       * @Param:
       * @return:
       * @Author: zhangtengpo
       * @Date: 2018/6/11
       */
    Result<List<WeshopListQueryRespDTO>> findWeshopByPage(WeshopListQueryReqDTO weshopListQueryReqDTO);

     /**
       * @Description: 查询微商铺详细信息
       * @Param:
       * @return:
       * @Author: zhangtengpo
       * @Date: 2018/6/11
       */
    Result<WeshopDetailQueryRespDTO> findWeshopDetail(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO);

    /**
     * 查询微商铺详细信息-无需登录-用于商铺分享
     * @param weshopDetailQueryReqDTO
     * @return
     */
    Result<WeshopDetailQueryRespDTO> findWeshopDetailWithoutLogin(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO);

    /**
     *  查询微商铺的访问信息
     * @param weshopVisitDetailListQueryReqDTO
     * @return
     */
    Result<WeshopIndexDetailQueryRespDTO> queryWeshopVisitDetailList(WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO);

    /**
     * 查询门店打印ip和端口
     * @param reqDTO
     * @return
     */
    Result<StorePrintIpAndPortQueryRespDTO> findPrintIpAndPort(StoreQueryReqDTO reqDTO);

    /**
     * 查询门店列表
     * @param storeInfoByInfoQuery
     * @return List<CompanyStoreListQueryRespDTO>
     */
    Result<List<CompanyStoreListQueryRespDTO>> findStoreInfoByInfoQuery(StoreInfoByInfoQuery storeInfoByInfoQuery);

    /**
     * 获取微商铺 分享 二维码 和 地址
     * @param reqDTO
     * @return
     */
    Result<WeshopShareRespDTO> shareWeshop(WeshopShareReqDTO reqDTO);


    /**
     * 查询登录人所属门店
     * @param reqDTO
     * @return
     */
    Result<List<StoreInfoByLoginQueryRespDTO>> findStoreInfoByLogin(StoreInfoByLoginQueryReqDTO reqDTO);
}
