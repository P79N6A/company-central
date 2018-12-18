package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.company.infrastructure.service.CompanyVerifyReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/6.
 */
@Deprecated
public class CompanyVerifyReadRpcServiceImpl implements CompanyVerifyReadRpcService {
    @Autowired
    private IProcess queryVerifyCompanyInfoProcess;

    @Override
    public Result<CompanyInfoVerifyReadRespDTO> findVerifyCompanyInfo(CompanyInfoVerifyReadReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoVerifyReadRespDTO>(), Action.QUERY_VERIFY_COMPANY_INFO);
        queryVerifyCompanyInfoProcess.start(context);
        return context.getResult();
    }
}
