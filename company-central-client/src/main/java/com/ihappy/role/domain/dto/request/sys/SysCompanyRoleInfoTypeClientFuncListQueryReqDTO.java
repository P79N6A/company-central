package com.ihappy.role.domain.dto.request.sys;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyRoleInfoTypeClientFuncListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 业务类型ID
     */
    private Integer ctId;
    /**
     * 客户端ID
     */
    private Integer clId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }
    @Override
    public void validation(){
        if (roleId == null || roleId <= 0L){
            throw new RoleException(RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg());
        }
        if (ctId == null || ctId <= 0){
            throw new RoleException(RoleErrorCodeEnum.CT_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CT_ID_IS_NOT_NULL.getErrMsg());
        }
        if (clId == null || clId <= 0){
            throw new RoleException(RoleErrorCodeEnum.CL_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CL_ID_IS_NOT_NULL.getErrMsg());
        }
    }
}
