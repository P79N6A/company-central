package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class CompanyRoleInfoQueryReqDTO extends ICallRequestBaseQuery {
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
    public void validation(){
        if (roleId==null){
            throw new RoleException(RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg());
        }
        //用户ID和公司ID不能为空
        if (getLoginCompId()==null||getLoginCompId() <= 0L ||getLoginPersonId() == null || getLoginPersonId() <= 0L){
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
