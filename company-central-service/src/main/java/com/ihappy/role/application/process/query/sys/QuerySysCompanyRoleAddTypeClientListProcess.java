package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.domain.model.factory.SysCompanyTypeFactory;
import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.company.infrastructure.service.inside.SysCompanyTypeService;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleAddTypeClientListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleAddTypeClientListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysClientFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.infrastructure.service.inside.SysClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 运营后台-平台设定-角色配置-角色添加-应用配置-类型列表process
 */
public class QuerySysCompanyRoleAddTypeClientListProcess extends DefaultQueryProcess<SysCompanyRoleAddTypeClientListQueryReqDTO, List<SysCompanyRoleAddTypeClientListQueryRespDTO>> {
    @Autowired
    private SysClientService sysClientService;
    @Autowired
    private SysCompanyTypeService sysCompanyTypeService;

    @Override
    public void process(Context<SysCompanyRoleAddTypeClientListQueryReqDTO, List<SysCompanyRoleAddTypeClientListQueryRespDTO>> context) {
        SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO = context.getParam();
        //查询系统客户端列表
        List<SysClientModel> clientsList = sysClientService.querySysClientList(SysClientFactory.sysClientFactorysysCompanyRoleAddTypeClientListQueryReqDTOToSysClientBO(sysCompanyRoleAddTypeClientListQueryReqDTO));
        if (CollectionUtils.isEmpty(clientsList)) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_CLIENT_LIST_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_CLIENT_LIST_IS_NOT_NULL.getErrMsg());
        }
        //查询系统公司类型列表
        List<SysCompanyTypeModel> typesList = sysCompanyTypeService.selectSysCompanyTypeList(SysCompanyTypeFactory.sysCompanyRoleAddTypeClientListQueryReqDTOToSysCompanyTypeBO(sysCompanyRoleAddTypeClientListQueryReqDTO));
        if (CollectionUtils.isEmpty(typesList)) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_COMPANY_TYPE_LIST_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_COMPANY_TYPE_LIST_IS_NOT_NULL.getErrMsg());
        }
        List<SysCompanyRoleAddTypeClientListQueryRespDTO> list = new ArrayList<>();
        //循环查找两张表
        for (SysCompanyTypeModel sysCompanyTypeModel : typesList) {
            for (SysClientModel sysClientModel : clientsList) {
                list.add(SysCompanyRoleFactory.modelTOSysCompanyRoleAddTypeClientListQueryRespDTO(sysClientModel, sysCompanyTypeModel));
            }
            context.getResult().setModule(list);
        }
    }


}
