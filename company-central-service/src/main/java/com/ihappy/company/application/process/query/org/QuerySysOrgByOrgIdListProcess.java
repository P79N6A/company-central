package com.ihappy.company.application.process.query.org;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.bo.SysOrgByOrgListBO;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByOrgIdListQuery;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoRespDTO;
import com.ihappy.company.domain.model.factory.SysOrgFactory;
import com.ihappy.company.domain.model.model.SysOrgModel;
import com.ihappy.company.infrastructure.service.inside.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 通过部门ID集合 查询部门基本信息
 * Created by liuhc on 2018/6/14.
 */
public class QuerySysOrgByOrgIdListProcess extends DefaultQueryProcess<SysOrgBasicInfoByOrgIdListQuery,List<SysOrgBasicInfoRespDTO>> {

    @Autowired
    private SysOrgService sysOrgService;

    @Override
    public void process(Context<SysOrgBasicInfoByOrgIdListQuery, List<SysOrgBasicInfoRespDTO>> context) {

        SysOrgBasicInfoByOrgIdListQuery sysOrgBasicInfoByOrgIdListQuery = context.getParam();

        //查询db
        SysOrgByOrgListBO sysOrgByOrgListBO = new SysOrgByOrgListBO();
        sysOrgByOrgListBO.setOrgIdList(sysOrgBasicInfoByOrgIdListQuery.getOrgIdList());
        List<SysOrgModel> orgModelList = sysOrgService.getSysOrgListByOrgIdList(sysOrgByOrgListBO);

        //转换
        List<SysOrgBasicInfoRespDTO> dtoList = SysOrgFactory.toSysOrgBasiceInfo(orgModelList);
        context.getResult().setModule(dtoList);
    }
}
