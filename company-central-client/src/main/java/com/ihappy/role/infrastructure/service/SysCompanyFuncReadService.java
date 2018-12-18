package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncListReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncListRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;
@Deprecated
public interface SysCompanyFuncReadService {
    /**
     * 查询系统公司功能菜单列表
     * @param sysCompanyFuncListReqDTO
     * @return
     */
    Result<List<SysCompanyFuncListRespDTO>> findSysCompanyFuncList(SysCompanyFuncListReqDTO sysCompanyFuncListReqDTO);


}
