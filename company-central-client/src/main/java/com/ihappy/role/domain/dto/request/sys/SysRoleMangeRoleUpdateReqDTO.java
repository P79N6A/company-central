package com.ihappy.role.domain.dto.request.sys;


import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.JsonUtil;
import com.ihappy.role.exception.RoleException;
import com.yx.eweb.util.StringUtil;

public class SysRoleMangeRoleUpdateReqDTO extends ICallRequestBaseDTO {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleMemo;
    /**
     * 角色权限
     */
    private String roleRights;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    public String getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(String roleRights) {
        this.roleRights = roleRights;
    }

    @Override
    public void validation() {
        if (roleId == null || roleId <= 0L){
            throw new RoleException(RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg());
        }
        if (StringUtil.isBlank(roleName)){
            throw new RoleException(RoleErrorCodeEnum.ROLE_NAME_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_NOT_NULL.getErrMsg() );
        }
        if (StringUtil.isBlank(roleRights)){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_NOT_NULL.getErrMsg());
        }
        if (roleName.length()>10){
            throw new RoleException(RoleErrorCodeEnum.ROLE_NAME_IS_LIMIT_10.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_LIMIT_10.getErrMsg());
        }
        if (roleMemo.length()>30){
            throw new RoleException(RoleErrorCodeEnum.ROLE_MEMO_MAX_LENGTH.getErrCode(),
                    RoleErrorCodeEnum.ROLE_MEMO_MAX_LENGTH.getErrMsg());
        }
        if(JsonUtil.isJsonArray(roleRights)==false){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
    }
}
