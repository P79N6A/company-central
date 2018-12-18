package com.ihappy.role.interfaces.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.role.infrastructure.service.SysCompanyRoleWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Deprecated
public class SysCompanyRoleWriteServiceImpl implements SysCompanyRoleWriteService {
    @Autowired
    private IProcess updateSysCompanyRoleConfigRoleInfoProcess;
    @Autowired
    private IProcess addSysCompanyRoleConfigRoleInfoProcess;
    @Autowired
    private IProcess deleteSysCompanyRoleConfigRoleInfoProcess;
    @Autowired
    private IProcess querySysCompanyRoleAddTypeClientListProcess;
    @Autowired
    private IProcess querySysCompanyRoleAddTypeClientFuncListProcess;
    @Override
    public Result<SysCompanyRoleConfigRoleAddRespDTO> addSysCompanyRoleConfigRole(SysCompanyRoleConfigRoleAddReqDTO sysCompanyRoleConfigRoleAddReqDTO) {
        Context context = new Context(sysCompanyRoleConfigRoleAddReqDTO, new Result<SysCompanyRoleConfigRoleAddRespDTO>(), Action.ADD_SYS_ROLE_INFO);
        addSysCompanyRoleConfigRoleInfoProcess.start(context);
        return context.getResult();
    }
    @Override
    public Result<SysCompanyRoleConfigRoleInfoUpdateRespDTO> editSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO) {
        Context context = new Context(sysCompanyRoleConfigRoleInfoUpdateReqDTO, new Result<SysCompanyRoleConfigRoleInfoUpdateRespDTO>(), Action.UPDATE_ROLE_INFO);
        updateSysCompanyRoleConfigRoleInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyRoleConfigRoleDeleteRespDTO> removeSysCompanyRoleConfigRole(SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO) {
        Context context = new Context(sysCompanyRoleConfigRoleDeleteReqDTO, new Result<SysCompanyRoleConfigRoleDeleteRespDTO>(), Action.DELETE_ROLE_INFO);
        deleteSysCompanyRoleConfigRoleInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SysCompanyRoleAddTypeClientListQueryRespDTO>> findSysCompanyRoleAddTypeClientList(SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO) {
       Context context=new Context(sysCompanyRoleAddTypeClientListQueryReqDTO,new Result<List<SysCompanyRoleAddTypeClientListQueryRespDTO>>(),Action.QUERY_SYS_COMPANY_ROLE_ADD_CLIENT_TYPE_LIST);
        querySysCompanyRoleAddTypeClientListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO>> findSysCompanyRoleAddTypeClientFuncList(SysCompanyRoleAddTypeClientFuncListQueryReqDTO sysCompanyRoleAddTypeClientFuncListQueryReqDTO) {
        Context context=new Context(sysCompanyRoleAddTypeClientFuncListQueryReqDTO,new Result<List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO>>(),Action.QUERY_SYS_COMPANY_ROLE_ADD_CLIENT_TYPE_FUNC_LIST);
        querySysCompanyRoleAddTypeClientFuncListProcess.start(context);
        return context.getResult();
    }


}
