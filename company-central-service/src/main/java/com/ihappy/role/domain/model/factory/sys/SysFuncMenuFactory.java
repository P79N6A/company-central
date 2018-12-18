package com.ihappy.role.domain.model.factory.sys;

import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeListQueryRespDTO;

public class SysFuncMenuFactory {
    public static SysCompanyFuncMenuApplyTypeListQueryRespDTO sysFuncMenuApplyTypeListQueryRespDTOToModel(SysClientModel sysClientModel, SysCompanyTypeModel sysCompanyTypeModel) {
        SysCompanyFuncMenuApplyTypeListQueryRespDTO sysCompanyFuncMenuApplyTypeListQueryRespDTO =new SysCompanyFuncMenuApplyTypeListQueryRespDTO();
        sysCompanyFuncMenuApplyTypeListQueryRespDTO.setCtId(sysCompanyTypeModel.getDO().getCtId());
        sysCompanyFuncMenuApplyTypeListQueryRespDTO.setClId(sysClientModel.getDO().getClId());
        sysCompanyFuncMenuApplyTypeListQueryRespDTO.setName(sysCompanyTypeModel.getDO().getCtName()+"-"+sysClientModel.getDO().getClName());
        return sysCompanyFuncMenuApplyTypeListQueryRespDTO;
    }
}
