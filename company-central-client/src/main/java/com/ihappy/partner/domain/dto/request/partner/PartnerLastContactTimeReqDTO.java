package com.ihappy.partner.domain.dto.request.partner;


import com.ihappy.partner.exception.PartnerException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;

/**
 * Created by sunjd on 2018/4/20.
 */
public class PartnerLastContactTimeReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -5966833213276170955L;
    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 伙伴id
     */
    private Long partnerId;
    /**
     * 往来时间
     */
    private Long lastContactTime;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(Long lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    @Override
    public void validation() {
        if (compId == null) {
            throw new PartnerException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (partnerId == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_ID_IS_NULL.getErrMsg());
        }
    }
}
