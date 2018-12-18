package com.ihappy.role.application.process.query.sys;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.common.util.ListConvertToTreeList;
import com.ihappy.company.domain.model.factory.SysCompanyTypeFactory;
import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.company.infrastructure.service.inside.SysCompanyTypeService;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleInfoTypeClientFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleInfoMenuRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleInfoTypeClientFuncListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysClientFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysClientService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import com.ihappy.trade.common.util.ToolConver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运营后台角色配置角色应用详情配置类型菜单process
 */
public class QuerySysCompanyRoleInfoTypeClientFuncListProcess extends DefaultQueryProcess<SysCompanyRoleInfoTypeClientFuncListQueryReqDTO, SysCompanyRoleInfoTypeClientFuncListQueryRespDTO> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;
    @Autowired
    private SysCompanyTypeService sysCompanyTypeService;
    @Autowired
    private SysClientService sysClientService;
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyRoleInfoTypeClientFuncListQueryReqDTO, SysCompanyRoleInfoTypeClientFuncListQueryRespDTO> context) {
        SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO = context.getParam();
        //查询系统公司类型信息
        SysCompanyTypeModel sysCompanyTypeModel = sysCompanyTypeService.selectOneSysCompanyTypeByCtId(SysCompanyTypeFactory.sysCompanyRoleInfoTypeClientFuncListQueryReqDTOToSysCompanyTypeBO2(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO));
        //类型是否为空，为空抛出异常
        if (sysCompanyTypeModel == null) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_COMPANY_TYPE_INFO_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.SYS_COMPANY_TYPE_INFO_IS_NOT_NULL.getErrMsg());
        }
        //查询角色信息
        SysCompanyRoleModel role = sysCompanyRoleService.findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleFactory.sysCompanyRoleConfigRoleInfoMenuReqDTOTOModel(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO));
        if (role == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        if (role.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        SysCompanyRoleInfoTypeClientFuncListQueryRespDTO sysCompanyRoleInfoTypeClientFuncListQueryRespDTO = new SysCompanyRoleInfoTypeClientFuncListQueryRespDTO();
        //响应出参角色信息
        sysCompanyRoleInfoTypeClientFuncListQueryRespDTO.setRoleInfo(SysCompanyRoleFactory.modelTOSysCompanyRoleConfigRoleListQueryRespDTO(role));
        //响应出参系统公司功能菜单
        List<SysCompanyRoleConfigRoleInfoMenuRespDTO> menu = new ArrayList<>();
        SysClientModel client = sysClientService.querySysClientByClId(SysClientFactory.sysCompanyRoleInfoTypeClientFuncListQueryReqDTOToSysClientInfoBO(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO));
        //如何选中类型对应的菜单
        //获取系统公司总菜单
        List<SysCompanyFuncModel> allMenuList = sysCompanyFuncService.findSysCompanyFuncList(SysCompanyRoleFactory.sysCompanyRoleInfoTypeClientFuncListQueryReqDTOToSysCompanyFuncBO(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO));
        List<Integer> funcIdList = new ArrayList<>();
        Map<String, String> rightsMap = getMenu(client.getDO().getClId().toString(), sysCompanyTypeModel.getDO().getCtId().toString(), role.getDO().getRoleRights(), funcIdList);
        for (SysCompanyFuncModel sysCompanyFuncModel : allMenuList) {
            int isChecked = 0;
            if (rightsMap.get(sysCompanyFuncModel.getDO().getCtFuncId() + "") != null) {
                isChecked = 1;
            }
            SysCompanyRoleFactory.roleDtoToDto(sysCompanyFuncModel).setIsChecked(isChecked);
            menu.add(SysCompanyRoleFactory.roleDtoToDto(sysCompanyFuncModel));
        }
        // 菜单列表改变成树的形状
        sysCompanyRoleInfoTypeClientFuncListQueryRespDTO.setMenu(ListConvertToTreeList.changeAscIdStr(menu));
        context.getResult().setModule(sysCompanyRoleInfoTypeClientFuncListQueryRespDTO);
    }

    Map<String, String> getMenu(String clId, String ctId, String rights, List<Integer> funcIdsList) {
        List<SysCompanyRoleConfigRoleRightsRespDTO> sysCompanyRoleConfigRoleRightsRespDTOS = JSONArray.parseArray(rights, SysCompanyRoleConfigRoleRightsRespDTO.class);
        Map<String, String> map = new HashMap<>();
        for (SysCompanyRoleConfigRoleRightsRespDTO sysCompanyRoleConfigRoleRightsRespDTO : sysCompanyRoleConfigRoleRightsRespDTOS) {
            if (sysCompanyRoleConfigRoleRightsRespDTO.getClId() != null &&
                    sysCompanyRoleConfigRoleRightsRespDTO.getClId().intValue() == Integer.valueOf(clId).intValue()
                    && sysCompanyRoleConfigRoleRightsRespDTO.getCtId() != null &&
                    sysCompanyRoleConfigRoleRightsRespDTO.getCtId().intValue() == Long.valueOf(ctId).intValue()) {
                funcIdsList = ToolConver.stringParseInteger(sysCompanyRoleConfigRoleRightsRespDTO.getFunc());
                for (Integer funcId : funcIdsList) {
                    map.put(funcId + "", funcId + "");
                }
            }
        }
        return map;
    }
}
