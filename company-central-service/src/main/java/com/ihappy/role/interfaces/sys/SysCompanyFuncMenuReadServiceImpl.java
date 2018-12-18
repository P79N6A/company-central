package com.ihappy.role.interfaces.sys;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeListQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO;
import com.ihappy.role.infrastructure.service.SysCompanyFuncMenuReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Deprecated
public class SysCompanyFuncMenuReadServiceImpl implements SysCompanyFuncMenuReadService {
    @Autowired
    private IProcess querySysFuncMenuApplyTypeListProcess;
    @Autowired
    private IProcess querySysFuncMenuApplyTypeMenuListProcess;
    @Autowired
    private IProcess querySysCompanyFuncMenuApplyTypeMenuInfoProcess;
    @Override
    public Result<List<SysCompanyFuncMenuApplyTypeListQueryRespDTO>> findSysFuncMenuApplyTypeList(SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO) {
        Context context=new Context(sysCompanyFuncMenuApplyTypeListQueryReqDTO,new  Result<List<SysCompanyFuncMenuApplyTypeListQueryRespDTO>>(),Action.QUERY_TYPE_LIST);
        querySysFuncMenuApplyTypeListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO>> findSysFuncMenuApplyTypeMenuList(SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO) {
        Context context=new Context(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO,new  Result<Page<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO>>(),Action.QUERY_TYPE_MENU_LIST);
        querySysFuncMenuApplyTypeMenuListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO> findSysCompanyFuncMenuApplyTypeMenuInfo(SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO) {
        Context context=new Context(sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO,new Result<SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO>(),Action.QUERY_TYPE_MENU_INFO);
        querySysCompanyFuncMenuApplyTypeMenuInfoProcess.start(context);
        return context.getResult();
    }
}
