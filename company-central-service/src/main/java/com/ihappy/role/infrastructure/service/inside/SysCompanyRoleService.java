package com.ihappy.role.infrastructure.service.inside;

import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.role.domain.bo.SysCompanyRoleConfigBO;
import com.ihappy.role.domain.bo.SysCompanyRoleBO;
import com.ihappy.role.domain.dbdo.sys.SysCompanyRole;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;

import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
public interface SysCompanyRoleService {
    List<SysCompanyRoleModel> findSysRoleListByRoleIdList(List<Long> roleIdList);

    List<SysCompanyRole> findAllSysRoleListByRoleIdList();

    /**
     * 根据ctIds 查询过滤后的权限
     * 只要 ctIds 中的 ctId 在roleRights 中存在则不过滤
     * @param ctIds
     * @return
     */
    List<CompanyRoleBO> findAllSysRoleListByCtIds(String ctIds);
    /**
     * 根据公司id列表 查询系统角色列表 通过ctId 过滤
     * @param compIds
     * @return
     */
    List<CompanyRoleBO> findAllSysRoleListByCompIds(List<Long> compIds);


    /**
     * 查询运营后台角色配置角色列表
     *
     * @param sysCompanyRoleConfigBO
     * @return
     */
    List<SysCompanyRoleModel> findSysCompanyRoleConfigList(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 查询系统公司角色列表
     * @param sysCompanyRoleConfigBO
     * @return
     */
    List<SysCompanyRoleModel> findSysCompanyRoleList(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 查询运营后台角色配置角色列表角色数量
     * @param sysCompanyRoleConfigBO
     * @return
     */
    Integer findSysCompanyRoleConfigListRoleCount(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 查询运营后台角色配置角色详情
     *
     * @param sysCompanyRoleConfigBO
     * @return
     */
    SysCompanyRoleModel findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 根据角色ID修改运营后台角色配置角色信息
     *
     * @param sysCompanyRoleConfigBO
     * @return
     */
    Integer editSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 根据角色ID修改运营后台角色配置角色信息为is_deleted=1删除状态
     *
     * @param sysCompanyRoleConfigBO
     * @return
     */
    Integer removeSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 运营后台角色配置角色添加
     * @param sysCompanyRoleConfigBO
     * @return
     */
    Integer addSysCompanyRoleConfigRole(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * 检查系统公司角色名称是否重复
     * @param sysCompanyRoleConfigBO
     * @return
     */
    SysCompanyRoleModel checkSysCompanyRoleNameIsOrNotExisit(SysCompanyRoleConfigBO sysCompanyRoleConfigBO);

    /**
     * app-管理-角色管理-角色列表-查询系统公司角色列表
     * @param sysCompanyRoleBO
     * @return
     */
    List<SysCompanyRoleModel> findSyCompanyRoleList(SysCompanyRoleBO sysCompanyRoleBO);

    /**
     * app-管理-角色管理-角色列表-查询系统公司角色详情
     * @param sysCompanyRoleBO
     * @return
     */
    SysCompanyRoleModel finsSysCompanyRoleInfo(SysCompanyRoleBO sysCompanyRoleBO);

    /**
     * 查询不是这些角色名称的角色列表
     * @return
     */
    List<SysCompanyRoleModel> findRoleListByCondition(SysCompanyRoleBO sysCompanyRoleBO);

}
