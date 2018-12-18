package com.ihappy.communal.infrastructure.service.outside.trade;

import com.ihappy.trade.domain.dto.request.order.OrderStatisticReqDTO;
import com.ihappy.trade.domain.dto.response.order.OrderStatisticRespDTO;

/**
 * Created by sunjd on 2018/8/9.
 */
public interface StatisticsReadService {

    OrderStatisticRespDTO queryOrderStatisticsByPartner(OrderStatisticReqDTO reqDTO);
}
