package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public interface SysCompanyRoleWriteService {
    /**
     * 添加运营后台角色配置角色信息
     * @param sysCompanyRoleConfigRoleAddReqDTO
     * @return
     */
    Result<SysCompanyRoleConfigRoleAddRespDTO> addSysCompanyRoleConfigRole(SysCompanyRoleConfigRoleAddReqDTO sysCompanyRoleConfigRoleAddReqDTO);

    /**
     * 根据角色ID修改运营后台角色配置角色信息
     * @param sysCompanyRoleConfigRoleInfoUpdateReqDTO
     * @return
     */
    Result<SysCompanyRoleConfigRoleInfoUpdateRespDTO> editSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO);

    /**
     * 删除运营后台角色配置角色信息
     * @param sysCompanyRoleConfigRoleDeleteReqDTO
     * @return
     */
    Result<SysCompanyRoleConfigRoleDeleteRespDTO> removeSysCompanyRoleConfigRole(SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO);

    /**
     * 运营后台平台设定角色配置角色添加应用配置类型列表查询
     * @param sysCompanyRoleAddTypeClientListQueryReqDTO
     * @return
     */
    Result<List<SysCompanyRoleAddTypeClientListQueryRespDTO>>  findSysCompanyRoleAddTypeClientList(SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO);

    /**
     * 运营后台平台设定角色配置角色添加应用配置类型功能列表查询
     * @param sysCompanyRoleAddTypeClientFuncListQueryReqDTO
     * @return
     */
    Result<List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO>> findSysCompanyRoleAddTypeClientFuncList(SysCompanyRoleAddTypeClientFuncListQueryReqDTO sysCompanyRoleAddTypeClientFuncListQueryReqDTO);
}
