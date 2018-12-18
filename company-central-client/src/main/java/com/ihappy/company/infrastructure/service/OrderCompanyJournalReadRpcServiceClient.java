package com.ihappy.company.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalByIdQuery;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by liuhc on 2018/6/28.
 */
@Deprecated
public class OrderCompanyJournalReadRpcServiceClient implements OrderCompanyJournalReadRpcService {

    private OrderCompanyJournalReadRpcService orderCompanyJournalReadRpcService;

    public void setOrderCompanyJournalReadRpcService(OrderCompanyJournalReadRpcService orderCompanyJournalReadRpcService) {
        this.orderCompanyJournalReadRpcService = orderCompanyJournalReadRpcService;
    }


}
