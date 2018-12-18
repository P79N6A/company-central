package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

public class SysFuncMenuBackstageMenuListSubQueryRespDTO extends ICallResponseBaseDTO {
    /**
     * 业务类型功能id
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
    private Integer funcType;
    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;
    /**
     * 子菜单
     *
     * @return
     */
    private List<SysFuncMenuBackstageMenuListSubSubQueryRespDTO> subsub;

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

    public List<SysFuncMenuBackstageMenuListSubSubQueryRespDTO> getSubsub() {
        return subsub;
    }

    public void setSubsub(List<SysFuncMenuBackstageMenuListSubSubQueryRespDTO> subsub) {
        this.subsub = subsub;
    }
}
