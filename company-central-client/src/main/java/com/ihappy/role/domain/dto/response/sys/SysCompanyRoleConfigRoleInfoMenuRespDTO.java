package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.common.domain.TreeDTO;

import java.util.List;

public class SysCompanyRoleConfigRoleInfoMenuRespDTO extends TreeDTO {
    /**
     * 客户端ID
     */
    private Integer clId;
    /**
     * 分级深度
     */
    private Integer ctDepth;
    /**
     * 业务分类功能ID
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
     * 企业业务分类id，和对应菜单1对多，必须选择的所属企业分类id
     */
    private Integer ctId;
    /**
     * 根据该排序号来确定在页面上位置，越小越在前面。
     */
    private Integer ctSort;
    /**
     * 1菜单, 2操作
     */
    private Integer funcType;
    /**
     * 是否选中 0 未选中 1选中
     */
    private Integer isChecked;
    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;
    /**
     * 资源代码集合
     */
    private String sourceCodes;
    /**
     * 子菜单
     */
    private List<SysCompanyRoleConfigRoleInfoMenuSubRespDTO> sub;

    public List<SysCompanyRoleConfigRoleInfoMenuSubRespDTO> getSub() {
        return sub;
    }

    public void setSub(List<SysCompanyRoleConfigRoleInfoMenuSubRespDTO> sub) {
        this.sub = sub;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public Integer getCtDepth() {
        return ctDepth;
    }

    public void setCtDepth(Integer ctDepth) {
        this.ctDepth = ctDepth;
    }

    public Integer getCtFuncId() {
        return ctFuncId;
    }

    public void setCtFuncId(Integer ctFuncId) {
        this.ctFuncId = ctFuncId;
    }

    public String getCtFuncLink() {
        return ctFuncLink;
    }

    public void setCtFuncLink(String ctFuncLink) {
        this.ctFuncLink = ctFuncLink;
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

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getCtSort() {
        return ctSort;
    }

    public void setCtSort(Integer ctSort) {
        this.ctSort = ctSort;
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Integer getParentCtFuncId() {
        return parentCtFuncId;
    }

    public void setParentCtFuncId(Integer parentCtFuncId) {
        this.parentCtFuncId = parentCtFuncId;
    }

    public String getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(String sourceCodes) {
        this.sourceCodes = sourceCodes;
    }
}
