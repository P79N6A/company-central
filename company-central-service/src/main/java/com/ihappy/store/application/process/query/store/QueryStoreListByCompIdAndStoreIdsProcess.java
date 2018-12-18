package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/10.
 */
public class QueryStoreListByCompIdAndStoreIdsProcess extends DefaultQueryProcess<CompanyStoreListQueryReqDTO,List<CompanyStoreListQueryRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<CompanyStoreListQueryReqDTO, List<CompanyStoreListQueryRespDTO>> context) {
        CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO = context.getParam();
        List<CompanyStoreModel> companyStoreModels = companyStoreService.findValidStoreListByCompIdAndStoreIds(CompanyStoreFactory.reqDTOToQueryStoreListByCompIdAndStoreIdsBO(companyStoreListQueryReqDTO));
        List<CompanyStoreListQueryRespDTO> sysCompanyRoleQueryRespDTOs = CompanyStoreFactory.modelListToRespDTOList(companyStoreModels);
        context.getResult().setModule(sysCompanyRoleQueryRespDTOs);
    }
}
