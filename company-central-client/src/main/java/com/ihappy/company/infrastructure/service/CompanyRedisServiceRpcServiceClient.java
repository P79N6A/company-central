package com.ihappy.company.infrastructure.service;

import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by liuhc on 2018/6/4.
 */
public class CompanyRedisServiceRpcServiceClient implements CompanyRedisServiceRpcService {

    private CompanyRedisServiceRpcService companyRedisServiceRpcService;

    public void setCompanyRedisServiceRpcService(CompanyRedisServiceRpcService companyRedisServiceRpcService) {
        this.companyRedisServiceRpcService = companyRedisServiceRpcService;
    }

    @Override
    public Result<List<PrivilegeAllRespDTO>> getAllPrivilegeByCtIdAndCLientIdQuery(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO) {
        return companyRedisServiceRpcService.getAllPrivilegeByCtIdAndCLientIdQuery(sysCompanyFuncListQueryReqDTO);
    }

    @Override
    public Result<List<PrivilegeAllRespDTO>> getAllPrivilegeCLientIdQuery(SysFuncListQueryReqDTO sysFuncListQueryReqDTO) {
        return companyRedisServiceRpcService.getAllPrivilegeCLientIdQuery(sysFuncListQueryReqDTO);
    }

    @Override
    public Result<List<SysCompanyRoleQueryRespDTO>> getSysCompanyRoleList(SysCompanyRoleQueryReqDTO reqDTO) {
        reqDTO.validation();
        return companyRedisServiceRpcService.getSysCompanyRoleList(reqDTO);
    }
}
