package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * created by zhangmengdan
 * create at 2018/8/23
 */
public class SysCompanyFuncMenuApplyTypeMenuAddRespDTO extends ICallResponseBaseDTO {
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
