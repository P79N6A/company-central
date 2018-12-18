package com.ihappy.role.domain.model.factory.company;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.bo.GetCompanyRoleFuncMenuBO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.domain.bo.*;
import com.ihappy.role.domain.dbdo.company.BaseinfoCompanyRole;
import com.ihappy.role.domain.dbdo.sys.SysCompanyRole;
import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.user.domain.query.person.PersonInfoByPersonIdQuery;
import com.ihappy.user.domain.query.person.PersonRoleQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
public class CompanyRoleFactory {
    public static List<CompanyRoleQueryRespDTO> boList2CompanyRoleQueryRespDTOList(List<CompanyRoleBO> companyRoleBOs) {
        List<CompanyRoleQueryRespDTO> respDTOS = new ArrayList<CompanyRoleQueryRespDTO>();
        for (CompanyRoleBO obj : companyRoleBOs) {
            respDTOS.add(obj.toCompanyRoleQueryRespDTO());
        }
        return respDTOS;
    }

    public static List<CompanyRoleQueryRespDTO> modelListToRespDTOList(List<CompanyRoleModel> companyRoleModels) {
        List<CompanyRoleQueryRespDTO> respDTOS = new ArrayList<CompanyRoleQueryRespDTO>();
        for (CompanyRoleModel obj : companyRoleModels) {
            CompanyRoleQueryRespDTO companyRoleQueryRespDTO = new CompanyRoleQueryRespDTO();
            BeanUtils.copyProperties(obj.getDO(), companyRoleQueryRespDTO);
            List<RoleRightsRespDTO> roleRights = JSONArray.parseArray(obj.getDO().getRoleRights(), RoleRightsRespDTO.class);
            companyRoleQueryRespDTO.setRoleRights(roleRights);
            respDTOS.add(companyRoleQueryRespDTO);
        }
        return respDTOS;
    }


    public static List<BaseinfoCompanyRole> sysCompanyRoleListToBaseinfoCompanyRoleList(List<SysCompanyRole> sysCompanyRoles, Integer compId) {
        List<BaseinfoCompanyRole> resList = new ArrayList<BaseinfoCompanyRole>();
        for (SysCompanyRole obj : sysCompanyRoles) {
            BaseinfoCompanyRole res = new BaseinfoCompanyRole();
            res.setRoleId(DistributedPrimaryKeyFactory.generateCompanyRoleId(compId));
            res.setCompId(compId);
            res.setRoleName(obj.getRoleName() == null ? "" : obj.getRoleName());
            res.setCreatedAt(obj.getCreatedAt() == null ? CompanyDateUtil.getDate14Long(new Date()) : obj.getCreatedAt());
            res.setUpdatedAt(obj.getUpdatedAt() == null ? CompanyDateUtil.getDate14Long(new Date()) : obj.getUpdatedAt());
            res.setCreatedPersonId(obj.getCreatedPersonId() == null ? 0L : obj.getCreatedPersonId());
            res.setUpdatedPersonId(obj.getUpdatedPersonId() == null ? 0L : obj.getUpdatedPersonId());
            res.setRoleMemo(obj.getRoleMemo() == null ? "" : obj.getRoleMemo());
            res.setRoleRights(obj.getRoleRights() == null ? "" : obj.getRoleRights());
            res.setRoleSort(obj.getRoleSort() == null ? 1 : obj.getRoleSort());
            res.setIsHide(obj.getIsHide());
            resList.add(res);
        }
        return resList;
    }

    public static List<CompanyRoleBO> sysCompanyRoleListToCompanyRoleBOList(List<SysCompanyRole> sysCompanyRoles) {
        if (CollectionUtils.isEmpty(sysCompanyRoles)) {
            return new ArrayList<>();
        }
        List<CompanyRoleBO> res = new ArrayList<CompanyRoleBO>();
        for (SysCompanyRole obj : sysCompanyRoles) {
            CompanyRoleBO companyRoleBO = new CompanyRoleBO();
            BeanUtils.copyProperties(obj, companyRoleBO);
            List<RoleRightsBO> roleRightsList = JSONArray.parseArray(obj.getRoleRights(), RoleRightsBO.class);
            companyRoleBO.setRoleRightsList(roleRightsList);
            res.add(companyRoleBO);
        }
        return res;
    }

    public static List<BaseinfoCompanyRole> companyRoleBOListToBaseinfoCompanyRoleList(List<CompanyRoleBO> companyRoleBOs, Integer compId) {
        if (CollectionUtils.isEmpty(companyRoleBOs)) {
            return new ArrayList<>();
        }
        List<BaseinfoCompanyRole> resList = new ArrayList<BaseinfoCompanyRole>();
        for (CompanyRoleBO obj : companyRoleBOs) {
            BaseinfoCompanyRole res = new BaseinfoCompanyRole();
            res.setRoleId(DistributedPrimaryKeyFactory.generateCompanyRoleId(compId));
            res.setCompId(compId);
            res.setRoleName(obj.getRoleName() == null ? "" : obj.getRoleName());
            res.setCreatedAt(obj.getCreatedAt() == null ? CompanyDateUtil.getDate14Long(new Date()) : obj.getCreatedAt());
            res.setUpdatedAt(obj.getUpdatedAt() == null ? CompanyDateUtil.getDate14Long(new Date()) : obj.getUpdatedAt());
            res.setCreatedPersonId(obj.getCreatedPersonId() == null ? 0L : obj.getCreatedPersonId());
            res.setUpdatedPersonId(obj.getUpdatedPersonId() == null ? 0L : obj.getUpdatedPersonId());
            res.setRoleMemo(obj.getRoleMemo() == null ? "" : obj.getRoleMemo());
            res.setRoleRights(obj.getRoleRights() == null ? "" : obj.getRoleRights());
            res.setRoleSort(obj.getRoleSort() == null ? 1 : obj.getRoleSort());
            res.setIsHide(obj.getIsHide());
            res.setRoleNo(obj.getRoleNo());
            //设置默认标识
            res.setIsDefault(1);
            res.setRoleNo(obj.getRoleNo());
            resList.add(res);
        }
        return resList;
    }

    public static BaseinfoCompanyRole companyRoleAddReqDTOTOModel(CompanyRoleAddReqDTO companyRoleAddReqDTO) {
        if (companyRoleAddReqDTO == null) {
            return null;
        }
        BaseinfoCompanyRole baseinfoCompanyRole = new BaseinfoCompanyRole();
        baseinfoCompanyRole.setCompId(companyRoleAddReqDTO.getLoginCompId().intValue());
        baseinfoCompanyRole.setRoleId(DistributedPrimaryKeyFactory.generateCompanyRoleId(companyRoleAddReqDTO.getLoginCompId()));
        baseinfoCompanyRole.setRoleName(companyRoleAddReqDTO.getRoleName());
        baseinfoCompanyRole.setRoleMemo(companyRoleAddReqDTO.getRoleMemo());
        baseinfoCompanyRole.setRoleNo(companyRoleAddReqDTO.getRoleNo());
        baseinfoCompanyRole.setRoleRights(companyRoleAddReqDTO.getRoleRights());
        baseinfoCompanyRole.setRoleSort(companyRoleAddReqDTO.getRoleSort());
        baseinfoCompanyRole.setCreatedAt(companyRoleAddReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(companyRoleAddReqDTO.getCreateTime()));
        baseinfoCompanyRole.setCreatedPersonId(companyRoleAddReqDTO.getLoginPersonId());
        baseinfoCompanyRole.setUpdatedAt(companyRoleAddReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(companyRoleAddReqDTO.getUpdateTime()));
        baseinfoCompanyRole.setUpdatedPersonId(companyRoleAddReqDTO.getLoginPersonId());
        baseinfoCompanyRole.setIsDeleted(0);
        baseinfoCompanyRole.setIsHide(0);
        return baseinfoCompanyRole;
    }

    public static CompanyRoleBO companyRoleUpdateReqDTOModel(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        if (companyRoleUpdateReqDTO == null) {
            return null;
        }
        CompanyRoleBO companyRoleBO = new CompanyRoleBO();
        companyRoleBO.setCompId(Integer.valueOf(companyRoleUpdateReqDTO.getLoginCompId() + ""));
        companyRoleBO.setRoleId(companyRoleUpdateReqDTO.getRoleId());
        companyRoleBO.setRoleName(companyRoleUpdateReqDTO.getRoleName());
        companyRoleBO.setRoleMemo(companyRoleUpdateReqDTO.getRoleMemo());
        companyRoleBO.setRoleNo(companyRoleUpdateReqDTO.getRoleNo());
        companyRoleBO.setIsHide(Integer.valueOf(companyRoleUpdateReqDTO.getIsHide()));
        companyRoleBO.setUpdatedAt(DateUtil.getTodayTextYMD());
        companyRoleBO.setUpdatedPersonId(companyRoleUpdateReqDTO.getUpdateId());
        return companyRoleBO;
    }

    public static CompanyRoleInfoQueryRespDTO modelTCompanyRoleQueryRespDTO(CompanyRoleModel companyRoleModel) {
        CompanyRoleInfoQueryRespDTO companyRoleInfoQueryRespDTO = new CompanyRoleInfoQueryRespDTO();
        companyRoleInfoQueryRespDTO.setRoleId(companyRoleModel.getDO().getRoleId());
        companyRoleInfoQueryRespDTO.setRoleName(companyRoleModel.getDO().getRoleName());
        companyRoleInfoQueryRespDTO.setRoleMemo(companyRoleModel.getDO().getRoleMemo());
        companyRoleInfoQueryRespDTO.setRoleNo(companyRoleModel.getDO().getRoleNo());
        companyRoleInfoQueryRespDTO.setIsHide(companyRoleModel.getDO().getIsHide());
        return companyRoleInfoQueryRespDTO;
    }

    public static GetCompanyRoleFuncMenuBO getCompanyRoleFuncMenuBOTOModel(CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO) {
        GetCompanyRoleFuncMenuBO getCompanyRoleFuncMenuBO = new GetCompanyRoleFuncMenuBO();
        getCompanyRoleFuncMenuBO.setRoleId(companyRoleInfoQueryReqDTO.getRoleId());
        return getCompanyRoleFuncMenuBO;
    }

    public static CompanyRoleMenuListQueryRespDTO modelTOCompanyRoleMenuQueryRespDTO(SysCompanyFuncModel sysCompanyFuncModel) {

        CompanyRoleMenuListQueryRespDTO companyRoleMenuListQueryRespDTO = new CompanyRoleMenuListQueryRespDTO();
        companyRoleMenuListQueryRespDTO.setClId(sysCompanyFuncModel.getDO().getClId());
        companyRoleMenuListQueryRespDTO.setCtDepth(sysCompanyFuncModel.getDO().getCtDepth());
        companyRoleMenuListQueryRespDTO.setCtFuncId(sysCompanyFuncModel.getDO().getCtFuncId());
        companyRoleMenuListQueryRespDTO.setCtFuncLink(sysCompanyFuncModel.getDO().getCtFuncLink());
        companyRoleMenuListQueryRespDTO.setCtFuncName(sysCompanyFuncModel.getDO().getCtFuncName());
        companyRoleMenuListQueryRespDTO.setCtFuncNo(sysCompanyFuncModel.getDO().getCtFuncNo());
        companyRoleMenuListQueryRespDTO.setCtId(sysCompanyFuncModel.getDO().getCtId());
        companyRoleMenuListQueryRespDTO.setCtMemo(sysCompanyFuncModel.getDO().getCtMemo());
        companyRoleMenuListQueryRespDTO.setCtSort(sysCompanyFuncModel.getDO().getCtSort());
        companyRoleMenuListQueryRespDTO.setFuncType(sysCompanyFuncModel.getDO().getFuncType());
        companyRoleMenuListQueryRespDTO.setIsChecked(0);
        companyRoleMenuListQueryRespDTO.setParentCtFuncId(sysCompanyFuncModel.getDO().getParentCtFuncId());
        companyRoleMenuListQueryRespDTO.setSourceCodes(sysCompanyFuncModel.getDO().getSourceCodes());

        companyRoleMenuListQueryRespDTO.setParentId(Long.parseLong(sysCompanyFuncModel.getDO().getParentCtFuncId() + ""));
        companyRoleMenuListQueryRespDTO.setSort(sysCompanyFuncModel.getDO().getCtSort());
        companyRoleMenuListQueryRespDTO.setId(sysCompanyFuncModel.getDO().getCtFuncId());
        return companyRoleMenuListQueryRespDTO;
    }

    public static RoleRightsMenuListQueryRespDTO privilegeAllRespDtoToRoleRightsMenuListQueryRespDTO(PrivilegeAllRespDTO respDTO) {
        RoleRightsMenuListQueryRespDTO roleRightsMenuListQueryRespDTO = new RoleRightsMenuListQueryRespDTO();

        roleRightsMenuListQueryRespDTO.setClId(respDTO.getClId());
        roleRightsMenuListQueryRespDTO.setCtDepth(respDTO.getCtDepth());
        roleRightsMenuListQueryRespDTO.setCtFuncId(respDTO.getCtFuncId());
        roleRightsMenuListQueryRespDTO.setCtFuncLink(respDTO.getCtFuncLink());
        roleRightsMenuListQueryRespDTO.setCtFuncName(respDTO.getCtFuncName());
        roleRightsMenuListQueryRespDTO.setCtFuncNo(respDTO.getCtFuncNo());
        roleRightsMenuListQueryRespDTO.setCtId(respDTO.getCtId());
        roleRightsMenuListQueryRespDTO.setCtMemo(respDTO.getCtMemo());
        roleRightsMenuListQueryRespDTO.setCtSort(respDTO.getCtSort());
        roleRightsMenuListQueryRespDTO.setFuncType(Long.valueOf(respDTO.getFuncType()));
        roleRightsMenuListQueryRespDTO.setIsChecked(0);
        roleRightsMenuListQueryRespDTO.setParentCtFuncId(respDTO.getParentCtFuncId());
        roleRightsMenuListQueryRespDTO.setSourceCodes(respDTO.getSourceCodes());

        roleRightsMenuListQueryRespDTO.setParentId(Long.parseLong(respDTO.getParentCtFuncId() + ""));
        roleRightsMenuListQueryRespDTO.setSort(respDTO.getCtSort());
        roleRightsMenuListQueryRespDTO.setId(respDTO.getCtFuncId());
        return roleRightsMenuListQueryRespDTO;
    }

    public static QueryCompanyRolePageBO companyRoleListQueryReqDTOToQueryCompanyRolePageBO(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO) {
        QueryCompanyRolePageBO queryCompanyRolePageBO = new QueryCompanyRolePageBO();
        queryCompanyRolePageBO.setLimit(null);
        queryCompanyRolePageBO.setOffset(null);
        queryCompanyRolePageBO.setCreatedPersonId(companyRoleListQueryReqDTO.getLoginPersonId());
        queryCompanyRolePageBO.setCompId(companyRoleListQueryReqDTO.getLoginCompId().intValue());
        return queryCompanyRolePageBO;
    }

    public static List<CompanyRoleListQueryListRespDTO> sysAndCompanyRoleToCompanyRoleListQueryRespDTO(List<CompanyRoleBO> findSysCompanyRoleList, List<CompanyRoleModel> companyRoleModelsList) {
        List<CompanyRoleListQueryListRespDTO> companyRoleListQueryListRespDTO = new ArrayList<>();
        for (CompanyRoleBO companyRoleBO : findSysCompanyRoleList) {
            CompanyRoleListQueryListRespDTO companyRoleListQueryListRespDTO1 = new CompanyRoleListQueryListRespDTO();
            companyRoleListQueryListRespDTO1.setRoleId(companyRoleBO.getRoleId());
            companyRoleListQueryListRespDTO1.setRoleName(companyRoleBO.getRoleName());
            companyRoleListQueryListRespDTO1.setIsHide(companyRoleBO.getIsHide());
            companyRoleListQueryListRespDTO1.setRoleNo(companyRoleBO.getRoleNo());
            companyRoleListQueryListRespDTO1.setRoleMemo(companyRoleBO.getRoleMemo());
            companyRoleListQueryListRespDTO1.setSystemFlag(1);
            companyRoleListQueryListRespDTO.add(companyRoleListQueryListRespDTO1);
        }
        for (CompanyRoleModel companyRoleModel : companyRoleModelsList) {
            CompanyRoleListQueryListRespDTO companyRoleListQueryListRespDTO1 = new CompanyRoleListQueryListRespDTO();
            companyRoleListQueryListRespDTO1.setRoleId(companyRoleModel.getDO().getRoleId());
            companyRoleListQueryListRespDTO1.setRoleName(companyRoleModel.getDO().getRoleName());
            companyRoleListQueryListRespDTO1.setIsHide(companyRoleModel.getDO().getIsHide());
            companyRoleListQueryListRespDTO1.setRoleNo(companyRoleModel.getDO().getRoleNo());
            companyRoleListQueryListRespDTO1.setRoleMemo(companyRoleModel.getDO().getRoleMemo());
            companyRoleListQueryListRespDTO1.setSystemFlag(0);
            companyRoleListQueryListRespDTO.add(companyRoleListQueryListRespDTO1);
        }
        return companyRoleListQueryListRespDTO;
    }

    public static List<CompanyRoleListQueryListRespDTO> sysCompanyRoleToCompanyRoleListQueryRespDTO(List<CompanyRoleBO> findSysCompanyRoleList, List<CompanyRoleModel> companyRoleModelsList) {
        List<CompanyRoleListQueryListRespDTO> companyRoleListQueryListRespDTO = new ArrayList<>();
        for (CompanyRoleBO companyRoleBO : findSysCompanyRoleList) {
            CompanyRoleListQueryListRespDTO companyRoleListQueryListRespDTO1 = new CompanyRoleListQueryListRespDTO();
            companyRoleListQueryListRespDTO1.setRoleId(companyRoleBO.getRoleId());
            companyRoleListQueryListRespDTO1.setRoleName("系统"+companyRoleBO.getRoleName());
            companyRoleListQueryListRespDTO1.setIsHide(companyRoleBO.getIsHide());
            companyRoleListQueryListRespDTO1.setRoleNo(companyRoleBO.getRoleNo());
            companyRoleListQueryListRespDTO1.setRoleMemo(companyRoleBO.getRoleMemo());
            companyRoleListQueryListRespDTO.add(companyRoleListQueryListRespDTO1);
        }
        return companyRoleListQueryListRespDTO;
    }
    public static GetCompanyRoleFuncMenuBO companyRoleUpdateReqDTOToGetCompanyRoleFuncMenuBO(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        GetCompanyRoleFuncMenuBO getCompanyRoleFuncMenuBO = new GetCompanyRoleFuncMenuBO();
        getCompanyRoleFuncMenuBO.setIsDeleted(0);
        getCompanyRoleFuncMenuBO.setRoleId(companyRoleUpdateReqDTO.getRoleId());
        return getCompanyRoleFuncMenuBO;
    }

    public static CheckRoleNameBO companyRoleUpdateReqDTOToCheckRoleNameBO(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        CheckRoleNameBO checkRoleNameBO = new CheckRoleNameBO();
        checkRoleNameBO.setCompId(companyRoleUpdateReqDTO.getLoginCompId().intValue());
        checkRoleNameBO.setRoleId(companyRoleUpdateReqDTO.getRoleId());
        checkRoleNameBO.setRoleName(companyRoleUpdateReqDTO.getRoleName());
        return checkRoleNameBO;
    }

    public static CheckRoleNameBO companyRoleAddReqDTOToCheckRoleNameBO(CompanyRoleAddReqDTO companyRoleAddReqDTO) {
        CheckRoleNameBO checkRoleNameBO = new CheckRoleNameBO();
        checkRoleNameBO.setCompId(companyRoleAddReqDTO.getLoginCompId().intValue());
        checkRoleNameBO.setRoleName(companyRoleAddReqDTO.getRoleName());
        return checkRoleNameBO;
    }


    public static GetCompanyRoleFuncMenuBO companyRoleDelReqDTOToModel(CompanyRoleDelReqDTO companyRoleDelReqDTO) {
        GetCompanyRoleFuncMenuBO getCompanyRoleFuncMenuBO = new GetCompanyRoleFuncMenuBO();
        getCompanyRoleFuncMenuBO.setIsDeleted(0);
        getCompanyRoleFuncMenuBO.setRoleId(companyRoleDelReqDTO.getRoleId());
        return getCompanyRoleFuncMenuBO;

    }

    public static PersonRoleQuery companyRoleDelReqDTOToPersonRoleQuery(CompanyRoleDelReqDTO companyRoleDelReqDTO) {
        PersonRoleQuery personRoleQuery = new PersonRoleQuery();
        personRoleQuery.setCompId(companyRoleDelReqDTO.getLoginCompId());
        personRoleQuery.setRoleId(companyRoleDelReqDTO.getRoleId());
        return personRoleQuery;
    }

    public static CompanyRoleBO companyRoleDelReqDTOToCompanyRoleBO(CompanyRoleDelReqDTO companyRoleDelReqDTO) {
        CompanyRoleBO companyRoleBO = new CompanyRoleBO();
        companyRoleBO.setRoleId(companyRoleDelReqDTO.getRoleId());
        companyRoleBO.setUpdatedAt(companyRoleDelReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(companyRoleDelReqDTO.getUpdateTime()));
        companyRoleBO.setUpdatedPersonId(companyRoleDelReqDTO.getLoginPersonId());
        return companyRoleBO;
    }

    public static CompanyRoleAddRoleMenuBO companyRoleMenuQueryReqDTOToCompanyRoleAddRoleMenuBO(CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO) {
        CompanyRoleAddRoleMenuBO companyRoleAddRoleMenuBO = new CompanyRoleAddRoleMenuBO();
        companyRoleAddRoleMenuBO.setIsDeleted(0);
        return companyRoleAddRoleMenuBO;
    }

    public static List<Long> companyRoleListQueryReqDTOToCompId(CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO) {
        List<Long> compIds = new ArrayList<>();
        compIds.add(companyRoleListQueryReqDTO.getLoginCompId());
       return compIds;
    }

    public static CompanyInfoByCompIdQuery companyRoleUpdateReqDTOToCompanyInfoByCompIdQuery(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery=new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(companyRoleUpdateReqDTO.getLoginCompId().intValue());
        return companyInfoByCompIdQuery;
    }
    public static List<Long> reqDTOToModel(AppRoleListQueryByDiffPowerReqDTO reqDTO) {
        List<Long> compIds = new ArrayList<>();
        compIds.add(reqDTO.getLoginCompId());
        return compIds;
    }

    public static QueryCompanyRolePageBO reqDTOToQueryCompanyRolePageBO(AppRoleListQueryByDiffPowerReqDTO reqDTO) {
        QueryCompanyRolePageBO queryCompanyRolePageBO = new QueryCompanyRolePageBO();
        queryCompanyRolePageBO.setLimit(null);
        queryCompanyRolePageBO.setOffset(null);
        queryCompanyRolePageBO.setCreatedPersonId(reqDTO.getLoginPersonId());
        queryCompanyRolePageBO.setCompId(reqDTO.getLoginCompId().intValue());
        return queryCompanyRolePageBO;
    }

    public static List<AppRoleListQueryByDiffPowerRespDTO> modelToRespDTO(List<CompanyRoleBO> findSysCompanyRoleList, List<CompanyRoleModel> roleList) {
        List<AppRoleListQueryByDiffPowerRespDTO> companyRoleListQueryListRespDTO = new ArrayList<>();
        AppRoleListQueryByDiffPowerRespDTO companyRoleListQueryListRespDTO1 = new AppRoleListQueryByDiffPowerRespDTO();
        for (CompanyRoleBO companyRoleBO : findSysCompanyRoleList) {
            companyRoleListQueryListRespDTO1.setRoleId(companyRoleBO.getRoleId());
            companyRoleListQueryListRespDTO1.setRoleName(companyRoleBO.getRoleName());
            companyRoleListQueryListRespDTO1.setIsHide(companyRoleBO.getIsHide());
            companyRoleListQueryListRespDTO1.setRoleNo(companyRoleBO.getRoleNo());
            companyRoleListQueryListRespDTO1.setRoleMemo(companyRoleBO.getRoleMemo());
            companyRoleListQueryListRespDTO.add(companyRoleListQueryListRespDTO1);
        }
        for (CompanyRoleModel companyRoleModel : roleList) {
            companyRoleListQueryListRespDTO1.setRoleId(companyRoleModel.getDO().getRoleId());
            companyRoleListQueryListRespDTO1.setRoleName(companyRoleModel.getDO().getRoleName());
            companyRoleListQueryListRespDTO1.setIsHide(companyRoleModel.getDO().getIsHide());
            companyRoleListQueryListRespDTO1.setRoleNo(companyRoleModel.getDO().getRoleNo());
            companyRoleListQueryListRespDTO1.setRoleMemo(companyRoleModel.getDO().getRoleMemo());
            companyRoleListQueryListRespDTO.add(companyRoleListQueryListRespDTO1);
        }
        return companyRoleListQueryListRespDTO;
    }

    public static PersonInfoByPersonIdQuery reqToPersonInfoRespDTO(AppRoleListQueryByDiffPowerReqDTO reqDTO) {
        PersonInfoByPersonIdQuery personInfoByPersonIdQuery=new PersonInfoByPersonIdQuery();
        personInfoByPersonIdQuery.setPersonId(reqDTO.getLoginPersonId());
        personInfoByPersonIdQuery.setComId(reqDTO.getLoginCompId());
        personInfoByPersonIdQuery.setDeletedFlag(0);
        return personInfoByPersonIdQuery;
    }

    public static QueryCompanyRolePageBO reqToQueryCompanyRolePageBO(AppRoleListQueryByDiffPowerReqDTO reqDTO) {
        QueryCompanyRolePageBO queryCompanyRolePageBO=new QueryCompanyRolePageBO();
        queryCompanyRolePageBO.setRoleName(reqDTO.getRoleName());
        queryCompanyRolePageBO.setCompId(reqDTO.getLoginCompId().intValue());
        return queryCompanyRolePageBO;
    }

    public static List<AppRoleListQueryByDiffPowerRespDTO> modelToAppRoleListQueryByDiffPowerRespDTO(List<SysCompanyRoleModel> sysCompanyRoleModelList, List<CompanyRoleModel> companyRoleModelsList) {
        List<AppRoleListQueryByDiffPowerRespDTO> appRoleListQueryByDiffPowerRespDTOList=new ArrayList<>();
            for (SysCompanyRoleModel sysCompanyRoleModel:sysCompanyRoleModelList){
                AppRoleListQueryByDiffPowerRespDTO appRoleListQueryByDiffPowerRespDTO=new AppRoleListQueryByDiffPowerRespDTO();
                appRoleListQueryByDiffPowerRespDTO.setIsHide(sysCompanyRoleModel.getDO().getIsHide());
                appRoleListQueryByDiffPowerRespDTO.setRoleId(sysCompanyRoleModel.getDO().getRoleId());
                appRoleListQueryByDiffPowerRespDTO.setRoleMemo(sysCompanyRoleModel.getDO().getRoleMemo());
                appRoleListQueryByDiffPowerRespDTO.setRoleName(sysCompanyRoleModel.getDO().getRoleName());
                appRoleListQueryByDiffPowerRespDTO.setRoleNo(sysCompanyRoleModel.getDO().getRoleNo());
                appRoleListQueryByDiffPowerRespDTOList.add(appRoleListQueryByDiffPowerRespDTO);
            }
            for (CompanyRoleModel sysCompanyRoleModel:companyRoleModelsList){
                AppRoleListQueryByDiffPowerRespDTO appRoleListQueryByDiffPowerRespDTO=new AppRoleListQueryByDiffPowerRespDTO();
                appRoleListQueryByDiffPowerRespDTOList.add(appRoleListQueryByDiffPowerRespDTO);
                appRoleListQueryByDiffPowerRespDTO.setIsHide(sysCompanyRoleModel.getDO().getIsHide());
                appRoleListQueryByDiffPowerRespDTO.setRoleId(sysCompanyRoleModel.getDO().getRoleId());
                appRoleListQueryByDiffPowerRespDTO.setRoleMemo(sysCompanyRoleModel.getDO().getRoleMemo());
                appRoleListQueryByDiffPowerRespDTO.setRoleName(sysCompanyRoleModel.getDO().getRoleName());
                appRoleListQueryByDiffPowerRespDTO.setRoleNo(sysCompanyRoleModel.getDO().getRoleNo());
                appRoleListQueryByDiffPowerRespDTOList.add(appRoleListQueryByDiffPowerRespDTO);
            }
        return appRoleListQueryByDiffPowerRespDTOList;
    }

    public static CompanyRoleInfoQueryReqDTO sysCompanyRoleToCompanyRoleInfoQueryReqDTO(SysCompanyRole sysCompanyRole,SysCompanyRoleBO sysCompanyRoleBO) {
        CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO=new CompanyRoleInfoQueryReqDTO();
        companyRoleInfoQueryReqDTO.setRoleId(sysCompanyRole.getRoleId());
        companyRoleInfoQueryReqDTO.setLoginCompId(sysCompanyRoleBO.getCompId().longValue());
        companyRoleInfoQueryReqDTO.setLoginPersonId(sysCompanyRoleBO.getUserId().longValue());
        return companyRoleInfoQueryReqDTO;
    }
}