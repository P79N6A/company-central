package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysRoleManageRoleRightsRespDTO extends ICallResponseBaseDTO {
    /**
     *客户端ID
     */
    private Long clId;
    /**
     *角色菜单权限
     */
    private String func;

    public Long getClId() {
        return clId;
    }

    public void setClId(Long clId) {
        this.clId = clId;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
