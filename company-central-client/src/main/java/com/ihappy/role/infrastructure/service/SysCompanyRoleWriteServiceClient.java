package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public class SysCompanyRoleWriteServiceClient implements SysCompanyRoleWriteService {
  private SysCompanyRoleWriteService sysCompanyRoleWriteService;

    @Override
    public Result<SysCompanyRoleConfigRoleAddRespDTO> addSysCompanyRoleConfigRole(SysCompanyRoleConfigRoleAddReqDTO sysCompanyRoleConfigRoleAddReqDTO) {
        sysCompanyRoleConfigRoleAddReqDTO.validation();
        return sysCompanyRoleWriteService.addSysCompanyRoleConfigRole(sysCompanyRoleConfigRoleAddReqDTO);
    }

    @Override
    public Result<SysCompanyRoleConfigRoleInfoUpdateRespDTO> editSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO) {
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.validation();
        return sysCompanyRoleWriteService.editSysCompanyRoleConfigRoleInfoByRoleId(sysCompanyRoleConfigRoleInfoUpdateReqDTO);
    }

    @Override
    public Result<SysCompanyRoleConfigRoleDeleteRespDTO> removeSysCompanyRoleConfigRole(SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO) {
        sysCompanyRoleConfigRoleDeleteReqDTO.validation();
        return sysCompanyRoleWriteService.removeSysCompanyRoleConfigRole(sysCompanyRoleConfigRoleDeleteReqDTO);
    }

    @Override
    public Result<List<SysCompanyRoleAddTypeClientListQueryRespDTO>> findSysCompanyRoleAddTypeClientList(SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO) {
        sysCompanyRoleAddTypeClientListQueryReqDTO.validation();
        return sysCompanyRoleWriteService.findSysCompanyRoleAddTypeClientList(sysCompanyRoleAddTypeClientListQueryReqDTO);
    }

    @Override
    public Result<List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO>> findSysCompanyRoleAddTypeClientFuncList(SysCompanyRoleAddTypeClientFuncListQueryReqDTO sysCompanyRoleAddTypeClientFuncListQueryReqDTO) {
        sysCompanyRoleAddTypeClientFuncListQueryReqDTO.validation();;
        return sysCompanyRoleWriteService.findSysCompanyRoleAddTypeClientFuncList(sysCompanyRoleAddTypeClientFuncListQueryReqDTO);
    }
}
