package com.ihappy.role.infrastructure.repo.mybatis.mapper.sys;

import com.ihappy.role.domain.dbdo.sys.SysCompanyFunc;
import com.ihappy.role.domain.bo.*;

import java.util.List;

public interface SysCompanyFuncMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_company_func
     *
     * @mbg.generated Thu May 31 15:44:54 CST 2018
     */
    int deleteByPrimaryKey(Integer ctFuncId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_company_func
     *
     * @mbg.generated Thu May 31 15:44:54 CST 2018
     */
    int insert(SysCompanyFunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_company_func
     *
     * @mbg.generated Thu May 31 15:44:54 CST 2018
     */
    int insertSelective(SysCompanyFunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_company_func
     *
     * @mbg.generated Thu May 31 15:44:54 CST 2018
     */
    List<SysCompanyFunc> selectByPrimaryKey(Integer ctFuncId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_company_func
     *
     * @mbg.generated Thu May 31 15:44:54 CST 2018
     */
    int updateByPrimaryKeySelective(SysCompanyFunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_company_func
     *
     * @mbg.generated Thu May 31 15:44:54 CST 2018
     */
    int updateByPrimaryKey(SysCompanyFunc record);

    /**
     * 通过业务类型 查询所有权限
     *
     * @param sysCompanyFuncByCtIdQuery
     * @return
     */
    List<SysCompanyFunc> selecSysCompanyFunctListByCtId(SysCompanyFuncByCtIdQuery sysCompanyFuncByCtIdQuery);

    /**
     * 查询运营后台角色配置角色信息应用配置类型菜单
     *
     * @param sysCompanyRoleConfigRoleInfoTypeMenuBO
     * @return
     */
    List<SysCompanyFunc> selectSysCompanyRoleConfigRoleInfoTypeMenu(SysCompanyRoleConfigRoleInfoTypeMenuBO sysCompanyRoleConfigRoleInfoTypeMenuBO);

    /**
     * 查询系统公司类型菜单
     *
     * @param sysCompanyFuncBO
     * @return
     */
    SysCompanyFunc findSysCompanyFuncByCtFuncId(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询公司角色菜单列表
     *
     * @param companyRoleMenuBO
     * @return
     */
    List<SysCompanyFunc> selectCompanyRoleMenuList(CompanyRoleMenuBO companyRoleMenuBO);

    /**
     * 查询app-管理-角色管理-添加角色-菜单列表
     *
     * @param companyRoleAddRoleMenuBO
     * @return
     */
    List<SysCompanyFunc> selectCompanyRoleAddRoleMenuList(CompanyRoleAddRoleMenuBO companyRoleAddRoleMenuBO);

    /**
     * 根据ctId和clId查询系统公司功能菜单
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFunc> selectSysCompanyFuncListByctIdclId(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 查询系统公司功能菜单列表
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFunc> selectSysCompanyFuncList(SysCompanyFuncBO sysCompanyFuncBO);
    /**
     * 查询运营后台-平台设定-功能菜单-应用-类型-菜单列表
     *
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFunc> selectSysCompanyFuncMenuApplyTypeMenuList(SysCompanyFuncBO sysCompanyFuncBO);
    /**
     * 查询运营后台-平台设定-功能菜单-应用-类型-菜单列表数量
     *
     * @param sysCompanyFuncBO
     * @return
     */
    int selectSysCompanyFuncMenuApplyTypeMenuListCount(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-添加菜单
     * @param sysCompanyFuncBO
     * @return
     */
    int insertSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO);
    /**
     * 运营后台-平台设定-功能菜单-应用-类型-修改菜单
     * @param sysCompanyFuncBO
     * @return
     */
    int updateSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-添加或修改-检查菜单名称是否重复
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFunc> checkMenuNameIsOrNotRepeat(SysCompanyFuncBO sysCompanyFuncBO);
    /**
     * 运营后台-平台设定-功能菜单-应用-类型-添加或修改-检查菜单编号是否重复
     * @param sysCompanyFuncBO
     * @return
     */
    List<SysCompanyFunc> checkMenuNoIsOrNotRepeat(SysCompanyFuncBO sysCompanyFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-删除菜单
     * @param sysCompanyFuncBO
     * @return
     */
    int delSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO);

}