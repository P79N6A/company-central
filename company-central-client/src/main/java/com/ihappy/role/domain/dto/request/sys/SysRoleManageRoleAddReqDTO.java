package com.ihappy.role.domain.dto.request.sys;

import com.alibaba.fastjson.JSONArray;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.JsonUtil;
import com.ihappy.role.exception.RoleException;
import com.yx.eweb.util.StringUtil;

public class SysRoleManageRoleAddReqDTO extends ICallRequestBaseDTO {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 描述
     */
    private String roleMemo;
    /**
     * 角色权限
     */
    private String roleRights;

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
        if (StringUtil.isBlank(roleName)) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_NAME_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_NOT_NULL.getErrMsg());
        }
        //判断角色名称长度不能超过10
        if (roleName.length() > 10) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_NAME_IS_LIMIT_10.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_LIMIT_10.getErrMsg());
        }
        //判断角色描述长度不能超过30
        if (roleMemo.length() > 30) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_MEMO_MAX_LENGTH.getErrCode(),
                    RoleErrorCodeEnum.ROLE_MEMO_MAX_LENGTH.getErrMsg());
        }
        if (JSONArray.parseArray(roleRights).equals(false)) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
        if (StringUtil.isBlank(roleRights)) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_NOT_NULL.getErrMsg());
        }
        if(JsonUtil.isJsonArray(roleRights)==false){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
    }
}
