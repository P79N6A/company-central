package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.partner.domain.dto.request.partner.PartnerLastContactTimeReqDTO;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoInsideAddRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/4/20.
 */
public class PartnerWriteInsideRpcServiceTest extends BaseTest {
    @Test
    public void lastContactTime() throws Exception {
        PartnerWriteInsideRpcService partnerWriteInsideRpcService = getBean("partnerWriteInsideRpcService");
        PartnerLastContactTimeReqDTO reqDTO = new PartnerLastContactTimeReqDTO();
        reqDTO.setCompId(90);
        reqDTO.setPartnerId(570090L);
        reqDTO.setLastContactTime(201804201507L);
        Result<String> res = partnerWriteInsideRpcService.lastContactTime(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void addOrQueryProvider() throws Exception {
        PartnerWriteInsideRpcService partnerWriteInsideRpcService = getBean("partnerWriteInsideRpcService");
        ProviderInfoInsideAddReqDTO reqDTO = new ProviderInfoInsideAddReqDTO();
        reqDTO.setBuyerCompId(78213);
        reqDTO.setCreatedPersonId(511899L);
        reqDTO.setPartnerCompId(78211);
        reqDTO.setPartnerName("");
        reqDTO.setPartnerType(0);
        //reqDTO.setPartnerLinkman("联系人");
        //reqDTO.setMobile("18205245625");
        Result<ProviderInfoInsideAddRespDTO> res = partnerWriteInsideRpcService.addOrQueryProvider(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        lastContactTime();
        addOrQueryProvider();
    }
}