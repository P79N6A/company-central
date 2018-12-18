package com.ihappy.store.application.process.query.store;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhc on 2018/10/31.
 */
public class QueryAllStoreByCompIdProcess extends DefaultQueryProcess<CompanyStoreListQueryReqDTO,List<CompanyStoreListQueryRespDTO>> {

    @Autowired
    private BaseinfoCompanyStoreMapper baseinfoCompanyStoreMapper;

    @Override
    public void process(Context<CompanyStoreListQueryReqDTO, List<CompanyStoreListQueryRespDTO>> context) {

        CompanyStoreListQueryReqDTO param = context.getParam();

        List<CompanyStoreListQueryRespDTO> dtoList = new ArrayList<>();
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setCompId(param.getCompId());
        List<BaseinfoCompanyStore> dolList =  baseinfoCompanyStoreMapper.selectSelective(baseinfoCompanyStore);
        if(!CollectionUtil.isEmpty(dolList)){
            List<CompanyStoreModel> modelList = new ArrayList<>();
            for(BaseinfoCompanyStore store: dolList){
                modelList.add(new CompanyStoreModel(store));
            }
            dtoList = CompanyStoreFactory.modelListToRespDTOList(modelList);
        }
        context.getResult().setModule(dtoList);
    }
}
