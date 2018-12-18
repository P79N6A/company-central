package com.ihappy.role.infrastructure.service.inside;

import com.ihappy.role.domain.bo.CheckRoleNameBO;
import com.ihappy.role.domain.bo.SysRoleManageBO;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
public interface SysRoleService {
    List<SysRoleModel> findRoleListByRoleIdList(List<Long> roleIdList);

    /**
     * 根据公司ID分页查询角色列表信息
     *
     * @param sysRoleManageBO
     * @return
     */
    List<SysRoleModel> findSysRoleManagePage(SysRoleManageBO sysRoleManageBO);

    /**
     * 根据公司ID分页查询角色列表信息角色数量
     *
     * @param sysRoleManageBO
     * @return
     */
    Integer findSysRoleManagePageRoleCount(SysRoleManageBO sysRoleManageBO);

    /**
     * 查询运营后台不是这个角色ID的角色名称
     */
    SysRoleModel checkSysRoleNameIsOrNotRepeat(CheckRoleNameBO checkRoleNameBO);

    /**
     * 根据角色ID查询运营后台角色管理角色详情
     *
     * @param sysRoleManageBO
     * @return
     */
    SysRoleModel findSysRoleManageRoleInfoByRoleId(SysRoleManageBO sysRoleManageBO);


    /**
     * 添加运营后台角色管理角色信息
     *
     * @param sysRoleManageBO
     * @return
     */
    Integer addSysRoleManageRoleInfo(SysRoleManageBO sysRoleManageBO);

    /**
     * 根据角色ID更新运营后台角色管理角色信息
     *
     * @param sysRoleManageBO
     * @return
     */
    Integer editSysRoleManageRoleInfoByRoleId(SysRoleManageBO sysRoleManageBO);

    /**
     * 根据角色ID修改运营后台角色管理角色信息为is_deleted=1删除状态
     *
     * @param sysRoleManageBO
     * @return
     */
    Integer removeSysRoleManageRoleInfoByRoleId(SysRoleManageBO sysRoleManageBO);

}
