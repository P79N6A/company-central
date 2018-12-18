package com.ihappy.communal.infrastructure.mq.consumer.impl;

import com.ihappy.communal.infrastructure.mq.consumer.PartnerOrderStatisticConsumer;
import com.ihappy.communal.infrastructure.service.outside.trade.PayJournalReadOutService;
import com.ihappy.company.domain.bo.trade.PayJournalBO;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.service.inside.PartnerArrearsOrderService;
import com.ihappy.trade.common.constants.PayConstants;
import com.ihappy.trade.domain.mq.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sunjd on 2018/8/9.
 */
public class PartnerOrderStatisticConsumerImpl implements PartnerOrderStatisticConsumer {
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private PayJournalReadOutService payJournalReadOutService;
    @Autowired
    private PartnerArrearsOrderService partnerArrearsOrderService;

    @Override
    public void updatePartnerStatistics(OrderBuyerCreateMessage message) {
        updatePartnerArrears(message.getRelatedMainPayJournalIdList());
        companyPartnerService.updatePartnerStatistics(message);
    }

    @Override
    public void updatePartnerStatistics(OrderBuyerPayMessage message) {
        companyPartnerService.updatePartnerStatistics(message);
    }

    @Override
    public void updatePartnerStatistics(OrderBuyerRefundPayMessage message) {
        companyPartnerService.updatePartnerStatistics(message);
    }

    @Override
    public void updatePartnerStatistics(OrderSellerPayMessage message) {
        companyPartnerService.updatePartnerStatistics(message);
    }

    @Override
    public void updatePartnerStatistics(OrderSellerRefundCreateMessage message) {
        updatePartnerArrears(message.getRelatedMainPayJournalIdList());
        companyPartnerService.updatePartnerStatistics(message);
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
