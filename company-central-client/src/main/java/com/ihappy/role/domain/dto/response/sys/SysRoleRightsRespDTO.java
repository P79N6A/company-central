package com.ihappy.role.domain.dto.response.sys;


import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/4/4.
 */
public class SysRoleRightsRespDTO implements Serializable {
    private static final long serialVersionUID = 6188622727709210838L;
    /**
     * 业务类型
     */
    private String ctId;

    /**
     * 端
     */
    private String clId;

    /**
     * 菜单
     */
    private String func;

    public RoleRightsRespDTO toRoleRightsRespDTO(){
        RoleRightsRespDTO roleRightsRespDTO = new RoleRightsRespDTO();
        roleRightsRespDTO.setCtId(ctId);
        roleRightsRespDTO.setClId(clId);
        roleRightsRespDTO.setFunc(func);
        return roleRightsRespDTO;
    }

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }

    public String getClId() {
        return clId;
    }

    public void setClId(String clId) {
        this.clId = clId;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
