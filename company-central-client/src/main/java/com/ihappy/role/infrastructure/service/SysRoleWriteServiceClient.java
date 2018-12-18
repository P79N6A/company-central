package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoDeleteByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleMangeRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoDeleteByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleMangeRoleUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
@Deprecated
public class SysRoleWriteServiceClient implements SysRoleWriteService {
    @Autowired
    private SysRoleWriteService sysRoleWriteService;

    @Override
    public Result<SysRoleManageRoleInfoDeleteByRoleIdRespDTO> removeSysRoleManageRoleInfoByRoleId(SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO) {
        sysRoleManageRoleInfoDeleteByRoleIdReqDTO.validation();
        return sysRoleWriteService.removeSysRoleManageRoleInfoByRoleId(sysRoleManageRoleInfoDeleteByRoleIdReqDTO);
    }

    @Override
    public Result<SysRoleManageRoleAddRespDTO> addSysRoleManageRole(SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO) {
        sysRoleManageRoleAddReqDTO.validation();
        return sysRoleWriteService.addSysRoleManageRole(sysRoleManageRoleAddReqDTO);
    }

    @Override
    public Result<SysRoleMangeRoleUpdateRespDTO> editSysRoleManageRoleInfoByRoleId(SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO) {
        sysRoleMangeRoleUpdateReqDTO.validation();
        return sysRoleWriteService.editSysRoleManageRoleInfoByRoleId(sysRoleMangeRoleUpdateReqDTO);
    }

}
