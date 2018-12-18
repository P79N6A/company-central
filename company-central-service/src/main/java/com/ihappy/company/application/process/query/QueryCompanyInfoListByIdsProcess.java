package com.ihappy.company.application.process.query;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.dto.request.CompanyInfoListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoListQueryRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/2.
 */
public class QueryCompanyInfoListByIdsProcess extends DefaultQueryProcess<CompanyInfoListQueryReqDTO,List<CompanyInfoListQueryRespDTO>> {
    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<CompanyInfoListQueryReqDTO, List<CompanyInfoListQueryRespDTO>> context) {
        CompanyInfoListQueryReqDTO companyInfoListQueryReqDTO = context.getParam();
        List<CompanyModel> companyModels = companyInfoService.queryCompanyInfoListByIds(companyInfoListQueryReqDTO.getCompIds());
        List<CompanyInfoListQueryRespDTO> companyInfoListQueryRespDTOs = BaseinfoCompanyFactory.modelListToCompanyInfoListQueryReqDTOList(companyModels);
        context.getResult().setModule(companyInfoListQueryRespDTOs);
    }
}
