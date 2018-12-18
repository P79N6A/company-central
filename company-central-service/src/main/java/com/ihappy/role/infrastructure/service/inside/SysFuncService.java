package com.ihappy.role.infrastructure.service.inside;

import com.ihappy.role.domain.bo.SysFuncBO;
import com.ihappy.role.domain.bo.SysFuncByClIdBO;
import com.ihappy.role.domain.bo.SysFuncListBO;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/16.
 */
public interface SysFuncService {

    /**
     * 查询所有权限
     * @param sysFuncByClIdBO
     * @return
     */
    List<SysFuncModel> selectSysFuncByList(SysFuncByClIdBO sysFuncByClIdBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表查询
     * @param sysFuncListBO
     * @return
     */
    List<SysFuncModel> querySysFuncMenuBackstageMenuList(SysFuncListBO sysFuncListBO);

    /**
     *  运营后台-平台设定-功能菜单-后台-菜单列表-删除菜单
     * @param sysFuncBO
     * @return
     */
    int removeSysFuncMenuBackstageMenu(SysFuncBO sysFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-添加菜单
     * @param sysFuncBO
     * @return
     */
    int addSysFuncMenuBackstageMenu(SysFuncBO sysFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-查看菜单详情
     * @param sysFuncBO
     * @return
     */
    SysFuncModel findSysFuncMenuBackstageMenuInfo(SysFuncBO sysFuncBO);

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表-编辑-修改菜单
     * @param sysFuncBO
     * @return
     */
    int editSysFuncMenuBackstageMenuInfo(SysFuncBO sysFuncBO);

    /**
     * 判断菜单名称是否重复
     * @param sysFuncBO
     * @return
     */
    List<SysFuncModel> checkMenuNameIsOrNotRepeat(SysFuncBO sysFuncBO);

    /**
     * 判断菜单编号是否重复
     * @param sysFuncBO
     * @return
     */
    List<SysFuncModel> checkMenuNoIsOrNotRepeat(SysFuncBO sysFuncBO);
}
