package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by zhangmengdan
 * * 运营后台-平台设定-功能菜单-后台-菜单详情查询process
 */
public class QuerySysFuncMenuBackstageMenuInfoProcess extends DefaultQueryProcess<SysFuncMenuBackstageMenuInfoQueryReqDTO, SysFuncMenuBackstageMenuInfoQueryRespDTO> {
    @Autowired
    private SysFuncService sysFuncService;

    @Override
    public void process(Context<SysFuncMenuBackstageMenuInfoQueryReqDTO, SysFuncMenuBackstageMenuInfoQueryRespDTO> context) {
        SysFuncMenuBackstageMenuInfoQueryReqDTO sysFuncMenuBackstageMenuInfoQueryReqDTO = context.getParam();
        SysFuncModel menuInfo = sysFuncService.findSysFuncMenuBackstageMenuInfo(SysFuncFactory.sysFuncMenuBackstageMenuInfoQueryReqDTOToSysFuncBO(sysFuncMenuBackstageMenuInfoQueryReqDTO));
        //菜单是否存在
        if (menuInfo == null) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrCode(),
                    RoleErrorCodeEnum.MENU_IS_NOT_EXIST.getErrMsg());
        }
        //菜单是否被删除
        if (menuInfo.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.MENU_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.MENU_IS_DELETED.getErrMsg());
        }
        context.getResult().setModule(SysFuncFactory.sysFuncModelToSysFuncMenuBackstageMenuInfoQueryRespDTO(menuInfo));

    }
}
