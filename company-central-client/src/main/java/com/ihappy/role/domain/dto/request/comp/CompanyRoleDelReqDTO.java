package com.ihappy.role.domain.dto.request.comp;


import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class CompanyRoleDelReqDTO extends ICallRequestBaseDTO {
    /**
     * 角色id
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
        if (roleId==null || roleId <= 0L){
            throw new RoleException(RoleErrorCodeEnum.COMPANY_ROLE_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_ID_IS_NOT_NULL.getErrMsg());
        }
        if (getLoginCompId() == null || getLoginCompId() <= 0L || getLoginPersonId() == null || getLoginPersonId() <= 0L){
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
