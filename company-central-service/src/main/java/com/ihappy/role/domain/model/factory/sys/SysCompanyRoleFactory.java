package com.ihappy.role.domain.model.factory.sys;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.role.domain.bo.SysCompanyFuncBO;
import com.ihappy.role.domain.bo.SysCompanyRoleBO;
import com.ihappy.role.domain.bo.SysCompanyRoleConfigBO;
import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.RoleRightsMenuListQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyRoleListQueryRespDTOList;
import com.ihappy.role.domain.dto.response.sys.*;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.user.domain.query.person.PersonRoleQuery;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
public class SysCompanyRoleFactory {
    public static List<SysCompanyRoleQueryRespDTO> modelListToRespDTOList(List<SysCompanyRoleModel> sysCompanyRoleModels) {
        List<SysCompanyRoleQueryRespDTO> list = new ArrayList<SysCompanyRoleQueryRespDTO>();
        for (SysCompanyRoleModel obj : sysCompanyRoleModels){
            SysCompanyRoleQueryRespDTO sysCompanyRoleQueryRespDTO = new SysCompanyRoleQueryRespDTO();
            BeanUtils.copyProperties(obj.getDO(), sysCompanyRoleQueryRespDTO);
            List<SysRoleRightsRespDTO> sysRoleRights = JSONArray.parseArray(obj.getDO().getRoleRights(), SysRoleRightsRespDTO.class);
            sysCompanyRoleQueryRespDTO.setSysRoleRights(sysRoleRights);
            list.add(sysCompanyRoleQueryRespDTO);
        }
        return list;
    }


    public static SysCompanyRoleConfigBO sysRoleConfigRoleListQueryReqDTOTOModel(SysCompanyRoleConfigRoleListQueryReqDTO sysCompanyRoleConfigRoleListQueryReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setLimit(sysCompanyRoleConfigRoleListQueryReqDTO.getLimit());
        sysCompanyRoleConfigBO.setOffset(sysCompanyRoleConfigRoleListQueryReqDTO.getOffset());
        sysCompanyRoleConfigBO.setKeyWords(sysCompanyRoleConfigRoleListQueryReqDTO.getKeyWords());
        return sysCompanyRoleConfigBO;
    }

    public static List<SysCompanyRoleConfigRoleListQueryRespDTO> toModelSysRoleConfigRoleListQueryRespDTO(List<SysCompanyRoleModel> models) {
        List<SysCompanyRoleConfigRoleListQueryRespDTO> sysCompanyRoleConfigRoleListQueryRespDTOS = new ArrayList<>();
        for (SysCompanyRoleModel sysCompanyRoleModel : models) {
            SysCompanyRoleConfigRoleListQueryRespDTO sysCompanyRoleConfigRoleListQueryRespDTO = new SysCompanyRoleConfigRoleListQueryRespDTO();
            sysCompanyRoleConfigRoleListQueryRespDTO.setRoleId(sysCompanyRoleModel.getDO().getRoleId());
            sysCompanyRoleConfigRoleListQueryRespDTO.setRoleName(sysCompanyRoleModel.getDO().getRoleName());
            sysCompanyRoleConfigRoleListQueryRespDTO.setRoleMemo(sysCompanyRoleModel.getDO().getRoleMemo());
            sysCompanyRoleConfigRoleListQueryRespDTOS.add(sysCompanyRoleConfigRoleListQueryRespDTO);
        }
        return sysCompanyRoleConfigRoleListQueryRespDTOS;
    }

    public static SysCompanyRoleConfigRoleListQueryRespDTO modelTOSysCompanyRoleConfigRoleListQueryRespDTO(SysCompanyRoleModel sysCompanyRoleModel) {
        SysCompanyRoleConfigRoleListQueryRespDTO sysCompanyRoleConfigRoleListQueryRespDTO = new SysCompanyRoleConfigRoleListQueryRespDTO();
        sysCompanyRoleConfigRoleListQueryRespDTO.setRoleId(sysCompanyRoleModel.getDO().getRoleId());
        sysCompanyRoleConfigRoleListQueryRespDTO.setRoleName(sysCompanyRoleModel.getDO().getRoleName());
        sysCompanyRoleConfigRoleListQueryRespDTO.setRoleMemo(sysCompanyRoleModel.getDO().getRoleMemo());
        return sysCompanyRoleConfigRoleListQueryRespDTO;
    }

    public static SysCompanyRoleConfigBO sysRoleConfigRoleInfoQueryReqDTOTOModel(SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleId(sysCompanyRoleConfigRoleInfoQueryReqDTO.getRoleId());
        return sysCompanyRoleConfigBO;
    }

    public static SysCompanyRoleConfigRoleInfoQueryRespDTO modelToSysRoleConfigRoleInfoQueryRespDTO(SysCompanyRoleModel sysCompanyRoleModel) {
        SysCompanyRoleConfigRoleInfoQueryRespDTO sysCompanyRoleConfigRoleInfoQueryRespDTO = new SysCompanyRoleConfigRoleInfoQueryRespDTO();
        sysCompanyRoleConfigRoleInfoQueryRespDTO.setRoleId(sysCompanyRoleModel.getDO().getRoleId());
        sysCompanyRoleConfigRoleInfoQueryRespDTO.setRoleName(sysCompanyRoleModel.getDO().getRoleName());
        sysCompanyRoleConfigRoleInfoQueryRespDTO.setRoleMemo(sysCompanyRoleModel.getDO().getRoleMemo());
        sysCompanyRoleConfigRoleInfoQueryRespDTO.setRoleRights(sysCompanyRoleModel.getDO().getRoleRights());
        return sysCompanyRoleConfigRoleInfoQueryRespDTO;
    }

    public static SysCompanyRoleConfigBO sysCompanyRoleConfigRoleInfoMenuReqDTOTOModel(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleId(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.getRoleId());
        return sysCompanyRoleConfigBO;
    }

    public static SysCompanyRoleConfigBO sysCompanyRoleConfigRoleInfoUpdateReqDTOTOModel(SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleId(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleId());
        sysCompanyRoleConfigBO.setRoleName(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleName());
        sysCompanyRoleConfigBO.setRoleMemo(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleMemo());
        sysCompanyRoleConfigBO.setRoleRights(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleRights());
        return sysCompanyRoleConfigBO;
    }

    public static SysCompanyRoleInfoTypeClientListQueryRespDTO modelTOSysCompanyRoleInfoTypeClientListQueryRespDTO(SysCompanyTypeModel sysCompanyTypeModel, SysClientModel sysClientModel) {
        SysCompanyRoleInfoTypeClientListQueryRespDTO sysCompanyRoleInfoTypeClientQueryRespDTO = new SysCompanyRoleInfoTypeClientListQueryRespDTO();
        String sysCompanyTypeName = sysCompanyTypeModel.getDO().getCtName() + "-" + sysClientModel.getDO().getClName();
        sysCompanyRoleInfoTypeClientQueryRespDTO.setClId(sysClientModel.getDO().getClId());
        sysCompanyRoleInfoTypeClientQueryRespDTO.setCtId(sysCompanyTypeModel.getDO().getCtId());
        sysCompanyRoleInfoTypeClientQueryRespDTO.setIsChecked(0);
        sysCompanyRoleInfoTypeClientQueryRespDTO.setName(sysCompanyTypeName);
        return sysCompanyRoleInfoTypeClientQueryRespDTO;
    }

    public static SysCompanyRoleConfigRoleInfoMenuRespDTO roleDtoToDto(SysCompanyFuncModel sysCompanyFuncModel) {
        SysCompanyRoleConfigRoleInfoMenuRespDTO sysCompanyRoleConfigRoleInfoMenuRespDTO = new SysCompanyRoleConfigRoleInfoMenuRespDTO();
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setIsChecked(0);
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setClId(sysCompanyFuncModel.getDO().getClId());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtDepth(sysCompanyFuncModel.getDO().getCtDepth());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtFuncId(sysCompanyFuncModel.getDO().getCtFuncId());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtFuncLink(sysCompanyFuncModel.getDO().getCtFuncLink());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtFuncName(sysCompanyFuncModel.getDO().getCtFuncName());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtFuncNo(sysCompanyFuncModel.getDO().getCtFuncNo());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtId(sysCompanyFuncModel.getDO().getCtId());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setCtSort(sysCompanyFuncModel.getDO().getCtSort());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setFuncType(sysCompanyFuncModel.getDO().getFuncType());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setParentCtFuncId(sysCompanyFuncModel.getDO().getParentCtFuncId());
        sysCompanyRoleConfigRoleInfoMenuRespDTO.setSourceCodes(sysCompanyFuncModel.getDO().getSourceCodes());
        return sysCompanyRoleConfigRoleInfoMenuRespDTO;
    }

    public static SysCompanyRoleAddTypeClientFuncListQueryRespDTO modelTOSysCompanyRoleAddTypeClientFuncListQueryRespDTO(SysCompanyFuncModel sysCompanyFuncModel) {
        SysCompanyRoleAddTypeClientFuncListQueryRespDTO sysCompanyRoleAddTypeClientFuncListQueryRespDTO = new SysCompanyRoleAddTypeClientFuncListQueryRespDTO();
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setClId(sysCompanyFuncModel.getDO().getClId());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setCtDepth(sysCompanyFuncModel.getDO().getCtDepth());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setCtFuncId(sysCompanyFuncModel.getDO().getCtFuncId());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setCtFuncLink(sysCompanyFuncModel.getDO().getCtFuncLink());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setCtFuncName(sysCompanyFuncModel.getDO().getCtFuncName());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setCtFuncNo(sysCompanyFuncModel.getDO().getCtFuncNo());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setCtSort(sysCompanyFuncModel.getDO().getCtSort());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setFuncType(sysCompanyFuncModel.getDO().getFuncType());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setIsChecked(0);
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setParentCtFuncId(sysCompanyFuncModel.getDO().getParentCtFuncId());
        sysCompanyRoleAddTypeClientFuncListQueryRespDTO.setSourceCodes(sysCompanyFuncModel.getDO().getSourceCodes());
        return sysCompanyRoleAddTypeClientFuncListQueryRespDTO;
    }

    public static SysCompanyRoleAddTypeClientListQueryRespDTO modelTOSysCompanyRoleAddTypeClientListQueryRespDTO(SysClientModel sysClientModel, SysCompanyTypeModel sysCompanyTypeModel) {
        SysCompanyRoleAddTypeClientListQueryRespDTO sysCompanyRoleAddTypeClientListQueryRespDTO = new SysCompanyRoleAddTypeClientListQueryRespDTO();
        String clId = String.valueOf(sysClientModel.getDO().getClId());
        String ctId = String.valueOf(sysCompanyTypeModel.getDO().getCtId());
        String clName = sysClientModel.getDO().getClName();
        String ctName = sysCompanyTypeModel.getDO().getCtName();
        String name = ctName + "-" + clName;
        sysCompanyRoleAddTypeClientListQueryRespDTO.setClId(Integer.valueOf(clId));
        sysCompanyRoleAddTypeClientListQueryRespDTO.setCtId(Integer.valueOf(ctId));
        sysCompanyRoleAddTypeClientListQueryRespDTO.setIsChecked(0);
        sysCompanyRoleAddTypeClientListQueryRespDTO.setName(name);
        return sysCompanyRoleAddTypeClientListQueryRespDTO;
    }

    public static SysCompanyRoleConfigBO sysCompanyRoleConfigRoleAddReqDTOToSysCompanyRoleConfigBO(SysCompanyRoleConfigRoleAddReqDTO sysCompanyRoleConfigRoleAddReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleName(sysCompanyRoleConfigRoleAddReqDTO.getRoleName());
        sysCompanyRoleConfigBO.setRoleMemo(sysCompanyRoleConfigRoleAddReqDTO.getRoleMemo());
        sysCompanyRoleConfigBO.setRoleRights(sysCompanyRoleConfigRoleAddReqDTO.getRoleRights());
        sysCompanyRoleConfigBO.setCreatedAt(sysCompanyRoleConfigRoleAddReqDTO.getCreateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysCompanyRoleConfigRoleAddReqDTO.getCreateTime()));
        sysCompanyRoleConfigBO.setCreatedPersonId(sysCompanyRoleConfigRoleAddReqDTO.getCreateId());
        return sysCompanyRoleConfigBO;
    }

    public static SysCompanyRoleConfigBO sysCompanyRoleConfigRoleDeleteReqDTOToSysCompanyRoleConfigBO(SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleId(sysCompanyRoleConfigRoleDeleteReqDTO.getRoleId());
        sysCompanyRoleConfigBO.setUpdatedAt(sysCompanyRoleConfigRoleDeleteReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysCompanyRoleConfigRoleDeleteReqDTO.getUpdateTime()));
        sysCompanyRoleConfigBO.setUpdatedPersonId(sysCompanyRoleConfigRoleDeleteReqDTO.getUpdateId());
        return sysCompanyRoleConfigBO;
    }

    public static SysCompanyRoleConfigBO sysCompanyRoleConfigRoleInfoUpdateReqDTOToSysCompanyRoleConfigBO(SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleId(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleId());
        sysCompanyRoleConfigBO.setRoleName(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleName());
        sysCompanyRoleConfigBO.setRoleMemo(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleMemo());

        sysCompanyRoleConfigBO.setUpdatedAt(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getUpdateTime() == null?CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getUpdateTime()));
        sysCompanyRoleConfigBO.setUpdatedPersonId(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getUpdateId());
        return sysCompanyRoleConfigBO;
    }

    public static SysCompanyFuncBO sysCompanyRoleAddTypeClientFuncListQueryReqDTOToSysCompanyFuncBO(SysCompanyRoleAddTypeClientFuncListQueryReqDTO sysCompanyRoleAddTypeClientFuncListQueryReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setIsDeleted(0);
        sysCompanyFuncBO.setClId(sysCompanyRoleAddTypeClientFuncListQueryReqDTO.getClId());
        sysCompanyFuncBO.setCtId(sysCompanyRoleAddTypeClientFuncListQueryReqDTO.getCtId());
        return sysCompanyFuncBO;
    }

    public static SysCompanyFuncBO sysCompanyRoleInfoTypeClientFuncListQueryReqDTOToSysCompanyFuncBO(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setIsDeleted(0);
        sysCompanyFuncBO.setClId(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.getClId());
        sysCompanyFuncBO.setCtId(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.getCtId());
        return sysCompanyFuncBO;

    }

    public static List<SysCompanyRoleListQueryRespDTOList> sysCompanyRoleModelToSysCompanyRoleListQueryRespDTO(List<SysCompanyRoleModel> sysCompanyRoleList) {
        List<SysCompanyRoleListQueryRespDTOList> list = new ArrayList<>();
        for (SysCompanyRoleModel sysCompanyRoleModel : sysCompanyRoleList) {
            SysCompanyRoleListQueryRespDTOList sysCompanyRoleListQueryRespDTO = new SysCompanyRoleListQueryRespDTOList();
            sysCompanyRoleListQueryRespDTO.setSysRoleId(sysCompanyRoleModel.getDO().getRoleId());
            sysCompanyRoleListQueryRespDTO.setSysRoleName(sysCompanyRoleModel.getDO().getRoleName());
            list.add(sysCompanyRoleListQueryRespDTO);
        }
        return list;
    }

    public static SysCompanyRoleBO companyRoleDelReqDTODTOToSysCompanyRoleBO(CompanyRoleDelReqDTO companyRoleDelReqDTO) {
        SysCompanyRoleBO sysCompanyRoleBO = new SysCompanyRoleBO();
        sysCompanyRoleBO.setIsDeleted(0);
        sysCompanyRoleBO.setRoleId(companyRoleDelReqDTO.getRoleId());
        return sysCompanyRoleBO;
    }

    public static SysCompanyRoleBO companyRoleUpdateReqDTOToSysCompanyRoleBO(CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO) {
        SysCompanyRoleBO sysCompanyRoleBO = new SysCompanyRoleBO();
        sysCompanyRoleBO.setIsDeleted(0);
        sysCompanyRoleBO.setRoleId(companyRoleUpdateReqDTO.getRoleId());
        return sysCompanyRoleBO;
    }


    public static SysCompanyRoleBO companyRoleInfoQueryReqDTOTosysCompanyRoleBO(CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO) {
        SysCompanyRoleBO sysCompanyRoleBO = new SysCompanyRoleBO();
        sysCompanyRoleBO.setIsDeleted(0);
        sysCompanyRoleBO.setRoleId(companyRoleInfoQueryReqDTO.getRoleId());
        return sysCompanyRoleBO;
    }

    public static CompanyRoleInfoQueryRespDTO modelTCompanyRoleQueryRespDTO(SysCompanyRoleModel sysCompanyRoleInfo) {
        CompanyRoleInfoQueryRespDTO companyRoleInfoQueryRespDTO = new CompanyRoleInfoQueryRespDTO();
        companyRoleInfoQueryRespDTO.setRoleId(sysCompanyRoleInfo.getDO().getRoleId());
        companyRoleInfoQueryRespDTO.setRoleNo(sysCompanyRoleInfo.getDO().getRoleNo());
        companyRoleInfoQueryRespDTO.setRoleName(sysCompanyRoleInfo.getDO().getRoleName());
        companyRoleInfoQueryRespDTO.setRoleMemo(sysCompanyRoleInfo.getDO().getRoleMemo());
        companyRoleInfoQueryRespDTO.setIsHide(sysCompanyRoleInfo.getDO().getIsHide());
        return companyRoleInfoQueryRespDTO;
    }

    public static RoleRightsMenuListQueryRespDTO privilegeAllRespDtoToRoleRightsMenuListQueryRespDTO(PrivilegeAllRespDTO privilegeAllRespDTO) {
        RoleRightsMenuListQueryRespDTO roleRightsMenuListQueryRespDTO = new RoleRightsMenuListQueryRespDTO();
        roleRightsMenuListQueryRespDTO.setClId(privilegeAllRespDTO.getClId());
        roleRightsMenuListQueryRespDTO.setCtDepth(privilegeAllRespDTO.getCtDepth());
        roleRightsMenuListQueryRespDTO.setCtFuncId(privilegeAllRespDTO.getCtFuncId());
        roleRightsMenuListQueryRespDTO.setCtFuncLink(privilegeAllRespDTO.getCtFuncLink());
        roleRightsMenuListQueryRespDTO.setCtFuncName(privilegeAllRespDTO.getCtFuncName());
        roleRightsMenuListQueryRespDTO.setCtFuncNo(privilegeAllRespDTO.getCtFuncNo());
        roleRightsMenuListQueryRespDTO.setCtId(privilegeAllRespDTO.getCtId());
        roleRightsMenuListQueryRespDTO.setCtMemo(privilegeAllRespDTO.getCtMemo());
        roleRightsMenuListQueryRespDTO.setCtSort(privilegeAllRespDTO.getCtSort());
        roleRightsMenuListQueryRespDTO.setFuncType(Long.valueOf(privilegeAllRespDTO.getFuncType()));
        roleRightsMenuListQueryRespDTO.setIsChecked(0);
        roleRightsMenuListQueryRespDTO.setParentCtFuncId(privilegeAllRespDTO.getParentCtFuncId());
        roleRightsMenuListQueryRespDTO.setSourceCodes(privilegeAllRespDTO.getSourceCodes());

        roleRightsMenuListQueryRespDTO.setParentId(Long.parseLong(privilegeAllRespDTO.getParentCtFuncId() + ""));
        roleRightsMenuListQueryRespDTO.setSort(privilegeAllRespDTO.getCtSort());
        roleRightsMenuListQueryRespDTO.setId(privilegeAllRespDTO.getCtFuncId());
        return roleRightsMenuListQueryRespDTO;
    }

    public static SysCompanyRoleConfigBO sysCompanyRoleInfoTypeClientListQueryReqDTOToSysCompanyRoleConfigBO(SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO) {
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO=new SysCompanyRoleConfigBO();
        sysCompanyRoleConfigBO.setRoleId(sysCompanyRoleInfoTypeClientListQueryReqDTO.getRoleId());
        return sysCompanyRoleConfigBO;
    }

    public static PersonRoleQuery sysCompanyRoleConfigRoleDeleteReqDTOToPersonRoleQuery(SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO) {
        PersonRoleQuery personRoleQuery=new PersonRoleQuery();
        personRoleQuery.setCompId(-1L);
        personRoleQuery.setRoleId(sysCompanyRoleConfigRoleDeleteReqDTO.getRoleId());
        return personRoleQuery;

    }

    public static SysCompanyFuncBO companyRoleMenuQueryReqDTOToBO(CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO) {

        SysCompanyFuncBO funcBO = new SysCompanyFuncBO();
        funcBO.setClId(Integer.parseInt(companyRoleMenuQueryReqDTO.getLoginClId()));
        funcBO.setCtId(Integer.parseInt(companyRoleMenuQueryReqDTO.getLoginCtId()));
        funcBO.setIsDeleted(0);

        return funcBO;
    }

    public static SysCompanyRoleBO reqToSysCompanyRoleBO(AppRoleListQueryByDiffPowerReqDTO reqDTO) {
        SysCompanyRoleBO sysCompanyRoleBO=new SysCompanyRoleBO();
        sysCompanyRoleBO.setCompId(reqDTO.getLoginCompId().intValue());
        sysCompanyRoleBO.setRoleName(reqDTO.getRoleName());
        sysCompanyRoleBO.setUserId(reqDTO.getLoginPersonId().intValue());
        return sysCompanyRoleBO;
    }

    public static SysCompanyFuncBO sysCompanyRoleBOTosysCompanyFuncBO(CompanyModel companyModel) {
        SysCompanyFuncBO sysCompanyFuncBO=new SysCompanyFuncBO();
        sysCompanyFuncBO.setClId(2);
        sysCompanyFuncBO.setCtId(Integer.valueOf(companyModel.getDO().getCtIds()));
        sysCompanyFuncBO.setIsDeleted(0);
        return sysCompanyFuncBO;
    }
}
