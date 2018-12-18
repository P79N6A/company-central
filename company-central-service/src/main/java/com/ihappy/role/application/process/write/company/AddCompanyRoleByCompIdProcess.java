package com.ihappy.role.application.process.write.company;

import com.alibaba.fastjson.JSON;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleAddReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleAddRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleRight;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.exception.RoleException;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * APP-管理-角色管理-角色添加process
 */
public class AddCompanyRoleByCompIdProcess extends DefaultProcess<CompanyRoleAddReqDTO, CompanyRoleAddRespDTO> {
    @Autowired
    private CompanyRoleService companyRoleService;

    @Override
    public void process(Context<CompanyRoleAddReqDTO, CompanyRoleAddRespDTO> context) {
        //通过上下文获取参数
        CompanyRoleAddReqDTO companyRoleAddReqDTO = context.getParam();
        //查询角色信息
        CompanyRoleModel role = companyRoleService.checkRoleNameIsExist(CompanyRoleFactory.companyRoleAddReqDTOToCheckRoleNameBO(companyRoleAddReqDTO));
        //判断角色名称是否重复,如果重复，报出异常
        if (role != null) {
            throw new CompanyException(RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_REPEAT.getErrMsg());
        }
        //将companyRoleAddReqDTO请求参数通过model转换baseinfoCompanyRole
        List<CompanyRoleRight> compRoleRightsFromReq = JSON.parseArray(companyRoleAddReqDTO.getRoleRights(),
                CompanyRoleRight.class);
        if(CollectionUtil.isEmpty(compRoleRightsFromReq)){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
        if(StringUtil.isBlank(compRoleRightsFromReq.get(0).getFunc())){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
        if(StringUtil.isBlank(compRoleRightsFromReq.get(0).getCtId())){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
        if(StringUtil.isBlank(compRoleRightsFromReq.get(0).getClId())){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
        //通过baseinfoCompanyRole接口插入角色
        int addRole = companyRoleService.addCompanyRole(CompanyRoleFactory.companyRoleAddReqDTOTOModel(companyRoleAddReqDTO));
        if (addRole >0){
            CompanyRoleAddRespDTO companyRoleAddRespDTO=new CompanyRoleAddRespDTO();
            context.getResult().setModule(companyRoleAddRespDTO);
        }
    }
}