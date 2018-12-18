package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.unifiedLog.module.Result;

@Deprecated
public interface CompanyRoleWriteService {

    /**
     * 添加公司角色通过公司id
     * @param companyRoleAddReqDTO
     * @return
     */
    Result<CompanyRoleAddRespDTO> addCompanyRoleByCompId(CompanyRoleAddReqDTO companyRoleAddReqDTO);

    /**
     * 根据角色id修改公司角色信息
     * @param companyRoleUpdateReqDTO
     * @return
     */
    Result<CompanyRoleUpdateRespDTO> editCompanyRoleByRoleId(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO);
    /**
     * 根据roleId删除角色信息
     * @param companyRoleDelReqDTO
     * @return
     */
    Result<CompanyRoleDelRespDTO> removeCompanyRoleByRoleId(CompanyRoleDelReqDTO companyRoleDelReqDTO);

}
