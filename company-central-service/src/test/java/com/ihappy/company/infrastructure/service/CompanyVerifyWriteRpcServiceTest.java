package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sunjd on 2018/6/6.
 * PC端企业认证 修改接口 测试类
 */
public class CompanyVerifyWriteRpcServiceTest extends BaseTest {
    @Test
    public void verifyCompanyInfo() throws Exception {
        CompanyVerifyWriteRpcService service = getBean("companyVerifyWriteRpcService");
        CompanyInfoVerifyReqDTO reqDTO = new CompanyInfoVerifyReqDTO();
        reqDTO.setCompId(78118);
        reqDTO.setNature(1);
        reqDTO.setCompShortName("XXXXX");
        reqDTO.setLegalMan("法人");
        reqDTO.setCardFrontUrl("XXX");
        reqDTO.setCardBackUrl("XXX");
        reqDTO.setLicense("XXX");
        reqDTO.setLicensePicurl("XXX");
        reqDTO.setIsVerified(2);

        Result<CompanyInfoVerifyRespDTO> res = service.verifyCompanyInfo(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void addVerifyCompanyInfo() throws Exception {
        CompanyVerifyWriteRpcService service = getBean("companyVerifyWriteRpcService");
        CompanyInfoVerifyAddReqDTO reqDTO = new CompanyInfoVerifyAddReqDTO();
        reqDTO.setCompId(78118);
        reqDTO.setNature(1);
        reqDTO.setCompShortName("XXX");
        reqDTO.setLegalMan("法人");
        reqDTO.setCardFrontUrl("XXX");
        reqDTO.setCardBackUrl("XXX");
        reqDTO.setLicense("XXX");
        reqDTO.setLicensePicurl("XXX");

        Result<CompanyInfoVerifyAddRespDTO> res = service.addVerifyCompanyInfo(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}