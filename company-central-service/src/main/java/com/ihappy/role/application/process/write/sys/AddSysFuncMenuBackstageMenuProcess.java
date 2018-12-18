package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuAddReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuAddRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *  created by zhangmengdan
 *  * create at 2018/8/23
 * 运营后台-平台设定-功能菜单-后台-菜单添加process
 */
public class AddSysFuncMenuBackstageMenuProcess extends DefaultProcess<SysFuncMenuBackstageMenuAddReqDTO, SysFuncMenuBackstageMenuAddRespDTO> {
    @Autowired
    private SysFuncService sysFuncService;

    @Override
    public void process(Context<SysFuncMenuBackstageMenuAddReqDTO, SysFuncMenuBackstageMenuAddRespDTO> context) {
        SysFuncMenuBackstageMenuAddReqDTO sysFuncMenuBackstageMenuAddReqDTO = context.getParam();
        List<SysFuncModel> checkMenuName = sysFuncService.checkMenuNameIsOrNotRepeat(SysFuncFactory.sysFuncMenuBackstageMenuAddReqDTOToSysFuncBO(sysFuncMenuBackstageMenuAddReqDTO));
        //判断菜单名称是否重复
        if (checkMenuName.size() >0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NAME_IS_REPEAT.getErrMsg());
        }
        List<SysFuncModel> checkMenuNo = sysFuncService.checkMenuNoIsOrNotRepeat(SysFuncFactory.sysFuncMenuBackstageMenuAddReqDTOToSysFuncBO(sysFuncMenuBackstageMenuAddReqDTO));
        //判断菜单编号是否重复
        if (checkMenuNo.size() > 0) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.MENU_NO_IS_REPEAT.getErrMsg());
        }
        int addMenu = sysFuncService.addSysFuncMenuBackstageMenu(SysFuncFactory.sysFuncMenuBackstageMenuAddReqDTOToSysFuncBO(sysFuncMenuBackstageMenuAddReqDTO));
        SysFuncMenuBackstageMenuAddRespDTO result = new SysFuncMenuBackstageMenuAddRespDTO();
        if (addMenu > 0) {
            result.setMessage("添加成功");
        }
        context.getResult().setModule(result);
    }
}
