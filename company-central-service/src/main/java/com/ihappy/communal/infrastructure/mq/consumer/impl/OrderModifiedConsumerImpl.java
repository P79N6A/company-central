package com.ihappy.communal.infrastructure.mq.consumer.impl;

import com.ihappy.communal.infrastructure.mq.consumer.OrderModifiedConsumer;
import com.ihappy.communal.infrastructure.service.outside.trade.PayJournalReadOutService;
import com.ihappy.communal.infrastructure.service.outside.trade.StatisticsReadService;
import com.ihappy.company.domain.bo.trade.PayJournalBO;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.service.inside.PartnerArrearsOrderService;
import com.ihappy.trade.common.constants.PayConstants;
import com.ihappy.trade.domain.mq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-27 下午4:47
 */
public class OrderModifiedConsumerImpl implements OrderModifiedConsumer {
    @Autowired
    private StatisticsReadService statisticsReadService;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private PayJournalReadOutService payJournalReadOutService;
    @Autowired
    private PartnerArrearsOrderService partnerArrearsOrderService;
    @Autowired
    private TransactionTemplate companyTransactionTemplate;

    @Override
    public void handleOrderSellerModified(OrderSellerModifiedMessage orderSellerModifiedMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderSellerModifiedMessage);
            return true;
        });
    }

    @Override
    public void handleOrderSellerEndMessage(OrderSellerEndMessage orderSellerEndMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderSellerEndMessage);
            return true;
        });
    }

    @Override
    public void handleOrderSellerCancelMessage(OrderSellerCancelMessage orderSellerCancelMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderSellerCancelMessage);
            return true;
        });
    }

    @Override
    public void handleOrderBuyerModified(OrderBuyerModifiedMessage orderBuyerModifiedMessage) {
        companyPartnerService.updatePartnerStatistics(orderBuyerModifiedMessage);
    }

    @Override
    public void handleOrderBuyerCancel(OrderBuyerCancelMessage orderBuyerCancelMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderBuyerCancelMessage);
            return true;
        });
    }

    @Override
    public void handleOrderBuyerEnd(OrderBuyerEndMessage orderBuyerEndMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderBuyerEndMessage);
            return true;
        });
    }

    @Override
    public void handleOrderBuyerRefundCreate(OrderBuyerRefundCreateMessage orderBuyerRefundCreateMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderBuyerRefundCreateMessage);
            return true;
        });
    }

    @Override
    public void handleOrderBuyerRefundCancel(OrderBuyerRefundCancelMessage orderBuyerRefundCancelMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderBuyerRefundCancelMessage);
            return true;
        });
    }

    @Override
    public void handleOrderSellerCreate(OrderSellerCreateMessage orderSellerCreateMessage) {
        // 更新客户欠款预付款
        updatePartnerArrears(orderSellerCreateMessage.getRelatedMainPayJournalIdList());
        companyTransactionTemplate.execute(status -> {
            // 更新客户对账信息
            OrderBaseMessage message = new OrderSellerCancelMessage();
            message.setCompId(orderSellerCreateMessage.getCompId());
            message.setPartnerId(orderSellerCreateMessage.getPartnerId());
            message.setOrderId(orderSellerCreateMessage.getOrderId());
            message.setOrderType(orderSellerCreateMessage.getOrderType());
            companyPartnerService.updatePartnerStatistics(message);
            return true;
        });
    }

    @Override
    public void handleOrderSellerRefundPayMessage(OrderSellerRefundPayMessage orderSellerRefundPayMessage) {
        companyTransactionTemplate.execute(transactionStatus -> {
            handleOrderChange(orderSellerRefundPayMessage);
            return true;
        });
    }

    private void handleOrderChange(OrderBaseMessage orderModifiedMessage) {
        updatePartnerArrears(orderModifiedMessage.getRelatedMainPayJournalIdList());
        // 更新客户对账信息
        companyPartnerService.updatePartnerStatistics(orderModifiedMessage);

    }

    private void updatePartnerArrears(List<Long> relatedMainPayJournalIdList) {
        // 查询所有相关的支付流水
        List<PayJournalBO> payJournalBOS
                = payJournalReadOutService.queryPayJournalByMainIds(relatedMainPayJournalIdList);
        // 过滤出欠款流水和预付款流水
        List<PayJournalBO> debtPayJournals = filterPayJournalByPayType(payJournalBOS, PayConstants.DEBT_PAID);
        List<PayJournalBO> prePaidPayJournals = filterPayJournalByPayType(payJournalBOS, PayConstants.PRE_PAID);
        // 处理流水
        debtPayJournals.stream().forEach(debtPayJournal -> partnerArrearsOrderService.handlePayJournal(debtPayJournal));
        prePaidPayJournals.stream().forEach(prePaidPayJournal -> partnerArrearsOrderService.handlePayJournal(prePaidPayJournal));
    }

    private List<PayJournalBO> filterPayJournalByPayType(List<PayJournalBO> payJournalBOS, int payType) {
        return payJournalBOS.stream().filter(payJournalBO -> payJournalBO.getPayType().equals(payType)).collect(Collectors.toList());
    }
}
