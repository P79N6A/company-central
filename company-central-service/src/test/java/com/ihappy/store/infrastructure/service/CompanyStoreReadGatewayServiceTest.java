package com.ihappy.store.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleRight;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.store.domain.dto.response.store.*;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunjd on 2018/8/29.
 */
public class CompanyStoreReadGatewayServiceTest extends BaseTest {

    CompanyStoreReadGatewayService service;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = (CompanyStoreReadGatewayService) applicationContext.getBean("companyStoreReadGatewayService");
    }

    @Test
    public void queryStoreList() throws Exception {
        StoreQueryReqDTO reqDTO = new StoreQueryReqDTO();
        reqDTO.setCompId(78211L);
        reqDTO.setLoginCompId(78211L);
        reqDTO.setIsPublic(1);
        Result<List<StoreQueryRespDTO>> res = service.queryStoreList(reqDTO);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void queryOrderCompanyJournalPage() throws Exception {
        OrderCompanyJournalQuery reqDTO = new OrderCompanyJournalQuery();
        reqDTO.setPayPersonName("lhc0o1");
        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        reqDTO.setLoginCompId(78211L);
        reqDTO.setLoginPersonId(58114L);
        Result<Page<OrderCompanyJournalInfoRespDTO>> res = service.queryOrderCompanyJournalPage(reqDTO);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void queryStoreServiceStatusPage() throws Exception {
        StoreServiceStatusPageQueryReqDTO reqDTO = new StoreServiceStatusPageQueryReqDTO();
        //reqDTO.setRegisterStartTime("2018-10-17");
        //reqDTO.setRegisterEndTime("2018-08-15");
        //reqDTO.setPeriodOfValidity(0);
        //reqDTO.setCompShortName("默认企业(44243");
        reqDTO.setStoreName("20001");
        //reqDTO.setBossMobile("442438");
        //reqDTO.setCtId("1");
        //reqDTO.setExpireStatus(0);
        //reqDTO.setStartDay(0);
        //reqDTO.setEndDay(1);
        //reqDTO.setStatus(1);
        //reqDTO.setStoreId(1L);
        //reqDTO.setCompId(15488485626556565L);
        //reqDTO.setPayRemarkUserId(0L);
        //reqDTO.setPayRemarkUserName("21");
        reqDTO.setPeriodOfValidity(3);

        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        Result<Page<StoreServiceStatusPageQueryRespDTO>> res = service.queryStoreServiceStatusPage(reqDTO);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void queryStorePage() throws Exception {
        StorePageQueryReqDTO reqDTO = new StorePageQueryReqDTO();
        //reqDTO.setRegisterStartTime("2018-10-17");
        //reqDTO.setRegisterEndTime("2018-08-15");
        //reqDTO.setPeriodOfValidity(0);
        //reqDTO.setCompShortName("默认企业(44243");
        //reqDTO.setStoreName("3184628002");
        //reqDTO.setBossMobile("442438");
        //reqDTO.setCtId("1");
        //reqDTO.setExpireStatus(0);
        //reqDTO.setStartDay(0);
        //reqDTO.setEndDay(1);
        //reqDTO.setStatus(1);
        //reqDTO.setStoreId(1L);
        //reqDTO.setCompId(15488485626556565L);
        //reqDTO.setCtIds("3");
        //reqDTO.setCompId(78211L);

        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        Result<Page<StorePageQueryRespDTO>> res = service.queryStorePage(reqDTO);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void queryPersonPerformancePage() throws Exception {
        PersonPerformanceReqDTO reqDTO = new PersonPerformanceReqDTO();
        reqDTO.setLoginCompId(2840L);
        reqDTO.setYearMonth("2018-11");
        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        reqDTO.setStoreId(378252840L);
        reqDTO.setLoginPersonId(140443L);
        Result<Page<PersonPerformanceRespDTO>> res = service.queryPersonPerformancePage(reqDTO);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void queryPerformancePage() throws Exception {
        StorePerformanceReqDTO reqDTO = new StorePerformanceReqDTO();
        reqDTO.setLoginCompId(2846L);
        reqDTO.setYearMonth("2018-12");
        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        reqDTO.setLoginPersonId(140465L);
        Result<Page<StorePerformanceRespDTO>> res = service.queryStorePerformancePage(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 企业用户查询门店详情 -- 测试通过
     */
    @Test
    public void findStoreInfo() throws Exception {
        CompanyStroreInfoQueryReqDTO companyStroreInfoQueryReqDTO=new CompanyStroreInfoQueryReqDTO();
        companyStroreInfoQueryReqDTO.setLoginCompId(78002L);
        companyStroreInfoQueryReqDTO.setLoginPersonId(511897L);
        companyStroreInfoQueryReqDTO.setStoreId(3186838002L);
        System.out.println(JSON.toJSONString(service.findStoreInfo(companyStroreInfoQueryReqDTO)));
    }
    /**
     * 企业用户查询门店列表O
     */
    @Test
    public void findStoreList()throws Exception{
        StoreListQueryReqDTO storeListQueryReqDTO=new StoreListQueryReqDTO();
        storeListQueryReqDTO.setLoginCompId(78002L);
        storeListQueryReqDTO.setLoginPersonId(511703L);
        long startTime = System.currentTimeMillis();
        System.out.println(JSON.toJSONString(service.findStoreList(storeListQueryReqDTO)));
        printResult(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testAll() throws Exception {
        queryPersonPerformancePage();
        queryPerformancePage();
        findStoreInfo();
        findStoreList();
    }

    public static void main(String[] args) {
       String text = "[{\"clId\":2,\"ctId\":1,\"func\":\"2,3,4,5,6,7,14,15,16,17,18,20,22,23,24,25,26,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,183,191,213,216,219,222,224\"},{\"clId\":2,\"ctId\":2,\"func\":\"65,66,67,68,73,75,76,77,78,79,80,82,83,84,85,86,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,184,192,214,217,220,223,225\"},{\"clId\":2,\"ctId\":3,\"func\":\"124,125,126,127,132,134,135,136,137,138,139,146,147,148,149,150,151,153,154,155,156,157,158,159,160,161,162,163,164,165,166,168,169,170,171,172,173,174,175,176,177,178,179,180,182,185,186,187,188,194,195,215,218,221,226,227\"}]";

        JSON.parseArray(text, CompanyRoleRight.class);
        String text1 = "[{\"clId\":\"2\",\"ctId\":\"1\",\"func\":\"2,3,4,5,6,7,14,15,16,17,18,20,22,23,24,25,26,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,183,191,213,216,219,222,224\"},{\"clId\":2,\"ctId\":2,\"func\":\"65,66,67,68,73,75,76,77,78,79,80,82,83,84,85,86,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,184,192,214,217,220,223,225\"},{\"clId\":2,\"ctId\":3,\"func\":\"124,125,126,127,132,134,135,136,137,138,139,146,147,148,149,150,151,153,154,155,156,157,158,159,160,161,162,163,164,165,166,168,169,170,171,172,173,174,175,176,177,178,179,180,182,185,186,187,188,194,195,215,218,221,226,227\"}]";

         JSON.parseArray(text1, CompanyRoleRight.class);
    }
}