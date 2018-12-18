package com.ihappy.role.interfaces.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuDelReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuAddRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuDelRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO;
import com.ihappy.role.infrastructure.service.SysCompanyFuncMenuWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
@Deprecated
public class SysCompanyFuncMenuWriteServiceImpl implements SysCompanyFuncMenuWriteService {
    @Autowired
    private IProcess addSysCompanyFuncMenuApplyTypeMenuProcess;
    @Autowired
    private  IProcess updateSysCompanyFuncMenuApplyTypeMenuProcess;
    @Autowired
    private IProcess delSysCompanyFuncMenuApplyTypeMenuProcess;

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuAddRespDTO> addSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuAddReqDTO sysCompanyFuncMenuApplyTypeMenuAddReqDTO) {
        Context context=new Context(sysCompanyFuncMenuApplyTypeMenuAddReqDTO,new Result<SysCompanyFuncMenuApplyTypeMenuAddRespDTO>(),Action.ADD_MENU);
        addSysCompanyFuncMenuApplyTypeMenuProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO> updateSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO) {
        Context context=new Context(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO,new Result<SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO>(),Action.UPDATE_MENU);
        updateSysCompanyFuncMenuApplyTypeMenuProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuDelRespDTO> removeSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncMenuApplyTypeMenuDelReqDTO sysCompanyFuncMenuApplyTypeMenuDelReqDTO) {
       Context context=new Context(sysCompanyFuncMenuApplyTypeMenuDelReqDTO,new Result<SysCompanyFuncMenuApplyTypeMenuDelRespDTO>(),Action.DELETE_MENU);
       delSysCompanyFuncMenuApplyTypeMenuProcess.start(context);
        return context.getResult();
    }
}
