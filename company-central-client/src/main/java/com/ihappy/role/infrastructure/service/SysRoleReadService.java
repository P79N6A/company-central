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
 * 运营平台用户角色查询接口
 */
@Deprecated
public interface SysRoleReadService {
    /**
     * 查询运营平台用户的角色列表  sysdb 的 sys_role 表
     * @param reqDTO
     * @return
     */
    Result<List<SysRoleQueryRespDTO>> findSysRoleListByRoleIdList(SysRoleQueryReqDTO reqDTO);
    /**
     * 分页查询运营后台角色管理角色列表
     * @param sysRoleManageRoleListQueryReqDTO
     * @return
     */
    Result<Page<SysRoleManageRoleListQueryRespDTO>> findSysRoleManageRoleList(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO);

    /**
     * 通过分页查询运营后台角色管理角色列表角色数量
     * @param sysRoleManageRoleListQueryReqDTO
     * @return
     */
    Result<Integer>  findSysRoleManageRoleListCount(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO);

    /**
     * 通过角色ID查询运营后台角色管理角色详情
     * @param sysRoleManageRoleInfoQueryByRoleIdReqDTO
     * @return
     */
    Result<SysRoleManageRoleInfoQueryByRoleIdRespDTO> findSysRoleManageRoleInfoByRoleId(SysRoleManageRoleInfoQueryByRoleIdReqDTO sysRoleManageRoleInfoQueryByRoleIdReqDTO);


}
