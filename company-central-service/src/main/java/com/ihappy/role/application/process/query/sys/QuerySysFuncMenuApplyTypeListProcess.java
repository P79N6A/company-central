package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.model.factory.SysCompanyTypeFactory;
import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.company.infrastructure.service.inside.SysCompanyTypeService;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysClientFactory;
import com.ihappy.role.domain.model.factory.sys.SysFuncMenuFactory;
import com.ihappy.role.infrastructure.service.inside.SysClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class QuerySysFuncMenuApplyTypeListProcess extends DefaultQueryProcess<SysCompanyFuncMenuApplyTypeListQueryReqDTO, List<SysCompanyFuncMenuApplyTypeListQueryRespDTO>> {
    @Autowired
    private SysClientService sysClientService;
    @Autowired
    private SysCompanyTypeService sysCompanyTypeService;

    @Override
    public void process(Context<SysCompanyFuncMenuApplyTypeListQueryReqDTO, List<SysCompanyFuncMenuApplyTypeListQueryRespDTO>> context) {
        SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO = context.getParam();
        //查询客户端列表
        List<SysClientModel> clientList = sysClientService.querySysClientList(SysClientFactory.sysFuncMenuApplyTypeListQueryReqDTOToSysClientBO(sysCompanyFuncMenuApplyTypeListQueryReqDTO));
        //查询系统功能类型列表
        List<SysCompanyTypeModel> typeList = sysCompanyTypeService.selectSysCompanyTypeList(SysCompanyTypeFactory.sysFuncMenuApplyTypeListQueryReqDTOToSysCompanyTypeBO(sysCompanyFuncMenuApplyTypeListQueryReqDTO));
        List<SysCompanyFuncMenuApplyTypeListQueryRespDTO> sysCompanyFuncMenuApplyTypeListQueryRespDTOList = new ArrayList<>();
        //循环两张表
        for (SysCompanyTypeModel sysCompanyTypeModel : typeList) {
            for (SysClientModel sysClientModel : clientList) {
                sysCompanyFuncMenuApplyTypeListQueryRespDTOList.add(SysFuncMenuFactory.sysFuncMenuApplyTypeListQueryRespDTOToModel(sysClientModel, sysCompanyTypeModel));
            }
        }
        context.getResult().setModule(sysCompanyFuncMenuApplyTypeListQueryRespDTOList);
    }
}
