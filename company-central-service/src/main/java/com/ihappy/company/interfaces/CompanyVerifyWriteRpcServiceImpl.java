package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.company.infrastructure.service.CompanyVerifyWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/6.
 */
@Deprecated
public class CompanyVerifyWriteRpcServiceImpl implements CompanyVerifyWriteRpcService {
    @Autowired
    private IProcess addVerifyCompanyInfoProcess;

    @Autowired
    private IProcess verifyCompanyInfoProcess;

    @Override
    public Result<CompanyInfoVerifyRespDTO> verifyCompanyInfo(CompanyInfoVerifyReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoVerifyRespDTO>(), Action.VERIFY_COMPANY_INFO);
        verifyCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoVerifyAddRespDTO> addVerifyCompanyInfo(CompanyInfoVerifyAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoVerifyAddRespDTO>(), Action.ADD_VERIFY_COMPANY_INFO);
        addVerifyCompanyInfoProcess.start(context);
        return context.getResult();
    }
}
