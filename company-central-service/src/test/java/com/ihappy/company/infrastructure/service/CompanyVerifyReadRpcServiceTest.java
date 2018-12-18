package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyVerifyReadRpcServiceTest extends BaseTest {
    @Test
    public void findVerifyCompanyInfo() throws Exception {
        CompanyVerifyReadRpcService service = getBean("companyVerifyReadRpcService");
        CompanyInfoVerifyReadReqDTO reqDTO = new CompanyInfoVerifyReadReqDTO();
        reqDTO.setCompId(1);

        Result<CompanyInfoVerifyReadRespDTO> res = service.findVerifyCompanyInfo(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}