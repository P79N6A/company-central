package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.CancelOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.PassOrFailReviewOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.UpdateOrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.CancelOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.PassOrFailReviewOrderCompanyJournalRespDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.UpdateOrderCompanyJournalRespDTO;
import com.ihappy.store.infrastructure.service.CompanyStoreWriteGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by liuhc on 2018/6/29.
 */
public class OrderCompanyJournalWriteRpcServiceTest extends BaseTest {

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void addOrderCompanyJournalTest() throws Exception {
        CompanyStoreWriteGatewayService companyStoreWriteGatewayService = getBean("companyStoreWriteGatewayService");
        OrderCompanyJournalReqDTO orderCompanyJournalReqDTO = new OrderCompanyJournalReqDTO();
        orderCompanyJournalReqDTO.setCompId(78332L);
        orderCompanyJournalReqDTO.setMemo("测测");
        orderCompanyJournalReqDTO.setPayContent("356填");
        orderCompanyJournalReqDTO.setPayMoney(59900L);
        orderCompanyJournalReqDTO.setPayPersonLogin("aa");
        orderCompanyJournalReqDTO.setPayPersonName("bb");
        orderCompanyJournalReqDTO.setPayTime("2018-07-18 10:34:23");
        orderCompanyJournalReqDTO.setPayTitle("ddd");
        orderCompanyJournalReqDTO.setPayType(1);
        orderCompanyJournalReqDTO.setSourceOrderNo("20180719103423");
        orderCompanyJournalReqDTO.setTaxNo("sssss");
        orderCompanyJournalReqDTO.setLoginPersonId(219L);
        orderCompanyJournalReqDTO.setLoginCompId(-1L);
        orderCompanyJournalReqDTO.setBillFlag(1);
        Result<OrderCompanyJournalRespDTO> res = companyStoreWriteGatewayService.addOrderCompanyJournal(orderCompanyJournalReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
    }


    @Test
    public void updateOrderCompanyJournalTest() throws Exception {
        CompanyStoreWriteGatewayService companyStoreWriteGatewayService = getBean("companyStoreWriteGatewayService");
        UpdateOrderCompanyJournalReqDTO orderCompanyJournalReqDTO = new UpdateOrderCompanyJournalReqDTO();
        orderCompanyJournalReqDTO.setOrderId(30L);
        orderCompanyJournalReqDTO.setCompId(78331L);
        orderCompanyJournalReqDTO.setMemo("测1111测");
        orderCompanyJournalReqDTO.setPayContent("3511116填");
        orderCompanyJournalReqDTO.setPayMoney(59900L);
        orderCompanyJournalReqDTO.setPayPersonLogin("aabb");
        orderCompanyJournalReqDTO.setPayPersonName("bb");
        orderCompanyJournalReqDTO.setPayTime("2018-07-20 10:10:00");
        orderCompanyJournalReqDTO.setPayTitle("sh12345678aabb");
        orderCompanyJournalReqDTO.setPayType(2);
        orderCompanyJournalReqDTO.setSourceOrderNo("FW1807140000301");
        orderCompanyJournalReqDTO.setTaxNo("ssss111111s");
        orderCompanyJournalReqDTO.setLoginPersonId(219L);
        orderCompanyJournalReqDTO.setLoginCompId(-1L);
        orderCompanyJournalReqDTO.setBillFlag(1);
        orderCompanyJournalReqDTO.setVersion(1);
        Result<UpdateOrderCompanyJournalRespDTO> res = companyStoreWriteGatewayService.updateOrderCompanyJournal(orderCompanyJournalReqDTO);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void cancelOrderCompanyJournal() throws Exception {
        CompanyStoreWriteGatewayService companyStoreWriteGatewayService = getBean("companyStoreWriteGatewayService");
        CancelOrderCompanyJournalReqDTO orderCompanyJournalQuery = new CancelOrderCompanyJournalReqDTO();
        orderCompanyJournalQuery.setOrderId(11L);
        orderCompanyJournalQuery.setLoginPersonId(511884L);
        orderCompanyJournalQuery.setLoginCompId(-1L);
        Result<CancelOrderCompanyJournalRespDTO> res = companyStoreWriteGatewayService.cancelOrderCompanyJournal(orderCompanyJournalQuery);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void passReviewOrderTest() throws Exception {
        CompanyStoreWriteGatewayService companyStoreWriteGatewayService = getBean("companyStoreWriteGatewayService");
        PassOrFailReviewOrderCompanyJournalReqDTO passOrFailReviewOrderCompanyJournalReqDTO = new PassOrFailReviewOrderCompanyJournalReqDTO();
        passOrFailReviewOrderCompanyJournalReqDTO.setOrderId(30L);
        passOrFailReviewOrderCompanyJournalReqDTO.setLoginPersonId(511884L);
        passOrFailReviewOrderCompanyJournalReqDTO.setLoginCompId(-1L);
        passOrFailReviewOrderCompanyJournalReqDTO.setVersion(0);
        Result<PassOrFailReviewOrderCompanyJournalRespDTO> res = companyStoreWriteGatewayService.passReviewOrder(passOrFailReviewOrderCompanyJournalReqDTO);
        System.out.println(JSON.toJSONString(res));
    }
}
