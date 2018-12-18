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
public interface CompanyStoreReadRpcService {

    /**
     *      根据门店名称查询门店信息
     * @param storeInfoQueryReqDTO
     * @return
     */
    Result<StoreInfoQueryRespDTO> queryStoreInfoByStoreName(StoreInfoQueryReqDTO storeInfoQueryReqDTO);
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
     * @Author sunjd
     * @Description 根据条件查询门店列表
     * @Date 14:45 2018/11/20
     * @Param [reqDTO]
     * @return com.ihappy.unifiedLog.module.Result<java.util.List<com.ihappy.store.domain.dto.response.store.StoreQueryRespDTO>>
     **/
    Result<List<StoreQueryRespDTO>> queryStoreList(StoreQueryReqDTO reqDTO);


    Result<List<UserInfoRespDTO>> queryStoreManager(StoreManagerQueryReqDTO reqDTO);

    /**
     * 查询所有门店
     * @param reqDTO
     * @return
     */
    Result<List<CompanyStoreListQueryRespDTO>> queryAllStoreByCompId(CompanyStoreListQueryReqDTO reqDTO);

    /**
     * @Author sunjd
     * @Description 根据条件查询业绩表-rpc调用
     * @Date 14:44 2018/11/3
     * @Param [reqDTO]
     * @return com.ihappy.unifiedLog.module.Result<java.util.List<com.ihappy.store.domain.dto.response.store.SalePerformanceRespDTO>>
     **/
    Result<List<SalePerformanceRespDTO>> querySalePerformanceByCondition(SalePerformanceReqDTO reqDTO);

    /**
     * @Author sunjd
     * @Description 查询门店业绩
     * @Date 10:31 2018/12/6
     * @Param [reqDTO]
     * @return com.ihappy.unifiedLog.module.Result<com.ihappy.store.domain.dto.response.store.StorePerformanceRespDTO>
     **/
    Result<StorePerformanceRespDTO> queryStorePerformance(StorePerformanceReqDTO reqDTO);
}
