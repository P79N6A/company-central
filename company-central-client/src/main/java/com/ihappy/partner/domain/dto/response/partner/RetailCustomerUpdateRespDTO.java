package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 16:19
 * *@content
 **/
public class RetailCustomerUpdateRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "返回参数",defaultValue = "",required = true)
    private String message;

    public RetailCustomerUpdateRespDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
