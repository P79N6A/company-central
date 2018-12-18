package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UpdateSysCompanyFuncMenuApplyTypeMenuProcess extends DefaultProcess<SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO, SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO, SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO> context) {
        SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO = context.getParam();
        //查询菜单详情
        SysCompanyFuncModel menuInfo = sysCompanyFuncService.findSysCompanyFuncByCtFuncId(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuUpdateReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO));
        //菜单是否存在
        if (menuInfo == null) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrCode(),
                    RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrMsg());
        }
        List<SysCompanyFuncModel> checkMenuName = sysCompanyFuncService.checkMenuNameIsOrNotRepeat(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuUpdateReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO));
        //菜单名称是否重复
        if (checkMenuName.size()>0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrMsg());
        }
        List<SysCompanyFuncModel> checkMenuNo = sysCompanyFuncService.checkMenuNoIsOrNotRepeat(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuUpdateReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO));
        //菜单编号是否重复
        if (checkMenuNo.size()>0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrMsg());
        }
        int updateMenu = sysCompanyFuncService.editSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuUpdateReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO));
        SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO result = new SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO();
        if (updateMenu > 0) {
            result.setMessage("修改成功");
        }
        context.getResult().setModule(result);
    }
}
