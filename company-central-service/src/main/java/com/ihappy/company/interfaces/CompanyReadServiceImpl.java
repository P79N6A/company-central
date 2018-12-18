package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.company.infrastructure.service.CompanyReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 11:24
 * *@content
 **/
public class CompanyReadServiceImpl implements CompanyReadService {
    @Autowired
    private IProcess companyInfoQueryProcess;

    @Override
    public Result<BaseInfoCompanyInfoQueryRespDTO> queryCompanyInfo(CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        Context context=new Context(companyInfoQueryReqDTO,new Result<BaseInfoCompanyInfoQueryRespDTO>(), Action.QUERY_COMPANY_INFO);
        companyInfoQueryProcess.start(context);
        return context.getResult();
    }
}
