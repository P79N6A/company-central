package com.ihappy.role.domain.dto.response.sys;

import java.io.Serializable;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/15 10:13
 * @Version系统公司角色权限包含内容
 */
public class SysCompanyRoleRightRespDTO implements Serializable {
    /**
     * 客户端id
     */
    private String ctId;
    /**
     * 业务分类id
     */
    private String clId;

    /**
     * 权限id
     * @return
     */
    private String func;

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
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
}
