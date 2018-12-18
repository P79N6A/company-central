package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 7318104528838301638L;
    @FieldComment(value = "会员id", defaultValue = "", required = true)
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
        if (getLoginCompId() == null || getLoginCompId() <= 0 || getLoginPersonId() == null || getLoginPersonId() <= 0) {
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }
}
