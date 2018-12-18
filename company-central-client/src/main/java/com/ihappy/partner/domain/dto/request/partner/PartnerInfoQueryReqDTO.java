package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/14.
 */
public class PartnerInfoQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 1386654856143251387L;
    /**
     * 伙伴id
     */
    @FieldComment(value = "PartnerId",required = true,defaultValue = "90001")
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
