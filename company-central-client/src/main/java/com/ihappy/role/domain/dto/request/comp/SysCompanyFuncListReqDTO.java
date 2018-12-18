package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

public class SysCompanyFuncListReqDTO extends ICallRequestBaseQuery {
    /**
     * 客户端ID
     */
    private Integer clId;
    /**
     * 业务分类ID
     */
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
