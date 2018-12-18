package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalByIdQuery;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.store.infrastructure.service.CompanyStoreReadGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by chenying on 2018/6/29.
 */
public class OrderCompanyJournalReadRpcServiceTest extends BaseTest {

    @Test
    public void queryOrderCompanyJournalPage() throws Exception {
        CompanyStoreReadGatewayService companyStoreReadGatewayService = getBean("companyStoreReadGatewayService");
        OrderCompanyJournalQuery orderCompanyJournalQuery = new OrderCompanyJournalQuery();
//        orderCompanyJournalQuery.setPayType(1);
        //orderCompanyJournalQuery.setMomoPersonId(219L);
//        orderCompanyJournalQuery.setCompId(1L);
//        orderCompanyJournalQuery.setPayPersonName("bb");
//        orderCompanyJournalQuery.setPayTimeStart("2018-06-28");
//        orderCompanyJournalQuery.setPayTimeEnd("2018-06-28");
        orderCompanyJournalQuery.setLoginPersonId(511884L);
        orderCompanyJournalQuery.setLoginCompId(-1L);
//        orderCompanyJournalQuery.setAssessorPersonId(511884L);
        orderCompanyJournalQuery.setAuditorName("cy");
        orderCompanyJournalQuery.setLimit(10);
        orderCompanyJournalQuery.setOffset(0);
        Result<Page<OrderCompanyJournalInfoRespDTO>> res = companyStoreReadGatewayService.queryOrderCompanyJournalPage(orderCompanyJournalQuery);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
    }


    @Test
    public void queryOrderCompanyJournalDetail() throws Exception {
        CompanyStoreReadGatewayService companyStoreReadGatewayService = getBean("companyStoreReadGatewayService");
        OrderCompanyJournalByIdQuery orderCompanyJournalQuery = new OrderCompanyJournalByIdQuery();
        orderCompanyJournalQuery.setOrderId(11L);
        orderCompanyJournalQuery.setLoginPersonId(511884L);
        orderCompanyJournalQuery.setLoginCompId(-1L);
        Result<OrderCompanyJournalInfoRespDTO> res = companyStoreReadGatewayService.queryOrderCompanyJournalDetail(orderCompanyJournalQuery);
        System.out.println(JSON.toJSONString(res));
    }
}