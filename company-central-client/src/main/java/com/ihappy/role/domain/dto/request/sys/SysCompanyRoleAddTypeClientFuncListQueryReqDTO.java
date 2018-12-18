package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

public class SysCompanyRoleAddTypeClientFuncListQueryReqDTO extends ICallRequestBaseQuery {
    private Integer clId;
    private Integer ctId;

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }
}
