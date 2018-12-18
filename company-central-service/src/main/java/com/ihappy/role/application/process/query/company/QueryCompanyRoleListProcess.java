package com.ihappy.role.application.process.query.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
public class QueryCompanyRoleListProcess extends DefaultQueryProcess<CompanyRoleQueryReqDTO,List<CompanyRoleQueryRespDTO>> {

    @Autowired
    private CompanyRoleService companyRoleService;

    @Override
    public void process(Context<CompanyRoleQueryReqDTO, List<CompanyRoleQueryRespDTO>> context) {
        CompanyRoleQueryReqDTO companyRoleQueryReqDTO = context.getParam();
        List<CompanyRoleQueryRespDTO> companyRoleQueryRespDTOs = new ArrayList<CompanyRoleQueryRespDTO>();
        if (!CollectionUtils.isEmpty(companyRoleQueryReqDTO.sysRoleIdList())){
            List<SysCompanyRoleQueryRespDTO> sysCompanyRoleQueryRespDTOS = RolePrivilegeRedisUtil.getSysCompanyRole(ConfigCenterUtil.ENV,companyRoleQueryReqDTO.sysRoleIdList(),companyRoleQueryReqDTO.getLoginCtId(),companyRoleQueryReqDTO.getLoginClId());
            if (!CollectionUtils.isEmpty(sysCompanyRoleQueryRespDTOS)){
                for (SysCompanyRoleQueryRespDTO obj : sysCompanyRoleQueryRespDTOS){
                    companyRoleQueryRespDTOs.add(obj.toCompanyRoleQueryRespDTO());
                }
            }
        }
        if (!CollectionUtils.isEmpty(companyRoleQueryReqDTO.companyRoleIdList())){
            List<CompanyRoleModel> companyRoleModels = companyRoleService.findRoleListByRoleIdList(companyRoleQueryReqDTO.companyRoleIdList());
            companyRoleQueryRespDTOs.addAll(CompanyRoleFactory.modelListToRespDTOList(companyRoleModels));
        }
        context.getResult().setModule(companyRoleQueryRespDTOs);
    }
}
