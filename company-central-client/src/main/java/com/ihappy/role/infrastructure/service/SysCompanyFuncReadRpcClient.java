package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public class SysCompanyFuncReadRpcClient implements SysCompanyFuncReadRpcService {
    private SysCompanyFuncReadRpcService sysCompanyFuncReadService;

    @Override
    public Result<List<PrivilegeAllRespDTO>> selectSysCompanyFunctListByCtId(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO) {
        return sysCompanyFuncReadService.selectSysCompanyFunctListByCtId(sysCompanyFuncListQueryReqDTO);

    }
}