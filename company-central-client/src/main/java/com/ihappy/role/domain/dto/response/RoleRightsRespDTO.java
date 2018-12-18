package com.ihappy.role.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/4/2.
 */
public class RoleRightsRespDTO implements Serializable {

    private static final long serialVersionUID = 3360379989106903179L;
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
