package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuUptateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuUptateRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * created by zhangmengdan
 * * create at 2018/8/23
 * 运营后台-平台设定-功能菜单-后台-菜单修改process
 */
public class UpdateSysFuncMenuBackstageMenuInfoProcess extends DefaultProcess<SysFuncMenuBackstageMenuUptateReqDTO, SysFuncMenuBackstageMenuUptateRespDTO> {
    @Autowired
    private SysFuncService sysFuncService;

    @Override
    public void process(Context<SysFuncMenuBackstageMenuUptateReqDTO, SysFuncMenuBackstageMenuUptateRespDTO> context) {
        SysFuncMenuBackstageMenuUptateReqDTO sysFuncMenuBackstageMenuUptateReqDTO = context.getParam();
        SysFuncModel menu = sysFuncService.findSysFuncMenuBackstageMenuInfo(SysFuncFactory.sysFuncMenuBackstageMenuUptateReqDTOToSysFuncBO(sysFuncMenuBackstageMenuUptateReqDTO));
        //菜单是否存在
        if (menu == null) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrCode(),
                    RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrMsg());
        }
        List<SysFuncModel> checkMenuName = sysFuncService.checkMenuNameIsOrNotRepeat(SysFuncFactory.sysFuncMenuBackstageMenuUptateReqDTOToSysFuncBO(sysFuncMenuBackstageMenuUptateReqDTO));
        //判断菜单名称是否重复
        if (checkMenuName.size() > 0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrMsg());
        }
        List<SysFuncModel> checkMenuNo = sysFuncService.checkMenuNoIsOrNotRepeat(SysFuncFactory.sysFuncMenuBackstageMenuUptateReqDTOToSysFuncBO(sysFuncMenuBackstageMenuUptateReqDTO));
        //判断菜单名称是否重复
        if (checkMenuNo.size() > 0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrMsg());
        }
        int updateMenu = sysFuncService.editSysFuncMenuBackstageMenuInfo(SysFuncFactory.sysFuncMenuBackstageMenuUptateReqDTOToSysFuncBO(sysFuncMenuBackstageMenuUptateReqDTO));
        SysFuncMenuBackstageMenuUptateRespDTO sysFuncMenuBackstageMenuUptateRespDTO = new SysFuncMenuBackstageMenuUptateRespDTO();
        if (updateMenu > 0) {
            sysFuncMenuBackstageMenuUptateRespDTO.setMessage("修改成功");
        }
        context.getResult().setModule(sysFuncMenuBackstageMenuUptateRespDTO);
    }
}
