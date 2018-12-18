package com.ihappy.role.interfaces.sys;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.role.infrastructure.service.SysCompanyRoleReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
@Deprecated
public class SysCompanyRoleReadServiceImpl implements SysCompanyRoleReadService {
    @Autowired
    private IProcess querySysCompanyRoleListProcess;
    @Autowired
    private IProcess querySysCompanyRoleConfigListProcess;
    @Autowired
    private IProcess querySysCompanyRoleConfigRoleInfoProcess;
    @Autowired
    private IProcess querySysCompanyRoleInfoTypeClientListProcess;
    @Autowired
    private IProcess querySysCompanyRoleInfoTypeClientFuncListProcess;

    @Override
    public Result<List<SysCompanyRoleQueryRespDTO>> findSysRoleListByRoleIdList(SysCompanyRoleQueryReqDTO sysCompanyRoleQueryReqDTO) {
        Context context = new Context(sysCompanyRoleQueryReqDTO, new Result<List<SysCompanyRoleQueryRespDTO>>(), Action.QUERY_COMPANY_ROLEID_LIST);
        querySysCompanyRoleListProcess.start(context);
        return context.getResult();
    }


    @Override
    public Result<Page<SysCompanyRoleConfigRoleListQueryRespDTO>> findSysCompanyRoleConfigRolePage(SysCompanyRoleConfigRoleListQueryReqDTO sysCompanyRoleConfigRoleListQueryReqDTO) {
        Context context = new Context(sysCompanyRoleConfigRoleListQueryReqDTO, new Result<Page<SysCompanyRoleConfigRoleListQueryRespDTO>>(), Action.QUERY_ROLEID_LIST);
        querySysCompanyRoleConfigListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyRoleConfigRoleInfoQueryRespDTO> findSysCompanyRoleConfigRoleInfo(SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO) {
        Context context = new Context(sysCompanyRoleConfigRoleInfoQueryReqDTO, new Result<SysCompanyRoleConfigRoleInfoQueryRespDTO>(), Action.QUERY_ROLE_INFO);
        querySysCompanyRoleConfigRoleInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SysCompanyRoleInfoTypeClientListQueryRespDTO>> findSysCompanyRoleInfoTypeClientList(SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO) {
       Context context=new Context(sysCompanyRoleInfoTypeClientListQueryReqDTO,new Result<List<SysCompanyRoleInfoTypeClientListQueryRespDTO>> (),Action.QUERY_SYS_COMPANY_ROLE_INFO_CLIENT_TYPE_LIST);
        querySysCompanyRoleInfoTypeClientListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyRoleInfoTypeClientFuncListQueryRespDTO> findSysCompanyRoleInfoTypeClientFuncList(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO) {
        Context context = new Context(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO, new Result<SysCompanyRoleInfoTypeClientFuncListQueryRespDTO>(), Action.QUERY_COMPANY_ROLE_MENU_LIST);
        querySysCompanyRoleInfoTypeClientFuncListProcess.start(context);
        return context.getResult();
    }


}
