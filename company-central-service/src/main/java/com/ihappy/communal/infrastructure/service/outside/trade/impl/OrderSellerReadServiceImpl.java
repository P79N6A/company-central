package com.ihappy.communal.infrastructure.service.outside.trade.impl;

import com.ihappy.communal.infrastructure.service.outside.trade.OrderSellerReadService;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.trade.domain.dto.request.order.LastConsumeOrderQueryReqDTO;
import com.ihappy.trade.domain.dto.request.order.OrderPerformanceQueryReqDTO;
import com.ihappy.trade.domain.dto.response.order.LastConsumeOrderQueryRespDTO;
import com.ihappy.trade.domain.dto.response.order.OrderPerformanceQueryRespDTO;
import com.ihappy.trade.service.order.OrderSellerReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/8/29.
 */
public class OrderSellerReadServiceImpl implements OrderSellerReadService {
    private Logger logger = CompanyLoggerUtil.getLogger();

    @Autowired
    private OrderSellerReadRpcService orderSellerReadRpcService;
    @Override
    public List<OrderPerformanceQueryRespDTO> queryStorePerformance(OrderPerformanceQueryReqDTO reqDTO) {
        Result<List<OrderPerformanceQueryRespDTO>> res = orderSellerReadRpcService.queryStorePerformance(reqDTO);
        if(res.isSuccess() && res.getModule() != null){
            return res.getModule();
        }
        return null;
    }

    @Override
    public LastConsumeOrderQueryRespDTO queryLastConsumeRetailOrder(LastConsumeOrderQueryReqDTO lastConsumeOrderQueryReqDTO) {
        try {
            Result<LastConsumeOrderQueryRespDTO> respDTOResult =
                    orderSellerReadRpcService.queryLastConsumeRetailOrder(lastConsumeOrderQueryReqDTO);
            if (respDTOResult.isSuccess() && respDTOResult.getModule() != null) {
                return respDTOResult.getModule();
            }
        } catch (Exception e) {
            logger.error("OrderSellerReadServiceImpl::queryLastConsumeRetailOrder外部服务调用失败", e);
        }
        return null;
    }
}
