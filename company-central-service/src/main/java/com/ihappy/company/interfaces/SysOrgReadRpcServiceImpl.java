package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByIdQueryRpcReqDTO;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByOrgIdListQuery;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoByIdQueryRpcRespDTO;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoRespDTO;
import com.ihappy.company.infrastructure.service.SysOrgReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liuhc on 2018/6/14.
 */
@Deprecated
public class SysOrgReadRpcServiceImpl implements SysOrgReadRpcService {

    @Autowired
    private IProcess querySysOrgByOrgIdListProcess;

    @Autowired
    private IProcess queryAllChildSysOrgByIdProcess;

    @Override
    public Result<List<SysOrgBasicInfoRespDTO>> getSysOrgBasicInfo(SysOrgBasicInfoByOrgIdListQuery sysOrgBasicInfoByOrgIdListQuery) {
        Context context = new Context(sysOrgBasicInfoByOrgIdListQuery, new Result<List<SysOrgBasicInfoRespDTO>>(), Action.GET_SYS_ORG_INFO);
        querySysOrgByOrgIdListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysOrgBasicInfoByIdQueryRpcRespDTO> getAllChildSysOrgById(SysOrgBasicInfoByIdQueryRpcReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<SysOrgBasicInfoByIdQueryRpcRespDTO>(), Action.GET_ALL_CHILD_SYS_ORG_BY_ID);
        queryAllChildSysOrgByIdProcess.start(context);
        return context.getResult();
    }
}
