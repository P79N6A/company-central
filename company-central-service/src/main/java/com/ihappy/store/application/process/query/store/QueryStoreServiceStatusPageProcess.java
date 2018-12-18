package com.ihappy.store.application.process.query.store;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.bo.store.StoreInfoBO;
import com.ihappy.store.domain.bo.store.StoreInfoQueryBO;
import com.ihappy.store.domain.dto.request.store.StoreServiceStatusPageQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.StoreServiceStatusPageQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/10/19.
 */
public class QueryStoreServiceStatusPageProcess extends DefaultQueryProcess<StoreServiceStatusPageQueryReqDTO, Page<StoreServiceStatusPageQueryRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StoreServiceStatusPageQueryReqDTO, Page<StoreServiceStatusPageQueryRespDTO>> context) {
        StoreServiceStatusPageQueryReqDTO reqDTO = context.getParam();
        StoreInfoQueryBO bo = CompanyStoreFactory.storeServiceStatusPageQueryReqDTO2StoreInfoQueryBO(reqDTO);
        List<StoreInfoBO> boList = new ArrayList<StoreInfoBO>();
        Integer total = companyStoreService.queryStorePageCount(bo);
        if (total != 0){
            boList = companyStoreService.queryStorePage(bo);
        }
        List<StoreServiceStatusPageQueryRespDTO> list = CompanyStoreFactory.storeInfoBOList2StoreServiceStatusPageQueryRespDTOList(boList);
        Page<StoreServiceStatusPageQueryRespDTO> resPage = new Page(1, 1, total, list);
        context.getResult().setModule(resPage);
    }
}
