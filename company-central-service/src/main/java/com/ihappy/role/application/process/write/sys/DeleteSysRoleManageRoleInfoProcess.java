package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoDeleteByRoleIdReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoDeleteByRoleIdRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.person.PersonRoleInfoRespDTO;
import com.ihappy.user.service.person.BaseinfoPersonInsideRpcReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * created by zhangmengdan
 *  运营后台-设置-角色管理-角色删除process
 */
public class DeleteSysRoleManageRoleInfoProcess extends DefaultProcess<SysRoleManageRoleInfoDeleteByRoleIdReqDTO, SysRoleManageRoleInfoDeleteByRoleIdRespDTO> {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private BaseinfoPersonInsideRpcReadService baseinfoPersonInsideRpcReadService;

    @Override
    public void process(Context<SysRoleManageRoleInfoDeleteByRoleIdReqDTO, SysRoleManageRoleInfoDeleteByRoleIdRespDTO> context) {
        SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO = context.getParam();
        SysRoleModel role = sysRoleService.findSysRoleManageRoleInfoByRoleId(SysRoleFactory.sysRoleManageRoleInfoDeleteByRoleIdReqDTOTOModel(sysRoleManageRoleInfoDeleteByRoleIdReqDTO));
        //判断角色是否存在
        if (role == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //判断角色是否被删除
        if (role.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        //查询角色是否已被使用
        Result<List<PersonRoleInfoRespDTO>> roleuser = baseinfoPersonInsideRpcReadService.queryPersonRoleInfo(SysRoleFactory.sysRoleManageRoleInfoDeleteByRoleIdReqDTOToPersonRoleQuery(sysRoleManageRoleInfoDeleteByRoleIdReqDTO));
        //判断是否能调用用户中心的接口，或者接口获取的model是否为空
        if (!roleuser.isSuccess()||!CollectionUtils.isEmpty(roleuser.getModule())) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_USED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_USED.getErrMsg());
        }
        Integer deleteRole = sysRoleService.removeSysRoleManageRoleInfoByRoleId(SysRoleFactory.sysRoleManageRoleInfoDeleteByRoleIdReqDTOTOModel(sysRoleManageRoleInfoDeleteByRoleIdReqDTO));
        SysRoleManageRoleInfoDeleteByRoleIdRespDTO sysRoleManageRoleInfoDeleteByRoleIdRespDTO = new SysRoleManageRoleInfoDeleteByRoleIdRespDTO();
        if (deleteRole == null || deleteRole == 0) {
            sysRoleManageRoleInfoDeleteByRoleIdRespDTO.setMessage("删除失败");
        } else {
            sysRoleManageRoleInfoDeleteByRoleIdRespDTO.setMessage("删除成功");
        }
        context.getResult().setModule(sysRoleManageRoleInfoDeleteByRoleIdRespDTO);
    }
}
