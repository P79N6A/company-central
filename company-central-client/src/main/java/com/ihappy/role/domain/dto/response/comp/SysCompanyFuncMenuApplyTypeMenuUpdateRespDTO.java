package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysCompanyFuncMenuApplyTypeMenuUpdateRespDTO extends ICallResponseBaseDTO {
    /**
     * 返回信息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
