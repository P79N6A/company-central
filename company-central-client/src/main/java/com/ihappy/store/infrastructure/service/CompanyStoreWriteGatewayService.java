package com.ihappy.store.infrastructure.service;

import com.ihappy.store.domain.dto.request.ordercompanyjournal.CancelOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.PassOrFailReviewOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.UpdateOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.response.OperateResultMessageRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.CancelOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.PassOrFailReviewOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.UpdateOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.store.DisableStoreRespDTO;
import com.ihappy.store.domain.dto.response.store.EnableStoreRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by chenying on 2018/8/27.
 */
public interface CompanyStoreWriteGatewayService {

    /**
     * 新增门店
     * @param companyStoreAdminAddReqDTO
     * @return
     */
    Result<OperateResultMessageRespDTO> addCompanyStoreAdmin(CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO);

    /**
     * 修改门店
     * @param companyStoreAdminUpdateReqDTO
     * @return
     */
    Result<OperateResultMessageRespDTO> updateCompanyStoreAdmin(CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO);

    /**
     * 删除门店
     * @param companyStoreAdminDeleteReqDTO
     * @return
     */
    Result<OperateResultMessageRespDTO> deleteCompanyStoreAdmin(CompanyStoreAdminDeleteReqDTO companyStoreAdminDeleteReqDTO);

    Result<String> addPersonPerformance(AddPersonPerformanceReqDTO reqDTO);

    /**
     * 启用门店
     * @param enableStoreReqDTO
     * @return
     */
    Result<EnableStoreRespDTO> enableStore(EnableStoreReqDTO enableStoreReqDTO);

    /**
     * 禁用门店
     * @param disableStoreReqDTO
     * @return
     */
    Result<DisableStoreRespDTO> disableStore(DisableStoreReqDTO disableStoreReqDTO);

    /**
     * 运营平台 新增缴费记录
     * @param reqDTO
     * @return
     */
    Result<OrderCompanyJournalRespDTO> addOrderCompanyJournal(OrderCompanyJournalReqDTO reqDTO);

    /**
     * 运营平台 修改备注
     * @param reqDTO
     * @return
     */
    Result<UpdateOrderCompanyJournalRespDTO> updateOrderCompanyJournal(UpdateOrderCompanyJournalReqDTO reqDTO);

    /**
     * 运营平台 作废单据
     * @param reqDTO
     * @return
     */
    Result<CancelOrderCompanyJournalRespDTO> cancelOrderCompanyJournal(CancelOrderCompanyJournalReqDTO reqDTO);

    /**
     * 运营平台 审核通过
     * @param reqDTO
     * @return
     */
    Result<PassOrFailReviewOrderCompanyJournalRespDTO> passReviewOrder(PassOrFailReviewOrderCompanyJournalReqDTO reqDTO);
    /**
     * PC端-修改门店支付备注
     * @param reqDTO
     * @return
     */
    Result<String> updateStorePayRemark(StoreInfoUpdateReqDTO reqDTO);
}
