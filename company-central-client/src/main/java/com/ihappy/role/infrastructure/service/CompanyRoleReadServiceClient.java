package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
@Deprecated
public class CompanyRoleReadServiceClient implements CompanyRoleReadService {
    private CompanyRoleReadService companyRoleReadService;

    public CompanyRoleReadService getCompanyRoleReadService() {
        return companyRoleReadService;
    }

    public void setCompanyRoleReadService(CompanyRoleReadService companyRoleReadService) {
        this.companyRoleReadService = companyRoleReadService;
    }

    @Override
    public Result<List<CompanyRoleQueryRespDTO>> findRoleListByRoleIdList(CompanyRoleQueryReqDTO companyRoleQueryReqDTO) {
        companyRoleQueryReqDTO.validation();
        return companyRoleReadService.findRoleListByRoleIdList(companyRoleQueryReqDTO);
    }

    @Override
    public Result<List<CompanyRoleQueryRespDTO>> findRoleListByCompIdList(CompanyRoleByCompIdQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyRoleReadService.findRoleListByCompIdList(reqDTO);
    }
    @Override
    public Result<CompanyRoleListQueryRespDTO> findRoleListByCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO) {
        companyRoleListQueryReqDTO.validation();
        return companyRoleReadService.findRoleListByCompId(companyRoleListQueryReqDTO);
    }

    @Override
    public Result<Integer> findRoleCountByCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO) {
        companyRoleListQueryReqDTO.validation();
        return companyRoleReadService.findRoleCountByCompId(companyRoleListQueryReqDTO);
    }

    @Override
    public Result<CompanyRoleAndFuncQueryRespDTO> findRoleByRoleId(CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO) {
        companyRoleInfoQueryReqDTO.validation();
        return companyRoleReadService.findRoleByRoleId(companyRoleInfoQueryReqDTO);
    }

    @Override
    public Result<SysCompanyRoleListQueryRespDTO> findSysCompanyRoleList(SysCompanyRoleListQueryReqDTO sysCompanyRoleListQueryReqDTO) {
        sysCompanyRoleListQueryReqDTO.validation();
        return companyRoleReadService.findSysCompanyRoleList(sysCompanyRoleListQueryReqDTO);
    }

    @Override
    public Result<CompanyRoleMenuQueryRespDTO> findCompanyRoleMenu(CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO) {
        companyRoleMenuQueryReqDTO.validation();
        return companyRoleReadService.findCompanyRoleMenu(companyRoleMenuQueryReqDTO);
    }

    @Override
    public Result<List<AppRoleListQueryByDiffPowerRespDTO>> findAppRoleListByDiffPower(AppRoleListQueryByDiffPowerReqDTO appRoleListQueryByDiffPowerReqDTO) {
        appRoleListQueryByDiffPowerReqDTO.validation();
        return companyRoleReadService.findAppRoleListByDiffPower(appRoleListQueryByDiffPowerReqDTO);
    }
}
