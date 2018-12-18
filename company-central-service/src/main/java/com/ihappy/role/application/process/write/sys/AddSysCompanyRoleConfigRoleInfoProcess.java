package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleAddReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleAddRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by zhangmengdan
 */
public class AddSysCompanyRoleConfigRoleInfoProcess extends DefaultProcess<SysCompanyRoleConfigRoleAddReqDTO, SysCompanyRoleConfigRoleAddRespDTO> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<SysCompanyRoleConfigRoleAddReqDTO, SysCompanyRoleConfigRoleAddRespDTO> context) {
        SysCompanyRoleConfigRoleAddReqDTO sysCompanyRoleConfigRoleAddReqDTO = context.getParam();
        //检查系统公司角色名称是否重复
        SysCompanyRoleModel sysCompanyRoleName = sysCompanyRoleService.checkSysCompanyRoleNameIsOrNotExisit(SysCompanyRoleFactory.sysCompanyRoleConfigRoleAddReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleConfigRoleAddReqDTO));
        if (sysCompanyRoleName != null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrMsg());
        }

        Integer addSysCompanyRole = sysCompanyRoleService.addSysCompanyRoleConfigRole(SysCompanyRoleFactory.sysCompanyRoleConfigRoleAddReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleConfigRoleAddReqDTO));
        SysCompanyRoleConfigRoleAddRespDTO sysCompanyRoleConfigRoleAddRespDTO = new SysCompanyRoleConfigRoleAddRespDTO();
        if (addSysCompanyRole > 0) {
            sysCompanyRoleConfigRoleAddRespDTO.setMessage("添加成功");
        }
        context.getResult().setModule(sysCompanyRoleConfigRoleAddRespDTO);
    }
}