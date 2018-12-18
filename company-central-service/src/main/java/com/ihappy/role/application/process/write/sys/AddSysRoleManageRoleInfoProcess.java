package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleAddReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleAddRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**created by zhangmengdan
 * 运营后台-设置-角色管理-角色详情process
 */
public class AddSysRoleManageRoleInfoProcess extends DefaultProcess<SysRoleManageRoleAddReqDTO, SysRoleManageRoleAddRespDTO> {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public void process(Context<SysRoleManageRoleAddReqDTO, SysRoleManageRoleAddRespDTO> context) {
        SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO = context.getParam();
        //检查角色名称是否重复
        SysRoleModel checkSysRoleNameIsOrNotRepeat = sysRoleService.checkSysRoleNameIsOrNotRepeat(SysRoleFactory.sysRoleManageRoleAddReqDTOTOModel(sysRoleManageRoleAddReqDTO));
        if (checkSysRoleNameIsOrNotRepeat != null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrMsg());
        }

        //添加角色信息
        Integer addRole = sysRoleService.addSysRoleManageRoleInfo(SysRoleFactory.sysRoleManageRoleAddReqDTOToModel(sysRoleManageRoleAddReqDTO));
        SysRoleManageRoleAddRespDTO sysRoleManageRoleAddRespDTO = new SysRoleManageRoleAddRespDTO();
        if (addRole == null || addRole == 0) {
            sysRoleManageRoleAddRespDTO.setMessage("添加失败");
        } else {
            sysRoleManageRoleAddRespDTO.setMessage("添加成功");
        }
        context.getResult().setModule(sysRoleManageRoleAddRespDTO);

    }
}
