package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyInfoAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 6348573610332120185L;
    /**
     * 企业id
     */
    private Integer compId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
