package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyRoleListQueryReqDTO extends ICallRequestBaseQuery {
    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginCompId() <= 0L || getLoginPersonId() == null || getLoginPersonId() <= 0L) {
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());

        }
    }
}
