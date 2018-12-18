package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

public class SysFuncMenuBackstageMenuInfoQueryRespDTO extends ICallResponseBaseDTO {
    /**
     * 业务类型功能id
     */
    private Integer ctFuncId;
    /**
     * 一个url地址，菜单类型必填，操作类型非必填
     */
    private String ctFuncLink;
    /**
     * 菜单名称，在同一级别下不可重复
     */
    private String ctFuncName;
    /**
     * 必须要填写的一个编号，唯一
     */
    private String ctFuncNo;
    /**
     * 关于该菜单页面功能的一个说明
     */
    private String ctMemo;
    /**
     * 根据该排序号来确定在页面上位置，越小越在前面。
     */
    private Integer ctSort;
    /**
     * 1菜单, 2操作。
     */
    private Integer funcType;
    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;
    /**
     * 源码
     */
    private String sourceCodes;

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

    public String getCtFuncLink() {
        return ctFuncLink;
    }

    public void setCtFuncLink(String ctFuncLink) {
        this.ctFuncLink = ctFuncLink;
    }

    public String getCtMemo() {
        return ctMemo;
    }

    public void setCtMemo(String ctMemo) {
        this.ctMemo = ctMemo;
    }

    public Integer getCtSort() {
        return ctSort;
    }

    public void setCtSort(Integer ctSort) {
        this.ctSort = ctSort;
    }

    public String getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(String sourceCodes) {
        this.sourceCodes = sourceCodes;
    }
}
