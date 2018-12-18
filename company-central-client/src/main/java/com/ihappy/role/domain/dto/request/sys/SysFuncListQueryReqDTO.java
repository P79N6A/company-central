package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.SysCompanyFuncErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

/**
 * Created by Administrator on 2018/6/16.
 */
public class SysFuncListQueryReqDTO extends ICallRequestBaseQuery {

    /**
     *默认移动端
     */
    private Integer clientId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public void validation() {
        if (clientId == null || clientId <= 0) {
            throw new RoleException(SysCompanyFuncErrorCodeEnum.CTID_IS_NULL.getErrCode(),
                    SysCompanyFuncErrorCodeEnum.CTID_IS_NULL.getErrMsg());
        }
    }
}
