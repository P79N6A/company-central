package com.ihappy.communal.infrastructure.service.outside.trade.impl;

import com.ihappy.communal.infrastructure.service.outside.trade.PayJournalReadOutService;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.domain.bo.trade.PayJournalBO;
import com.ihappy.trade.domain.dto.request.pay.PayJournalQueryByMainIdReqDTO;
import com.ihappy.trade.domain.dto.response.pay.PayJournalQueryByMainIdRespDTO;
import com.ihappy.trade.service.trade.PayJournalReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-27 下午5:03
 */
public class PayJournalReadOutServiceImpl implements PayJournalReadOutService {
    @Autowired
    private PayJournalReadRpcService payJournalReadRpcService;

    @Override
    public List<PayJournalBO> queryPayJournalByMainIds(List<Long> mainPayJournalIds) {
        if(CollectionUtil.isEmpty(mainPayJournalIds)){
            return new ArrayList<>();
        }
        PayJournalQueryByMainIdReqDTO payJournalQueryByMainIdReqDTO = new PayJournalQueryByMainIdReqDTO();
        payJournalQueryByMainIdReqDTO.setMainPayJournalIdList(mainPayJournalIds);
        Result<List<PayJournalQueryByMainIdRespDTO>> result = payJournalReadRpcService.queryPayJournalByMainJournal(payJournalQueryByMainIdReqDTO);
        if(result == null || !result.isSuccess()){
            return null;
        }
        List<PayJournalBO> payJournalBOList = result.getModule().stream().map(payJournalQueryByMainIdRespDTO -> {
            PayJournalBO payJournalBO = new PayJournalBO();
            payJournalBO.setIsDeleted(payJournalQueryByMainIdRespDTO.getIsDeleted());
            payJournalBO.setCreatedPersonId(payJournalQueryByMainIdRespDTO.getCreatedPersonId());
            payJournalBO.setUpdatedPersonId(payJournalQueryByMainIdRespDTO.getUpdatedPersonId());
            payJournalBO.setOrderNo(payJournalQueryByMainIdRespDTO.getOrderNo());
            payJournalBO.setOrderId(payJournalQueryByMainIdRespDTO.getOrderId());
            payJournalBO.setOrderType(payJournalQueryByMainIdRespDTO.getOrderType());
            payJournalBO.setFundType(payJournalQueryByMainIdRespDTO.getFundStatus());
            payJournalBO.setMainPayJournalId(payJournalQueryByMainIdRespDTO.getMainPayJournalId());
            payJournalBO.setPayJournalId(payJournalQueryByMainIdRespDTO.getPayJournalId());
            payJournalBO.setPayType(payJournalQueryByMainIdRespDTO.getPayType());
            payJournalBO.setPayAmount(payJournalQueryByMainIdRespDTO.getPayAmount());
            payJournalBO.setCompId(payJournalQueryByMainIdRespDTO.getCompId());
            payJournalBO.setPartnerId(payJournalQueryByMainIdRespDTO.getPartnerId());
            return payJournalBO;
        }).collect(Collectors.toList());
        return payJournalBOList;
    }
}
