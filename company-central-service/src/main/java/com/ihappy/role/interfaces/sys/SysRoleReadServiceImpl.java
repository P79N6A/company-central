package com.ihappy.role.interfaces.sys;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoQueryByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoQueryByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleListQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleQueryRespDTO;
import com.ihappy.role.infrastructure.service.SysRoleReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
@Deprecated
public class SysRoleReadServiceImpl implements SysRoleReadService {
    @Autowired
    private IProcess querySysRoleListByRoleIdListProcess;
    @Autowired
    private IProcess querySysRoleManagePageProcess;
    @Autowired
    private IProcess querySysRoleManageRoleInfoByRoleIdProcess;


    @Override
    public Result<List<SysRoleQueryRespDTO>> findSysRoleListByRoleIdList(SysRoleQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<SysRoleQueryRespDTO>>(), Action.QUERY_ROLEID_LIST);
        querySysRoleListByRoleIdListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<SysRoleManageRoleListQueryRespDTO>> findSysRoleManageRoleList(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO) {
        Context context = new Context(sysRoleManageRoleListQueryReqDTO, new Result<Page<SysRoleManageRoleListQueryRespDTO>>(), Action.QUERY_ROLEID_LIST);
        querySysRoleManagePageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Integer> findSysRoleManageRoleListCount(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO) {
        Context context = new Context(sysRoleManageRoleListQueryReqDTO, new Result<Integer>(), Action.QUERY_ROLEID_LIST);
        querySysRoleManagePageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysRoleManageRoleInfoQueryByRoleIdRespDTO> findSysRoleManageRoleInfoByRoleId(SysRoleManageRoleInfoQueryByRoleIdReqDTO sysRoleManageRoleInfoQueryByRoleIdReqDTO) {
        Context context = new Context(sysRoleManageRoleInfoQueryByRoleIdReqDTO, new Result<SysRoleManageRoleInfoQueryByRoleIdRespDTO>(), Action.QUERY_ROLE_INFO);
        querySysRoleManageRoleInfoByRoleIdProcess.start(context);
        return context.getResult();
    }


}