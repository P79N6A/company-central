package com.ihappy.company.domain.dto.response.companyverify;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyInfoVerifyAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 4066170386522057494L;
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
