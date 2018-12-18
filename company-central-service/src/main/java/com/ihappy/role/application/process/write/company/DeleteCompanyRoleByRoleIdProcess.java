package com.ihappy.role.application.process.write.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dbdo.company.BaseinfoCompanyRole;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleDelReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleDelRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.company.BaseinfoCompanyRoleMapper;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.person.PersonRoleInfoRespDTO;
import com.ihappy.user.service.person.BaseinfoPersonInsideRpcReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * created by zhangmengdan
 * created at 2018/8/27
 * APP-管理-角色管理-角色-角色删除process
 */
public class DeleteCompanyRoleByRoleIdProcess extends DefaultProcess<CompanyRoleDelReqDTO, CompanyRoleDelRespDTO> {
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private BaseinfoCompanyRoleMapper baseinfoCompanyRoleMapper;
    @Autowired
    private BaseinfoPersonInsideRpcReadService baseinfoPersonInsideRpcReadService;
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<CompanyRoleDelReqDTO, CompanyRoleDelRespDTO> context) {
        CompanyRoleDelReqDTO companyRoleDelReqDTO = context.getParam();
        //查询系统角色详情
        SysCompanyRoleModel sysCompanyRoleInfo = sysCompanyRoleService.finsSysCompanyRoleInfo(SysCompanyRoleFactory.companyRoleDelReqDTODTOToSysCompanyRoleBO(companyRoleDelReqDTO));
        if (sysCompanyRoleInfo != null) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_ROLE_NOT_CAN_DELETED.getErrCode(),
                    RoleErrorCodeEnum.SYS_ROLE_NOT_CAN_DELETED.getErrMsg());
        }

        //查询公司角色详情
        BaseinfoCompanyRole baseinfoCompanyRole = baseinfoCompanyRoleMapper.selectCompanyRoleByRoleId(CompanyRoleFactory.companyRoleDelReqDTOToModel(companyRoleDelReqDTO));
        //角色是否为空
        if (baseinfoCompanyRole == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //系统默认角色不能删除
        if (baseinfoCompanyRole.getIsDefault() == 1) {
            throw new CompanyException(RoleErrorCodeEnum.SYSTEM_ROLE_NAME_IS_CAN_NOT_DELETED.getErrCode(),
                    RoleErrorCodeEnum.SYSTEM_ROLE_NAME_IS_CAN_NOT_DELETED.getErrMsg());
        }

        //查询角色是否已被使用
        Result<List<PersonRoleInfoRespDTO>> roleuser = baseinfoPersonInsideRpcReadService.queryPersonRoleInfo( CompanyRoleFactory.companyRoleDelReqDTOToPersonRoleQuery(companyRoleDelReqDTO));
        //判断是否能调用用户中心的接口，或者接口获取的model是否为空
        if (!roleuser.isSuccess() || !CollectionUtils.isEmpty(roleuser.getModule())) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_USED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_USED.getErrMsg());
        }

        Integer deleteRole = companyRoleService.removeCompanyRoleByRoleId(CompanyRoleFactory.companyRoleDelReqDTOToCompanyRoleBO(companyRoleDelReqDTO));
        CompanyRoleDelRespDTO respDTO = new CompanyRoleDelRespDTO();
        if (deleteRole > 0) {
            respDTO.setMessage("删除成功");
        }
        context.getResult().setModule(respDTO);
    }
}
