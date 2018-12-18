package com.ihappy.company.infrastructure.mq.consumer;

import com.ihappy.BaseTest;
import com.ihappy.communal.infrastructure.mq.consumer.OrderModifiedConsumer;
import com.ihappy.communal.infrastructure.mq.consumer.PartnerOrderStatisticConsumer;
import com.ihappy.trade.domain.mq.OrderSellerPayMessage;
import org.junit.Test;

/**
 * Created by sunjd on 2018/8/11.
 */
public class PartnerOrderStatisticConsumerTest extends BaseTest {
    PartnerOrderStatisticConsumer partnerOrderStatisticConsumer;
    OrderModifiedConsumer orderModifiedConsumer;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        partnerOrderStatisticConsumer = (PartnerOrderStatisticConsumer) applicationContext.getBean("partnerOrderStatisticConsumer");
        orderModifiedConsumer = (OrderModifiedConsumer) applicationContext.getBean("orderModifiedConsumer");
    }
    @Test
    public void updatePartnerStatistics() throws Exception {
        String str = "{\"relatedGoodsList\":[{\"goodsId\":21513458211,\"goodsIdPath\":\"21513458211\"}],\"relatedStoreAndStockList\":[{\"storeId\":3181198211,\"stockId\":682658211}],\"relatedMainPayJournalIdList\":[81028398211],\"orderId\":27029558211,\"orderType\":1,\"orderStatus\":2,\"operatorId\":511897,\"compId\":78211,\"partnerId\":72538158211,\"confirmedAt\":20181024143403}";
        //OrderBuyerPayMessage orderBuyerPayMessage = JSON.parseObject(str, OrderBuyerPayMessage.class);
        OrderSellerPayMessage orderBuyerPayMessage = new OrderSellerPayMessage();
        orderBuyerPayMessage.setPartnerId(74101918211L);
        orderBuyerPayMessage.setOrderType(3);
        orderBuyerPayMessage.setCompId(78211L);
        partnerOrderStatisticConsumer.updatePartnerStatistics(orderBuyerPayMessage);
        Thread.sleep(30000);
    }
}