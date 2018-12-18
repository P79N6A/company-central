package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/12.
 */
public class AddInvateRegisterPartnerRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 4532991537278188986L;
    private Long partnerId;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}
