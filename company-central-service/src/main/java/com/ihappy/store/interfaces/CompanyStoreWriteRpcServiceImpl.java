package com.ihappy.store.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.store.StorePrintIpAndPortUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.store.infrastructure.service.CompanyStoreWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/16.
 */
public class CompanyStoreWriteRpcServiceImpl implements CompanyStoreWriteRpcService {
    @Autowired
    private IProcess updatePrintIpAndPortProcess;
    @Autowired
    private IProcess updateCompanyStoreProcess;
    @Autowired
    private IProcess updateWeshopCollectionProcess;


    @Override
    public Result<String> updatePrintIpAndPort(StorePrintIpAndPortUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_PRINT_IP_AND_PORT);
        updatePrintIpAndPortProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Boolean> updateCompanyStoreWeshopInfo(CompanyStoreUpdateReqDTO companyStoreUpdateReqDTO) {
        Context context = new Context(companyStoreUpdateReqDTO, new Result<Boolean>(), Action.UPDATE_COMPANY_SOTRE);
        updateCompanyStoreProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Boolean> updateWeshopCollection(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {
        Context context = new Context(companyWeshopCollectionReqDTO, new Result<Boolean>(), Action.UPDATE_USER_COLLECTION_STORE);
        updateWeshopCollectionProcess.start(context);
        return context.getResult();
    }
    @Autowired
    private IProcess addWeshopVisitProcess;

    @Override
    public Result<String> addWeshopVisitCount(WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO) {
        Context<WeshopVisitCountAddReqDTO, String> context = new Context<WeshopVisitCountAddReqDTO, String>(weshopVisitCountAddReqDTO,
                new Result<String>(), Action.ADD_WESHOP_VISIT);
        addWeshopVisitProcess.start(context);
        return context.getResult();
    }

}
