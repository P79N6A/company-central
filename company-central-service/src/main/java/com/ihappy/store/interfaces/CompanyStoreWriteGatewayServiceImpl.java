package com.ihappy.store.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
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
import com.ihappy.store.infrastructure.service.CompanyStoreWriteGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenying on 2018/8/27.
 */
public class CompanyStoreWriteGatewayServiceImpl implements CompanyStoreWriteGatewayService {

    @Autowired
    private IProcess addCompanyStoreAdminProcess;

    @Autowired
    private IProcess updateCompanyStoreAdminProcess;

    @Autowired
    private IProcess deleteCompanyStoreAdminProcess;
    @Autowired
    private IProcess addPersonPerformanceProcess;
    @Autowired
    private IProcess disableStoreProcess;
    @Autowired
    private IProcess enableStoreProcess;
    @Autowired
    private IProcess addOrderCompanyJournalProcess;

    @Autowired
    private IProcess updateOrderCompanyJournalProcess;

    @Autowired
    private IProcess cancelOrderCompanyJournalProcess;

    @Autowired
    private IProcess passReviewOrderCompanyJournalProcess;
    @Autowired
    private IProcess updateStorePayRemarkProcess;

    @Override
    public Result<OperateResultMessageRespDTO> addCompanyStoreAdmin(CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO) {
        Context<CompanyStoreAdminAddReqDTO, OperateResultMessageRespDTO> context = new Context<CompanyStoreAdminAddReqDTO, OperateResultMessageRespDTO>(companyStoreAdminAddReqDTO,
                new Result<OperateResultMessageRespDTO>(), Action.ADD_COMPANY_STORE);
        addCompanyStoreAdminProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<OperateResultMessageRespDTO> updateCompanyStoreAdmin(CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO) {
        Context<CompanyStoreAdminUpdateReqDTO, OperateResultMessageRespDTO> context = new Context<CompanyStoreAdminUpdateReqDTO, OperateResultMessageRespDTO>(companyStoreAdminUpdateReqDTO,
                new Result<OperateResultMessageRespDTO>(), Action.UPDATE_COMPANY_STORE);
        updateCompanyStoreAdminProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<OperateResultMessageRespDTO> deleteCompanyStoreAdmin(CompanyStoreAdminDeleteReqDTO companyStoreAdminDeleteReqDTO) {
        Context<CompanyStoreAdminDeleteReqDTO, OperateResultMessageRespDTO> context = new Context<CompanyStoreAdminDeleteReqDTO, OperateResultMessageRespDTO>(companyStoreAdminDeleteReqDTO,
                new Result<OperateResultMessageRespDTO>(), Action.DELETE_COMPANY_STORE);
        deleteCompanyStoreAdminProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> addPersonPerformance(AddPersonPerformanceReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.ADD_PERSON_PERFORMANCE);
        addPersonPerformanceProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<EnableStoreRespDTO> enableStore(EnableStoreReqDTO enableStoreReqDTO) {
        Context context=new Context(enableStoreReqDTO,new Result<EnableStoreRespDTO>(),Action.ENABLE_STORE);
        enableStoreProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<DisableStoreRespDTO> disableStore(DisableStoreReqDTO disableStoreReqDTO) {
       Context context=new Context(disableStoreReqDTO,new Result<DisableStoreRespDTO>(),Action.DISABLE_STORE);
       disableStoreProcess.start(context);
        return context.getResult();
    }
    @Override
    public Result<OrderCompanyJournalRespDTO> addOrderCompanyJournal(OrderCompanyJournalReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<OrderCompanyJournalRespDTO>(), Action.ADD_ORDER_COMPANY_SERVICE_JOURNAL);
        addOrderCompanyJournalProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<UpdateOrderCompanyJournalRespDTO> updateOrderCompanyJournal(UpdateOrderCompanyJournalReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<UpdateOrderCompanyJournalRespDTO>(), Action.UPDATE_ORDER_COMPANY_SERVICE_JOURNAL);
        updateOrderCompanyJournalProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CancelOrderCompanyJournalRespDTO> cancelOrderCompanyJournal(CancelOrderCompanyJournalReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CancelOrderCompanyJournalRespDTO>(), Action.UPDATE_ORDER_COMPANY_SERVICE_JOURNAL);
        cancelOrderCompanyJournalProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PassOrFailReviewOrderCompanyJournalRespDTO> passReviewOrder(PassOrFailReviewOrderCompanyJournalReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PassOrFailReviewOrderCompanyJournalReqDTO>(), Action.PASS_REVIEW_ORDER);
        passReviewOrderCompanyJournalProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateStorePayRemark(StoreInfoUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_STORE_PAY_REMARK);
        updateStorePayRemarkProcess.start(context);
        return context.getResult();
    }
}
