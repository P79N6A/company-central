package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class  SysFuncMenuBackstageMenuListSubSubQueryRespDTO extends ICallResponseBaseDTO {
    /**
     *业务类型功能id
     */
    private Integer ctFuncId;
    /**
     *菜单名称，在同一级别下不可重复
     */
    private String ctFuncName;
    /**
     *必须要填写的一个编号，唯一
     */
    private String ctFuncNo;
    /**
     1菜单, 2操作。
     */
    private Integer funcType;
    /**
     *父级菜单id
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
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    public Integer getParentCtFuncId() {
        return parentCtFuncId;
    }

    public void setParentCtFuncId(Integer parentCtFuncId) {
        this.parentCtFuncId = parentCtFuncId;
    }
}
