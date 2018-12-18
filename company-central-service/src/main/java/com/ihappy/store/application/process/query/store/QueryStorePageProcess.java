package com.ihappy.store.application.process.query.store;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.bo.store.StoreInfoBO;
import com.ihappy.store.domain.bo.store.StoreInfoQueryBO;
import com.ihappy.store.domain.dto.request.store.StorePageQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.StorePageQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/10/17.
 */
public class QueryStorePageProcess extends DefaultQueryProcess<StorePageQueryReqDTO, Page<StorePageQueryRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<StorePageQueryReqDTO, Page<StorePageQueryRespDTO>> context) {
        StorePageQueryReqDTO reqDTO = context.getParam();
        StoreInfoQueryBO bo = CompanyStoreFactory.storePageQueryReqDTOToStoreInfoQueryBO(reqDTO);
        List<StoreInfoBO> boList = new ArrayList<StoreInfoBO>();
        Integer total = companyStoreService.queryStorePageCount(bo);
        if (total != 0){
            boList = companyStoreService.queryStorePage(bo);
        }
        List<StorePageQueryRespDTO> list = CompanyStoreFactory.storeInfoBOList2StorePageQueryRespDTOList(boList);
        Page<StorePageQueryRespDTO> resPage = new Page(1, 1, total, list);
        context.getResult().setModule(resPage);
    }
}
