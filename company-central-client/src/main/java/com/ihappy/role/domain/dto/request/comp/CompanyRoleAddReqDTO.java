package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.JsonUtil;
import com.ihappy.role.exception.RoleException;
import com.yx.eweb.util.StringUtil;

public class CompanyRoleAddReqDTO extends ICallRequestBaseDTO {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色编号
     */
    private String roleNo;
    /**
     * 描述
     */
    private String roleMemo;
    /**
     * 公司角色权限 {1:’1,2,3,4’,2:’2,3,4,5’}
     */
    private String roleRights;
    /**
     * 角色排序 根据该排序号来确定在页面上位置，越小越在前面 默认1
     */
    private Integer roleSort;
    /**
     * 1-隐藏，0-不隐藏 默认1
     */
    private Integer isHide;

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }
    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    public String getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(String roleRights) {
        this.roleRights = roleRights;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    /**
     * 参数校验
     */
    @Override
    public void validation() {

        if (getLoginCompId() == null || getLoginCompId() <= 0L || getLoginPersonId() == null || getLoginPersonId() <= 0L){
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
        if (isHide==null){
            throw new RoleException(RoleErrorCodeEnum.IS_HIDE_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.IS_HIDE_IS_NOT_NULL.getErrMsg());
        }
        if (StringUtil.isBlank(roleName)){
            throw new RoleException(RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_NULL.getErrMsg());
        }
        if (StringUtil.isBlank(roleRights) ){
            throw new RoleException(RoleErrorCodeEnum.COMPANY_ROLE_RIGHTS_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_RIGHTS_IS_NOT_NULL.getErrMsg());
        }
        if (StringUtil.isBlank(roleNo)){
            throw new RoleException(RoleErrorCodeEnum.PLEASE_CHANGE_ROLE_TYPE.getErrCode(),
                    RoleErrorCodeEnum.PLEASE_CHANGE_ROLE_TYPE.getErrMsg());
        }
        if(JsonUtil.isJsonArray(roleRights)==false){
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }

    }
}
