package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.StoreInfoQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.StoreInfoQueryRespDTO;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: company-central
 * @description: 门店信息查询
 * @author: 汪正
 * @create: 2018-07-30 14:07
 **/
public class QueryStoreInfoByNameProcess extends DefaultQueryProcess<StoreInfoQueryReqDTO,StoreInfoQueryRespDTO> {

    @Autowired
    CompanyStoreService companyStoreService;


    @Override
    public void process(Context<StoreInfoQueryReqDTO, StoreInfoQueryRespDTO> context) {
        StoreInfoQueryReqDTO storeInfoQueryReqDTO = context.getParam();
        List<BaseinfoCompanyStore> baseinfoCompanyStores =
                companyStoreService.queryStoreByStoreName(storeInfoQueryReqDTO.getStoreName(),storeInfoQueryReqDTO.getCompId());
        //存在门店
        if(baseinfoCompanyStores != null && baseinfoCompanyStores.size() > 0){
            BaseinfoCompanyStore companyStore = baseinfoCompanyStores.get(0);
            StoreInfoQueryRespDTO storeInfoQueryRespDTO = new StoreInfoQueryRespDTO();
            BeanUtils.copyProperties(companyStore, storeInfoQueryRespDTO);
            context.setResultModule(storeInfoQueryRespDTO);
            return;
        }
        //不存在门店 新增返回
        BaseinfoCompanyStore companyStore = getCreateBaseinfoCompanyStore(storeInfoQueryReqDTO);
        int row = companyStoreService.addStoreAndStock(companyStore);
        if(row > 0){
            StoreInfoQueryRespDTO storeInfoQueryRespDTO = new StoreInfoQueryRespDTO();
            BeanUtils.copyProperties(companyStore, storeInfoQueryRespDTO);
            context.setResultModule(storeInfoQueryRespDTO);
        }
        else {
            throw new CompanyException(StoreErrorCodeEnum.
                    STORE_QUERY_IS_FAIL.getErrCode(),
                    StoreErrorCodeEnum.STORE_QUERY_IS_FAIL.getErrMsg());
        }
    }

    private BaseinfoCompanyStore getCreateBaseinfoCompanyStore(StoreInfoQueryReqDTO storeInfoQueryReqDTO) {
        BaseinfoCompanyStore companyStore = new BaseinfoCompanyStore();
        long storeId = DistributedPrimaryKeyFactory.generateCompanyStoreId(storeInfoQueryReqDTO.getCompId());
        companyStore.setStoreId(storeId);
        companyStore.setStoreNo(storeId + "");
        companyStore.setCompId((int) (long) storeInfoQueryReqDTO.getCompId());
        companyStore.setStoreName(storeInfoQueryReqDTO.getStoreName());
        companyStore.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        companyStore.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        companyStore.setCreatedPersonId(storeInfoQueryReqDTO.getLoginPersonId());
        companyStore.setUpdatedPersonId(storeInfoQueryReqDTO.getLoginPersonId());
        return companyStore;
    }

}
