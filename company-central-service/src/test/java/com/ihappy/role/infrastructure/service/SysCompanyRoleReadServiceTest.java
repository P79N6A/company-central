package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.sys.*;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/4.
 */
public class SysCompanyRoleReadServiceTest extends BaseTest {
    @Test
    public void findSysRoleListByRoleIdList() throws Exception {
        SysCompanyRoleReadService sysCompanyRoleReadService = getBean("sysCompanyRoleReadService");
        SysCompanyRoleQueryReqDTO sysCompanyRoleQueryReqDTO = new SysCompanyRoleQueryReqDTO();
        List<Long> roleIds = new ArrayList<Long>(Arrays.asList(2L));
        sysCompanyRoleQueryReqDTO.setRoleIds(roleIds);
        Result<List<SysCompanyRoleQueryRespDTO>> res = sysCompanyRoleReadService.findSysRoleListByRoleIdList(sysCompanyRoleQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
    /**
     * 查询运营后台角色配置角色列表--测试通过
     * @throws Exception
     */
    @Test
    public void findSysRoleConfigRoleList()throws Exception{
        SysCompanyRoleReadService sysCompanyRoleReadService = getBean("sysCompanyRoleReadService");
        SysCompanyRoleConfigRoleListQueryReqDTO sysCompanyRoleConfigRoleListQueryReqDTO =new SysCompanyRoleConfigRoleListQueryReqDTO();
        sysCompanyRoleConfigRoleListQueryReqDTO.setKeyWords("角色");
        sysCompanyRoleConfigRoleListQueryReqDTO.setLimit(10);
        sysCompanyRoleConfigRoleListQueryReqDTO.setOffset(0);
        System.out.println(JSON.toJSONString(sysCompanyRoleReadService.findSysCompanyRoleConfigRolePage(sysCompanyRoleConfigRoleListQueryReqDTO)));

    }
    /**
     * 查询运营后台角色配置角色详情-- 测试通过
     * @throws Exception
     */
    @Test
    public void findSysRoleConfigRoleInfo()throws Exception{
        SysCompanyRoleReadService sysCompanyRoleReadService = getBean("sysCompanyRoleReadService");
        SysCompanyRoleConfigRoleInfoQueryReqDTO sysCompanyRoleConfigRoleInfoQueryReqDTO =new SysCompanyRoleConfigRoleInfoQueryReqDTO();
        sysCompanyRoleConfigRoleInfoQueryReqDTO.setRoleId(1L);
        System.out.println(JSON.toJSONString(sysCompanyRoleReadService.findSysCompanyRoleConfigRoleInfo(sysCompanyRoleConfigRoleInfoQueryReqDTO)));
    }

    /**
     * 运营后台角色配置角色详情应用配置类型列表是否选中详情-- 测试通过
     * @throws Exception
     */
    @Test
    public void findSysCompanyRoleInfoTypeClientListProcess() throws Exception{
    SysCompanyRoleReadService sysCompanyRoleReadService = getBean("sysCompanyRoleReadService");
    SysCompanyRoleInfoTypeClientListQueryReqDTO sysCompanyRoleInfoTypeClientListQueryReqDTO=new SysCompanyRoleInfoTypeClientListQueryReqDTO();
    sysCompanyRoleInfoTypeClientListQueryReqDTO.setIsSys(0);
    sysCompanyRoleInfoTypeClientListQueryReqDTO.setRoleId(1L);
    System.out.println(JSON.toJSONString(sysCompanyRoleReadService.findSysCompanyRoleInfoTypeClientList(sysCompanyRoleInfoTypeClientListQueryReqDTO)));
}

    /**运营后台角色配置角色应用详情配置类型菜单 --测试通过
     * @throws Exception
     */
    @Test
    public void findSysCompanyRoleConfigRoleInfoMenu() throws Exception {
        SysCompanyRoleReadService sysCompanyRoleReadService = getBean("sysCompanyRoleReadService");
        SysCompanyRoleInfoTypeClientFuncListQueryReqDTO sysCompanyRoleInfoTypeClientFuncListQueryReqDTO = new SysCompanyRoleInfoTypeClientFuncListQueryReqDTO();
        sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.setRoleId(2L);
        sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.setCtId(1);
        sysCompanyRoleInfoTypeClientFuncListQueryReqDTO.setClId(2);
        System.out.println(JSON.toJSONString(sysCompanyRoleReadService.findSysCompanyRoleInfoTypeClientFuncList(sysCompanyRoleInfoTypeClientFuncListQueryReqDTO)));
    }

    @Test
    public void testAll() throws Exception {
        findSysRoleListByRoleIdList();
        findSysRoleConfigRoleList();
        findSysRoleConfigRoleInfo();
        findSysCompanyRoleInfoTypeClientListProcess();
        findSysCompanyRoleConfigRoleInfoMenu();
    }
}