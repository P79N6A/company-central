package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/18.
 */
public class PartnerArrearsOrderAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 6263711896804558001L;
    /**
     * 订单id
     */
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
