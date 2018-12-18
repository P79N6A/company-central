package com.ihappy.role.domain.model.factory.sys;


import com.ihappy.role.domain.bo.SysClientBO;
import com.ihappy.role.domain.bo.SysClientInfoBO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleAddTypeClientListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleInfoTypeClientFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleInfoTypeClientListQueryReqDTO;

public class SysClientFactory {
    public static SysClientInfoBO sysCompanyRoleInfoTypeClientFuncListQueryReqDTOToSysClientInfoBO(SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO) {
        SysClientInfoBO sysClientInfoBO = new SysClientInfoBO();
        sysClientInfoBO.setIsDeleted(0);
        sysClientInfoBO.setClId(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.getClId());
        return sysClientInfoBO;
    }

    public static SysClientBO sysFuncMenuApplyTypeListQueryReqDTOToSysClientBO(SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO) {
        SysClientBO sysClientBO = new SysClientBO();
        sysClientBO.setIsDeleted(0);
        return sysClientBO;
    }

    public static SysClientBO sysCompanyRoleInfoTypeClientListQueryReqDTOToSysClientBO(SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO) {
        SysClientBO sysClientBO = new SysClientBO();
        sysClientBO.setIsDeleted(0);
        return sysClientBO;
    }

    public static SysClientBO sysClientFactorysysCompanyRoleAddTypeClientListQueryReqDTOToSysClientBO(SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO) {
        SysClientBO sysClientBO = new SysClientBO();
        sysClientBO.setIsDeleted(0);
        return sysClientBO;
    }

    public static SysClientBO sysCompanyRoleConfigRoleInfoQueryReqDTOToSysClientBO(SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO) {
        SysClientBO sysClientBO = new SysClientBO();
        sysClientBO.setIsDeleted(0);
        return sysClientBO;
    }
}
