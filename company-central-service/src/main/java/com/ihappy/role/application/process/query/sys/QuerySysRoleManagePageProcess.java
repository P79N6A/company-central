package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.domain.Page;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 运营后台-设置-角色配置-角色列表查询process
 */
public class QuerySysRoleManagePageProcess extends DefaultQueryProcess<SysRoleManageRoleListQueryReqDTO, Page<SysRoleManageRoleListQueryRespDTO>> {

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public void process(Context<SysRoleManageRoleListQueryReqDTO, Page<SysRoleManageRoleListQueryRespDTO>> context) {
        SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO = context.getParam();
        Integer roleCount = sysRoleService.findSysRoleManagePageRoleCount(SysRoleFactory.sysRoleManageRoleListQueryReqDTOTOModel(sysRoleManageRoleListQueryReqDTO));
        List<SysRoleManageRoleListQueryRespDTO> sysRoleModels = new ArrayList<>();
        if (roleCount >= 1) {
            List<SysRoleModel> roles = sysRoleService.findSysRoleManagePage(SysRoleFactory.sysRoleManageRoleListQueryReqDTOTOModel(sysRoleManageRoleListQueryReqDTO));
            sysRoleModels = SysRoleFactory.modelTOSysRoleManageRoleListQueryRespDTO(roles);

        }
        Page<SysRoleManageRoleListQueryRespDTO> result = new Page<>(1, 10, roleCount, sysRoleModels);
        context.getResult().setModule(result);

    }
}
