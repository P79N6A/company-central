package com.ihappy.role.domain.bo;

import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/6/4.
 */
public class CompanyRoleBO {
    private Integer ctId;
    private Integer clId;
    /**
     *
     * 角色id
     */
    private Long roleId;

    /**
     *
     * 角色名称
     */
    private String roleName;

    /**
     *
     * 角色编号
     */
    private String roleNo;

    /**
     *
     * 角色简介
     */
    private String roleMemo;

    /**
     *
     *角色权限
     */
    private String roleRights;

    /**
     *
     * 排序
     */
    private Integer roleSort;

    /**
     *
     * 公司id
     */
    private Integer compId;

    /**
     *创建时间
     */
    private Long createdAt;

    /**
     *
     * 更新时间
     */
    private Long updatedAt;

    /**
     *
     * 创建人
     */
    private Long createdPersonId;

    /**
     *
     * 更新人
     */
    private Long updatedPersonId;

    /**
     * 是否删除
     *
     */
    private Integer isDeleted;

    /**
     * 0 表示不隐藏 1表示隐藏
     */
    private Integer isHide;
    /**
     * 公司角色权限
     */
    private List<RoleRightsBO> roleRightsList;

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

    public CompanyRoleQueryRespDTO toCompanyRoleQueryRespDTO(){
        CompanyRoleQueryRespDTO respDTO = new CompanyRoleQueryRespDTO();
        BeanUtils.copyProperties(this,respDTO);
        if (!CollectionUtils.isEmpty(roleRightsList)){
            List<RoleRightsRespDTO> roleRights = new ArrayList<RoleRightsRespDTO>();
            for (RoleRightsBO obj : roleRightsList){
                roleRights.add(obj.toRoleRightsRespDTO());
            }
            respDTO.setRoleRights(roleRights);
        }
        return respDTO;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }

    public List<RoleRightsBO> getRoleRightsList() {
        return roleRightsList;
    }

    public void setRoleRightsList(List<RoleRightsBO> roleRightsList) {
        this.roleRightsList = roleRightsList;
    }
}
