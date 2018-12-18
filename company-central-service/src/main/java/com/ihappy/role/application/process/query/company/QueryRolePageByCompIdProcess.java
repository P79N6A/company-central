package com.ihappy.role.application.process.query.company;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleListQueryListRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleListQueryRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * ceated by zhangmengdan
 * created at 2018/8/25
 * 分页查询App-管理-角色管理-角色列表process
 */
public class QueryRolePageByCompIdProcess extends DefaultQueryProcess<CompanyRoleListQueryReqDTO, CompanyRoleListQueryRespDTO> {
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<CompanyRoleListQueryReqDTO, CompanyRoleListQueryRespDTO> context) {
        CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO = context.getParam();
        //查询系统公司角色列表
        List<CompanyRoleBO> findSysCompanyRoleList = sysCompanyRoleService.findAllSysRoleListByCompIds(CompanyRoleFactory.companyRoleListQueryReqDTOToCompId(companyRoleListQueryReqDTO));
        //查询公司角色列表
        List<CompanyRoleModel> roleList = companyRoleService.findRolePageByCompId(CompanyRoleFactory.companyRoleListQueryReqDTOToQueryCompanyRolePageBO(companyRoleListQueryReqDTO));

        //判断null
        if (CollectionUtil.isEmpty(roleList)) {
            roleList = new ArrayList<>();
        }
        if (CollectionUtil.isEmpty(findSysCompanyRoleList)) {
            findSysCompanyRoleList = new ArrayList<>();
        }
        CompanyRoleListQueryRespDTO companyRoleListQueryRespDTO = new CompanyRoleListQueryRespDTO();
        List<CompanyRoleListQueryListRespDTO> companyRoleListQueryListRespDTOList=CompanyRoleFactory.sysAndCompanyRoleToCompanyRoleListQueryRespDTO(findSysCompanyRoleList, roleList);
        companyRoleListQueryRespDTO.setList(companyRoleListQueryListRespDTOList);
        context.getResult().setModule(companyRoleListQueryRespDTO);
    }
}
