package com.ihappy.store.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.store.infrastructure.service.CompanyStoreWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: company-central
 * @description: 门店信息更新
 * @author: 汪正
 * @create: 2018-05-16 20:13
 **/
@Deprecated
public class CompanyStoreWriteServiceImpl implements CompanyStoreWriteService {

    @Autowired
    private IProcess updateCompanyStoreProcess;

    @Autowired
    private IProcess updateWeshopCollectionProcess;

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
}
