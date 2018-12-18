package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.company.infrastructure.service.CompanyCompletionInfoWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/25.
 */
@Deprecated
public class CompanyCompletionInfoWriteRpcServiceImpl implements CompanyCompletionInfoWriteRpcService {
    @Autowired
    private IProcess completionCompanyInfoProcess;

    @Override
    public Result<String> completionInfo(CompanyCompletionInfoReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.COMPLETION_COMPANY_INFO);
        completionCompanyInfoProcess.start(context);
        return context.getResult();
    }
}
