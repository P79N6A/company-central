package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.sys.*;
import org.junit.Test;

import java.util.Date;

public class SysCompanyRoleWriteServiceTest extends BaseTest {
    SysCompanyRoleWriteService sysCompanyRoleWriteService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sysCompanyRoleWriteService = (SysCompanyRoleWriteService) applicationContext.getBean("sysCompanyRoleWriteService");
    }

    /**
     * 运营后台平台设定角色配置角色添加应用配置类型列表查询-- 测试通过
     */
    @Test
    public void querySysCompanyRoleAddTypeClientList() throws Exception {
        SysCompanyRoleAddTypeClientListQueryReqDTO sysCompanyRoleAddTypeClientListQueryReqDTO = new SysCompanyRoleAddTypeClientListQueryReqDTO();
        sysCompanyRoleAddTypeClientListQueryReqDTO.setIsSys(0);
        System.out.println(JSON.toJSONString(sysCompanyRoleWriteService.findSysCompanyRoleAddTypeClientList(sysCompanyRoleAddTypeClientListQueryReqDTO)));
    }

    /**
     * 运营后台平台设定角色配置角色添加应用配置类型功能列表查询--测试通过
     *
     * @throws Exception
     */
    @Test
    public void querySysCompanyRoleAddTypeClientFuncList() throws Exception {
        SysCompanyRoleAddTypeClientFuncListQueryReqDTO sysCompanyRoleAddTypeClientFuncListQueryReqDTO = new SysCompanyRoleAddTypeClientFuncListQueryReqDTO();
        sysCompanyRoleAddTypeClientFuncListQueryReqDTO.setClId(2);
        sysCompanyRoleAddTypeClientFuncListQueryReqDTO.setCtId(2);
        System.out.println(JSON.toJSONString(sysCompanyRoleWriteService.findSysCompanyRoleAddTypeClientFuncList(sysCompanyRoleAddTypeClientFuncListQueryReqDTO)));
    }

    /**
     * 添加运营后台角色配置角色信息 --测试通过
     *
     * @throws Exception
     */
    @Test
    public void addSysCompanyRoleConfigRoleInfo() throws Exception {
        SysCompanyRoleConfigRoleAddReqDTO sysCompanyRoleConfigRoleAddReqDTO = new SysCompanyRoleConfigRoleAddReqDTO();
        sysCompanyRoleConfigRoleAddReqDTO.setRoleName("yy");
        sysCompanyRoleConfigRoleAddReqDTO.setRoleMemo("sssss");
        sysCompanyRoleConfigRoleAddReqDTO.setRoleRights("[{\"clId\":2,\"ctId\":1,\"func\":\"256,2,3,259,4,5,6,262\"}]");
        sysCompanyRoleConfigRoleAddReqDTO.setCreateTime(new Date());
        sysCompanyRoleConfigRoleAddReqDTO.setCreateId(511703);
        System.out.println(JSON.toJSONString(sysCompanyRoleWriteService.addSysCompanyRoleConfigRole(sysCompanyRoleConfigRoleAddReqDTO)));
    }

    /**
     * 修改运营后台角色配置角色信息 -- 测试通过
     *
     * @throws Exception
     */
    @Test
    public void updateSyCompanyRoleConfigRoleInfo() throws Exception {
        SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO = new SysCompanyRoleConfigRoleInfoUpdateReqDTO();
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.setRoleId(4L);
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.setRoleName("kee");
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.setRoleMemo("cc");
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.setRoleRights("[{\"ctId\":1,\"clId\":2,\"func\":\"1\"}]");
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.setUpdateTime(new Date());
        sysCompanyRoleConfigRoleInfoUpdateReqDTO.setUpdateId(511884);
        System.out.println(JSON.toJSONString(sysCompanyRoleWriteService.editSysCompanyRoleConfigRoleInfoByRoleId(sysCompanyRoleConfigRoleInfoUpdateReqDTO)));
    }

    /**
     * 删除运营后台角色配置角色信息 -- 测试通过
     *
     * @throws Exception
     */
    @Test
    public void deleteSysCompanyRoleConfigRoleInfo() throws Exception {
        SysCompanyRoleConfigRoleDeleteReqDTO sysCompanyRoleConfigRoleDeleteReqDTO = new SysCompanyRoleConfigRoleDeleteReqDTO();
        sysCompanyRoleConfigRoleDeleteReqDTO.setRoleId(30L);
        sysCompanyRoleConfigRoleDeleteReqDTO.setUpdateTime(new Date());
        sysCompanyRoleConfigRoleDeleteReqDTO.setUpdateId(511703);
        System.out.println(JSON.toJSONString(sysCompanyRoleWriteService.removeSysCompanyRoleConfigRole(sysCompanyRoleConfigRoleDeleteReqDTO)));
    }

    @Test
    public void testAll() throws Exception {
        querySysCompanyRoleAddTypeClientList();
        querySysCompanyRoleAddTypeClientFuncList();
        addSysCompanyRoleConfigRoleInfo();
        updateSyCompanyRoleConfigRoleInfo();
        deleteSysCompanyRoleConfigRoleInfo();
    }
}
