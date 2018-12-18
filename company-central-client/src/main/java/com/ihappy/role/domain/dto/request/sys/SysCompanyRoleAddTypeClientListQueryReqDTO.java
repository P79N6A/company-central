package com.ihappy.role.domain.dto.request.sys;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;

public class SysCompanyRoleAddTypeClientListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 0-否，非系统，前端显示，需要进行过滤，1-用户平台 默认0
     * @return
     */
    private Integer isSys;

    public Integer getIsSys() {
        return isSys;
    }

    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
    }
}
