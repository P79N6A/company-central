package com.ihappy.role.domain.dto.request.comp;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 业务分类功能菜单id
     */
  private Integer ctFuncId;

    public Integer getCtFuncId() {
        return ctFuncId;
    }

    public void setCtFuncId(Integer ctFuncId) {
        this.ctFuncId = ctFuncId;
    }
    @Override
    public void validation(){
        if (ctFuncId == null || ctFuncId <0){
            throw new RoleException(RoleErrorCodeEnum.CT_FUNC_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CT_FUNC_ID_IS_NOT_NULL.getErrMsg());
        }
    }
}
