package com.ihappy.communal.infrastructure.service.outside.trade;

import com.ihappy.trade.domain.dto.request.pay.AddPayJournalReqDTO;

/**
 * Created by liuhc on 2018/6/30.
 */
public interface PayJournalWriteOutService {

    String addPayJourna(AddPayJournalReqDTO addPayJournalReqDTO);
}
