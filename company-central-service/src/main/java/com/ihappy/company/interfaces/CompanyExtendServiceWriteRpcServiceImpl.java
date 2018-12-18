package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.company.infrastructure.service.CompanyExtendServiceWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/28.
 */
@Deprecated
public class CompanyExtendServiceWriteRpcServiceImpl implements CompanyExtendServiceWriteRpcService {
    @Autowired
    private IProcess addCompanyExtendServiceJournalProcess;

    @Override
    public Result<CompanyExtendServiceAddRespDTO> addCompanyExtendServiceJournal(CompanyExtendServiceAddReqDTO req) {
        Context context = new Context(req, new Result<CompanyExtendServiceAddRespDTO>(), Action.ADD_COMPANY_EXTEND_SERVICE_JOURNAL);
        addCompanyExtendServiceJournalProcess.start(context);
        return context.getResult();
    }
}
