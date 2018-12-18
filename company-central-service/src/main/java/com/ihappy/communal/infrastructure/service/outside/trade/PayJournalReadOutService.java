package com.ihappy.communal.infrastructure.service.outside.trade;

import com.ihappy.company.domain.bo.trade.PayJournalBO;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-27 下午5:02
 */
public interface PayJournalReadOutService {
    /**
        * @Description: 根据主支付流水id查询所有支付流水
        * @Param:
        * @return:
        * @Author: zhangtengpo
        * @Date: 18-8-27 下午5:06
        */
    List<PayJournalBO> queryPayJournalByMainIds(List<Long> mainPayJournalIds);
}
