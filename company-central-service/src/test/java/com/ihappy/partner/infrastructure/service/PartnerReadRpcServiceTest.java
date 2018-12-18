package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunjd on 2018/4/3.
 */
public class PartnerReadRpcServiceTest extends BaseTest {
    @Test
    public void findPartnerList() throws Exception {
        PartnerReadRpcService service = getBean("partnerReadRpcService");
        PartnerListQueryReqDTO reqDTO = new PartnerListQueryReqDTO();
        reqDTO.setPartnerType(1);
        reqDTO.setIsDefault(1);
        reqDTO.setLoginCompId(78211L);
        Result<List<PartnerInfoQueryRespDTO>> res = service.findPartnerList(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findDefaultPartner() throws Exception {
        PartnerReadRpcService service = getBean("partnerReadRpcService");
        PartnerDefQueryReqDTO reqDTO = new PartnerDefQueryReqDTO();
        reqDTO.setPartnerType(1);
        reqDTO.setLoginCompId(78213L);
        reqDTO.setType(1);
        Result<PartnerInfoQueryRespDTO> res = service.findDefaultPartner(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findPartnerPage() throws Exception {
        PartnerReadRpcService service = getBean("partnerReadRpcService");
        PartnerPageReqDTO reqDTO = new PartnerPageReqDTO();
        reqDTO.setPartnerType(1);
        reqDTO.setLoginCompId(78211L);
        reqDTO.setOrder("total_number");
        reqDTO.setSort("asc");
        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        Result<Page<PartnerInfoQueryRespDTO>> res = service.findPartnerPage(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findPartnerStatistics() throws Exception {
        PartnerReadRpcService service = getBean("partnerReadRpcService");
        PartnerStatisticsReqDTO reqDTO = new PartnerStatisticsReqDTO();
        reqDTO.setPartnerType(1);
        reqDTO.setLoginCompId(78211L);
        reqDTO.setSearchStr("大风车");
        Result<PartnerStatisticsRespDTO> res = service.findPartnerStatistics(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findPartner() throws Exception {
        PartnerReadRpcService service = getBean("partnerReadRpcService");
        PartnerInfoQueryReqDTO partnerInfoQueryReqDTO = new PartnerInfoQueryReqDTO();
        partnerInfoQueryReqDTO.setPartnerId(370162L);
        Result<PartnerInfoQueryRespDTO> res = service.findPartner(partnerInfoQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 解决 renyl修改 sharding-jdbc 源码支持 or
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findProviderList() throws Exception {
        PartnerReadRpcService partnerReadRpcService = getBean("partnerReadRpcService");
        ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO = new ProviderInfoListQueryReqDTO();
        //providerInfoListQueryReqDTO.setSearchStr("");
        providerInfoListQueryReqDTO.setOverstriking(true);
        providerInfoListQueryReqDTO.setLoginCompId(1L);
        //providerInfoListQueryReqDTO.setIsDefault(0);

        Result<List<ProviderInfoListQueryRespDTO>> res = partnerReadRpcService.findProviderList(providerInfoListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     *单元测试通过
     * @throws Exception
     */
    @Test
    public void findProvider() throws Exception {
        PartnerReadRpcService partnerReadRpcService = getBean("partnerReadRpcService");
        ProviderInfoQueryReqDTO providerInfoQueryReqDTO = new ProviderInfoQueryReqDTO();
        providerInfoQueryReqDTO.setPartnerId(70711960278L);
        Result<ProviderInfoQueryRespDTO> res = partnerReadRpcService.findProvider(providerInfoQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findCustomerList() throws Exception {
        PartnerReadRpcService partnerReadRpcService = getBean("partnerReadRpcService");
        CustomerInfoListQueryReqDTO customerInfoListQueryReqDTO = new CustomerInfoListQueryReqDTO();
        //customerInfoListQueryReqDTO.setSearchStr("散客");
        //customerInfoListQueryReqDTO.setOverstriking(true);
        customerInfoListQueryReqDTO.setLoginCompId(1L);
        customerInfoListQueryReqDTO.setSearchStr("dsfd");
        //customerInfoListQueryReqDTO.setIsDefault(0);


        Result<List<CustomerInfoListQueryRespDTO>> res = partnerReadRpcService.findCustomerList(customerInfoListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findCustomer() throws Exception {
        PartnerReadRpcService partnerReadRpcService = getBean("partnerReadRpcService");
        CustomerInfoQueryReqDTO customerInfoQueryReqDTO = new CustomerInfoQueryReqDTO();
        customerInfoQueryReqDTO.setPartnerId(570090L);
        Result<CustomerInfoQueryRespDTO> res = partnerReadRpcService.findCustomer(customerInfoQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findDefProviderList() throws Exception {
        PartnerReadRpcService partnerReadRpcService = getBean("partnerReadRpcService");
        DefProviderListQueryReqDTO defProviderListQueryReqDTO = new DefProviderListQueryReqDTO();
        defProviderListQueryReqDTO.setLoginCompId(278L);

        Result<DefProviderListQueryRespDTO> res = partnerReadRpcService.findDefProviderList(defProviderListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findDefCustomerList() throws Exception {
        PartnerReadRpcService partnerReadRpcService = getBean("partnerReadRpcService");
        DefCustomerListQueryReqDTO defCustomerListQueryReqDTO = new DefCustomerListQueryReqDTO();
        defCustomerListQueryReqDTO.setLoginCompId(78211L);

        Result<DefCustomerListQueryRespDTO> res = partnerReadRpcService.findDefCustomerList(defCustomerListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }


    public static void main(String[] args) {
        Long dueAmount = Long.valueOf(2800000+567900+391100+270000+190000+24000+20000);
        Long onthewayNumber = Long.valueOf(53+2+40+4);
        Long partnerArrears = Long.valueOf(-122800+176400+113300-10000+10000);
        System.out.println("dueAmount = "+dueAmount);
        System.out.println("onthewayNumber = "+onthewayNumber);
        System.out.println("partnerArrears = "+partnerArrears);
    }

    @Test
    public void testAll() throws Exception {
        System.out.println("findDefaultPartner");
        findDefaultPartner();
        System.out.println("findPartnerPage");
        findPartnerPage();
        System.out.println("findPartnerStatistics");
        findPartnerStatistics();
        System.out.println("findPartner");
        findPartner();
        System.out.println("findProviderList");
        findProviderList();
        System.out.println("findProvider");
        findProvider();
        System.out.println("findCustomerList");
        findCustomerList();
        System.out.println("findCustomer");
        findCustomer();
        System.out.println("findDefProviderList");
        findDefProviderList();
        System.out.println("findDefCustomerList");
        findDefCustomerList();
    }
}