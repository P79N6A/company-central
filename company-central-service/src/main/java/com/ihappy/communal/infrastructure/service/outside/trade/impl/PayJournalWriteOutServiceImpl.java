package com.ihappy.communal.infrastructure.service.outside.trade.impl;

import com.ihappy.communal.infrastructure.service.outside.trade.PayJournalWriteOutService;
import com.ihappy.trade.service.trade.PayJournalWriteRpcService;
import com.ihappy.trade.domain.dto.request.pay.AddPayJournalReqDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuhc on 2018/6/30.
 */
public class PayJournalWriteOutServiceImpl implements PayJournalWriteOutService {

    @Autowired
    private PayJournalWriteRpcService payJournalWriteRpcServiceClient;

    @Override
    public String addPayJourna(AddPayJournalReqDTO addPayJournalReqDTO) {
        payJournalWriteRpcServiceClient.addPayJournal(addPayJournalReqDTO);
        return null;
    }
}
