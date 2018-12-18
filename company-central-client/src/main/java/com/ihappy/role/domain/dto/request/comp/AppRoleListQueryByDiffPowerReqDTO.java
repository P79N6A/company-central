package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/24 12:16
 * *@content
 **/
public class AppRoleListQueryByDiffPowerReqDTO extends ICallRequestBaseQuery {
    @FieldComment(value = "角色名称")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginCompId() < 0L || getLoginPersonId() == null || getLoginPersonId() < 0L) {
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
