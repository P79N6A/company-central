package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuAddReqDTO;
import com.ihappy.role.domain.dto.response.comp.SysCompanyFuncMenuApplyTypeMenuAddRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * created by zhangmengdan
 * create at 2018/8/23
 * 运营后台-平台设定-功能菜单-应用-类型-添加菜单process
 */
public class AddSysCompanyFuncMenuApplyTypeMenuProcess extends DefaultProcess<SysCompanyFuncMenuApplyTypeMenuAddReqDTO, SysCompanyFuncMenuApplyTypeMenuAddRespDTO> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<SysCompanyFuncMenuApplyTypeMenuAddReqDTO, SysCompanyFuncMenuApplyTypeMenuAddRespDTO> context) {
        SysCompanyFuncMenuApplyTypeMenuAddReqDTO sysCompanyFuncMenuApplyTypeMenuAddReqDTO = context.getParam();
        List<SysCompanyFuncModel> checkMenuName = sysCompanyFuncService.checkMenuNameIsOrNotRepeat(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuAddReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuAddReqDTO));
        //菜单名称是否重复
        if (checkMenuName.size() > 0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrMsg());
        }
        List<SysCompanyFuncModel> checkMenuNo = sysCompanyFuncService.checkMenuNoIsOrNotRepeat(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuAddReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuAddReqDTO));
        //菜单编号是否重复
        if (checkMenuNo.size() > 0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrMsg());
        }
        int addMenu = sysCompanyFuncService.addSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncFactory.sysCompanyFuncMenuApplyTypeMenuAddReqDTOToSysCompanyFuncBO(sysCompanyFuncMenuApplyTypeMenuAddReqDTO));
        SysCompanyFuncMenuApplyTypeMenuAddRespDTO sysCompanyFuncMenuApplyTypeMenuAddRespDTO = new SysCompanyFuncMenuApplyTypeMenuAddRespDTO();
        if (addMenu > 0) {
            sysCompanyFuncMenuApplyTypeMenuAddRespDTO.setMessage("添加成功");
        }
        context.getResult().setModule(sysCompanyFuncMenuApplyTypeMenuAddRespDTO);
    }
}

