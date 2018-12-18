package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.BaseTest;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import org.junit.Test;

/**
 * Created by sunjd on 2018/5/30.
 */
public class CompanyStoreServiceImplTest extends BaseTest {
    @Test
    public void addDefStore() throws Exception {
        CompanyStoreService companyStoreService = getBean("companyStoreService");

        //添加默认门店，同时添加默认仓库
        BaseinfoCompanyStore store = new BaseinfoCompanyStore();
        store.setCompId(78069);
        store.setAdminPersonId(1L);
        Boolean addStroeFlag = companyStoreService.addDefStore(new CompanyStoreModel(store));
        if (!addStroeFlag){
            throw new CompanyException(StoreErrorCodeEnum.
                    ADD_DEF_STORE_ERROR.getErrCode(),
                    StoreErrorCodeEnum.ADD_DEF_STORE_ERROR.getErrMsg());
        }
    }

}