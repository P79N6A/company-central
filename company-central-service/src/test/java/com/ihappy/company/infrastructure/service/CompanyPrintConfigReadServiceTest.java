package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigInfoRespDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigListRespDTO;
import com.ihappy.company.infrastructure.service.inside.CompanyPrintConfigService;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-04 20:20
 */
public class CompanyPrintConfigReadServiceTest extends BaseTest {

    private CompanyPrintConfigReadService companyPrintConfigReadService;

    private CompanyPrintConfigService companyPrintConfigService;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        companyPrintConfigReadService = (CompanyPrintConfigReadService)applicationContext.getBean("companyPrintConfigReadService");
        companyPrintConfigService = (CompanyPrintConfigService)applicationContext.getBean("companyPrintConfigService");
    }

    @Test
    public void testFindCompanyPrintConfigList(){
        CompanyPrintConfigListQueryReqDTO reqDTO = new CompanyPrintConfigListQueryReqDTO();
        reqDTO.setCompId(78213L);
        Result<List<CompanyPrintConfigListRespDTO>> result = companyPrintConfigReadService.findCompanyPrintConfigList(reqDTO);
        System.out.println(JSON.toJSON(result.getModule()));
    }

    @Test
    public void testFindCompanyPrintConfigInfo(){
        CompanyPrintConfigInfoQueryReqDTO companyPrintConfigInfoQueryReqDTO = new CompanyPrintConfigInfoQueryReqDTO();
        companyPrintConfigInfoQueryReqDTO.setBillType(0);
        companyPrintConfigInfoQueryReqDTO.setBillTypeCode(500);
        //companyPrintConfigInfoQueryReqDTO.setCompId(109);
        companyPrintConfigInfoQueryReqDTO.setLoginCompId(78213L);
//        companyPrintConfigInfoQueryReqDTO.setLoginPersonId(219L);
        Result<CompanyPrintConfigInfoRespDTO> res = companyPrintConfigReadService.findCompanyPrintConfigInfo(companyPrintConfigInfoQueryReqDTO);
        System.out.println(JSON.toJSON(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }


}
