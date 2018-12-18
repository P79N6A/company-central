package com.ihappy.role.domain.dto.response.sys;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.role.domain.dto.response.RoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
public class SysRoleQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -6062806030018517435L;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 业务类型
     */
    private Integer ctId;
    /**
     * 角色名称 一个企业内部级别下需要唯一
     */
    private String roleName;
    /**
     * 角色编号
     */
    private String roleNo;
    /**
     * 运营平台角色权限
     */
    private List<RoleRightsRespDTO> roleRights;
    /**
     * 角色排序
     */
    private Integer roleSort;
    /**
     * 角色描述
     */
    private String roleMemo;

    public CompanyRoleQueryRespDTO toCompanyRoleQueryRespDTO(){
        CompanyRoleQueryRespDTO respDTO = new CompanyRoleQueryRespDTO();
        BeanUtils.copyProperties(this,respDTO);
        return respDTO;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
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

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public List<RoleRightsRespDTO> getRoleRights() {
        return roleRights;
    }

    public void setRoleRights(List<RoleRightsRespDTO> roleRights) {
        this.roleRights = roleRights;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }
}
