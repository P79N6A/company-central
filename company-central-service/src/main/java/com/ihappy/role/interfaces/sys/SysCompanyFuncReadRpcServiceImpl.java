package com.ihappy.role.interfaces.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.infrastructure.service.SysCompanyFuncReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Deprecated
public class SysCompanyFuncReadRpcServiceImpl implements SysCompanyFuncReadRpcService {
    @Autowired
    private IProcess querySysCompanyFuncListProcess;


    @Override
    public Result<List<PrivilegeAllRespDTO>> selectSysCompanyFunctListByCtId(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO) {
        Context context = new Context(sysCompanyFuncListQueryReqDTO, new Result<List<PrivilegeAllRespDTO>>(), Action.QUERY_SYSCOMPANYLIST);
        querySysCompanyFuncListProcess.start(context);
        return context.getResult();
    }

}
