package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.ListConvertToTreeList;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 运营后台-平台设定-功能菜单-应用-类型-菜单列表查询process
 */
public class QuerySysFuncMenuApplyTypeMenuListProcess extends DefaultQueryProcess<SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO, List<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO>> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO, List<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO>> context) {
        SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO = context.getParam();
        List<SysCompanyFuncModel> sysCompanyFuncModelList = sysCompanyFuncService.selectSysCompanyFuncMenuApplyTypeMenuList(SysCompanyFuncFactory.sysFuncMenuApplyTypeMenuListQueryReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO));
        List<SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO> list = new ArrayList<>();
        Set<Long> setIds = new HashSet<>();
        if (!CollectionUtil.isEmpty(sysCompanyFuncModelList)) {
            for (SysCompanyFuncModel sysCompanyFuncModel : sysCompanyFuncModelList) {
                   if (SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuListQueryRespDTOToSysCompanyFuncModel(sysCompanyFuncModel).getCtFuncName().contains(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.getName())){
                       setIds.add(Long.valueOf(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuListQueryRespDTOToSysCompanyFuncModel(sysCompanyFuncModel).getCtFuncId()+""));
                   }
                    list.add(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuListQueryRespDTOToSysCompanyFuncModel(sysCompanyFuncModel));

            }
        }
        context.getResult().setModule(ListConvertToTreeList.changeForOnlySomeNodeByAsc(list, setIds));
    }
}

