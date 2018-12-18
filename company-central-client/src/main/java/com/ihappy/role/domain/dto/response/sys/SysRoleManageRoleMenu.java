package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.common.domain.TreeDTO;

public class SysRoleManageRoleMenu extends TreeDTO {
    /**
     * 客户端ID
     */
    private Integer clId;
    /**
     * 业务分类功能ID
     */
    private Integer ctFuncId;
    /**
     * 菜单名称
     *
     */
    private String ctFuncName;
    /**
     * 菜单编号
     */
    private String ctFuncNo;
    /**
     * 功能类型 1.菜单 2.操作 默认1
     */
    private Integer funcType;
    /**
     * 是否选中 1、选中 2、未选中
     */
    private Integer isChecked;
    /**
     * 父级菜单ID
     */
    private Integer parentCtFuncId;

    /**
     * 子菜单
     * @return
     */
    private SysRoleManageRoleMenuSub sub;

    public SysRoleManageRoleMenuSub getSub() {
        return sub;
    }

    public void setSub(SysRoleManageRoleMenuSub sub) {
        this.sub = sub;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

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

}
