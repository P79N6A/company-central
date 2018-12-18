package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.bo.SysCompanyFuncByCtIdQuery;
import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyFuncFactory;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuerySysCompanyFuncListProcess extends DefaultQueryProcess<SysCompanyFuncListQueryReqDTO, List<PrivilegeAllRespDTO>> {

    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyFuncListQueryReqDTO, List<PrivilegeAllRespDTO>> context) {
        SysCompanyFuncListQueryReqDTO sysCompanyFuncListQuryReqDTO = context.getParam();
        List<PrivilegeAllRespDTO> result = SysCompanyFuncFactory.modelListToSysCompanyFuncListQueryRespDTO(sysCompanyFuncService.selectSysCompanyFunctListByCtId(SysCompanyFuncFactory.sysCompanyFuncListQuryReqDTOToSysCompanyFuncByCtIdQuery(sysCompanyFuncListQuryReqDTO)));
        SysCompanyFuncByCtIdQuery sysCompanyFuncByCtIdQuery = new SysCompanyFuncByCtIdQuery();
        if (!CollectionUtil.isEmpty(result)) {
            RolePrivilegeRedisUtil.putAllPriv(ConfigCenterUtil.ENV, sysCompanyFuncListQuryReqDTO.getCtId() + "", sysCompanyFuncByCtIdQuery.getClientId() + "", result);
        }
        context.getResult().setModule(result);
    }
}
