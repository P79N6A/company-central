package com.ihappy.role.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoQueryByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoQueryByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleListQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
@Deprecated
public class SysRoleReadServiceClient implements SysRoleReadService {
    private SysRoleReadService sysRoleReadService;

    public SysRoleReadService getSysRoleReadService() {
        return sysRoleReadService;
    }

    public void setSysRoleReadService(SysRoleReadService sysRoleReadService) {
        this.sysRoleReadService = sysRoleReadService;
    }

    @Override
    public Result<List<SysRoleQueryRespDTO>> findSysRoleListByRoleIdList(SysRoleQueryReqDTO reqDTO) {
        reqDTO.validation();
        return sysRoleReadService.findSysRoleListByRoleIdList(reqDTO);
    }
    @Override
    public Result<Page<SysRoleManageRoleListQueryRespDTO>> findSysRoleManageRoleList(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO) {
        sysRoleManageRoleListQueryReqDTO.validation();
        return sysRoleReadService.findSysRoleManageRoleList(sysRoleManageRoleListQueryReqDTO);
    }

    @Override
    public Result<Integer> findSysRoleManageRoleListCount(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO) {
        sysRoleManageRoleListQueryReqDTO.validation();
        return sysRoleReadService.findSysRoleManageRoleListCount(sysRoleManageRoleListQueryReqDTO);
    }


    @Override
    public Result<SysRoleManageRoleInfoQueryByRoleIdRespDTO> findSysRoleManageRoleInfoByRoleId(SysRoleManageRoleInfoQueryByRoleIdReqDTO sysRoleManageRoleInfoQueryByRoleIdReqDTO) {
        sysRoleManageRoleInfoQueryByRoleIdReqDTO.validation();
        return sysRoleReadService.findSysRoleManageRoleInfoByRoleId(sysRoleManageRoleInfoQueryByRoleIdReqDTO);
    }
}
