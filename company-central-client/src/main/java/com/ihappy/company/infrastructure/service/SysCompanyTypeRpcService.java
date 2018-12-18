package com.ihappy.company.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by liuhc on 2018/5/16.
 */
@Deprecated
@Transfer(value = "com.ihappy.company.infrastructure.service.CompanyReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface SysCompanyTypeRpcService {

   Result<List<SysCompanyTypeInfoRespDTO>> queryAllSysCompanyType(SysCompanyTypeAllQuery sysCompanyTypeAllQuery);
}

