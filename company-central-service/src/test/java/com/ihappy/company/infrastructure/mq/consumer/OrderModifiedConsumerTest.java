package com.ihappy.company.infrastructure.mq.consumer;

import com.ihappy.BaseTest;
import com.ihappy.communal.infrastructure.mq.consumer.OrderModifiedConsumer;
import com.ihappy.trade.common.constants.OrderConstant;
import com.ihappy.trade.domain.mq.OrderBaseMessage;
import com.ihappy.trade.domain.mq.OrderSellerCancelMessage;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-9-3 下午5:15
 */
public class OrderModifiedConsumerTest extends BaseTest{
    private OrderModifiedConsumer orderModifiedConsumer;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        orderModifiedConsumer = applicationContext.getBean(OrderModifiedConsumer.class);
    }

    @Test
    public void test(){
        OrderSellerCancelMessage orderSellerCancelMessage = new OrderSellerCancelMessage();
        //orderSellerCancelMessage.setRelatedStoreIdList(Collections.singletonList(108080719L));
        orderSellerCancelMessage.setConfirmedAt(20180511155600L);
        orderSellerCancelMessage.setPartnerId(72527668009L);
        orderSellerCancelMessage.setCompId(78009L);
        orderSellerCancelMessage.setOperatorId(511831L);
        OrderBaseMessage.RelatedGoods relatedGoods1 = new OrderBaseMessage.RelatedGoods();
        relatedGoods1.setGoodsId(21492038009L);
        relatedGoods1.setGoodsIdPath("21492038009");
        OrderBaseMessage.RelatedGoods relatedGoods2 = new OrderBaseMessage.RelatedGoods();
        relatedGoods2.setGoodsId(21492058009L);
        relatedGoods2.setGoodsIdPath("21492058009");
        orderSellerCancelMessage.setRelatedGoodsList(Arrays.asList(relatedGoods1));
        orderSellerCancelMessage.setOrderStatus(OrderConstant.CANCEL_ORDER);
        //orderSellerCancelMessage.setRelatedStockIdList(Collections.singletonList(103510389L));
        orderSellerCancelMessage.setRelatedMainPayJournalIdList(Arrays.asList(80001408009L));
        orderSellerCancelMessage.setOrderId(8570389L);
        orderSellerCancelMessage.setOrderType(OrderConstant.ORDER_SELLER);
        orderModifiedConsumer.handleOrderSellerCancelMessage(orderSellerCancelMessage);
    }
}

