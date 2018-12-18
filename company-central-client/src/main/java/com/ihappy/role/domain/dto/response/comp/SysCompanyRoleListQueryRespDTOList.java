package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysCompanyRoleListQueryRespDTOList extends ICallResponseBaseDTO {
    /**
     * 角色id
     */
    private Long sysRoleId;
    /**
     * 角色名称
     */
    private String sysRoleName;

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }
}
