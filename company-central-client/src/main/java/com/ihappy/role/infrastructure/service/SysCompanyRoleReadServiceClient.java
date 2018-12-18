package com.ihappy.role.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
@Deprecated
public class SysCompanyRoleReadServiceClient implements SysCompanyRoleReadService {
    private SysCompanyRoleReadService sysCompanyRoleReadService;

    public SysCompanyRoleReadService getSysCompanyRoleReadService() {
        return sysCompanyRoleReadService;
    }

    public void setSysCompanyRoleReadService(SysCompanyRoleReadService sysCompanyRoleReadService) {
        this.sysCompanyRoleReadService = sysCompanyRoleReadService;
    }

    @Override
    public Result<List<SysCompanyRoleQueryRespDTO>> findSysRoleListByRoleIdList(SysCompanyRoleQueryReqDTO sysCompanyRoleQueryReqDTO) {
        sysCompanyRoleQueryReqDTO.validation();
        return sysCompanyRoleReadService.findSysRoleListByRoleIdList(sysCompanyRoleQueryReqDTO);
    }

    @Override
    public Result<Page<SysCompanyRoleConfigRoleListQueryRespDTO>> findSysCompanyRoleConfigRolePage(SysCompanyRoleConfigRoleListQueryReqDTO sysCompanyRoleConfigRoleListQueryReqDTO) {
        sysCompanyRoleConfigRoleListQueryReqDTO.validation();
        return sysCompanyRoleReadService.findSysCompanyRoleConfigRolePage(sysCompanyRoleConfigRoleListQueryReqDTO);
    }

    @Override
    public Result<SysCompanyRoleConfigRoleInfoQueryRespDTO> findSysCompanyRoleConfigRoleInfo(SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO) {
        sysCompanyRoleConfigRoleInfoQueryReqDTO.validation();
        return sysCompanyRoleReadService.findSysCompanyRoleConfigRoleInfo(sysCompanyRoleConfigRoleInfoQueryReqDTO);
    }

    @Override
    public Result<List<SysCompanyRoleInfoTypeClientListQueryRespDTO>> findSysCompanyRoleInfoTypeClientList(SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO) {
        sysCompanyRoleInfoTypeClientListQueryReqDTO.validation();
        return sysCompanyRoleReadService.findSysCompanyRoleInfoTypeClientList(sysCompanyRoleInfoTypeClientListQueryReqDTO);
    }

    @Override
    public Result<SysCompanyRoleInfoTypeClientFuncListQueryRespDTO> findSysCompanyRoleInfoTypeClientFuncList(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO) {
        sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.validation();
        return sysCompanyRoleReadService.findSysCompanyRoleInfoTypeClientFuncList(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO);
    }

}
