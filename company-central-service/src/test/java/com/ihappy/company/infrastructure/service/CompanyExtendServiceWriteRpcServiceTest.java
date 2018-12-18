package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by sunjd on 2018/6/28.
 */
public class CompanyExtendServiceWriteRpcServiceTest extends BaseTest {
    @Test
    public void addCompanyExtendServiceJournal() throws Exception {
        CompanyExtendServiceWriteRpcService service = getBean("companyExtendServiceWriteRpcService");
        CompanyExtendServiceAddReqDTO reqDTO = new CompanyExtendServiceAddReqDTO();
        reqDTO.setMoney(100L);
        reqDTO.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        //reqDTO.setOrderNo("eadb52012a17438eabed0bb164f55a96");
        reqDTO.setOrderType("充值");
        reqDTO.setTime(365);
        reqDTO.setSourceType(0);
        reqDTO.setCompId(1);
        reqDTO.setFundStatus(2);

        Result<CompanyExtendServiceAddRespDTO> res = service.addCompanyExtendServiceJournal(reqDTO);
        reqDTO.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        res = service.addCompanyExtendServiceJournal(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}