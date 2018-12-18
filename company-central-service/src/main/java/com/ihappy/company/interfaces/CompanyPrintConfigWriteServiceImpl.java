package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoUpdateReqDTO;
import com.ihappy.company.infrastructure.service.CompanyPrintConfigWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 16:00
 */
@Deprecated
public class CompanyPrintConfigWriteServiceImpl implements CompanyPrintConfigWriteService {

    @Autowired
    private IProcess updateCompanyPrintConfigProcess;

    @Override
    public Result<String> updateCompanyPrintConfig(CompanyPrintConfigInfoUpdateReqDTO companyPrintConfigInfoUpdateReqDTO) {
        Context<CompanyPrintConfigInfoUpdateReqDTO, String> context =
                new Context<>(companyPrintConfigInfoUpdateReqDTO, new Result<String>(), Action.UPDATE_PRINT_CONFIG);
        updateCompanyPrintConfigProcess.start(context);
        return context.getResult();
    }
}
