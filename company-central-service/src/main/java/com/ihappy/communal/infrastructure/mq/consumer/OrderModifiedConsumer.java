package com.ihappy.communal.infrastructure.mq.consumer;

import com.ihappy.trade.domain.mq.*;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-27 下午4:47
 */
public interface OrderModifiedConsumer {
    /**
     * @Description: 处理销售单编辑消息
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 18-8-27 下午4:48
     */
    void handleOrderSellerModified(OrderSellerModifiedMessage orderSellerModifiedMessage);

    /**
     * @Description: 销售单终结消息消费者
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 18-9-1 下午6:10
     */
    void handleOrderSellerEndMessage(OrderSellerEndMessage orderSellerEndMessage);

    /**
     * @Description: 销售单作废消息消费者
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 18-9-1 下午6:09
     */
    void handleOrderSellerCancelMessage(OrderSellerCancelMessage orderSellerCancelMessage);

    /**
     * @Description: 处理采购单编辑消息
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 18-8-27 下午4:48
     */
    void handleOrderBuyerModified(OrderBuyerModifiedMessage orderBuyerModifiedMessage);

    /**
     * 处理采购单作废消息
     *
     * @param orderBuyerCancelMessage
     */
    void handleOrderBuyerCancel(OrderBuyerCancelMessage orderBuyerCancelMessage);

    /**
     * 处理采购单终结消息
     *
     * @param orderBuyerEndMessage
     */
    void handleOrderBuyerEnd(OrderBuyerEndMessage orderBuyerEndMessage);

    /**
     * 处理采购退货单创建消息
     *
     * @param orderBuyerRefundCreateMessage
     */
    void handleOrderBuyerRefundCreate(OrderBuyerRefundCreateMessage orderBuyerRefundCreateMessage);

    /**
     * 处理采购退货单作废消息
     *
     * @param orderBuyerRefundCancelMessage
     */
    void handleOrderBuyerRefundCancel(OrderBuyerRefundCancelMessage orderBuyerRefundCancelMessage);

    /**
     * @Description: 销售单创建消费者
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 18-9-6 上午10:55
     */
    void handleOrderSellerCreate(OrderSellerCreateMessage orderSellerCreateMessage);

    /**
     * 零售退货消息消费者
     */
    void handleOrderSellerRefundPayMessage(OrderSellerRefundPayMessage orderSellerRefundPayMessage);
}
