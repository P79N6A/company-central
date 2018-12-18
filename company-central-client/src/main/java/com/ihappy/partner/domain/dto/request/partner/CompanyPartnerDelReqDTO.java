package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/6.
 * 删除Partner
 */
public class CompanyPartnerDelReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -5735950386774271468L;
    @FieldComment(value = "会员id",defaultValue = "",required = true)
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
    }
}
