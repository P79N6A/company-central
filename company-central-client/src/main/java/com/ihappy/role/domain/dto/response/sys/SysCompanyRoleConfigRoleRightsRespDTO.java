package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysCompanyRoleConfigRoleRightsRespDTO extends ICallResponseBaseDTO {
    /**
     *客户端ID
     */
    private Integer clId;
    /**
     *业务分类ID
     */
    private Integer ctId;
    /**
     *角色菜单权限
     */
    private String func;


    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

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
