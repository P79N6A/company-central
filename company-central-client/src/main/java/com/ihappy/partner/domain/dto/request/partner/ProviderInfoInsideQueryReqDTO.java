package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by Administrator on 2018/5/7.
 */
public class ProviderInfoInsideQueryReqDTO extends ICallRequestBaseQuery {

    private static final long serialVersionUID = 1385832999388574065L;

    /**
     * 企业id
     */
    private Integer compId;

    /**
     * 合伙人企业id
     */
    private Integer partnerCompId;

    /**
     * 0、供应商 1、客户
     */
    private Integer partnerType;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getPartnerCompId() {
        return partnerCompId;
    }

    public void setPartnerCompId(Integer partnerCompId) {
        this.partnerCompId = partnerCompId;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }
}
