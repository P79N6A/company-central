package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -6494270203343088816L;
    @FieldComment(value = "返回参数",defaultValue = "",required = true)
    private String message;

    public RetailCustomerAddRespDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
