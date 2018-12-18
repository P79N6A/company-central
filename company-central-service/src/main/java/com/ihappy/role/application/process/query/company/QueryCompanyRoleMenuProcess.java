package com.ihappy.role.application.process.query.company;


import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.ihappy.common.util.ListConvertToTreeList;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleMenuQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleMenuListQueryRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleMenuQueryRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by zhangmengdan
 * APP-管理-角色管理-添加角色-角色菜单process
 */
public class QueryCompanyRoleMenuProcess extends DefaultQueryProcess<CompanyRoleMenuQueryReqDTO, CompanyRoleMenuQueryRespDTO> {
    @Autowired
    private SysCompanyFuncService sysCompanyFuncService;

    @Override
    public void process(Context<CompanyRoleMenuQueryReqDTO, CompanyRoleMenuQueryRespDTO> context) {
        CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO = context.getParam();
        List<SysCompanyFuncModel> companyRoleMenuList = sysCompanyFuncService.findSysCompanyFuncListByctIdclId(SysCompanyRoleFactory.companyRoleMenuQueryReqDTOToBO(companyRoleMenuQueryReqDTO));
        if (CollectionUtils.isEmpty(companyRoleMenuList)) {
            throw new CompanyException(RoleErrorCodeEnum.COMPANY_ROLE_MENU_LIST_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_MENU_LIST_IS_NOT_NULL.getErrMsg());
        }
        //菜单响应
        CompanyRoleMenuQueryRespDTO companyRoleMenuQueryRespDTO = new CompanyRoleMenuQueryRespDTO();
        List<CompanyRoleMenuListQueryRespDTO> resultList = new ArrayList<>();
        Set<Long> setIds = new HashSet<>();
        if(!CollectionUtil.isEmpty(companyRoleMenuList)){
            for(SysCompanyFuncModel sysCompanyFuncModel : companyRoleMenuList){
                resultList.add(CompanyRoleFactory.modelTOCompanyRoleMenuQueryRespDTO(sysCompanyFuncModel));
                setIds.add(Long.parseLong(CompanyRoleFactory.modelTOCompanyRoleMenuQueryRespDTO(sysCompanyFuncModel).getCtFuncId()+""));
            }
            companyRoleMenuQueryRespDTO.setMenuList( ListConvertToTreeList.changeForOnlySomeNodeByAsc(resultList,setIds));

        }
        //将菜单转换成树的形式
        context.getResult().setModule(companyRoleMenuQueryRespDTO);
    }
}