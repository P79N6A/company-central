package com.ihappy.store.interfaces;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.communal.template.ServiceExecuteTemplate;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalByIdQuery;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.store.domain.dto.response.store.*;
import com.ihappy.store.infrastructure.service.CompanyStoreReadGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sunjd on 2018/8/27.
 */
@Component
public class CompanyStoreReadGatewayServiceImpl implements CompanyStoreReadGatewayService {
    @Autowired
    private IProcess queryPerformancePageProcess;
    @Autowired
    private IProcess queryPersonPerformancePageProcess;
    @Autowired
    private IProcess queryStoreInfoProcess;
    @Autowired
    private IProcess querySharingStoreInfoProcess;
    @Autowired
    private IProcess queryStoreListProcess;
    @Autowired
    private IProcess queryStorePageProcess;
    @Autowired
    private IProcess queryStoreInfoPayPageProcess;

    @Autowired
    private IProcess queryOrderCompanyJournalPageProcess;

    @Autowired
    private IProcess queryOrderCompanyJournalDetailProcess;

    @Autowired
    private IProcess queryStoreServiceStatusPageProcess;
    @Autowired
    private IProcess rpcQueryStoreListProcess;

    @Override
    public Result<Page<StorePerformanceRespDTO>> queryStorePerformancePage(StorePerformanceReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<Page<StorePerformanceRespDTO>>(), Action.QUERY_PERFORMANCE_PAGE);
        queryPerformancePageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<PersonPerformanceRespDTO>> queryPersonPerformancePage(PersonPerformanceReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<Page<PersonPerformanceRespDTO>>(), Action.QUERY_PERSON_PERFORMANCE_PAGE);
        queryPersonPerformancePageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyStroreInfoQueryRespDTO> findStoreInfo(CompanyStroreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        Context context = new Context(companyStroreInfoQueryReqDTO, new Result<CompanyStroreInfoQueryRespDTO>(), Action.QUERY_COMPANY_SOTRE);
        queryStoreInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StoreListQueryRespDTO>> findStoreList(StoreListQueryReqDTO storeListQueryReqDTO) {
        return ServiceExecuteTemplate.executeCommonReturnList(queryStoreListProcess, storeListQueryReqDTO, StoreListQueryRespDTO.class, Action.QUERY_STORE_LIST);
    }

    @Override
    public Result<Page<StorePageQueryRespDTO>> queryStorePage(StorePageQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<Page<StorePageQueryRespDTO>>(), Action.QUERY_STORE_PAGE);
        queryStorePageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<CompStorePayInfoPageRespDTO>> queryStoreInfoPayPage(CompStorePayInfoPageQueryReqDTO compStorePayInfoPageQueryReqDTO) {
        Context context = new Context(compStorePayInfoPageQueryReqDTO, new Result<Page<CompStorePayInfoPageRespDTO>>(), Action.QUERY_STORE_PAGE);
        queryStoreInfoPayPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<OrderCompanyJournalInfoRespDTO>> queryOrderCompanyJournalPage(OrderCompanyJournalQuery orderCompanyJournalQuery) {
        Context context = new Context(orderCompanyJournalQuery, new Result<Page<OrderCompanyJournalInfoRespDTO>>(), Action.QUERY_PRDER_COMPANY_JOURNAL);
        queryOrderCompanyJournalPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<OrderCompanyJournalInfoRespDTO> queryOrderCompanyJournalDetail(OrderCompanyJournalByIdQuery orderCompanyJournalByIdQuery) {
        Context context = new Context(orderCompanyJournalByIdQuery, new Result<OrderCompanyJournalInfoRespDTO>(), Action.QUERY_PRDER_COMPANY_JOURNAL);
        queryOrderCompanyJournalDetailProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<StoreServiceStatusPageQueryRespDTO>> queryStoreServiceStatusPage(StoreServiceStatusPageQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<Page<StoreServiceStatusPageQueryRespDTO>>(), Action.QUERY_STORE_SERVICE_STATUS_PAGE);
        queryStoreServiceStatusPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyStroreInfoQueryRespDTO> findSharingStoreInfo(SharingCompanyStoreInfoQueryReqDTO companyStroreInfoQueryReqDTO) {
        return ServiceExecuteTemplate.executeCommon(querySharingStoreInfoProcess, companyStroreInfoQueryReqDTO,
                CompanyStroreInfoQueryRespDTO.class, Action.QUERY_COMPANY_SOTRE);
    }

    @Override
    public Result<List<StoreQueryRespDTO>> queryStoreList(StoreQueryReqDTO reqDTO) {
        if (reqDTO.getCompId() == null){
            reqDTO.setCompId(reqDTO.getLoginCompId());
        }
        return ServiceExecuteTemplate.executeCommonReturnList(rpcQueryStoreListProcess, reqDTO,
                StoreQueryRespDTO.class, Action.QUERY_STORE_LIST);
    }
}
