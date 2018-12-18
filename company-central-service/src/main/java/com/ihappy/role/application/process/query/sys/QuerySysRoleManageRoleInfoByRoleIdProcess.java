package com.ihappy.role.application.process.query.sys;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.common.util.ListConvertToTreeList;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.bo.SysRoleManageBO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoQueryByRoleIdReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoQueryByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleMenu;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleRightsRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import com.ihappy.trade.common.util.ToolConver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by zhangmengdan
 * 运营后台-设置-角色配置-角色列表-角色详情process
 */
public class QuerySysRoleManageRoleInfoByRoleIdProcess extends DefaultQueryProcess<SysRoleManageRoleInfoQueryByRoleIdReqDTO, SysRoleManageRoleInfoQueryByRoleIdRespDTO> {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public void process(Context<SysRoleManageRoleInfoQueryByRoleIdReqDTO, SysRoleManageRoleInfoQueryByRoleIdRespDTO> context) {
        SysRoleManageRoleInfoQueryByRoleIdReqDTO sysRoleManageRoleInfoQueryByRoleIdReqDTO = context.getParam();
        SysRoleManageBO sysRoleManageBO = SysRoleFactory.sysRoleManageRoleInfoQueryByRoleIdReqDTOTOModel(sysRoleManageRoleInfoQueryByRoleIdReqDTO);
        SysRoleModel findRoleInfo = sysRoleService.findSysRoleManageRoleInfoByRoleId(sysRoleManageBO);
        //角色是否为空
        if (findRoleInfo == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //角色是否被删除
        if (findRoleInfo.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        //获取运营后台总菜单
        List<PrivilegeAllRespDTO> allMenuList = RolePrivilegeRedisUtil.getAllSysPriv(ConfigCenterUtil.ENV, "1");
        //响应设置角色信息及菜单
        SysRoleManageRoleInfoQueryByRoleIdRespDTO sysRoleManageRoleInfoQueryByRoleIdRespDTO = new SysRoleManageRoleInfoQueryByRoleIdRespDTO();
        sysRoleManageRoleInfoQueryByRoleIdRespDTO.setRoleInfo(SysRoleFactory.modelTOSysRoleManageRoleInfo(findRoleInfo));
        //功能菜单响应参数列表
        List<SysRoleManageRoleMenu> menuList = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        Map<String, String> rightsMap = getRoleMenuRights(findRoleInfo.getDO().getRoleRights(), "1", integers);
        for (PrivilegeAllRespDTO totalMenu : allMenuList) {
            int isChecked = 0;
            if (rightsMap.get(totalMenu.getCtFuncId() + "") != null) {
                isChecked = 1;
            }
            SysRoleFactory.sysRoleManageRoleMenuTOModel(totalMenu).setIsChecked(isChecked);
            menuList.add(SysRoleFactory.sysRoleManageRoleMenuTOModel(totalMenu));
//子菜单
            SysRoleFactory.sysRoleManageRoleMenuSubTOModel(totalMenu).setIsChecked(isChecked);
            SysRoleFactory.sysRoleManageRoleMenuTOModel(totalMenu).setSub(SysRoleFactory.sysRoleManageRoleMenuSubTOModel(totalMenu));

        }
        sysRoleManageRoleInfoQueryByRoleIdRespDTO.setMemu(ListConvertToTreeList.changeAscIdStr(menuList));
        context.getResult().setModule(sysRoleManageRoleInfoQueryByRoleIdRespDTO);
    }

    //如何获取角色菜单权限
    Map<String, String> getRoleMenuRights(String rights, String clId, List<Integer> funcIdList) {
        List<SysRoleManageRoleRightsRespDTO> rightsList = JSONArray.parseArray(rights, SysRoleManageRoleRightsRespDTO.class);
        Map<String, String> map = new HashMap<>();
        for (SysRoleManageRoleRightsRespDTO sysRoleManageRoleRightsRespDTO : rightsList) {
            if (sysRoleManageRoleRightsRespDTO.getClId() != null ||
                    sysRoleManageRoleRightsRespDTO.getClId().intValue() == Integer.valueOf(clId).intValue()) {

                funcIdList = ToolConver.stringParseInteger(sysRoleManageRoleRightsRespDTO.getFunc());
                for (Integer funcId : funcIdList) {
                    map.put(funcId + "", funcId + "");
                }
                return map;
            }
        }
        return map;
    }

}
