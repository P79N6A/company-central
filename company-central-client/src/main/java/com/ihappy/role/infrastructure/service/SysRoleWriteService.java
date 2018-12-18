package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoDeleteByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleMangeRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoDeleteByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleMangeRoleUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;

@Deprecated
public interface SysRoleWriteService {
    /**
     * 添加运营后台角色管理角色信息
     * @param sysRoleManageRoleAddReqDTO
     * @return
     */
    Result<SysRoleManageRoleAddRespDTO> addSysRoleManageRole(SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO);
    /**
     * 通过角色ID修改运营后台角色管理角色详情
     * @param sysRoleMangeRoleUpdateReqDTO
     * @return
     */
    Result<SysRoleMangeRoleUpdateRespDTO>   editSysRoleManageRoleInfoByRoleId(SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO);


    /**
     *根据角色ID修改运营后台角色管理角色信息的为删除状态
     * @param sysRoleManageRoleInfoDeleteByRoleIdReqDTO
     * @return
     */
    Result<SysRoleManageRoleInfoDeleteByRoleIdRespDTO> removeSysRoleManageRoleInfoByRoleId(SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO);

     }
