package com.ihappy.role.application.process.query.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.role.domain.bo.SysCompanyRoleBO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyRoleListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * created by zhangmengdan
 * created at 2018/8/27
 * 公司角色类型列表process
 */
public class FindSysCompanyRoleListProcess extends DefaultQueryProcess<SysCompanyRoleListQueryReqDTO,SysCompanyRoleListQueryRespDTO> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<SysCompanyRoleListQueryReqDTO, SysCompanyRoleListQueryRespDTO> context) {
        SysCompanyRoleListQueryReqDTO sysCompanyRoleListQueryReqDTO = context.getParam();
        SysCompanyRoleBO sysCompanyRoleBO = new SysCompanyRoleBO();
        List<SysCompanyRoleModel> sysCompanyRoleList = sysCompanyRoleService.findSyCompanyRoleList(sysCompanyRoleBO);
        SysCompanyRoleListQueryRespDTO sysCompanyRoleListQueryRespDTO1 = new SysCompanyRoleListQueryRespDTO();
        sysCompanyRoleListQueryRespDTO1.setList(SysCompanyRoleFactory.sysCompanyRoleModelToSysCompanyRoleListQueryRespDTO(sysCompanyRoleList));
        context.getResult().setModule(sysCompanyRoleListQueryRespDTO1);
    }
}
