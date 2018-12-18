package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

import java.util.List;

/**
 * 根据roleId查询 sysdb- sys_role
 * Created by sunjd on 2018/6/17.
 */
public class SysRoleQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -2380580948554968535L;
    /**
     * 权限id list
     */
    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public void validation() {
        if (roleIds == null || roleIds.size() == 0) {
            throw new RoleException(RoleErrorCodeEnum.
                    ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg());
        }
    }
}
