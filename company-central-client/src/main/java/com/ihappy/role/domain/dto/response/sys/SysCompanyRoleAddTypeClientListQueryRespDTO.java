package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysCompanyRoleAddTypeClientListQueryRespDTO extends ICallResponseBaseDTO {
    /**
     * 是否选中 0 未选中 1选中
     */
    private Integer isChecked;
    private Integer clId;
    private Integer ctId;
    private String name;

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
