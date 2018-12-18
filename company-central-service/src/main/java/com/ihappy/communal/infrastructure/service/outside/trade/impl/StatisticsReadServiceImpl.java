package com.ihappy.communal.infrastructure.service.outside.trade.impl;

import com.ihappy.communal.infrastructure.service.outside.trade.StatisticsReadService;
import com.ihappy.trade.domain.dto.request.order.OrderStatisticReqDTO;
import com.ihappy.trade.domain.dto.response.order.OrderStatisticRespDTO;
import com.ihappy.trade.service.order.StatisticsReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/8/9.
 */
public class StatisticsReadServiceImpl implements StatisticsReadService {
    @Autowired
    private StatisticsReadRpcService statisticsReadRpcServiceClient;
    @Override
    public OrderStatisticRespDTO queryOrderStatisticsByPartner(OrderStatisticReqDTO reqDTO) {
        Result<OrderStatisticRespDTO> res = statisticsReadRpcServiceClient.queryOrderStatisticsByPartner(reqDTO);
        return res.getModule();
    }
}
