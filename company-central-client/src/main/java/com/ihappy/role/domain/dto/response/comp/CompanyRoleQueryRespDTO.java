package com.ihappy.role.domain.dto.response.comp;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
public class CompanyRoleQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 1888265363650078376L;
    /**
     *角色id
     */
    private Long roleId;

    /**
     *角色名
     */
    private String roleName;

    /**
     *角色编号
     */
    private String roleNo;

    /**
     *角色介绍
     */
    private String roleMemo;

    /**
     * 公司角色权限
     */
    private List<RoleRightsRespDTO> roleRights;

    /**
     *角色排序
     */
    private Integer roleSort;

    /**
     *公司id
     */
    private Integer compId;

    /**
     *创建时间
     */
    private Long createdAt;

    /**
     *更新时间
     */
    private Long updatedAt;

    /**
     *创建人
     */
    private Long createdPersonId;

    /**
     *修改人
     */
    private Long updatedPersonId;

    /**
     *是否删除 是否软删除 0 未删除，1已删除
     */
    private Boolean isDeleted;

    /**
     * 0 表示不隐藏 1表示隐藏
     */
    private Integer isHide;

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

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }

    public List<RoleRightsRespDTO> getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(List<RoleRightsRespDTO> roleRights) {
        this.roleRights = roleRights;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
