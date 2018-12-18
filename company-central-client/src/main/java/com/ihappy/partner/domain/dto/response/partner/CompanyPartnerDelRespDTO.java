package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 19:46
 * *@content
 **/
public class CompanyPartnerDelRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "返回信息",required = true,defaultValue = "")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
