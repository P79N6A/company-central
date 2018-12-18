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
public class CompanyStoreWriteGatewayServiceClient implements CompanyStoreWriteGatewayService {

    private CompanyStoreWriteGatewayService companyStoreWriteGatewayService;

    public CompanyStoreWriteGatewayService getCompanyStoreWriteGatewayService() {
        return companyStoreWriteGatewayService;
    }

    public void setCompanyStoreWriteGatewayService(CompanyStoreWriteGatewayService companyStoreWriteGatewayService) {
        this.companyStoreWriteGatewayService = companyStoreWriteGatewayService;
    }

    @Override
    public Result<OperateResultMessageRespDTO> addCompanyStoreAdmin(CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO) {
        companyStoreAdminAddReqDTO.validation();
        return companyStoreWriteGatewayService.addCompanyStoreAdmin(companyStoreAdminAddReqDTO);
    }

    @Override
    public Result<OperateResultMessageRespDTO> updateCompanyStoreAdmin(CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO) {
        companyStoreAdminUpdateReqDTO.validation();
        return companyStoreWriteGatewayService.updateCompanyStoreAdmin(companyStoreAdminUpdateReqDTO);
    }

    @Override
    public Result<OperateResultMessageRespDTO> deleteCompanyStoreAdmin(CompanyStoreAdminDeleteReqDTO companyStoreAdminDeleteReqDTO) {
        companyStoreAdminDeleteReqDTO.validation();
        return companyStoreWriteGatewayService.deleteCompanyStoreAdmin(companyStoreAdminDeleteReqDTO);
    }

    @Override
    public Result<String> addPersonPerformance(AddPersonPerformanceReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreWriteGatewayService.addPersonPerformance(reqDTO);
    }

    @Override
    public Result<EnableStoreRespDTO> enableStore(EnableStoreReqDTO enableStoreReqDTO) {
        enableStoreReqDTO.validation();
        return companyStoreWriteGatewayService.enableStore(enableStoreReqDTO);
    }

    @Override
    public Result<DisableStoreRespDTO> disableStore(DisableStoreReqDTO disableStoreReqDTO) {
        disableStoreReqDTO.validation();
        return companyStoreWriteGatewayService.disableStore(disableStoreReqDTO);
    }

    @Override
    public Result<OrderCompanyJournalRespDTO> addOrderCompanyJournal(OrderCompanyJournalReqDTO reqDTO) {
        return companyStoreWriteGatewayService.addOrderCompanyJournal(reqDTO);
    }

    @Override
    public Result<UpdateOrderCompanyJournalRespDTO> updateOrderCompanyJournal(UpdateOrderCompanyJournalReqDTO reqDTO) {
        return companyStoreWriteGatewayService.updateOrderCompanyJournal(reqDTO);
    }

    @Override
    public Result<CancelOrderCompanyJournalRespDTO> cancelOrderCompanyJournal(CancelOrderCompanyJournalReqDTO reqDTO) {
        return companyStoreWriteGatewayService.cancelOrderCompanyJournal(reqDTO);
    }

    @Override
    public Result<PassOrFailReviewOrderCompanyJournalRespDTO> passReviewOrder(PassOrFailReviewOrderCompanyJournalReqDTO reqDTO) {
        return companyStoreWriteGatewayService.passReviewOrder(reqDTO);
    }

    @Override
    public Result<String> updateStorePayRemark(StoreInfoUpdateReqDTO reqDTO) {
        reqDTO.validation();
        return companyStoreWriteGatewayService.updateStorePayRemark(reqDTO);
    }
}
