package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/28.
 */
public class CompanyExtendServiceAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 3858141471558513387L;
    /**
     * 公司服务延长流水id
     */
    private Long journalId;

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }
}
