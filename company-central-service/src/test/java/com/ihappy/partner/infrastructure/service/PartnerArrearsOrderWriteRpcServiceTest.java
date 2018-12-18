package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.partner.domain.dto.request.partner.PartnerArrearsOrderAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerArrearsOrderAddRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/19.
 */
public class PartnerArrearsOrderWriteRpcServiceTest extends BaseTest {
    @Test
    public void addPartnerArrearsOrder() throws Exception {
        PartnerArrearsOrderWriteRpcService service = getBean("partnerArrearsOrderWriteRpcService");
        PartnerArrearsOrderAddReqDTO reqDTO = new PartnerArrearsOrderAddReqDTO();
        reqDTO.setPartnerId(72533248211L);
        reqDTO.setCompId(78211);
        reqDTO.setCreatedPersonId(511897L);
        reqDTO.setIncomeType(1);
        reqDTO.setMoney(7200L);
        //reqDTO.setOrderNum(UUID.randomUUID().toString().replaceAll("-", ""));
        reqDTO.setOrderNum("80013228211");
        reqDTO.setOrderNo("ZC180917000051");
        reqDTO.setCreatedPersonId(511897L);
        reqDTO.setOrderType(2);
        //reqDTO.setOrderType(1);
        //reqDTO.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        reqDTO.setType(2);

        reqDTO.setCreateTime(new Date());
        reqDTO.setUpdateTime(new Date());
        System.out.println(JSON.toJSONString(reqDTO));
        Result<PartnerArrearsOrderAddRespDTO> res = service.addPartnerArrearsOrder(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
}