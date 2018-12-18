package com.ihappy.company.domain.dto.response.companyverify;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyInfoVerifyRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -4969656333471355127L;
    /**
     * 返回消息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
