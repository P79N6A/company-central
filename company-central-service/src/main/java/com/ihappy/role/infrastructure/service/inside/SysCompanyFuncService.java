package com.ihappy.role.infrastructure.service.inside;

import com.ihappy.role.domain.bo.*;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;

import java.util.List;

public interface SysCompanyFuncService {
    /**
     * 通过业务类型 查询所有权限
     *
     * @param sysCompanyFuncByCtIdQuery
     * @return
     */
    List<SysCompanyFuncModel> selectSysCompanyFunctListByCtId(SysCompanyFuncByCtIdQuery sysCompanyFuncByCtIdQuery);

    /**
     * 查找运营后台角色配置角色信息应用配置类型菜单
     *
     * @param sysCompanyRoleConfigRoleInfoTypeMenuBO
     * @return
     */
    List<SysCompanyFuncModel> findSysCompanyRoleConfigRoleInfoTypeMenu(SysCompanyRoleConfigRoleInfoTypeMenuBO sysCompanyRoleConfigRoleInfoTypeMenuBO);

    /**
     * 查询系统公司类型菜单
     *
     * @param sysCompanyFuncBO
     * @return
     */
    SysCompanyFuncModel findSysCompanyFuncByCtFuncId(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询公司角色菜单列表
     *
     * @param companyRoleMenuBO
     * @return
     */
    List<SysCompanyFuncModel> findCompanyRoleMenuList(CompanyRoleMenuBO companyRoleMenuBO);

    /**
     * 查询app-管理-角色管理-添加角色-菜单列表
     *
     * @param companyRoleAddRoleMenuBO
     * @return
     */
    List<SysCompanyFuncModel> findCompanyRoleAddRoleMenuList(CompanyRoleAddRoleMenuBO companyRoleAddRoleMenuBO);

    /**
     * 根据ctId和clId查询系统公司功能菜单列表
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFuncModel> findSysCompanyFuncListByctIdclId(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询系统公司功能菜单列表
     *
     * @param sysCompanyFuncBO
     * @return
     */

    List<SysCompanyFuncModel> findSysCompanyFuncList(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询运营后台-平台设定-功能菜单-应用-类型-菜单列表
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFuncModel> selectSysCompanyFuncMenuApplyTypeMenuList(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询运营后台-平台设定-功能菜单-应用-类型-菜单列表数量
     *
     * @param sysCompanyFuncBO
     * @return
     */
    int selectSysCompanyFuncMenuApplyTypeMenuListCount(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询运营后台-平台设定-功能菜单-应用-类型-添加菜单
     *
     * @param sysCompanyFuncBO
     * @return
     */
    int addSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询运营后台-平台设定-功能菜单-应用-类型-修改菜单
     *
     * @param sysCompanyFuncBO
     * @return
     */
    int editSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-添加或修改-检查菜单名称是否重复
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFuncModel> checkMenuNameIsOrNotRepeat(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-添加或修改-检查菜单编号是否重复
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFuncModel> checkMenuNoIsOrNotRepeat(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-删除菜单
     *
     * @param sysCompanyFuncBO
     * @return
     */
    int removeSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO);

}
