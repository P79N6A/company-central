package com.ihappy.role.interfaces.sys;


import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoDeleteByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleMangeRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoDeleteByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleMangeRoleUpdateRespDTO;
import com.ihappy.role.infrastructure.service.SysRoleWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
@Deprecated
public class SysRoleWriteServiceImpl implements SysRoleWriteService {
    @Autowired
    private IProcess addSysRoleManageRoleInfoProcess;
    @Autowired
    private IProcess updateSysRoleManageRoleInfoProcess;
    @Autowired
    private IProcess deleteSysRoleManageRoleInfoProcess;


    @Override
    public Result<SysRoleManageRoleAddRespDTO> addSysRoleManageRole(SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO) {
        Context context = new Context(sysRoleManageRoleAddReqDTO, new Result<SysRoleManageRoleAddRespDTO>(), Action.ADD_SYS_ROLE_INFO);
        addSysRoleManageRoleInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysRoleMangeRoleUpdateRespDTO> editSysRoleManageRoleInfoByRoleId(SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO) {
        Context context = new Context(sysRoleMangeRoleUpdateReqDTO, new Result<SysRoleMangeRoleUpdateRespDTO>(), Action.UPDATE_ROLE_INFO);
        updateSysRoleManageRoleInfoProcess.start(context);
        return context.getResult();
    }


    @Override
    public Result<SysRoleManageRoleInfoDeleteByRoleIdRespDTO> removeSysRoleManageRoleInfoByRoleId(SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO) {
        Context context = new Context(sysRoleManageRoleInfoDeleteByRoleIdReqDTO, new Result<SysRoleManageRoleInfoDeleteByRoleIdRespDTO>(), Action.DELETE_ROLE_INFO);
        deleteSysRoleManageRoleInfoProcess.start(context);
        return context.getResult();
    }

}
