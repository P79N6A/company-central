package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 运营后台-平台设定-功能菜单-应用-类型-菜单列表-菜单详情查询process
 * created by zhangmengdan
 * created at 2018/8/23
 */
public class QuerySysCompanyFuncMenuApplyTypeMenuInfoProcess extends DefaultQueryProcess<SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO, SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO, SysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO> context) {
        SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO = context.getParam();
        SysCompanyFuncModel sysCompanyFuncModel = sysCompanyFuncService.findSysCompanyFuncByCtFuncId(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO));
        //判断是否存在
        if (sysCompanyFuncModel == null){
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrCode(),RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrMsg());
        }
        context.getResult().setModule(SysCompanyFuncFactory.sysCompanyFuncModelToSysCompanyFuncMenuApplyTypeMenuInfoQueryRespDTO(sysCompanyFuncModel));
    }
}
