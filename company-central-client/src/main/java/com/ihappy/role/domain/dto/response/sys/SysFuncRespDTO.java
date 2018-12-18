package com.ihappy.role.domain.dto.response.sys;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/16.
 */
public class SysFuncRespDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2912378247078958449L;

    /**
     *
     */
    private Integer ctFuncId;

    /**
     *
     */
    private Integer clId;

    /**
     *
     */
    private String ctFuncName;

    /**
     *
     */
    private String ctFuncNo;

    /**
     *
     */
    private String ctFuncIco;

    /**
     *
     */
    private String ctFuncLink;

    /**
     *
     */
    private String ctMemo;

    /**
     *
     */
    private Integer ctSort;

    /**
     *
     */
    private Integer parentCtFuncId;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private Integer funcType;

    /**
     *
     */
    private String sourceCodes;

    /**
     *
     */
    private Integer ctDepth;

    /**
     *
     */
    private Integer canlistNoright;

    public Integer getCtFuncId() {
        return ctFuncId;
    }

    public void setCtFuncId(Integer ctFuncId) {
        this.ctFuncId = ctFuncId;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
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

    public String getCtFuncIco() {
        return ctFuncIco;
    }

    public void setCtFuncIco(String ctFuncIco) {
        this.ctFuncIco = ctFuncIco;
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

    public Integer getParentCtFuncId() {
        return parentCtFuncId;
    }

    public void setParentCtFuncId(Integer parentCtFuncId) {
        this.parentCtFuncId = parentCtFuncId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    public String getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(String sourceCodes) {
        this.sourceCodes = sourceCodes;
    }

    public Integer getCtDepth() {
        return ctDepth;
    }

    public void setCtDepth(Integer ctDepth) {
        this.ctDepth = ctDepth;
    }

    public Integer getCanlistNoright() {
        return canlistNoright;
    }

    public void setCanlistNoright(Integer canlistNoright) {
        this.canlistNoright = canlistNoright;
    }
}

