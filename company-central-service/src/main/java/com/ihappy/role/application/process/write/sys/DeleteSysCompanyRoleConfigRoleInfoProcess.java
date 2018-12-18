package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleDeleteReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleDeleteRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.person.PersonRoleInfoRespDTO;
import com.ihappy.user.service.person.BaseinfoPersonInsideRpcReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * created by zhangmengdan
 */
public class DeleteSysCompanyRoleConfigRoleInfoProcess extends DefaultProcess<SysCompanyRoleConfigRoleDeleteReqDTO, SysCompanyRoleConfigRoleDeleteRespDTO> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;
    @Autowired
    private BaseinfoPersonInsideRpcReadService baseinfoPersonInsideRpcReadService;
    @Override
    public void process(Context<SysCompanyRoleConfigRoleDeleteReqDTO, SysCompanyRoleConfigRoleDeleteRespDTO> context) {
        SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO = context.getParam();
        //查询角色信息
        SysCompanyRoleModel role = sysCompanyRoleService.findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleFactory.sysCompanyRoleConfigRoleDeleteReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleConfigRoleDeleteReqDTO));
        //角色是否存在
        if (role == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //角色是否已被删除
        if (role.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        //从用户中心调用查看角色用户列表,查询角色是否已被使用，是则不能删除
        //查询角色是否已被使用
        Result<List<PersonRoleInfoRespDTO>> roleuser = baseinfoPersonInsideRpcReadService.queryPersonRoleInfo(SysCompanyRoleFactory.sysCompanyRoleConfigRoleDeleteReqDTOToPersonRoleQuery(sysCompanyRoleConfigRoleDeleteReqDTO));
        //判断是否能调用用户中心的接口，或者接口获取的model是否为空
        if (!roleuser.isSuccess() || !CollectionUtils.isEmpty(roleuser.getModule())) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_USED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_USED.getErrMsg());
        }
        //删除角色信息
        Integer deleteSysCompanyRole = sysCompanyRoleService.removeSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleFactory.sysCompanyRoleConfigRoleDeleteReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleConfigRoleDeleteReqDTO));
        SysCompanyRoleConfigRoleDeleteRespDTO sysCompanyRoleConfigRoleDeleteRespDTO = new SysCompanyRoleConfigRoleDeleteRespDTO();
        if (deleteSysCompanyRole > 0) {
            sysCompanyRoleConfigRoleDeleteRespDTO.setMessage("删除成功");
        }
        RolePrivilegeRedisUtil.delSysCompanyRole(ConfigCenterUtil.ENV, String.valueOf(sysCompanyRoleConfigRoleDeleteReqDTO.getRoleId()));
        context.getResult().setModule(sysCompanyRoleConfigRoleDeleteRespDTO);
    }
}
