package com.ihappy.role.interfaces.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleAddReqDTO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleDelReqDTO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleAddRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleDelRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleUpdateRespDTO;
import com.ihappy.role.infrastructure.service.CompanyRoleWriteService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

@Deprecated
public class CompanyRoleWriteServiceImpl implements CompanyRoleWriteService {
    @Autowired
    private IProcess addCompanyRoleByCompIdProcess;
    @Autowired
    private IProcess  updateCompanyRoleByRoleIdProcess;
    @Autowired
    private IProcess deleteCompanyRoleByRoleIdProcess;


    @Override
    public Result<CompanyRoleAddRespDTO> addCompanyRoleByCompId(CompanyRoleAddReqDTO companyRoleAddReqDTO) {
        Context context=new Context(companyRoleAddReqDTO,new Result<CompanyRoleAddRespDTO>(), Action.ADD_COMPANY_ROLE);
        addCompanyRoleByCompIdProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyRoleUpdateRespDTO> editCompanyRoleByRoleId(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        Context context=new Context(companyRoleUpdateReqDTO,new Result<CompanyRoleUpdateRespDTO>(),Action.UPDATE_COMPANY_ROLE_INFO);
        updateCompanyRoleByRoleIdProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyRoleDelRespDTO> removeCompanyRoleByRoleId(CompanyRoleDelReqDTO companyRoleDelReqDTO) {
        Context context=new Context(companyRoleDelReqDTO,new Result<Integer>(),Action.DELETE_COMPANY_ROLE_INFO);
        deleteCompanyRoleByRoleIdProcess.start(context);
        return context.getResult();
    }

}
