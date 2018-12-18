package com.ihappy.role.infrastructure.repo.mybatis.mapper.sys;

import com.ihappy.role.domain.bo.SysFuncBO;
import com.ihappy.role.domain.bo.SysFuncByClIdBO;
import com.ihappy.role.domain.bo.SysFuncListBO;
import com.ihappy.role.domain.dbdo.sys.SysFunc;

import java.util.List;

public interface SysFuncMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_func
     *
     * @mbggenerated Sat Jun 16 10:08:39 CST 2018
     */
    int deleteByPrimaryKey(Integer ctFuncId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_func
     *
     * @mbggenerated Sat Jun 16 10:08:39 CST 2018
     */
    int insert(SysFunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_func
     *
     * @mbggenerated Sat Jun 16 10:08:39 CST 2018
     */
    int insertSelective(SysFunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_func
     *
     * @mbggenerated Sat Jun 16 10:08:39 CST 2018
     */
    SysFunc selectByPrimaryKey(Integer ctFuncId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_func
     *
     * @mbggenerated Sat Jun 16 10:08:39 CST 2018
     */
    int updateByPrimaryKeySelective(SysFunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_func
     *
     * @mbggenerated Sat Jun 16 10:08:39 CST 2018
     */
    int updateByPrimaryKey(SysFunc record);

    /**
     * 通过客户端查询所有权限
     *
     * @param sysFuncByClIdBO
     * @return
     */
    List<SysFunc> selectSysFuncByList(SysFuncByClIdBO sysFuncByClIdBO);


    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表查询
     *
     * @param sysFuncListBO
     * @return
     */
    List<SysFunc> selectSysFuncMenuBackstageMenuList(SysFuncListBO sysFuncListBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表总数查询
     *
     * @param sysFuncListBO
     * @return
     */
    int selectSysFuncMenuBackstageMenuListTotal(SysFuncListBO sysFuncListBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-菜单删除
     *
     * @param sysFuncBO
     * @return
     */
    int deleteSysFuncMenuBackstageMenu(SysFuncBO sysFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-菜单添加
     *
     * @param sysFuncBO
     * @return
     */
    int addSysFuncMenuBackstageMenu(SysFuncBO sysFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-查看菜单详情
     *
     * @param sysFuncBO
     * @return
     */
    SysFunc selectSysFuncMenuBackstageMenuInfo(SysFuncBO sysFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-编辑-修改菜单
     *
     * @param sysFuncBO
     * @return
     */
    int updateSysFuncMenuBackstageMenuInfo(SysFuncBO sysFuncBO);

    /**
     * 判断菜单名称是否重复
     *
     * @param sysFuncBO
     * @return
     */
    List<SysFunc> checkMenuNameIsOrNotRepeat(SysFuncBO sysFuncBO);

    /**
     * 检查菜单编号是否重复
     * @param sysFuncBO
     * @return
     */
    List<SysFunc> checkMenuNoIsOrNotRepeat(SysFuncBO sysFuncBO);
}