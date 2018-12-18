package com.ihappy.store.infrastructure.service;

import com.ihappy.BaseTest;
import com.ihappy.store.domain.dto.request.store.CompanyStoreUpdateReqDTO;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/4/10.
 */
public class CompanyStoreWriteServiceTest extends BaseTest {
    private CompanyStoreWriteService companyStoreWriteService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        companyStoreWriteService = getBean("companyStoreWriteService");
    }

    @Test
    public void testUpdateCompanyStoreWeshopInfo(){
        CompanyStoreUpdateReqDTO companyStoreUpdateReqDTO = new CompanyStoreUpdateReqDTO();
        companyStoreUpdateReqDTO.setStoreId(3181198211L);
        //companyStoreUpdateReqDTO.setWeshopAddress("testtesttest");
        //companyStoreUpdateReqDTO.setWeshopCity("2222");
        //companyStoreUpdateReqDTO.setWeshopProvince("3333");
        //companyStoreUpdateReqDTO.setWeshopZone("4444");
        //companyStoreUpdateReqDTO.setWeshopNotice("warning");
        companyStoreUpdateReqDTO.setWeshopStatus(2);
        companyStoreUpdateReqDTO.setLoginCompId(78211L);
        Result<Boolean> result = companyStoreWriteService.updateCompanyStoreWeshopInfo(companyStoreUpdateReqDTO);
        Boolean module = result.getModule();
        System.out.println(module);
    }

    @Test
    public void testUpdateWeshopCollection(){
        CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO = new CompanyWeshopCollectionReqDTO();
        companyWeshopCollectionReqDTO.setCompId(148L);
        companyWeshopCollectionReqDTO.setOperateType(2);
        companyWeshopCollectionReqDTO.setStoreId(100230149L);
        companyWeshopCollectionReqDTO.setLoginTokenId("testtesttokentoken");
        companyWeshopCollectionReqDTO.setLoginPersonId(123L);

        Result<Boolean> result = companyStoreWriteService.updateWeshopCollection(companyWeshopCollectionReqDTO);
        System.out.println(result.getModule());
    }

    @Test
    public void testAll() throws Exception {
        testUpdateCompanyStoreWeshopInfo();
        testUpdateWeshopCollection();

    }
}