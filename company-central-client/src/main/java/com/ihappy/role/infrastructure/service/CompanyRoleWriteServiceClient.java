package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.unifiedLog.module.Result;

@Deprecated
public class CompanyRoleWriteServiceClient implements CompanyRoleWriteService {
    private CompanyRoleWriteService companyRoleWriteService;

    @Override
    public Result<CompanyRoleAddRespDTO> addCompanyRoleByCompId(CompanyRoleAddReqDTO companyRoleAddReqDTO) {
        companyRoleAddReqDTO.validation();
        return companyRoleWriteService.addCompanyRoleByCompId(companyRoleAddReqDTO);
    }

    @Override
    public Result<CompanyRoleUpdateRespDTO> editCompanyRoleByRoleId(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        companyRoleUpdateReqDTO.validation();
        return companyRoleWriteService.editCompanyRoleByRoleId(companyRoleUpdateReqDTO);
    }

    @Override
    public Result<CompanyRoleDelRespDTO> removeCompanyRoleByRoleId(CompanyRoleDelReqDTO companyRoleDelReqDTO) {
       companyRoleDelReqDTO.validation();
        return companyRoleWriteService.removeCompanyRoleByRoleId(companyRoleDelReqDTO);
    }



}
