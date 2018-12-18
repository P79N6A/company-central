package com.ihappy.role.domain.model.factory.sys;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.role.domain.bo.SysCompanyFuncBO;
import com.ihappy.role.domain.bo.SysCompanyFuncByCtIdQuery;
import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysCompanyFuncFactory {

    public static List<PrivilegeAllRespDTO> modelListToSysCompanyFuncListQueryRespDTO(List<SysCompanyFuncModel> models) {
        List<PrivilegeAllRespDTO> result = new ArrayList<>();
        for (SysCompanyFuncModel obj : models) {
            PrivilegeAllRespDTO respDTO = new PrivilegeAllRespDTO();
            respDTO.setCtFuncId(obj.getDO().getCtFuncId());
            respDTO.setCtDepth(obj.getDO().getCtDepth());
            respDTO.setCtFuncLink(obj.getDO().getCtFuncLink());
            respDTO.setCtFuncName(obj.getDO().getCtFuncName());
            respDTO.setCtFuncNo(obj.getDO().getCtFuncNo());
            respDTO.setCtId(obj.getDO().getCtId());
            respDTO.setCtSort(obj.getDO().getCtSort());
            respDTO.setParentCtFuncId(obj.getDO().getParentCtFuncId());
            respDTO.setSourceCodes(obj.getDO().getSourceCodes());
            respDTO.setCanlistNoright(obj.getDO().getCanlistNoright());
            respDTO.setCtFuncIco(obj.getDO().getCtFuncIco());
            respDTO.setClId(obj.getDO().getClId());
            respDTO.setCtMemo(obj.getDO().getCtMemo());
            respDTO.setFuncType(obj.getDO().getFuncType());
            respDTO.setStatus(obj.getDO().getStatus());
            result.add(respDTO);
        }
        return result;
    }

    public static SysCompanyFuncBO sysFuncMenuApplyTypeMenuListQueryReqDTOToSysCompanyFuncBO(SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setIsDeleted(0);
        sysCompanyFuncBO.setCtId(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.getCtId());
        sysCompanyFuncBO.setClId(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.getClId());
        sysCompanyFuncBO.setName(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.getName());
        return sysCompanyFuncBO;
    }
    public static SysCompanyFuncBO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTOToSysCompanyFuncBO(SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setIsDeleted(0);
        sysCompanyFuncBO.setCtFuncId(sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO.getCtFuncId());
        return sysCompanyFuncBO;
    }

    public static SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO sysCompanyFuncModelToSysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO(SysCompanyFuncModel sysCompanyFuncModel) {
        SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO = new SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO();
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setCtFuncId(sysCompanyFuncModel.getDO().getCtFuncId());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setCtFuncLink(sysCompanyFuncModel.getDO().getCtFuncLink());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setCtFuncName(sysCompanyFuncModel.getDO().getCtFuncName());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setCtFuncNo(sysCompanyFuncModel.getDO().getCtFuncNo());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setCtMemo(sysCompanyFuncModel.getDO().getCtMemo());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setCtSort(sysCompanyFuncModel.getDO().getCtSort());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setFuncType(sysCompanyFuncModel.getDO().getFuncType());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setParentCtFuncId(sysCompanyFuncModel.getDO().getParentCtFuncId());
        sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO.setSourceCodes(sysCompanyFuncModel.getDO().getSourceCodes());
        return sysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO;
    }

    public static SysCompanyFuncBO sysCompanyFuncMenuApplyTypeMenuAddReqDTOToSysCompanyFuncBO(SysCompanyFuncMenuApplyTypeMenuAddReqDTO sysCompanyFuncMenuApplyTypeMenuAddReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setCtFuncId(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtFuncId());
        sysCompanyFuncBO.setClId(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getClId());
        sysCompanyFuncBO.setCtId(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtId());
        sysCompanyFuncBO.setCtFuncName(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtFuncName());
        sysCompanyFuncBO.setCtFuncLink(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtFuncLink());
        sysCompanyFuncBO.setCtFuncNo(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtFuncNo());
        sysCompanyFuncBO.setFuncType(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getFuncType());
        sysCompanyFuncBO.setParentCtFuncId(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getParentCtFuncId());
        sysCompanyFuncBO.setSourceCodes(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getSourceCodes());
        sysCompanyFuncBO.setCtMemo(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtMemo());
        sysCompanyFuncBO.setCtSort(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCtSort());
        sysCompanyFuncBO.setParentCtFuncName(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getParentCtFuncName());
        sysCompanyFuncBO.setCreatedAt(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCreateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCreateTime()));
        sysCompanyFuncBO.setCreatedPersonId(sysCompanyFuncMenuApplyTypeMenuAddReqDTO.getCreateId());
        return sysCompanyFuncBO;
    }

    public static SysCompanyFuncBO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTOToSysCompanyFuncBO(SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setCtFuncId(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtFuncId());
        sysCompanyFuncBO.setClId(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getClId());
        sysCompanyFuncBO.setCtFuncLink(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtFuncLink());
        sysCompanyFuncBO.setCtFuncName(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtFuncName());
        sysCompanyFuncBO.setCtFuncNo(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtFuncNo());
        sysCompanyFuncBO.setCtId(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtId());
        sysCompanyFuncBO.setCtMemo(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtMemo());
        sysCompanyFuncBO.setCtSort(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getCtSort());
        sysCompanyFuncBO.setFuncType(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getFuncType());
        sysCompanyFuncBO.setParentCtFuncId(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getParentCtFuncId());
        sysCompanyFuncBO.setParentCtFuncName(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getParentCtFuncName());
        sysCompanyFuncBO.setSourceCodes(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getSourceCodes());
        sysCompanyFuncBO.setUpdatedAt(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getUpdateTime()));
        sysCompanyFuncBO.setUpdatedPersonId(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.getUpdateId());
        return sysCompanyFuncBO;
    }

    public static SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO sysCompanyFuncMenuApplyTypeMenuListQueryRespDTOToSysCompanyFuncModel(SysCompanyFuncModel sysCompanyFuncModel) {

        SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO = new SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO();
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setCtFuncId(sysCompanyFuncModel.getDO().getCtFuncId());
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setCtFuncName(sysCompanyFuncModel.getDO().getCtFuncName());
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setCtFuncNo(sysCompanyFuncModel.getDO().getCtFuncNo());
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setFuncType(sysCompanyFuncModel.getDO().getFuncType());
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setParentCtFuncId(sysCompanyFuncModel.getDO().getParentCtFuncId());

        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setId(sysCompanyFuncModel.getDO().getCtFuncId());
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setSort(sysCompanyFuncModel.getDO().getCtSort());
        sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO.setParentId(Long.parseLong(sysCompanyFuncModel.getDO().getParentCtFuncId()+""));

        return sysCompanyFuncMenuApplyTypeMenuListQueryRespDTO;
    }

    public static SysCompanyFuncBO sysCompanyFuncMenuApplyTypeMenuDelReqDTOToSysCompanyFuncBO(SysCompanyFuncMenuApplyTypeMenuDelReqDTO sysCompanyFuncMenuApplyTypeMenuDelReqDTO) {
        SysCompanyFuncBO sysCompanyFuncBO = new SysCompanyFuncBO();
        sysCompanyFuncBO.setIsDeleted(0);
        sysCompanyFuncBO.setCtFuncId(sysCompanyFuncMenuApplyTypeMenuDelReqDTO.getCtFuncId());
        sysCompanyFuncBO.setUpdatedAt(sysCompanyFuncMenuApplyTypeMenuDelReqDTO.getUpdateTime() == null?CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysCompanyFuncMenuApplyTypeMenuDelReqDTO.getUpdateTime()));
        sysCompanyFuncBO.setUpdatedPersonId(sysCompanyFuncMenuApplyTypeMenuDelReqDTO.getUpdateId());
        return sysCompanyFuncBO;
    }

    public static SysCompanyFuncByCtIdQuery sysCompanyFuncListQuryReqDTOToSysCompanyFuncByCtIdQuery(SysCompanyFuncListQueryReqDTO sysCompanyFuncListQuryReqDTO) {
        SysCompanyFuncByCtIdQuery sysCompanyFuncByCtIdQuery=new SysCompanyFuncByCtIdQuery();
        sysCompanyFuncByCtIdQuery.setClientId(sysCompanyFuncListQuryReqDTO.getClientId());
        sysCompanyFuncByCtIdQuery.setCtId(sysCompanyFuncListQuryReqDTO.getCtId());
        return sysCompanyFuncByCtIdQuery;
    }
}