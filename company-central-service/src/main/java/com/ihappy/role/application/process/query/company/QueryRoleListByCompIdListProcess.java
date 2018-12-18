package com.ihappy.role.application.process.query.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleByCompIdQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/6/6.
 */
public class QueryRoleListByCompIdListProcess extends DefaultQueryProcess<CompanyRoleByCompIdQueryReqDTO,List<CompanyRoleQueryRespDTO>> {
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<CompanyRoleByCompIdQueryReqDTO, List<CompanyRoleQueryRespDTO>> context) {
        CompanyRoleByCompIdQueryReqDTO reqDTO = context.getParam();
        List<CompanyRoleQueryRespDTO> companyRoleQueryRespDTOs = new ArrayList<CompanyRoleQueryRespDTO>();
        List<CompanyRoleBO> companyRoleBOs = sysCompanyRoleService.findAllSysRoleListByCompIds(reqDTO.getCompIds());
        if (!CollectionUtils.isEmpty(companyRoleBOs)){
            companyRoleQueryRespDTOs.addAll(CompanyRoleFactory.boList2CompanyRoleQueryRespDTOList(companyRoleBOs));
        }
        List<CompanyRoleModel> companyRoleModels = companyRoleService.findRoleListByCompIdList(reqDTO.getCompIds());
        if (!CollectionUtils.isEmpty(companyRoleModels)){
            companyRoleQueryRespDTOs.addAll(CompanyRoleFactory.modelListToRespDTOList(companyRoleModels));
        }
        context.getResult().setModule(companyRoleQueryRespDTOs);
    }
}
