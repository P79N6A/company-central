package com.ihappy.role.infrastructure.service;

import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuDelReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuAddRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuDelRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * created by zhangmengdan
 * create at 2018/8/23
 */
@Deprecated
public interface SysCompanyFuncMenuWriteService {
    /**
     * 运营后台-平台设定-功能菜单-应用-类型-菜单添加
     *
     * @param sysCompanyFuncMenuApplyTypeMenuAddReqDTO
     * @return
     */
    Result<SysCompanyFuncMenuApplyTypeMenuAddRespDTO> addSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuAddReqDTO sysCompanyFuncMenuApplyTypeMenuAddReqDTO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-菜单修改
     *
     * @param sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO
     * @return
     */
    Result<SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO> updateSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-菜单删除
     *
     * @param sysCompanyFuncMenuApplyTypeMenuDelReqDTO
     * @return
     */
    Result<SysCompanyFuncMenuApplyTypeMenuDelRespDTO> removeSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuDelReqDTO sysCompanyFuncMenuApplyTypeMenuDelReqDTO);
}
