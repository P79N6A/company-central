package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeListQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * author zhangmengdan
 * create time 2018/8/23
 */
@Deprecated
public interface SysCompanyFuncMenuReadService {
    /**
     * 运营后台-平台设定-功能菜单-应用-类型列表查询
     * @param sysCompanyFuncMenuApplyTypeListQueryReqDTO
     * @return
     */
    Result<List<SysCompanyFuncMenuApplyTypeListQueryRespDTO>>  findSysFuncMenuApplyTypeList(SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-菜单列表查询
     * @param sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO
     * @return
     */
    Result<List<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO>> findSysFuncMenuApplyTypeMenuList(SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO);
    /**
     *运营后台-平台设定-功能菜单-应用-类型-菜单列表-菜单详情查询
     * @param sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO
     * @return
     */
    Result<SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO> findSysCompanyFuncMenuApplyTypeMenuInfo(SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO);

}
