package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuDelReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuDelRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

public class DelSysCompanyFuncMenuApplyTypeMenuProcess extends DefaultProcess<SysCompanyFuncMenuApplyTypeMenuDelReqDTO, SysCompanyFuncMenuApplyTypeMenuDelRespDTO> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyFuncMenuApplyTypeMenuDelReqDTO, SysCompanyFuncMenuApplyTypeMenuDelRespDTO> context) {
        SysCompanyFuncMenuApplyTypeMenuDelReqDTO sysCompanyFuncMenuApplyTypeMenuDelReqDTO = context.getParam();
        //查询菜单详情
        SysCompanyFuncModel menu = sysCompanyFuncService.findSysCompanyFuncByCtFuncId(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuDelReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuDelReqDTO));
        //判断菜单是否存在
        if (menu == null) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrCode(),
                    RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrMsg());
        }
        int delMenu = sysCompanyFuncService.removeSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuDelReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuDelReqDTO));
        SysCompanyFuncMenuApplyTypeMenuDelRespDTO sysCompanyFuncMenuApplyTypeMenuDelRespDTO = new SysCompanyFuncMenuApplyTypeMenuDelRespDTO();
        if (delMenu > 0) {
            sysCompanyFuncMenuApplyTypeMenuDelRespDTO.setMessage("删除成功");
        }
        context.getResult().setModule(sysCompanyFuncMenuApplyTypeMenuDelRespDTO);
    }
}
