package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public interface SysCompanyFuncReadRpcService {
    Result<List<PrivilegeAllRespDTO>> selectSysCompanyFunctListByCtId(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO);

}
