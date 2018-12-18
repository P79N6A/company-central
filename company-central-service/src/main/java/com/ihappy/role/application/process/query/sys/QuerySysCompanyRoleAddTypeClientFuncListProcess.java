package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleAddTypeClientFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleAddTypeClientFuncListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangmengdan
 * 运营后台-平台设定-角色配置-角色添加-应用配置-类型-菜单列表process
 */
public class QuerySysCompanyRoleAddTypeClientFuncListProcess extends DefaultQueryProcess<SysCompanyRoleAddTypeClientFuncListQueryReqDTO, List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO>> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyRoleAddTypeClientFuncListQueryReqDTO, List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO>> context) {
        SysCompanyRoleAddTypeClientFuncListQueryReqDTO sysCompanyRoleAddTypeClientFuncListQueryReqDTO = context.getParam();
        //根据ctId和clId查询系统公司功能菜单列表
        List<SysCompanyFuncModel> funcList = sysCompanyFuncService.findSysCompanyFuncListByctIdclId(SysCompanyRoleFactory.sysCompanyRoleAddTypeClientFuncListQueryReqDTOToSysCompanyFuncBO(sysCompanyRoleAddTypeClientFuncListQueryReqDTO));
        List<SysCompanyRoleAddTypeClientFuncListQueryRespDTO> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(funcList)) {
            context.getResult().setModule(list);
            return;
        }
        for (SysCompanyFuncModel sysCompanyFuncModel : funcList) {
            list.add( SysCompanyRoleFactory.modelTOSysCompanyRoleAddTypeClientFuncListQueryRespDTO(sysCompanyFuncModel));
        }
        context.getResult().setModule(list);

    }
}
