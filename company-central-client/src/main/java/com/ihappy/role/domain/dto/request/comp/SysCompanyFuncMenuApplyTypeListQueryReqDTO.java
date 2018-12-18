package com.ihappy.role.domain.dto.request.comp;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyFuncMenuApplyTypeListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 0-否，非系统，前端显示，需要进行过滤，1-用户平台
     */
    private Integer isSys;

    public Integer getIsSys() {
        return isSys;
    }

    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
    }
    @Override
    public void validation(){
        if (isSys == null || isSys <0){
            throw new RoleException(RoleErrorCodeEnum.IS_SYS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.IS_SYS_NOT_NULL.getErrMsg());
        }
    }
}
