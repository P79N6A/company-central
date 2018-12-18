package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/7.
 */
public class CompanyInfoWithoutLoginQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -2908871133252491688L;

    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 企业简称
     */
    private String compShortName;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }
}
