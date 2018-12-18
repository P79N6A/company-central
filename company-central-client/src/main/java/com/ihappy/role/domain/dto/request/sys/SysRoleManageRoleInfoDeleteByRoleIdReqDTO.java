package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysRoleManageRoleInfoDeleteByRoleIdReqDTO extends ICallRequestBaseDTO {
    /**
     * 角色ID
     */
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public void validation() {
        if (roleId == null || roleId <= 0){
            throw new RoleException(RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg()  );
        }
    }
}
