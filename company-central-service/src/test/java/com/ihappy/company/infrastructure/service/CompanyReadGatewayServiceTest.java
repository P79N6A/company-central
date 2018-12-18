package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.sys.UpdateStatusReqDTO;
import com.ihappy.company.domain.dto.response.sys.UpdateStatusRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chenying on 2018/11/19.
 */
public class CompanyReadGatewayServiceTest extends BaseTest {
    private CompanyReadGatewayService service;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        service = (CompanyReadGatewayService)applicationContext.getBean("companyReadGatewayService");

    }

    @Test
    public void quereyUpdateStatus() throws Exception {
        UpdateStatusReqDTO reqDTO = new UpdateStatusReqDTO();
        reqDTO.setVersion("1.9");
        reqDTO.setOs("android");
        Result<UpdateStatusRespDTO> res = service.quereyUpdateStatus(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}