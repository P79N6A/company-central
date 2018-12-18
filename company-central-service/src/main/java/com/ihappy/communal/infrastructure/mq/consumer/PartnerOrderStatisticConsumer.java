package com.ihappy.communal.infrastructure.mq.consumer;

import com.ihappy.trade.domain.mq.*;

/**
 * Created by sunjd on 2018/8/9
 */
public interface PartnerOrderStatisticConsumer {
    public void updatePartnerStatistics(OrderBuyerCreateMessage message);

    public void updatePartnerStatistics(OrderBuyerPayMessage message);

    public void updatePartnerStatistics(OrderBuyerRefundPayMessage message);

    public void updatePartnerStatistics(OrderSellerPayMessage message);

    public void updatePartnerStatistics(OrderSellerRefundCreateMessage message);
}
