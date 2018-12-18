package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.SysCompanyFuncErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyFuncListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     *'企业业务分类id，和对应菜单1对多，必须选择的所属企业分类id
     */
    private Integer ctId;

    /**
     *默认移动端
     */
    private Integer clientId;
    /**
     * 分级深度，默认第1级分类是。
     */
    private Integer ctDepth;

    public Integer getCtDepth() {
        return ctDepth;
    }

    public void setCtDepth(Integer ctDepth) {
        this.ctDepth = ctDepth;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public void validation() {
        if (ctId == null || ctId <= 0) {
            throw new RoleException(SysCompanyFuncErrorCodeEnum.CTID_IS_NULL.getErrCode(),
                    SysCompanyFuncErrorCodeEnum.CTID_IS_NULL.getErrMsg());
        }
    }
}
