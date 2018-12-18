package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.infrastructure.service.CompanyRedisServiceRpcService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 从redis 查询信息，数据同步到redis
 * Created by liuhc on 2018/6/4.
 */
public class CompanyRedisServiceRpcServiceImpl implements CompanyRedisServiceRpcService {

    @Autowired
    private IProcess querySysCompanyFuncListProcess;

    @Autowired
    private IProcess querySysFuncListProcess;

    @Autowired
    private IProcess querySysCompanyRoleListProcess;

    @Override
    public Result<List<PrivilegeAllRespDTO>> getAllPrivilegeByCtIdAndCLientIdQuery(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO) {
        Context context = new Context(sysCompanyFuncListQueryReqDTO, new Result<List<PrivilegeAllRespDTO>>(), Action.QUERY_SYSCOMPANYLIST);
        querySysCompanyFuncListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<PrivilegeAllRespDTO>> getAllPrivilegeCLientIdQuery(SysFuncListQueryReqDTO sysFuncListQueryReqDTO) {
        Context context = new Context(sysFuncListQueryReqDTO, new Result<List<PrivilegeAllRespDTO>>(), Action.QUERY_SYSCOMPANYLIST);
        querySysFuncListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SysCompanyRoleQueryRespDTO>> getSysCompanyRoleList(SysCompanyRoleQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<SysCompanyRoleQueryRespDTO>>(), Action.QUERY_COMPANY_ROLEID_LIST);
        querySysCompanyRoleListProcess.start(context);
        Result<List<SysCompanyRoleQueryRespDTO>> res = context.getResult();
        List<SysCompanyRoleQueryRespDTO> list = res.getModule();
        if (!CollectionUtils.isEmpty(list)){
            list.forEach((obj)->{
                RolePrivilegeRedisUtil.putSysCompanyRole(ConfigCenterUtil.ENV,obj.getRoleId().toString(),obj);
            });
        }
        return res;
    }
}
