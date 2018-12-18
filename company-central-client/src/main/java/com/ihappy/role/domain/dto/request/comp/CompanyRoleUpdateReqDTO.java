package com.ihappy.role.domain.dto.request.comp;


import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.JsonUtil;
import com.ihappy.role.exception.RoleException;
import com.yx.eweb.util.StringUtil;


public class CompanyRoleUpdateReqDTO extends ICallRequestBaseDTO {
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色编号
     */
    private String roleNo;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleMemo;
    /**
     * 是否允许查看采购价 0不允许，1 允许
     */
    private Integer isHide;
    /**
     * 公司角色权限 {1:’1,2,3,4’,2:’2,3,4,5’}
     */
    private String roleRights;

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public String getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(String roleRights) {
        this.roleRights = roleRights;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }


    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginCompId() <= 0L || getLoginPersonId() == null || getLoginPersonId() <= 0L) {
            throw new RoleException(RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    RoleErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());

        }
        if (StringUtil.isBlank(roleName)) {
            throw new RoleException(RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_NULL.getErrMsg());
        }
        if (StringUtil.isBlank(roleRights)) {
            throw new RoleException(RoleErrorCodeEnum.COMPANY_ROLE_RIGHTS_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_RIGHTS_IS_NOT_NULL.getErrMsg());
        }
        if (roleId == null || roleId <= 0L) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg());
        }
        if (StringUtil.isBlank(roleNo)) {
            throw new RoleException(RoleErrorCodeEnum.COMPANY_ROLE_NO_IS_NOT_NULL.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_NO_IS_NOT_NULL.getErrMsg());
        }
        if (JsonUtil.isJsonArray(roleRights) == false) {
            throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                    RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
        }
    }
}

