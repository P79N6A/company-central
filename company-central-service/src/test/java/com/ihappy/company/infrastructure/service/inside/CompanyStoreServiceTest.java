package com.ihappy.company.infrastructure.service.inside;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.junit.Test;

/**
 * Created by sunjd on 2018/7/7.
 */
public class CompanyStoreServiceTest extends BaseTest {
    @Test
    public void addStoreAndStock() throws Exception {
        CompanyStoreService service = getBean("companyStoreService");
        BaseinfoCompanyStore obj = new BaseinfoCompanyStore();
        obj.setCompId(1);
        obj.setStoreId(210001L);
        Integer res = service.addStoreAndStock(obj);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void findByStoreIdAndCompId() throws Exception {
        CompanyStoreService service = getBean("companyStoreService");
        BaseinfoCompanyStore obj = new BaseinfoCompanyStore();
        obj.setCompId(1);
        obj.setStoreId(10001L);
        CompanyStoreModel res = service.findByStoreIdAndCompId(new CompanyStoreModel(obj));
        System.out.println(JSON.toJSONString(res));
    }
}