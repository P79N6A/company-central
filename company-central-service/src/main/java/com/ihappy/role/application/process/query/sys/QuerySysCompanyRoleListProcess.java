package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
public class QuerySysCompanyRoleListProcess extends DefaultQueryProcess<SysCompanyRoleQueryReqDTO,List<SysCompanyRoleQueryRespDTO>> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<SysCompanyRoleQueryReqDTO, List<SysCompanyRoleQueryRespDTO>> context) {
        SysCompanyRoleQueryReqDTO companyRoleQueryReqDTO = context.getParam();
        List<SysCompanyRoleModel> sysCompanyRoleModels = sysCompanyRoleService.findSysRoleListByRoleIdList(companyRoleQueryReqDTO.getRoleIds());
        List<SysCompanyRoleQueryRespDTO> sysCompanyRoleQueryRespDTOs = SysCompanyRoleFactory.modelListToRespDTOList(sysCompanyRoleModels);
        context.getResult().setModule(sysCompanyRoleQueryRespDTOs);
    }
}
