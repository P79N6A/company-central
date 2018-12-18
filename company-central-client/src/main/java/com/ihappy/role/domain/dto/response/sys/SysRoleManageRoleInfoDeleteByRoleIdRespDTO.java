package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysRoleManageRoleInfoDeleteByRoleIdRespDTO extends ICallResponseBaseDTO {
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
