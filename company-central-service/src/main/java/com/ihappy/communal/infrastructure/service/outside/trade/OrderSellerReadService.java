package com.ihappy.communal.infrastructure.service.outside.trade;

import com.ihappy.trade.domain.dto.request.order.LastConsumeOrderQueryReqDTO;
import com.ihappy.trade.domain.dto.request.order.OrderPerformanceQueryReqDTO;
import com.ihappy.trade.domain.dto.response.order.LastConsumeOrderQueryRespDTO;
import com.ihappy.trade.domain.dto.response.order.OrderPerformanceQueryRespDTO;
import reactor.util.annotation.Nullable;

import java.util.List;

/**
 * Created by sunjd on 2018/8/29.
 */
public interface OrderSellerReadService {
    List<OrderPerformanceQueryRespDTO> queryStorePerformance(OrderPerformanceQueryReqDTO reqDTO);

    @Nullable LastConsumeOrderQueryRespDTO queryLastConsumeRetailOrder(LastConsumeOrderQueryReqDTO lastConsumeOrderQueryReqDTO);
}
