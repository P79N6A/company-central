package com.ihappy.role.domain.model.factory.sys;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.role.domain.bo.CheckRoleNameBO;
import com.ihappy.role.domain.bo.SysRoleManageBO;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.user.domain.query.person.PersonRoleQuery;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
public class SysRoleFactory {
    public static List<SysRoleQueryRespDTO> modelListToRespDTOList(List<SysRoleModel> sysRoleModels) {
        List<SysRoleQueryRespDTO> res = new ArrayList<SysRoleQueryRespDTO>();
        for (SysRoleModel obj : sysRoleModels) {
            SysRoleQueryRespDTO sysRoleQueryRespDTO = new SysRoleQueryRespDTO();
            BeanUtils.copyProperties(obj.getDO(), sysRoleQueryRespDTO);
            List<RoleRightsRespDTO> roleRights = JSONArray.parseArray(obj.getDO().getRoleRights(), RoleRightsRespDTO.class);
            sysRoleQueryRespDTO.setRoleRights(roleRights);
            res.add(sysRoleQueryRespDTO);
        }
        return res;
    }

    public static SysRoleManageBO sysRoleManageRoleListQueryReqDTOTOModel(SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO) {
        SysRoleManageBO sysRoleManageBO = new SysRoleManageBO();
        sysRoleManageBO.setLimit(sysRoleManageRoleListQueryReqDTO.getLimit());
        sysRoleManageBO.setOffset(sysRoleManageRoleListQueryReqDTO.getOffset());
        sysRoleManageBO.setKeyWords(sysRoleManageRoleListQueryReqDTO.getKeyWords());
        return sysRoleManageBO;
    }

    public static List<SysRoleManageRoleListQueryRespDTO> modelTOSysRoleManageRoleListQueryRespDTO(List<SysRoleModel> sysRoleModel) {
        List<SysRoleManageRoleListQueryRespDTO> listQueryRespDTOS = new ArrayList<>();
        for (SysRoleModel sysRoleModel1 : sysRoleModel) {
            SysRoleManageRoleListQueryRespDTO sysRoleManageRoleListQueryRespDTO = new SysRoleManageRoleListQueryRespDTO();
            sysRoleManageRoleListQueryRespDTO.setRoleName(sysRoleModel1.getDO().getRoleName());
            sysRoleManageRoleListQueryRespDTO.setRoleMemo(sysRoleModel1.getDO().getRoleMemo());
            sysRoleManageRoleListQueryRespDTO.setRoleId(sysRoleModel1.getDO().getRoleId());
            listQueryRespDTOS.add(sysRoleManageRoleListQueryRespDTO);
        }
        return listQueryRespDTOS;
    }

    public static CheckRoleNameBO sysRoleManageRoleAddReqDTOTOModel(SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO) {
        CheckRoleNameBO checkRoleNameBO = new CheckRoleNameBO();
        checkRoleNameBO.setRoleName(sysRoleManageRoleAddReqDTO.getRoleName());
        return checkRoleNameBO;
    }

    public static CheckRoleNameBO sysRoleMangeRoleUpdateReqDTOTOModel(SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO) {
        CheckRoleNameBO checkRoleNameBO = new CheckRoleNameBO();
        checkRoleNameBO.setRoleName(sysRoleMangeRoleUpdateReqDTO.getRoleName());
        return checkRoleNameBO;
    }

    public static SysRoleManageBO sysRoleManageRoleAddReqDTOToModel(SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO) {
        SysRoleManageBO sysRoleManageBO = new SysRoleManageBO();
        sysRoleManageBO.setRoleName(sysRoleManageRoleAddReqDTO.getRoleName());
        sysRoleManageBO.setRoleMemo(sysRoleManageRoleAddReqDTO.getRoleMemo());
        sysRoleManageBO.setRoleRights(sysRoleManageRoleAddReqDTO.getRoleRights());
        sysRoleManageBO.setCreatedAt(sysRoleManageRoleAddReqDTO.getCreateTime() == null ?CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysRoleManageRoleAddReqDTO.getCreateTime()));
        sysRoleManageBO.setCreatedPersonId(sysRoleManageRoleAddReqDTO.getCreateId());
        return sysRoleManageBO;
    }


    public static SysRoleManageBO SysRoleMangeRoleUpdateReqDTOTOModel(SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO) {
        SysRoleManageBO sysRoleManageBO = new SysRoleManageBO();
        sysRoleManageBO.setRoleId(sysRoleMangeRoleUpdateReqDTO.getRoleId());
        sysRoleManageBO.setRoleName(sysRoleMangeRoleUpdateReqDTO.getRoleName());
        sysRoleManageBO.setRoleMemo(sysRoleMangeRoleUpdateReqDTO.getRoleMemo());

        sysRoleManageBO.setUpdatedAt(sysRoleMangeRoleUpdateReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysRoleMangeRoleUpdateReqDTO.getUpdateTime()));
        sysRoleManageBO.setUpdatedPersonId(sysRoleMangeRoleUpdateReqDTO.getUpdateId());
        return sysRoleManageBO;
    }

    public static SysRoleManageBO sysRoleManageRoleInfoDeleteByRoleIdReqDTOTOModel(SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO) {
        SysRoleManageBO sysRoleManageBO = new SysRoleManageBO();
        sysRoleManageBO.setRoleId(sysRoleManageRoleInfoDeleteByRoleIdReqDTO.getRoleId());
        sysRoleManageBO.setUpdatedAt(sysRoleManageRoleInfoDeleteByRoleIdReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysRoleManageRoleInfoDeleteByRoleIdReqDTO.getUpdateTime()));
        sysRoleManageBO.setUpdatedPersonId(sysRoleManageRoleInfoDeleteByRoleIdReqDTO.getUpdateId());
        return sysRoleManageBO;
    }

    public static SysRoleManageBO sysRoleManageRoleInfoQueryByRoleIdReqDTOTOModel(SysRoleManageRoleInfoQueryByRoleIdReqDTO sysRoleManageRoleInfoQueryByRoleIdReqDTO) {
        SysRoleManageBO sysRoleManageBO = new SysRoleManageBO();
        sysRoleManageBO.setRoleId(sysRoleManageRoleInfoQueryByRoleIdReqDTO.getRoleId());
        return sysRoleManageBO;
    }

    public static SysRoleManageRoleInfo modelTOSysRoleManageRoleInfo(SysRoleModel sysRoleModel) {
        SysRoleManageRoleInfo sysRoleManageRoleInfo = new SysRoleManageRoleInfo();
        sysRoleManageRoleInfo.setRoleId(sysRoleModel.getDO().getRoleId());
        sysRoleManageRoleInfo.setRoleName(sysRoleModel.getDO().getRoleName());
        sysRoleManageRoleInfo.setRoleMemo(sysRoleModel.getDO().getRoleMemo());
        return sysRoleManageRoleInfo;
    }

    public static SysRoleManageRoleMenu sysRoleManageRoleMenuTOModel(PrivilegeAllRespDTO totalMenu) {
        SysRoleManageRoleMenu sysRoleManageRoleMenu = new SysRoleManageRoleMenu();
        sysRoleManageRoleMenu.setIsChecked(0);
        sysRoleManageRoleMenu.setClId(totalMenu.getClId());
        sysRoleManageRoleMenu.setCtFuncId(totalMenu.getCtFuncId());
        sysRoleManageRoleMenu.setCtFuncName(totalMenu.getCtFuncName());
        sysRoleManageRoleMenu.setCtFuncNo(totalMenu.getCtFuncNo());
        sysRoleManageRoleMenu.setFuncType(totalMenu.getFuncType());
        sysRoleManageRoleMenu.setParentCtFuncId(totalMenu.getParentCtFuncId());
        return sysRoleManageRoleMenu;
    }

    public static SysRoleManageRoleMenuSub sysRoleManageRoleMenuSubTOModel(PrivilegeAllRespDTO totalMenu) {
        SysRoleManageRoleMenuSub sysRoleManageRoleMenuSub = new SysRoleManageRoleMenuSub();
        sysRoleManageRoleMenuSub.setIsChecked(0);
        sysRoleManageRoleMenuSub.setClId(totalMenu.getClId());
        sysRoleManageRoleMenuSub.setCtFuncId(totalMenu.getCtFuncId());
        sysRoleManageRoleMenuSub.setCtFuncName(totalMenu.getCtFuncName());
        sysRoleManageRoleMenuSub.setCtFuncNo(totalMenu.getCtFuncNo());
        sysRoleManageRoleMenuSub.setFuncType(totalMenu.getFuncType());
        sysRoleManageRoleMenuSub.setParentCtFuncId(totalMenu.getParentCtFuncId());
        return sysRoleManageRoleMenuSub;
    }

    public static PersonRoleQuery sysRoleManageRoleInfoDeleteByRoleIdReqDTOToPersonRoleQuery(SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO) {
        PersonRoleQuery personRoleQuery = new PersonRoleQuery();
        personRoleQuery.setCompId(-1L);
        personRoleQuery.setRoleId(sysRoleManageRoleInfoDeleteByRoleIdReqDTO.getRoleId());
        return personRoleQuery;
    }

}
