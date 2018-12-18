package com.ihappy.role.interfaces.sys;


import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncListReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncListRespDTO;
import com.ihappy.role.infrastructure.service.SysCompanyFuncReadService;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

@Deprecated
public class SysCompanyFuncReadServiceImpl implements SysCompanyFuncReadService {

    @Override
    public Result<List<SysCompanyFuncListRespDTO>> findSysCompanyFuncList(SysCompanyFuncListReqDTO sysCompanyFuncListReqDTO) {
        return null;
    }

}
