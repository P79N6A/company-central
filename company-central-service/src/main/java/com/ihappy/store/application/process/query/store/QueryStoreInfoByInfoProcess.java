package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.bo.store.StoreInfoQueryBO;
import com.ihappy.store.domain.dto.request.store.StoreInfoByInfoQuery;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liuhc on 2018/6/16.
 */
public class QueryStoreInfoByInfoProcess  extends DefaultQueryProcess<StoreInfoByInfoQuery,List<CompanyStoreListQueryRespDTO>> {

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StoreInfoByInfoQuery, List<CompanyStoreListQueryRespDTO>> context) {

        StoreInfoByInfoQuery storeInfoByInfoQuery = context.getParam();

        StoreInfoQueryBO storeInfoQueryBO = new StoreInfoQueryBO();
        storeInfoQueryBO.setCompId(storeInfoByInfoQuery.getCompId());
        storeInfoQueryBO.setDefaultFlag(storeInfoByInfoQuery.getDefaultFlag());

        List<CompanyStoreModel> companyStoreModels = companyStoreService.queryStoreInfoByInfoList(storeInfoQueryBO);
        List<CompanyStoreListQueryRespDTO> sysCompanyRoleQueryRespDTOs = CompanyStoreFactory.modelListToRespDTOList(companyStoreModels);
        context.getResult().setModule(sysCompanyRoleQueryRespDTOs);
    }
}
