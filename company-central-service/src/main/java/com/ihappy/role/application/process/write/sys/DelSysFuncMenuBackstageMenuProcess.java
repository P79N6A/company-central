package com.ihappy.role.application.process.write.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoDelReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoDelRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * *  created by zhangmengdan
 * *  * create at 2018/8/23
 * 运营后台-平台设定-功能菜单-后台-菜单删除process
 */
public class DelSysFuncMenuBackstageMenuProcess extends DefaultProcess<SysFuncMenuBackstageMenuInfoDelReqDTO, SysFuncMenuBackstageMenuInfoDelRespDTO> {
    @Autowired
    private SysFuncService sysFuncService;

    @Override
    public void process(Context<SysFuncMenuBackstageMenuInfoDelReqDTO, SysFuncMenuBackstageMenuInfoDelRespDTO> context) {
        SysFuncMenuBackstageMenuInfoDelReqDTO sysFuncMenuBackstageMenuInfoDelReqDTO = context.getParam();
        SysFuncModel menu = sysFuncService.findSysFuncMenuBackstageMenuInfo(SysFuncFactory.sysFuncMenuBackstageMenuInfoDelReqDTOToSysFuncBO(sysFuncMenuBackstageMenuInfoDelReqDTO));
        //菜单是否存在
        if (menu == null) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrCode(),
                    RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrMsg());
        }
        int delMenu = sysFuncService.removeSysFuncMenuBackstageMenu(SysFuncFactory.sysFuncMenuBackstageMenuInfoDelReqDTOToSysFuncBO(sysFuncMenuBackstageMenuInfoDelReqDTO));
        SysFuncMenuBackstageMenuInfoDelRespDTO result = new SysFuncMenuBackstageMenuInfoDelRespDTO();
        if (delMenu > 0) {
            result.setMessage("删除成功");
        }
        context.getResult().setModule(result);

    }
}
