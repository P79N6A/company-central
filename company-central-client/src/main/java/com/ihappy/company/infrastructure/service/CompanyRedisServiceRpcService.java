package com.ihappy.company.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * 此服务只供用户操作redis，不供其他服务调用
 * 慎用
 * Created by liuhc on 2018/6/4.
 */
public interface CompanyRedisServiceRpcService {

    /**
     * 通过客户端ID 业务类型 查询权限
     * @param sysCompanyFuncListQueryReqDTO
     * @return
     */
    Result<List<PrivilegeAllRespDTO>> getAllPrivilegeByCtIdAndCLientIdQuery(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO);

    /**
     * 查询运营后台所有角色信息
     * @param sysFuncListQueryReqDTO
     * @return
     */
    Result<List<PrivilegeAllRespDTO>> getAllPrivilegeCLientIdQuery(SysFuncListQueryReqDTO sysFuncListQueryReqDTO);

    /**
     * 查询系统用户角色列表
     * @param reqDTO
     * @return
     */
    Result<List<SysCompanyRoleQueryRespDTO>> getSysCompanyRoleList(SysCompanyRoleQueryReqDTO reqDTO);

}
