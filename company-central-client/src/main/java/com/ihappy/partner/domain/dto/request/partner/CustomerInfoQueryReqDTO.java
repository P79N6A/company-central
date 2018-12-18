package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;

/**
 * Created by sunjd on 2018/4/1.
 * 查询客户(单个)
 */
public class CustomerInfoQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 7814314660395491266L;
    /**
     * 伙伴id
     */
    private Long partnerId;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public void validation() {
        if (partnerId == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_ID_IS_NULL.getErrMsg());
        }
    }
}
