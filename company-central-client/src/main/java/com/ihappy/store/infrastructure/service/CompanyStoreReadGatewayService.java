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
 * Created by chenying on 2018/8/27.
 */
public interface CompanyStoreReadGatewayService {
    /**
     * 查询门店业绩分页列表
     *
     * @param reqDTO
     * @return
     */
    Result<Page<StorePerformanceRespDTO>> queryStorePerformancePage(StorePerformanceReqDTO reqDTO);

    /**
     * 查询员工业绩分页列表
     *
     * @param reqDTO
     * @return
     */
    Result<Page<PersonPerformanceRespDTO>> queryPersonPerformancePage(PersonPerformanceReqDTO reqDTO);

    /**
     * 企业用户查询门店详情
     *
     * @param companyStroreInfoQueryReqDTO
     * @return
     */
    Result<CompanyStroreInfoQueryRespDTO> findStoreInfo(CompanyStroreInfoQueryReqDTO companyStroreInfoQueryReqDTO);

    /**
     * 企业用户门店列表
     */
    Result<List<StoreListQueryRespDTO>> findStoreList(StoreListQueryReqDTO storeListQueryReqDTO);

    /**
     * @return com.ihappy.unifiedLog.module.Result<java.util.List               <               com.ihappy.store.domain.dto.response.store.StorePageQueryRespDTO>>
     * @Author sunjd
     * @Description 运营平台->用户中心->门店列表
     * @Date 10:38 2018/10/17
     * @Param [reqDTO]
     **/
    Result<Page<StorePageQueryRespDTO>> queryStorePage(StorePageQueryReqDTO reqDTO);

    /**
     * app端查看门店付款详情
     *
     * @param compStorePayInfoPageQueryReqDTO
     * @return
     */
    Result<Page<CompStorePayInfoPageRespDTO>> queryStoreInfoPayPage(CompStorePayInfoPageQueryReqDTO compStorePayInfoPageQueryReqDTO);

    /**
     * 查询运营平台点击缴费管理 分页
     *
     * @param orderCompanyJournalQuery
     * @return
     */
    Result<Page<OrderCompanyJournalInfoRespDTO>> queryOrderCompanyJournalPage(OrderCompanyJournalQuery orderCompanyJournalQuery);

    /**
     * 查询运营平台查看缴费详情
     *
     * @param orderCompanyJournalByIdQuery
     * @return
     */
    Result<OrderCompanyJournalInfoRespDTO> queryOrderCompanyJournalDetail(OrderCompanyJournalByIdQuery orderCompanyJournalByIdQuery);

    /**
     * 运营后台查询门店到期及缴费情况分页列表
     *
     * @param reqDTO
     * @return
     */
    Result<Page<StoreServiceStatusPageQueryRespDTO>> queryStoreServiceStatusPage(StoreServiceStatusPageQueryReqDTO reqDTO);

    /**
     * 分享页面查询门店详情, 无登录校验
     *
     * @param companyStroreInfoQueryReqDTO
     * @return
     */
    Result<CompanyStroreInfoQueryRespDTO> findSharingStoreInfo(SharingCompanyStoreInfoQueryReqDTO companyStroreInfoQueryReqDTO);

    /**
     * @Author sunjd
     * @Description 根据条件查询门店列表
     * @Date 14:45 2018/11/20
     * @Param [reqDTO]
     * @return com.ihappy.unifiedLog.module.Result<java.util.List<com.ihappy.store.domain.dto.response.store.StoreQueryRespDTO>>
     **/
    Result<List<StoreQueryRespDTO>> queryStoreList(StoreQueryReqDTO reqDTO);
}
