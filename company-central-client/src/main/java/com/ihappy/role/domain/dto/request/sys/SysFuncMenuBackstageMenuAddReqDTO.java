package com.ihappy.role.domain.dto.request.sys;


import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;
import com.yx.eweb.util.StringUtil;

public class SysFuncMenuBackstageMenuAddReqDTO extends ICallRequestBaseDTO {
    /**
     * 业务分类功能菜单id业务
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
     * 根据该排序号来确定在页面上位置，越小越在前面。
     */
    private Integer ctSort;
    /**
     * 关于该菜单页面功能的一个说明
     */
    private String ctMemo;
    /**
     * 1菜单, 2操作。
     */
    private Integer funcType;
    /**
     * 父级菜单id
     */
    private Integer parentCtFuncId;
    /**
     * 父级业务分类功能菜单名称
     */
    private String parentCtFuncName;
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

    public Integer getCtSort() {
        return ctSort;
    }

    public void setCtSort(Integer ctSort) {
        this.ctSort = ctSort;
    }

    public String getCtMemo() {
        return ctMemo;
    }

    public void setCtMemo(String ctMemo) {
        this.ctMemo = ctMemo;
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

    public String getParentCtFuncName() {
        return parentCtFuncName;
    }

    public void setParentCtFuncName(String parentCtFuncName) {
        this.parentCtFuncName = parentCtFuncName;
    }

    public String getSourceCodes() {
        return sourceCodes;
    }

    public void setSourceCodes(String sourceCodes) {
        this.sourceCodes = sourceCodes;
    }

    @Override
    public void validation() {
        //类型是否为空
        if (funcType == null || funcType < 0 ){
            throw new RoleException(RoleErrorCodeEnum.FUNC_TYPE_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.FUNC_TYPE_IS_NOT_NULL.getErrMsg());
        }
        //菜单名称是否为空
        if (StringUtil.isBlank(ctFuncName)){
            throw new RoleException(RoleErrorCodeEnum.CT_FUNC_NAME_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CT_FUNC_NAME_IS_NOT_NULL.getErrMsg());
        }
        //编码是否为空
        if (StringUtil.isBlank(ctFuncNo)){
            throw new RoleException(RoleErrorCodeEnum.CT_FUNC_NO_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.CT_FUNC_NO_IS_NOT_NULL.getErrMsg());
        }
        if (ctFuncName.length()>10){
            throw new RoleException(RoleErrorCodeEnum.UP_TO_TEN_CHARATERS_CAN_BE_ENTERED.getErrCode(),
                    RoleErrorCodeEnum.UP_TO_TEN_CHARATERS_CAN_BE_ENTERED.getErrMsg());
        }
        if (ctFuncNo.length()>10){
            throw new RoleException(RoleErrorCodeEnum.UP_TO_TEN_CHARATERS_CAN_BE_ENTERED.getErrCode(),
                    RoleErrorCodeEnum.UP_TO_TEN_CHARATERS_CAN_BE_ENTERED.getErrMsg());
        }
        //所属菜单是否为空
        if (parentCtFuncId == null || parentCtFuncId <0){
            throw new RoleException(RoleErrorCodeEnum.PARENT_CT_FUNC_ID_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.PARENT_CT_FUNC_ID_IS_NOT_NULL.getErrMsg());
        }
        if (ctMemo.length()>10){
            throw new RoleException(RoleErrorCodeEnum.UP_TO_TEN_CHARATERS_CAN_BE_ENTERED.getErrCode(),
                    RoleErrorCodeEnum.UP_TO_TEN_CHARATERS_CAN_BE_ENTERED.getErrMsg());
        }
    }
}
