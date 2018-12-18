package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/5/15.
 */
@Deprecated
public class RetailCustomerReadRpcServiceTest extends BaseTest {
    @Test
    public void findRetailCustomer() throws Exception {
        RetailCustomerReadRpcService service = getBean("retailCustomerReadRpcService");
        RetailCustomerQueryReqDTO reqDTO = new RetailCustomerQueryReqDTO();
        reqDTO.setPartnerId(72094640001L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        reqDTO.setLoginStoreId(1L);
        reqDTO.setLoginCompId(1L);

        System.out.println(JSON.toJSONString(reqDTO));
        Result<RetailCustomerQueryRespDTO> res = service.findRetailCustomer(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findRetailCustomerPage() throws Exception {
        RetailCustomerReadRpcService service = getBean("retailCustomerReadRpcService");
        RetailCustomerQueryPageReqDTO reqDTO = new RetailCustomerQueryPageReqDTO();
       // reqDTO.setOverstriking(true);
        //reqDTO.setSearchStr("cs");
        reqDTO.setOffset(0);
        reqDTO.setLimit(10);

        System.out.println(JSON.toJSONString(reqDTO));
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(512037L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        reqDTO.setLoginStoreId(1L);
        reqDTO.setLoginCompId(78324L);
        reqDTO.setLoginPersonId(512037L);
        //reqDTO.setFilterByUserRole(true);
        //reqDTO.setIsDefault(1);

        Result<Page<RetailCustomerQueryPageRespDTO>> res = service.findRetailCustomerPage(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
    @Test
    public void testAll() throws Exception {
        findRetailCustomer();
        findRetailCustomerPage();
    }
}