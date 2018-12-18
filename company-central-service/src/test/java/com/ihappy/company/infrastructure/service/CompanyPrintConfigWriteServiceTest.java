package com.ihappy.company.infrastructure.service;

import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoUpdateReqDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-04 20:20
 */
public class CompanyPrintConfigWriteServiceTest extends BaseTest {

    private CompanyPrintConfigWriteService companyPrintConfigWriteService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        companyPrintConfigWriteService = (CompanyPrintConfigWriteService)applicationContext.getBean("companyPrintConfigWriteService");

    }

    @Test
    public void testFindCompanyPrintConfigList(){
        CompanyPrintConfigInfoUpdateReqDTO reqDTO = new CompanyPrintConfigInfoUpdateReqDTO();
        reqDTO.setConfigId(478211L);
        reqDTO.setPrintSize("58mm*30mm");
        reqDTO.setBarCodeTemplateType(0);
        reqDTO.setFirstPrintFlag(0);
        Result<String> result = companyPrintConfigWriteService.updateCompanyPrintConfig(reqDTO);
        System.out.println(result.getModule());
    }

}
