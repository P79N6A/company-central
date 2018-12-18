package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.gateway.dto.ICallRequestBaseDTO;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerDelReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 2767117122619094103L;
    /**
     * 会员id
     */
    private Long partnerId;

    @Override
    public void validation() {

    }
}
