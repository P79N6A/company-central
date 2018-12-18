package com.ihappy.role.domain.dto.response;

import java.io.Serializable;

/**
 * Created by liuhc on 2018/6/4.
 */
public class PrivilegeAllRespDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2912378247078958449L;

    /**
     * 自增id
     */
    private Integer ctFuncId;

    /**
     * '企业业务分类id，和对应菜单1对多，必须选择的所属企业分类id
     */
    private Integer ctId;

    /**
     * 默认移动端
     */
    private Integer clId;

    /**
     * 菜单名称，在同一级别下不可重复
     */
    private String ctFuncName;

    /**
     * 必须要填写的一个编号，唯一
     */
    private String ctFuncNo;

    /**
     * 功能图标地址，需要图标可以设置该字段。
     */
    private String ctFuncIco;

    /**
     * 一个url地址，菜单类型必填，操作类型非必填
     */
    private String ctFuncLink;

    /**
     * 关于该菜单页面功能的一个说明
     */
    private String ctMemo;

    /**
     * 根据该排序号来确定在页面上位置，越小越在前面。
     */
    private Integer ctSort;

    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 1菜单, 2操作
     */
    private Integer funcType;

    /**
     * 资源代码集合
     */
    private String sourceCodes;

    /**
     * 分级深度，默认第1级分类是。
     */
    private Integer ctDepth;

    /**
     * 菜单不需要配置可以列表显示数据
     */
    private Integer canlistNoright;

    public Integer getCtFuncId() {
        return ctFuncId;
    }

    public void setCtFuncId(Integer ctFuncId) {
        this.ctFuncId = ctFuncId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
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
