package com.ihappy.role.domain.model.factory.sys;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.role.domain.bo.SysFuncBO;
import com.ihappy.role.domain.bo.SysFuncListBO;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuListQueryRespDTO;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/16.
 */
public class SysFuncFactory {

    public static PrivilegeAllRespDTO toPrivilegeAllRespDTO(SysFuncModel obj) {
        PrivilegeAllRespDTO respDTO = new PrivilegeAllRespDTO();
        respDTO.setCtFuncId(obj.getDO().getCtFuncId());
        respDTO.setCtDepth(obj.getDO().getCtDepth());
        respDTO.setCtFuncLink(obj.getDO().getCtFuncLink());
        respDTO.setCtFuncName(obj.getDO().getCtFuncName());
        respDTO.setCtFuncNo(obj.getDO().getCtFuncNo());
        respDTO.setCtSort(obj.getDO().getCtSort());
        respDTO.setParentCtFuncId(obj.getDO().getParentCtFuncId());
        respDTO.setSourceCodes(obj.getDO().getSourceCodes());
        respDTO.setCanlistNoright(obj.getDO().getCanlistNoright());
        respDTO.setCtFuncIco(obj.getDO().getCtFuncIco());
        respDTO.setClId(obj.getDO().getClId());
        respDTO.setCtMemo(obj.getDO().getCtMemo());
        respDTO.setFuncType(obj.getDO().getFuncType());
        respDTO.setStatus(obj.getDO().getStatus());
        return respDTO;
    }

    public static SysFuncBO sysFuncMenuBackstageMenuInfoDelReqDTOToSysFuncBO(SysFuncMenuBackstageMenuInfoDelReqDTO sysFuncMenuBackstageMenuInfoDelReqDTO) {
        SysFuncBO sysFuncBO = new SysFuncBO();
        sysFuncBO.setIsDeleted(0);
        sysFuncBO.setCtFuncId(sysFuncMenuBackstageMenuInfoDelReqDTO.getCtFuncId());
        sysFuncBO.setUpdatedAt(sysFuncMenuBackstageMenuInfoDelReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysFuncMenuBackstageMenuInfoDelReqDTO.getUpdateTime()));
        sysFuncBO.setUpdatedPersonId(sysFuncMenuBackstageMenuInfoDelReqDTO.getUpdateId());
        return sysFuncBO;
    }

    public static SysFuncBO sysFuncMenuBackstageMenuAddReqDTOToSysFuncBO(SysFuncMenuBackstageMenuAddReqDTO sysFuncMenuBackstageMenuAddReqDTO) {
        SysFuncBO sysFuncBO = new SysFuncBO();
        sysFuncBO.setCtFuncId(sysFuncMenuBackstageMenuAddReqDTO.getCtFuncId());
        sysFuncBO.setFuncType(sysFuncMenuBackstageMenuAddReqDTO.getFuncType());
        sysFuncBO.setCtFuncName(sysFuncMenuBackstageMenuAddReqDTO.getCtFuncName());
        sysFuncBO.setCtFuncNo(sysFuncMenuBackstageMenuAddReqDTO.getCtFuncNo());
        sysFuncBO.setParentCtFuncId(sysFuncMenuBackstageMenuAddReqDTO.getParentCtFuncId());
        sysFuncBO.setSourceCodes(sysFuncMenuBackstageMenuAddReqDTO.getSourceCodes());
        sysFuncBO.setCtFuncLink(sysFuncMenuBackstageMenuAddReqDTO.getCtFuncLink());
        sysFuncBO.setCtSort(sysFuncMenuBackstageMenuAddReqDTO.getCtSort());
        sysFuncBO.setCtMemo(sysFuncMenuBackstageMenuAddReqDTO.getCtMemo());
        sysFuncBO.setCreatedAt(sysFuncMenuBackstageMenuAddReqDTO.getCreateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysFuncMenuBackstageMenuAddReqDTO.getCreateTime()));
        sysFuncBO.setCreatedPersonId(sysFuncMenuBackstageMenuAddReqDTO.getCreateId());
        return sysFuncBO;
    }

    public static SysFuncBO sysFuncMenuBackstageMenuInfoQueryReqDTOToSysFuncBO(SysFuncMenuBackstageMenuInfoQueryReqDTO sysFuncMenuBackstageMenuInfoQueryReqDTO) {
        SysFuncBO sysFuncBO = new SysFuncBO();
        sysFuncBO.setCtFuncId(sysFuncMenuBackstageMenuInfoQueryReqDTO.getCtFuncId());
        sysFuncBO.setIsDeleted(0);
        return sysFuncBO;

    }

    public static SysFuncMenuBackstageMenuInfoQueryRespDTO sysFuncModelToSysFuncMenuBackstageMenuInfoQueryRespDTO(SysFuncModel sysFuncModel) {
        SysFuncMenuBackstageMenuInfoQueryRespDTO sysFuncMenuBackstageMenuInfoQueryRespDTO = new SysFuncMenuBackstageMenuInfoQueryRespDTO();
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setCtFuncId(sysFuncModel.getDO().getCtFuncId());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setCtFuncName(sysFuncModel.getDO().getCtFuncName());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setCtFuncLink(sysFuncModel.getDO().getCtFuncLink());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setCtFuncNo(sysFuncModel.getDO().getCtFuncNo());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setCtSort(sysFuncModel.getDO().getCtSort());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setCtMemo(sysFuncModel.getDO().getCtMemo());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setFuncType(sysFuncModel.getDO().getFuncType());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setParentCtFuncId(sysFuncModel.getDO().getParentCtFuncId());
        sysFuncMenuBackstageMenuInfoQueryRespDTO.setSourceCodes(sysFuncModel.getDO().getSourceCodes());
        return sysFuncMenuBackstageMenuInfoQueryRespDTO;
    }

    public static SysFuncBO sysFuncMenuBackstageMenuUptateReqDTOToSysFuncBO(SysFuncMenuBackstageMenuUptateReqDTO sysFuncMenuBackstageMenuUptateReqDTO) {
        SysFuncBO sysFuncBO = new SysFuncBO();
        sysFuncBO.setCtFuncId(sysFuncMenuBackstageMenuUptateReqDTO.getCtFuncId());
        sysFuncBO.setCtFuncName(sysFuncMenuBackstageMenuUptateReqDTO.getCtFuncName());
        sysFuncBO.setCtFuncLink(sysFuncMenuBackstageMenuUptateReqDTO.getCtFuncLink());
        sysFuncBO.setCtFuncNo(sysFuncMenuBackstageMenuUptateReqDTO.getCtFuncNo());
        sysFuncBO.setParentCtFuncId(sysFuncMenuBackstageMenuUptateReqDTO.getParentCtFuncId());
        sysFuncBO.setCtSort(sysFuncMenuBackstageMenuUptateReqDTO.getCtSort());
        sysFuncBO.setCtMemo(sysFuncMenuBackstageMenuUptateReqDTO.getCtMemo());
        sysFuncBO.setSourceCodes(sysFuncMenuBackstageMenuUptateReqDTO.getSourceCodes());
        sysFuncBO.setFuncType(sysFuncMenuBackstageMenuUptateReqDTO.getFuncType());
        sysFuncBO.setUpdatedAt(sysFuncMenuBackstageMenuUptateReqDTO.getUpdateTime() == null ? CompanyDateUtil.getDate14Long(new Date()):CompanyDateUtil.getDate14Long(sysFuncMenuBackstageMenuUptateReqDTO.getUpdateTime()));
        sysFuncBO.setUpdatedPersonId(sysFuncMenuBackstageMenuUptateReqDTO.getUpdateId());
        return sysFuncBO;
    }

    public static SysFuncMenuBackstageMenuListQueryRespDTO sysFuncMenuBackstageMenuListQueryRespDTOTosysFuncModel(SysFuncModel sysFuncModel) {
        SysFuncMenuBackstageMenuListQueryRespDTO sysFuncMenuBackstageMenuListQueryRespDTO = new SysFuncMenuBackstageMenuListQueryRespDTO();
        sysFuncMenuBackstageMenuListQueryRespDTO.setCtFuncId(sysFuncModel.getDO().getCtFuncId());
        sysFuncMenuBackstageMenuListQueryRespDTO.setCtFuncName(sysFuncModel.getDO().getCtFuncName());
        sysFuncMenuBackstageMenuListQueryRespDTO.setCtFuncNo(sysFuncModel.getDO().getCtFuncNo());
        sysFuncMenuBackstageMenuListQueryRespDTO.setFuncType(sysFuncModel.getDO().getFuncType());
        sysFuncMenuBackstageMenuListQueryRespDTO.setParentCtFuncId(sysFuncModel.getDO().getParentCtFuncId());

        sysFuncMenuBackstageMenuListQueryRespDTO.setId(sysFuncModel.getDO().getCtFuncId());
        sysFuncMenuBackstageMenuListQueryRespDTO.setSort(sysFuncModel.getDO().getCtSort());
        sysFuncMenuBackstageMenuListQueryRespDTO.setParentId(Long.valueOf(sysFuncModel.getDO().getParentCtFuncId()+""));
        return sysFuncMenuBackstageMenuListQueryRespDTO;
    }
    public static SysFuncListBO sysFuncMenuBackstageMenuListQueryReqDTOToSysFuncListBO(SysFuncMenuBackstageMenuListQueryReqDTO sysFuncMenuBackstageMenuListQueryReqDTO) {
        SysFuncListBO sysFuncListBO = new SysFuncListBO();
        sysFuncListBO.setIsDeleted(0);
        return sysFuncListBO;
    }
}
