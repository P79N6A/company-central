package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.model.model.CompanyExtendServiceJournalModel;

/**
 * Created by sunjd on 2018/6/28.
 * 公司服务时间延长
 */
public interface CompanyExtendService {
    /**
     *
     * 延长公司服务到期时间,并且生成流水
     * 必需入参
     * compId  公司id
     * orderNo 来源订单号
     * sourceType  来源  0、充值
     * time 延长时间 单位（天）
     * 出参
     * journalId 公司服务延长流水id
     *
     * 注：非事务，调用方需在事务内使用
     */
    Long  addCompanyExtendServiceJournal(CompanyExtendServiceJournalModel model);

    /**
     * 逻辑与 addCompanyExtendServiceJournal 相同，但在方法内部使用事务
     * @param model
     * @return
     */
    Long  addCompanyExtendServiceJournalWithTransaction(CompanyExtendServiceJournalModel model);
}
