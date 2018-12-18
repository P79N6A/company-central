package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.bo.SysOrgByOrgListBO;
import com.ihappy.company.domain.dbdo.SysOrg;
import com.ihappy.company.domain.model.model.SysOrgModel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public interface SysOrgService {

    /**
     * 通过部门id集合查询部门信息
     * @param sysOrgByOrgListBO
     * @return
     */
    List<SysOrgModel> getSysOrgListByOrgIdList(SysOrgByOrgListBO sysOrgByOrgListBO);

    /**
     * 根据id查询 Org
     * @param sysOrg
     * @return
     */
    SysOrgModel getSysOrgByOrgId(SysOrg sysOrg);

    /**
     * 查询下一级部门列表
     * @param sysOrg
     * @return
     */
    List<SysOrgModel> getChildSysOrgByOrgId(SysOrg sysOrg);

    /**
     * 查询所有子节点部门列表
     * @param sysOrgs
     * @return
     */
    List<SysOrgModel> getAllChildSysOrgByOrgId(List<SysOrg> sysOrgs);
}
