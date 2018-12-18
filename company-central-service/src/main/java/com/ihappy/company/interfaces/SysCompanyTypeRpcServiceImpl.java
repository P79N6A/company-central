package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.company.infrastructure.service.SysCompanyTypeRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liuhc on 2018/5/16.
 */
@Deprecated
public class SysCompanyTypeRpcServiceImpl implements SysCompanyTypeRpcService {

    @Autowired
    private IProcess queryAllSysCompanyTypeProcess;

    @Override
    public Result<List<SysCompanyTypeInfoRespDTO>> queryAllSysCompanyType(SysCompanyTypeAllQuery sysCompanyTypeAllQuery) {
        Context context = new Context(sysCompanyTypeAllQuery, new Result<List<SysCompanyTypeInfoRespDTO>>(), Action.QUERY_COMPANY_TYPE);
        queryAllSysCompanyTypeProcess.start(context);
        return context.getResult();
    }
}
