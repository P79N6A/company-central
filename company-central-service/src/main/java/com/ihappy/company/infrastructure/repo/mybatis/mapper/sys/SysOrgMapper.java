package com.ihappy.company.infrastructure.repo.mybatis.mapper.sys;

import com.ihappy.company.domain.bo.SysOrgByOrgListBO;
import com.ihappy.company.domain.dbdo.SysOrg;

import java.util.List;

public interface SysOrgMapper {
    /**
     * 查询下级部门
     * @param record
     * @return
     */
    List<SysOrg> selectChildren(SysOrg record);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    int deleteByPrimaryKey(Long orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    int insert(SysOrg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    int insertSelective(SysOrg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    SysOrg selectByPrimaryKey(Long orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    int updateByPrimaryKeySelective(SysOrg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    int updateByPrimaryKey(SysOrg record);

    /**
     * 通过部门ID集合查询部门信息
     * @param sysOrgByOrgListBO
     * @return
     */
    List<SysOrg> getSysOrgListByOrgIdList(SysOrgByOrgListBO sysOrgByOrgListBO);
}