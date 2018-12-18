package com.ihappy.role.application.process.query.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.domain.model.factory.SysCompanyTypeFactory;
import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.company.infrastructure.service.inside.SysCompanyTypeService;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleInfoTypeClientListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleInfoTypeClientListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysClientFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysClientService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuerySysCompanyRoleInfoTypeClientListProcess extends DefaultQueryProcess<SysCompanyRoleInfoTypeClientListQueryReqDTO, List<SysCompanyRoleInfoTypeClientListQueryRespDTO>> {
    @Autowired
    private SysClientService sysClientService;
    @Autowired
    private SysCompanyTypeService sysCompanyTypeService;
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<SysCompanyRoleInfoTypeClientListQueryReqDTO, List<SysCompanyRoleInfoTypeClientListQueryRespDTO>> context) {
        SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO = context.getParam();
//查询角色信息
        SysCompanyRoleModel role = sysCompanyRoleService.findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleFactory.sysCompanyRoleInfoTypeClientListQueryReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleInfoTypeClientListQueryReqDTO));
        //角色是否为空
        if (role == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //角色是否被删除
        if (role.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        //查询系统客户端列表
        List<SysClientModel> clientsList = sysClientService.querySysClientList( SysClientFactory.sysCompanyRoleInfoTypeClientListQueryReqDTOToSysClientBO(sysCompanyRoleInfoTypeClientListQueryReqDTO));
        if (clientsList.size() == 0) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_CLIENT_LIST_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_CLIENT_LIST_IS_NOT_NULL.getErrMsg());
        }
        //查询系统公司类型列表是否为空
        List<SysCompanyTypeModel> typesList = sysCompanyTypeService.selectSysCompanyTypeList( SysCompanyTypeFactory.sysCompanyRoleInfoTypeClientListQueryReqDTOToSysCompanyTypeBO(sysCompanyRoleInfoTypeClientListQueryReqDTO));
        if (typesList.size() == 0) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_COMPANY_TYPE_LIST_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_COMPANY_TYPE_LIST_IS_NOT_NULL.getErrMsg());
        }
        Map<String, String> rights = new HashMap<>();
        getRights(rights, role);
        List<SysCompanyRoleInfoTypeClientListQueryRespDTO> list = new ArrayList<>();
//循环两张表,如何选中类型列表
        for (SysCompanyTypeModel sysCompanyTypeModel : typesList) {
            for (SysClientModel sysClientModel : clientsList) {
                int isChecked = 0;
                if (rights.get(sysClientModel.getDO().getClId().toString() + "_" + sysCompanyTypeModel.getDO().getCtId().toString()) != null) {
                    isChecked = 1;
                }
                SysCompanyRoleFactory.modelTOSysCompanyRoleInfoTypeClientListQueryRespDTO(sysCompanyTypeModel,sysClientModel).setIsChecked(isChecked);
                list.add(SysCompanyRoleFactory.modelTOSysCompanyRoleInfoTypeClientListQueryRespDTO(sysCompanyTypeModel,sysClientModel));
            }
        }
        context.getResult().setModule(list);
    }

    Map<String, String> getRights(Map<String, String> clIdctIdNameMap, SysCompanyRoleModel sysCompanyRoleModel) {
        JSONArray jsonArray = JSONArray.parseArray(sysCompanyRoleModel.getRoleRights());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            clIdctIdNameMap.put(jsonObject.getString("clId") + "_" + jsonObject.getString("ctId"), jsonObject.getString("func"));
        }
        return clIdctIdNameMap;
    }
}
