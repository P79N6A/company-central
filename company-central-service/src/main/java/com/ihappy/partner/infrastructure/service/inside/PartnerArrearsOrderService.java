package com.ihappy.partner.infrastructure.service.inside;

import com.ihappy.company.domain.bo.trade.PayJournalBO;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;

/**
 * Created by sunjd on 2018/4/18.
 * 事务开始
 * 1.插入订单流水
 * 2.更新Partner欠款
 * 事务结束
 * 3.返回订单id
 */
public interface PartnerArrearsOrderService {

    Long addPartnerArrearsOrder(PartnerArrearsOrderModel model);
    /**
        * @Description: 处理支付流水
        * @Param:
        * @return:
        * @Author: zhangtengpo
        * @Date: 18-8-27 下午5:43
        */
    Boolean handlePayJournal(PayJournalBO payJournalBO);
}
