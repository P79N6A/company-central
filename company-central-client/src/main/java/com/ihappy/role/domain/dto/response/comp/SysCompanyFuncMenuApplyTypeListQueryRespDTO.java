package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysCompanyFuncMenuApplyTypeListQueryRespDTO extends ICallResponseBaseDTO {
    /**
     * 客户端id
     */
    private Integer clId;
    /**
     * 业务分类id
     */
    private Integer ctId;
    /**
     * 类型名称
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
