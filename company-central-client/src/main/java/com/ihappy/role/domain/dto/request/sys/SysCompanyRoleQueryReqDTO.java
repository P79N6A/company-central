package com.ihappy.role.domain.dto.request.sys;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

import java.util.List;

/**
 * 根据roleId查询 sysdb
 * Created by sunjd on 2018/4/4.
 */
public class SysCompanyRoleQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 6180139376885814949L;
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
