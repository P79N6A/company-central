package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.common.domain.TreeDTO;

public class SysCompanyFuncMenuApplyTypeMenuListQueryRespDTO extends TreeDTO {
    /**
     * 业务分类功能菜单id
     */
    private Integer ctFuncId;
    /**
     * 菜单名称，在同一级别下不可重复
     */
    private String ctFuncName;
    /**
     * 必须要填写的一个编号，唯一
     */
    private String ctFuncNo;
    /**
     * 1菜单, 2操作。
     */
    private Integer FuncType;
    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;

    public Integer getCtFuncId() {
        return ctFuncId;
    }

    public void setCtFuncId(Integer ctFuncId) {
        this.ctFuncId = ctFuncId;
    }

    public String getCtFuncName() {
        return ctFuncName;
    }

    public void setCtFuncName(String ctFuncName) {
        this.ctFuncName = ctFuncName;
    }

    public String getCtFuncNo() {
        return ctFuncNo;
    }

    public void setCtFuncNo(String ctFuncNo) {
        this.ctFuncNo = ctFuncNo;
    }

    public Integer getFuncType() {
        return FuncType;
    }

    public void setFuncType(Integer funcType) {
        FuncType = funcType;
    }

    public Integer getParentCtFuncId() {
        return parentCtFuncId;
    }

    public void setParentCtFuncId(Integer parentCtFuncId) {
        this.parentCtFuncId = parentCtFuncId;
    }
}
