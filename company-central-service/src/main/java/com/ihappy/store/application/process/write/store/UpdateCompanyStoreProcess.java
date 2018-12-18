package com.ihappy.store.application.process.write.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: company-central
 * @description: 门店信息更改
 * @author: 汪正
 * @create: 2018-05-16 18:58
 **/
public class UpdateCompanyStoreProcess extends DefaultProcess<CompanyStoreUpdateReqDTO, Boolean> {
    @Autowired
    private BaseinfoCompanyStoreMapper companyStoreMapper;

    @Override
    public void process(Context<CompanyStoreUpdateReqDTO, Boolean> context) {
        CompanyStoreUpdateReqDTO storeUpdateReqDTO = context.getParam();
        BaseinfoCompanyStore companyStore = getBaseinfoCompanyStoreByReqArgs(storeUpdateReqDTO);
        int number = companyStoreMapper.updateByPrimaryKeySelective(companyStore);
        if(number > 0){
            context.setResultSuccess(true);
            context.getResult().setModule(true);
        }
        else {
            context.setResultSuccess(false);
            context.getResult().setModule(false);
        }
    }
    private BaseinfoCompanyStore getBaseinfoCompanyStoreByReqArgs(CompanyStoreUpdateReqDTO storeUpdateReqDTO){
        BaseinfoCompanyStore companyStore = new BaseinfoCompanyStore();
        companyStore.setCompId(Integer.valueOf(storeUpdateReqDTO.getLoginCompId()+""));
        companyStore.setStoreId(storeUpdateReqDTO.getStoreId());
        companyStore.setWeshopName(storeUpdateReqDTO.getWeshopName());
        companyStore.setWeshopLogoImages(storeUpdateReqDTO.getWeshopLogoImages());
        companyStore.setWeshopManagerName(storeUpdateReqDTO.getWeshopManagerName());
        companyStore.setWeshopManagerId(storeUpdateReqDTO.getWeshopManagerId());
        companyStore.setWeshopContactType(storeUpdateReqDTO.getWeshopContactType());
        companyStore.setWeshopProvince(storeUpdateReqDTO.getWeshopProvince());
        companyStore.setWeshopCity(storeUpdateReqDTO.getWeshopCity());
        companyStore.setWeshopZone(storeUpdateReqDTO.getWeshopZone());
        companyStore.setWeshopAddress(storeUpdateReqDTO.getWeshopAddress());
        companyStore.setBusinessCategory(storeUpdateReqDTO.getBusinessCategory());
        companyStore.setWeshopImages(storeUpdateReqDTO.getWeshopImages());
        companyStore.setWeshopNotice(storeUpdateReqDTO.getWeshopNotice());
        companyStore.setIsOpenWeshopNotice(storeUpdateReqDTO.getIsOpenWeshopNotice());
        companyStore.setWeshopStatus(storeUpdateReqDTO.getWeshopStatus());
        companyStore.setIsDeletedWeshop(storeUpdateReqDTO.getIsDeletedWeshop());
        companyStore.setIsHasWeshop(storeUpdateReqDTO.getIsHasWeshop());
        companyStore.setWeshopManagerId(storeUpdateReqDTO.getWeshopManagerId());
        return companyStore;
    }
}