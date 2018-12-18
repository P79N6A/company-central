package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;

/**
 * Created by sunjd on 2018/5/15.
 */
@Deprecated
public class RetailCustomerWriteRpcServiceTest extends BaseTest {
    @Test
    public void addRetailCustomer() throws Exception {
        RetailCustomerWriteRpcService service = getBean("retailCustomerWriteRpcService");
        RetailCustomerAddReqDTO reqDTO = new RetailCustomerAddReqDTO();

        reqDTO.setPartnerName("王大锤");
        reqDTO.setMobile("1820542653");
        reqDTO.setHeadPortraitAddress("头像地址");
        reqDTO.setShoppingGuideId(31L);
        reqDTO.setStoreId(10001L);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        reqDTO.setLoginStoreId(1L);
        reqDTO.setLoginCompId(78214L);
        reqDTO.setCreateTime(new Date());
        reqDTO.setUpdateTime(new Date());

        System.out.println(JSON.toJSONString(reqDTO));
        Result<RetailCustomerAddRespDTO> res = service.addRetailCustomer(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void updateRetailCustomer() throws Exception {
        RetailCustomerWriteRpcService service = getBean("retailCustomerWriteRpcService");
        RetailCustomerUpdateReqDTO reqDTO = new RetailCustomerUpdateReqDTO();

        reqDTO.setPartnerId(72094640001L);
        reqDTO.setPartnerName("王大锤-修改测试");
        reqDTO.setMobile("1820542653");
        reqDTO.setHeadPortraitAddress("头像地址-修改测试");
        reqDTO.setShoppingGuideId(31L);
        reqDTO.setStoreId(10001L);


        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        reqDTO.setLoginStoreId(1L);
        reqDTO.setLoginCompId(1L);

        System.out.println(JSON.toJSONString(reqDTO));
        Result<String> res = service.updateRetailCustomer(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
    @Test
    public void testAll() throws Exception {
        addRetailCustomer();
        updateRetailCustomer();
    }
}