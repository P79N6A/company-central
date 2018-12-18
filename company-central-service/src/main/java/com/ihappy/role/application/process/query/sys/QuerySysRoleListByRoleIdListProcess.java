package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.role.domain.dto.request.sys.SysRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
public class QuerySysRoleListByRoleIdListProcess extends DefaultQueryProcess<SysRoleQueryReqDTO,List<SysRoleQueryRespDTO>> {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public void process(Context<SysRoleQueryReqDTO, List<SysRoleQueryRespDTO>> context) {
        SysRoleQueryReqDTO sysRoleQueryReqDTO = context.getParam();
        List<SysRoleModel> sysRoleModels = sysRoleService.findRoleListByRoleIdList(sysRoleQueryReqDTO.getRoleIds());
        List<SysRoleQueryRespDTO> sysRoleQueryRespDTOs = SysRoleFactory.modelListToRespDTOList(sysRoleModels);
        context.getResult().setModule(sysRoleQueryRespDTOs);
    }
}
