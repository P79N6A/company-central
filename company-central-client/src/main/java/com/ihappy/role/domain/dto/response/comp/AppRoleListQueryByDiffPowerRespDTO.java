package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/24 12:17
 * *@content
 **/
public class AppRoleListQueryByDiffPowerRespDTO extends ICallResponseBaseDTO {
    /**
     * 角色ID
     */
    @FieldComment(value = "角色ID")
    private Long roleId;
    /**
     * 角色编号
     */
    @FieldComment(value = "角色编号")
    private String roleNo;


    /**
     * 角色名称
     */
    @FieldComment(value = "角色名称")
    private String roleName;
    /**
     * 角色描述
     */
    @FieldComment(value = "角色描述")
    private String roleMemo;
    /**
     * 是否隐藏 1隐藏 0不隐藏 默认1
     */
    @FieldComment(value = "是否隐藏 1隐藏 0不隐藏 默认1")
    private Integer isHide;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

}
