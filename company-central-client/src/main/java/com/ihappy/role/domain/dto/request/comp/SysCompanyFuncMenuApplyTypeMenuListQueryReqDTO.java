package com.ihappy.role.domain.dto.request.comp;


import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;

public class SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO extends ICallRequestBaseQuery {
    /**
     * 业务分类id
     */
    private Integer ctId;
    /**
     * 客户端id
     */
    private Integer clId;
    /**
     * 菜单名称模糊查询
     */
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }
    @Override
    public void validation(){

        if (clId == null || clId <0){
            throw new RoleException(RoleErrorCodeEnum.CL_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CL_ID_IS_NOT_NULL.getErrMsg());
        }
        if (ctId == null || ctId<0){
            throw new RoleException(RoleErrorCodeEnum.CT_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CT_ID_IS_NOT_NULL.getErrMsg());
        }
    }
}
