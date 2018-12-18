package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.io.Serializable;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/14 18:26
 * @Version
 */
public class CompanyRoleRight implements Serializable {
    private String ctId;
    private String clId;
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
