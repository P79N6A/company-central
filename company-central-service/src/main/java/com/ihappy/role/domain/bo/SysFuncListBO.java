package com.ihappy.role.domain.bo;

public class SysFuncListBO {
    /**
     * 分级深度
     */
    private Integer ctDepth;
    /**
     * 是否删除 0 未删除 1已删除
     */
    private Integer isDeleted;
    /**
     * 限制条数
     */
    private Integer limit;
    /**
     * 起始位置
     */
    private Integer offset;
    /**
     * 业务分类功能菜单名称
     */
    private String ctFuncName;
    /**
     * 业务分类功能菜单名称模糊查询
     */
    private String name;
    /**
     * 业务分类功能菜单id业务
     */
    private Integer ctFuncId;
    /**
     * 1菜单, 2操作。
     */
    private Integer funcType;
    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;
    /**
     * 必须要填写的一个编号，唯一
     */
    private String ctFuncNo;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getCtFuncName() {
        return ctFuncName;
    }

    public void setCtFuncName(String ctFuncName) {
        this.ctFuncName = ctFuncName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCtFuncId() {
        return ctFuncId;
    }

    public void setCtFuncId(Integer ctFuncId) {
        this.ctFuncId = ctFuncId;
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

    public String getCtFuncNo() {
        return ctFuncNo;
    }

    public void setCtFuncNo(String ctFuncNo) {
        this.ctFuncNo = ctFuncNo;
    }

    public Integer getCtDepth() {
        return ctDepth;
    }

    public void setCtDepth(Integer ctDepth) {
        this.ctDepth = ctDepth;
    }
}
