package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.ListConvertToTreeList;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuListQueryRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by zhangmengdan
 * created at 2018/8/23
 * 运营后台-平台设定-功能菜单-后台-菜单列表查询process
 */
public class QuerySysFuncMenuBackstageMenuListProcess extends DefaultQueryProcess<SysFuncMenuBackstageMenuListQueryReqDTO, List<SysFuncMenuBackstageMenuListQueryRespDTO>> {
    @Autowired
    private SysFuncService sysFuncService;

    @Override
    public void process(Context<SysFuncMenuBackstageMenuListQueryReqDTO, List<SysFuncMenuBackstageMenuListQueryRespDTO>> context) {
        SysFuncMenuBackstageMenuListQueryReqDTO sysFuncMenuBackstageMenuListQueryReqDTO = context.getParam();
        List<SysFuncModel> sysAllFuncModelList = sysFuncService.querySysFuncMenuBackstageMenuList(SysFuncFactory.sysFuncMenuBackstageMenuListQueryReqDTOToSysFuncListBO(sysFuncMenuBackstageMenuListQueryReqDTO));
        //总菜单响应
        List<SysFuncMenuBackstageMenuListQueryRespDTO> list = new ArrayList<>();
        Set<Long> setIds = new HashSet<>();
        //循环菜单列表
        if (!CollectionUtil.isEmpty(sysAllFuncModelList)) {
            for (SysFuncModel sysFuncModel : sysAllFuncModelList) {
                if(SysFuncFactory.sysFuncMenuBackstageMenuListQueryRespDTOTosysFuncModel(sysFuncModel).getCtFuncName().contains(sysFuncMenuBackstageMenuListQueryReqDTO.getName())){
                    setIds.add(SysFuncFactory.sysFuncMenuBackstageMenuListQueryRespDTOTosysFuncModel(sysFuncModel).getCtFuncId().longValue());
                }
                list.add(SysFuncFactory.sysFuncMenuBackstageMenuListQueryRespDTOTosysFuncModel(sysFuncModel));
            }
        }
        context.getResult().setModule(ListConvertToTreeList.changeForOnlySomeNodeByAsc(list, setIds));
    }
}



