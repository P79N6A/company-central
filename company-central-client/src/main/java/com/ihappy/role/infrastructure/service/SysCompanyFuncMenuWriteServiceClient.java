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
public class SysCompanyFuncMenuWriteServiceClient implements SysCompanyFuncMenuWriteService {
    private SysCompanyFuncMenuWriteService sysCompanyFuncMenuWriteService;

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuAddRespDTO> addSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuAddReqDTO sysCompanyFuncMenuApplyTypeMenuAddReqDTO) {
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.validation();
        return sysCompanyFuncMenuWriteService.addSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncMenuApplyTypeMenuAddReqDTO);
    }

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO> updateSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO) {
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.validation();
        return sysCompanyFuncMenuWriteService.updateSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO);
    }

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuDelRespDTO> removeSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuDelReqDTO sysCompanyFuncMenuApplyTypeMenuDelReqDTO) {
        sysCompanyFuncMenuApplyTypeMenuDelReqDTO.validation();
        return sysCompanyFuncMenuWriteService.removeSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncMenuApplyTypeMenuDelReqDTO);
    }
}
