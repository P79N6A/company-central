package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeListQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public class SysCompanyFuncMenuReadServiceClient implements SysCompanyFuncMenuReadService {
    private SysCompanyFuncMenuReadService sysCompanyFuncMenuReadService;

    @Override
    public Result<List<SysCompanyFuncMenuApplyTypeListQueryRespDTO>> findSysFuncMenuApplyTypeList(SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO) {
        sysCompanyFuncMenuApplyTypeListQueryReqDTO.validation();
        return sysCompanyFuncMenuReadService.findSysFuncMenuApplyTypeList(sysCompanyFuncMenuApplyTypeListQueryReqDTO);
    }

    @Override
    public Result<List<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO>> findSysFuncMenuApplyTypeMenuList(SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO) {
        sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.validation();
        return sysCompanyFuncMenuReadService.findSysFuncMenuApplyTypeMenuList(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO);
    }

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO> findSysCompanyFuncMenuApplyTypeMenuInfo(SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO) {
        sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO.validation();
        return sysCompanyFuncMenuReadService.findSysCompanyFuncMenuApplyTypeMenuInfo(sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO);
    }
}
