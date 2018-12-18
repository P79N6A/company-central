package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 17:36
 * *@content
 **/
public class RetailCustomerInfoEnableReqDTO extends ICallRequestBaseDTO {
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
        setUpdateTime(new Date());
        if (getLoginCompId() == null || getLoginCompId() <= 0 || getLoginPersonId() == null || getLoginPersonId() <= 0) {
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }
}
