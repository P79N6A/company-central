package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncListReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncListRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public class SysCompanyFuncReadServiceClient implements SysCompanyFuncReadService {
    private SysCompanyFuncReadService sysCompanyFuncReadService;
    @Override
    public Result<List<SysCompanyFuncListRespDTO>> findSysCompanyFuncList(SysCompanyFuncListReqDTO sysCompanyFuncListReqDTO) {
        sysCompanyFuncListReqDTO.validation();
        return sysCompanyFuncReadService.findSysCompanyFuncList(sysCompanyFuncListReqDTO);
    }

}
