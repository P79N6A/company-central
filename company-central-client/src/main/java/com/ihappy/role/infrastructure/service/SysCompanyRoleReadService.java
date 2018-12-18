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
public interface SysCompanyRoleReadService {
    /**
     * 查询角色列表
     *
     * @param sysCompanyRoleQueryReqDTO
     * @return List<SysCompanyRoleQueryRespDTO>
     */
    Result<List<SysCompanyRoleQueryRespDTO>> findSysRoleListByRoleIdList(SysCompanyRoleQueryReqDTO sysCompanyRoleQueryReqDTO);
    /**
     * 查询运营后台角色配置角色列表
     *
     * @param sysCompanyRoleConfigRoleListQueryReqDTO
     * @return
     */
    Result<Page<SysCompanyRoleConfigRoleListQueryRespDTO>> findSysCompanyRoleConfigRolePage(SysCompanyRoleConfigRoleListQueryReqDTO sysCompanyRoleConfigRoleListQueryReqDTO);


    /**
     * 查询运营后台角色配置角色详情
     *
     * @param sysCompanyRoleConfigRoleInfoQueryReqDTO
     * @return
     */

    Result<SysCompanyRoleConfigRoleInfoQueryRespDTO> findSysCompanyRoleConfigRoleInfo(SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO);

    /**
     * 查询运营后台角色配置角色详情应用配置类型选中详情列表
     * @param sysCompanyRoleInfoTypeClientListQueryReqDTO
     * @return
     */
    Result<List<SysCompanyRoleInfoTypeClientListQueryRespDTO>> findSysCompanyRoleInfoTypeClientList(SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO);

    /**
     * 查询运营后台角色配置角色信息角色菜单
     *
     * @param sysCompanyRoleInfoTypeClientFuncListQueryReqDTO
     * @return
     */
    Result<SysCompanyRoleInfoTypeClientFuncListQueryRespDTO> findSysCompanyRoleInfoTypeClientFuncList(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO);


}
