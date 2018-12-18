package com.ihappy.role.interfaces.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.role.infrastructure.service.CompanyRoleReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
@Deprecated
public class CompanyRoleReadServiceImpl implements CompanyRoleReadService {
    @Autowired
    private IProcess queryCompanyRoleListProcess;
    @Autowired
    private IProcess queryRoleByRoleIdProcess;
    @Autowired
    private IProcess queryRolePageByCompIdProcess;
    @Autowired
    private IProcess queryRoleListByCompIdListProcess;
    @Autowired
    private IProcess findSysCompanyRoleListProcess;
    @Autowired
    private IProcess queryCompanyRoleMenuProcess;
    @Autowired
    private IProcess findAppRoleListByDiffPowerProcess;

    @Override
    public Result<List<CompanyRoleQueryRespDTO>> findRoleListByRoleIdList(CompanyRoleQueryReqDTO companyRoleQueryReqDTO) {
        Context context = new Context(companyRoleQueryReqDTO, new Result<List<CompanyRoleQueryRespDTO>>(), Action.QUERY_COMPANY_ROLEID_LIST);
        queryCompanyRoleListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyRoleQueryRespDTO>> findRoleListByCompIdList(CompanyRoleByCompIdQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<CompanyRoleQueryRespDTO>>(), Action.QUERY_COMPANY_ROLEID_LIST);
        queryRoleListByCompIdListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyRoleListQueryRespDTO> findRoleListByCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO) {
        Context context = new Context(companyRoleListQueryReqDTO, new Result<CompanyRoleListQueryRespDTO>(), Action.QUERY_COMPANY_ROLEID_LIST);
        queryRolePageByCompIdProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Integer> findRoleCountByCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO) {
        Context context = new Context(companyRoleListQueryReqDTO, new Result<Integer>(), Action.QUERY_COMPANY_ROLE_ID_COUNT);
        queryRolePageByCompIdProcess.start(context);
        return context.getResult();
    }


    @Override
    public Result<CompanyRoleAndFuncQueryRespDTO> findRoleByRoleId(CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO) {
        Context context = new Context(companyRoleInfoQueryReqDTO, new Result<CompanyRoleAndFuncQueryRespDTO>(), Action.QUERY_COMPANY_ROLE_INFO);
        queryRoleByRoleIdProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<SysCompanyRoleListQueryRespDTO> findSysCompanyRoleList(SysCompanyRoleListQueryReqDTO sysCompanyRoleListQueryReqDTO) {
        Context context=new Context(sysCompanyRoleListQueryReqDTO,new Result<SysCompanyRoleListQueryRespDTO>(),Action.QUERY_COMPANY_ROLE_TYPE_LIST);
        findSysCompanyRoleListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyRoleMenuQueryRespDTO> findCompanyRoleMenu(CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO) {
        Context context = new Context(companyRoleMenuQueryReqDTO, new Result<CompanyRoleMenuQueryRespDTO>(), Action.QUERY_COMPANY_ROLE_MENU_LIST);
        queryCompanyRoleMenuProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<AppRoleListQueryByDiffPowerRespDTO>> findAppRoleListByDiffPower(AppRoleListQueryByDiffPowerReqDTO appRoleListQueryByDiffPowerReqDTO) {
        Context context=new Context(appRoleListQueryByDiffPowerReqDTO,new Result<List<AppRoleListQueryByDiffPowerRespDTO>>(),Action.QUERY_APP_ROLE_LIST_BY_DIFF_POWER);
        findAppRoleListByDiffPowerProcess.start(context);
        return context.getResult();
    }


}
