package com.ihappy.role.domain.dto.request.sys;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyRoleInfoTypeClientListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 0-否，非系统，前端显示，需要进行过滤，1-用户平台 默认0
     * @return
     */
    private Integer isSys;
    /**
     * 角色ID
     */
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getIsSys() {
        return isSys;
    }

    public void setIsSys(Integer isSys) {
        this.isSys = isSys;
    }
    @Override
    public void validation(){

        if (isSys == null || isSys < 0){
            throw new RoleException(RoleErrorCodeEnum.IS_SYS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.IS_SYS_NOT_NULL.getErrMsg()  );
        }

    }
}
