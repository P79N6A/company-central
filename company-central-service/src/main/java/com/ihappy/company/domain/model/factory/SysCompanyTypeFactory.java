package com.ihappy.company.domain.model.factory;

import com.ihappy.company.domain.bo.SysCompanyTypeBO;
import com.ihappy.company.domain.dbdo.SysCompanyType;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleAddTypeClientListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleInfoTypeClientFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleInfoTypeClientListQueryReqDTO;

/**
 * Created by liuhc on 2018/5/16.
 */
public class SysCompanyTypeFactory {


    public static SysCompanyTypeInfoRespDTO toSysCompanyTypeInfoRespDTO(SysCompanyType sysCompanyType) {

        SysCompanyTypeInfoRespDTO sysCompanyTypeInfoRespDTO = new SysCompanyTypeInfoRespDTO();

        sysCompanyTypeInfoRespDTO.setCtId(sysCompanyType.getCtId());
        sysCompanyTypeInfoRespDTO.setCtName(sysCompanyType.getCtName());
        sysCompanyTypeInfoRespDTO.setCtMemo(sysCompanyType.getCtMemo());

        return sysCompanyTypeInfoRespDTO;
    }

    public static SysCompanyTypeBO sysCompanyRoleInfoTypeClientFuncListQueryReqDTOToSysCompanyTypeBO2(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO) {
        SysCompanyTypeBO sysCompanyTypeBO = new SysCompanyTypeBO();
        sysCompanyTypeBO.setIsDeleted(0);
        sysCompanyTypeBO.setCtId(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.getCtId());
        return sysCompanyTypeBO;
    }

    public static SysCompanyTypeBO sysFuncMenuApplyTypeListQueryReqDTOToSysCompanyTypeBO(SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO) {
        SysCompanyTypeBO sysCompanyTypeBO = new SysCompanyTypeBO();
        sysCompanyTypeBO.setIsDeleted(0);
        return sysCompanyTypeBO;
    }

    public static SysCompanyTypeBO sysCompanyRoleInfoTypeClientListQueryReqDTOToSysCompanyTypeBO(SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO) {
        SysCompanyTypeBO sysCompanyTypeBO = new SysCompanyTypeBO();
        sysCompanyTypeBO.setIsDeleted(0);
        return sysCompanyTypeBO;
    }

    public static SysCompanyTypeBO sysCompanyRoleAddTypeClientListQueryReqDTOToSysCompanyTypeBO(SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO) {
        SysCompanyTypeBO sysCompanyTypeBO = new SysCompanyTypeBO();
        sysCompanyTypeBO.setIsDeleted(0);
        return sysCompanyTypeBO;
    }

    public static SysCompanyTypeBO sysCompanyRoleConfigRoleInfoQueryReqDTOToSysCompanyTypeBO(SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO) {
        SysCompanyTypeBO sysCompanyTypeBO = new SysCompanyTypeBO();
        sysCompanyTypeBO.setIsDeleted(0);
        return sysCompanyTypeBO;
    }
}