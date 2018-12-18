package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
public class SysCompanyRoleQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 8479705709070555722L;
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
    private List<SysRoleRightsRespDTO> sysRoleRights;

    /**
     *角色排序
     */
    private Integer roleSort;

    /**
     * 0 表示不隐藏 1表示隐藏
     */
    private Integer isHide;

    public CompanyRoleQueryRespDTO toCompanyRoleQueryRespDTO(){
        CompanyRoleQueryRespDTO respDTO = new CompanyRoleQueryRespDTO();
        BeanUtils.copyProperties(this,respDTO);
        if (!CollectionUtils.isEmpty(sysRoleRights)){
            List<RoleRightsRespDTO> roleRights = new ArrayList<RoleRightsRespDTO>();
            for (SysRoleRightsRespDTO obj : sysRoleRights){
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

    public List<SysRoleRightsRespDTO> getSysRoleRights() {
        return sysRoleRights;
    }

    public void setSysRoleRights(List<SysRoleRightsRespDTO> sysRoleRights) {
        this.sysRoleRights = sysRoleRights;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public Integer getIsHide() {
        return isHide;
    }

    public void setIsHide(Integer isHide) {
        this.isHide = isHide;
    }
}
