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
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleInfoQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleInfoTypeClientListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysClientFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysClientService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运营后台-平台设定-角色配置-角色详情process
 */
public class QuerySysCompanyRoleConfigRoleInfoProcess extends DefaultQueryProcess<SysCompanyRoleConfigRoleInfoQueryReqDTO, SysCompanyRoleConfigRoleInfoQueryRespDTO> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;
    @Autowired
    private SysClientService sysClientService;
    @Autowired
    private SysCompanyTypeService sysCompanyTypeService;
    @Override
    public void process(Context<SysCompanyRoleConfigRoleInfoQueryReqDTO, SysCompanyRoleConfigRoleInfoQueryRespDTO> context) {
        SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO = context.getParam();
//查询角色信息
        SysCompanyRoleModel role = sysCompanyRoleService.findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleFactory.sysRoleConfigRoleInfoQueryReqDTOTOModel(sysCompanyRoleConfigRoleInfoQueryReqDTO));
        if (role == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        if (role.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        Map<String, String> roleListMap = new HashMap<>();
        getRoleRights(roleListMap, role);
        //查询客户端信息
        List<SysClientModel> sysClientModelList = sysClientService.querySysClientList(SysClientFactory.sysCompanyRoleConfigRoleInfoQueryReqDTOToSysClientBO(sysCompanyRoleConfigRoleInfoQueryReqDTO));
        //客户端是否为空，否则抛出异常
        if (CollectionUtils.isEmpty(sysClientModelList)) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_CLIENT_LIST_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_CLIENT_LIST_IS_NOT_NULL.getErrMsg());
        }
        //查询系统公司类型信息
        List<SysCompanyTypeModel> sysCompanyTypeModelList = sysCompanyTypeService.selectSysCompanyTypeList(SysCompanyTypeFactory.sysCompanyRoleConfigRoleInfoQueryReqDTOToSysCompanyTypeBO(sysCompanyRoleConfigRoleInfoQueryReqDTO));
        //类型是否为空，为空抛出异常
        if (CollectionUtils.isEmpty(sysCompanyTypeModelList)) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_COMPANY_TYPE_INFO_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_COMPANY_TYPE_INFO_IS_NOT_NULL.getErrMsg());
        }

        List<SysCompanyRoleInfoTypeClientListQueryRespDTO> list = new ArrayList<>();
        for (SysCompanyTypeModel sysCompanyTypeModel : sysCompanyTypeModelList) {
            for (SysClientModel sysClientModel : sysClientModelList) {
                int isChecked = 0;
                if (roleListMap.get(sysClientModel.getDO().getClId() + "_" + sysCompanyTypeModel.getDO().getCtId()) != null) {
                    isChecked = 1;
                }
                SysCompanyRoleFactory.modelTOSysCompanyRoleInfoTypeClientListQueryRespDTO(sysCompanyTypeModel, sysClientModel).setIsChecked(isChecked);
                list.add( SysCompanyRoleFactory.modelTOSysCompanyRoleInfoTypeClientListQueryRespDTO(sysCompanyTypeModel, sysClientModel));
            }
        }
        context.getResult().setModule(SysCompanyRoleFactory.modelToSysRoleConfigRoleInfoQueryRespDTO(role));
    }

    Map<String, String> getRoleRights(Map<String, String> clctNameMap, SysCompanyRoleModel sysCompanyRoleModel) {
        JSONArray jsonArray = JSONArray.parseArray(sysCompanyRoleModel.getRoleRights());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            clctNameMap.put(jsonObject.getString("clId") + "_" + jsonObject.get("ctId"), jsonObject.getString("func"));
        }
        return clctNameMap;
    }
}
