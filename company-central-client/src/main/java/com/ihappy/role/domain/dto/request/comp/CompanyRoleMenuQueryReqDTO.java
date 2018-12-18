package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.common.util.StringUtil;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class CompanyRoleMenuQueryReqDTO extends ICallRequestBaseQuery {
    @Override
    public void validation() {

        if (getLoginCompId() == null || getLoginCompId() <= 0L
                && getLoginPersonId() == null || getLoginPersonId() <= 0L) {
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }

        if(StringUtil.isBlank(getLoginClId()) || StringUtil.isBlank(getLoginCtId())){
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
