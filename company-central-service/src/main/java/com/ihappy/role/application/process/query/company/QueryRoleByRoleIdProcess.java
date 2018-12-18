package com.ihappy.role.application.process.query.company;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.common.util.ListConvertToTreeList;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.constans.RoleConstans;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleRoleRightsDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleAndFuncQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.RoleRightsMenuListQueryRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import com.ihappy.trade.common.util.ToolConver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * created by zhangmengdan
 * 查询app-管理-角色管理-角色详情process
 */
public class QueryRoleByRoleIdProcess extends DefaultQueryProcess<CompanyRoleInfoQueryReqDTO, CompanyRoleAndFuncQueryRespDTO> {
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<CompanyRoleInfoQueryReqDTO, CompanyRoleAndFuncQueryRespDTO> context) {
        CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO = context.getParam();
        //公司信息
        CompanyModel companyInfo = companyInfoService.selectCompanyInfo(BaseinfoCompanyFactory.companyRoleInfoQueryReqDTOToCompanyInfoByCompIdQuery(companyRoleInfoQueryReqDTO));
        if (companyInfo == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
        //响应信息
        CompanyRoleAndFuncQueryRespDTO companyRoleAndFuncQueryRespDTO = new CompanyRoleAndFuncQueryRespDTO();
        List<RoleRightsMenuListQueryRespDTO> menuList = new ArrayList<>();
        Set<Long> setids = new HashSet<>();
        List<Integer> funcList = new ArrayList<>();
        //系统公司菜单
        List<PrivilegeAllRespDTO> companyAllMenu = RolePrivilegeRedisUtil.getAllPriv(ConfigCenterUtil.ENV, companyInfo.getDO().getCtIds(), "2");
        //如果是系统公司角色
        if (companyRoleInfoQueryReqDTO.getRoleId().longValue() < RoleConstans.MAX_SYS_ROLE_ID) {
            //系统公司角色信息
            SysCompanyRoleModel sysCompanyRoleInfo = sysCompanyRoleService.finsSysCompanyRoleInfo(SysCompanyRoleFactory.companyRoleInfoQueryReqDTOTosysCompanyRoleBO(companyRoleInfoQueryReqDTO));
            if (sysCompanyRoleInfo == null) {
                throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS);
            }
            companyRoleAndFuncQueryRespDTO.setRoleInfo(SysCompanyRoleFactory.modelTCompanyRoleQueryRespDTO(sysCompanyRoleInfo));
            Map<String, String> sysCompanyRolerightsMap = getFunsList(sysCompanyRoleInfo.getDO().getRoleRights(), companyInfo.getDO().getCtIds(), "2", funcList);
            for (PrivilegeAllRespDTO privilegeAllRespDTO : companyAllMenu) {
                int isChecked = 0;
                if (sysCompanyRolerightsMap.get(privilegeAllRespDTO.getCtFuncId() + "") != null) {
                    isChecked = 1;
                }
                RoleRightsMenuListQueryRespDTO roleRightsMenuListQueryRespDTO =
                        SysCompanyRoleFactory.privilegeAllRespDtoToRoleRightsMenuListQueryRespDTO(privilegeAllRespDTO);
                roleRightsMenuListQueryRespDTO.setIsChecked(isChecked);
                setids.add(roleRightsMenuListQueryRespDTO.getCtFuncId().longValue());
                menuList.add(roleRightsMenuListQueryRespDTO);
            }
        } else {
            //企业公司角色信息
            CompanyRoleModel companyRole = companyRoleService.getCompanyRoleByRoleId(CompanyRoleFactory.getCompanyRoleFuncMenuBOTOModel(companyRoleInfoQueryReqDTO));
            if (companyRole == null) {
                throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS);
            }
            companyRoleAndFuncQueryRespDTO.setRoleInfo(CompanyRoleFactory.modelTCompanyRoleQueryRespDTO(companyRole));
            Map<String, String> rightsMap = getFunsList(companyRole.getDO().getRoleRights(), companyInfo.getDO().getCtIds(), "2", funcList);
            for (PrivilegeAllRespDTO respDTO : companyAllMenu) {
                int isChecked = 0;
                if (rightsMap.get(respDTO.getCtFuncId() + "") != null) {
                    isChecked = 1;
                }
                RoleRightsMenuListQueryRespDTO roleRightsMenuListQueryRespDTO = CompanyRoleFactory.
                        privilegeAllRespDtoToRoleRightsMenuListQueryRespDTO(respDTO);
                roleRightsMenuListQueryRespDTO.setIsChecked(isChecked);
                setids.add(roleRightsMenuListQueryRespDTO.getCtFuncId().longValue());
                menuList.add(roleRightsMenuListQueryRespDTO);
            }
        }
        companyRoleAndFuncQueryRespDTO.setMenuList(ListConvertToTreeList.changeForOnlySomeNodeByAsc(menuList, setids));
        context.getResult().setModule(companyRoleAndFuncQueryRespDTO);
    }

    Map<String, String> getFunsList(String rights, String ctId, String clId, List<Integer> funcIdsList) {
        List<CompanyRoleRoleRightsDTO> rightsList = JSONArray.parseArray(rights, CompanyRoleRoleRightsDTO.class);
        Map<String, String> map = new HashMap<>();
        for (CompanyRoleRoleRightsDTO roleRightsDTO : rightsList) {
            if (roleRightsDTO.getClId() != null || roleRightsDTO.getClId().intValue() == Integer.valueOf(clId).intValue()
                    && roleRightsDTO.getCtId() != null || roleRightsDTO.getCtId().intValue() == Integer.valueOf(ctId).intValue()) {
                funcIdsList = ToolConver.stringParseInteger(roleRightsDTO.getFunc());
                for (Integer funcId : funcIdsList) {
                    map.put(funcId + "", funcId + "");
                }
            }
        }
        return map;
    }
}
