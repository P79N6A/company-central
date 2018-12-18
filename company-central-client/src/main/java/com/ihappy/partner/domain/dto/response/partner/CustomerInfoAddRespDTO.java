package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CustomerInfoAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 8553294690714338171L;
    /**
     *伙伴企业ID
     */
    private Long partnerId;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}
