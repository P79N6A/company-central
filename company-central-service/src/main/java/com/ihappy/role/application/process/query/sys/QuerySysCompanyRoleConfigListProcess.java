package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.domain.Page;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 运营后台-平台设定-角色配置-角色列表process
 */
public class QuerySysCompanyRoleConfigListProcess extends DefaultQueryProcess<SysCompanyRoleConfigRoleListQueryReqDTO, Page<SysCompanyRoleConfigRoleListQueryRespDTO>> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<SysCompanyRoleConfigRoleListQueryReqDTO, Page<SysCompanyRoleConfigRoleListQueryRespDTO>> context) {
        SysCompanyRoleConfigRoleListQueryReqDTO sysCompanyRoleConfigRoleListQueryReqDTO = context.getParam();
        //查询角色列表
        List<SysCompanyRoleModel> rolesList = new ArrayList<>();
        Integer count = sysCompanyRoleService.findSysCompanyRoleConfigListRoleCount(SysCompanyRoleFactory.sysRoleConfigRoleListQueryReqDTOTOModel(sysCompanyRoleConfigRoleListQueryReqDTO));
        if (count > 0) {
            rolesList = sysCompanyRoleService.findSysCompanyRoleConfigList(SysCompanyRoleFactory.sysRoleConfigRoleListQueryReqDTOTOModel(sysCompanyRoleConfigRoleListQueryReqDTO));

        }
        Page<SysCompanyRoleConfigRoleListQueryRespDTO> list = new Page<>(1, 10, count, SysCompanyRoleFactory.toModelSysRoleConfigRoleListQueryRespDTO(rolesList));
        context.getResult().setModule(list);
    }
}
