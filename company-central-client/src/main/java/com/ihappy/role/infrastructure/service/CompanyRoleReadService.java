package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
@Deprecated
public interface CompanyRoleReadService {
    /**
     * 查询角色列表
     *
     * @param companyRoleQueryReqDTO
     * @return List<BaseinfoCompanyRespDTO>
     */
    Result<List<CompanyRoleQueryRespDTO>> findRoleListByRoleIdList(CompanyRoleQueryReqDTO companyRoleQueryReqDTO);

    /**
     * 查询角色列表
     * 根据企业id列表
     *
     * @param reqDTO
     * @return
     */
    Result<List<CompanyRoleQueryRespDTO>> findRoleListByCompIdList(CompanyRoleByCompIdQueryReqDTO reqDTO);

    /**
     * 通过公司查询企业角色列表
     *
     * @param companyRoleListQueryReqDTO
     * @return
     */
    Result<CompanyRoleListQueryRespDTO> findRoleListByCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO);


    /**
     * 通过公司ID查询角色列表数量
     * 没用
     *
     * @param companyRoleListQueryReqDTO
     * @return
     */
    @Deprecated
    Result<Integer> findRoleCountByCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO);

    /**
     * 根据角色ID查询角色信息
     *
     * @param companyRoleQueryReqDTO
     * @return
     */
    Result<CompanyRoleAndFuncQueryRespDTO> findRoleByRoleId(CompanyRoleInfoQueryReqDTO companyRoleQueryReqDTO);

    /**
     * 公司角色类型列表查询
     *
     * @param sysCompanyRoleListQueryReqDTO
     * @return
     */
    Result<SysCompanyRoleListQueryRespDTO> findSysCompanyRoleList(SysCompanyRoleListQueryReqDTO sysCompanyRoleListQueryReqDTO);

    /**
     * 查询APP 管理 角色管理 添加角色 菜单列表
     *
     * @param companyRoleMenuQueryReqDTO
     * @return
     */
    Result<CompanyRoleMenuQueryRespDTO> findCompanyRoleMenu(CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO);

    /**
     * 通过不同的权限查询角色列表
     * @param appRoleListQueryByDiffPowerReqDTO
     * @return
     */
    Result<List<AppRoleListQueryByDiffPowerRespDTO>> findAppRoleListByDiffPower(AppRoleListQueryByDiffPowerReqDTO appRoleListQueryByDiffPowerReqDTO);
}
