package com.ihappy.company.infrastructure.service;

import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by liuhc on 2018/5/16.
 */
@Deprecated
public class SysCompanyTypeRpcServiceClient implements SysCompanyTypeRpcService {

    private SysCompanyTypeRpcService sysCompanyTypeRpcService;

    public void setSysCompanyTypeRpcService(SysCompanyTypeRpcService sysCompanyTypeRpcService) {
        this.sysCompanyTypeRpcService = sysCompanyTypeRpcService;
    }

    @Override
    public Result<List<SysCompanyTypeInfoRespDTO>> queryAllSysCompanyType(SysCompanyTypeAllQuery sysCompanyTypeAllQuery) {
        return sysCompanyTypeRpcService.queryAllSysCompanyType(sysCompanyTypeAllQuery);
    }
}
