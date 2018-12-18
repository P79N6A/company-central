package com.ihappy.company.infrastructure.service;

import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyDefaultInformationCheckAndSetServiceTest extends BaseTest {

    private CompanyDefaultInformationCheckAndSetService companyDefaultInformationCheckAndSetService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        companyDefaultInformationCheckAndSetService = (CompanyDefaultInformationCheckAndSetService) applicationContext.getBean("companyDefaultInformationCheckAndSetService");
    }

    @Test
    public void testGenerateDefaultInformation(){
        VoidReqDTO voidReqDTO = new VoidReqDTO();
        Result<String> stringResult = companyDefaultInformationCheckAndSetService.generateDefaultInformation(voidReqDTO);
        System.out.println(stringResult.getModule());
    }

}