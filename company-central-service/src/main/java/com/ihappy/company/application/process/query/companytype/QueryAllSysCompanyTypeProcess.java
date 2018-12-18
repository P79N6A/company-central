package com.ihappy.company.application.process.query.companytype;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;
import com.ihappy.company.infrastructure.service.inside.SysCompanyTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhc on 2018/5/16.
 */
public class QueryAllSysCompanyTypeProcess extends DefaultQueryProcess<SysCompanyTypeAllQuery,List<SysCompanyTypeInfoRespDTO>> {

    @Autowired
    private SysCompanyTypeService sysCompanyTypeService;

    @Override
    public void process(Context<SysCompanyTypeAllQuery, List<SysCompanyTypeInfoRespDTO>> context) {

        List<SysCompanyTypeModel> modelList = sysCompanyTypeService.selectByCompanyTypeList();

        if (CollectionUtil.isEmpty(modelList)){
            context.getResult().setModule(null);
            return;
        }

        List<SysCompanyTypeInfoRespDTO> result = new ArrayList<>();
        for(SysCompanyTypeModel model : modelList){
            result.add(model.toSysCompanyTypeInfoRespDTO());
        }

        context.getResult().setModule(result);
    }
}
