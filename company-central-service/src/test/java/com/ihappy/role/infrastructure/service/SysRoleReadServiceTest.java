package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoQueryByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleInfoQueryByRoleIdRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleManageRoleListQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/6/17.
 */
public class SysRoleReadServiceTest extends BaseTest {
    SysRoleReadService sysRoleReadService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sysRoleReadService = (SysRoleReadService) applicationContext.getBean("sysRoleReadService");
    }

    /**
     * @throws Exception
     */

    @Test
    public void findSysRoleListByRoleIdList() throws Exception {
        SysRoleQueryReqDTO reqDTO = new SysRoleQueryReqDTO();
        List<Long> roleIds = new ArrayList<Long>(Arrays.asList(1L, 2L));
        reqDTO.setRoleIds(roleIds);
        Result<List<SysRoleQueryRespDTO>> res = sysRoleReadService.findSysRoleListByRoleIdList(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 查询运营后台角色管理角色列表   --  测试通过
     *
     * @throws Exception
     */
    @Test
    public void findSysRoleManageRoleList() throws Exception {
        SysRoleManageRoleListQueryReqDTO sysRoleManageRoleListQueryReqDTO = new SysRoleManageRoleListQueryReqDTO();
        sysRoleManageRoleListQueryReqDTO.setLimit(10);
        sysRoleManageRoleListQueryReqDTO.setOffset(0);
        sysRoleManageRoleListQueryReqDTO.setKeyWords("角色");
        Result<Page<SysRoleManageRoleListQueryRespDTO>> result = sysRoleReadService.findSysRoleManageRoleList(sysRoleManageRoleListQueryReqDTO);
        System.out.println(JSON.toJSONString(sysRoleReadService.findSysRoleManageRoleList(sysRoleManageRoleListQueryReqDTO)));
    }

    /**
     * 查询运营后台角色管理角色详情 -- 测试通过
     *
     * @throws Exception
     */
    @Test
    public void findSysRoleManageRoleInfo() throws Exception {
        SysRoleManageRoleInfoQueryByRoleIdReqDTO sysRoleManageRoleInfoQueryByRoleIdReqDTO = new SysRoleManageRoleInfoQueryByRoleIdReqDTO();
        sysRoleManageRoleInfoQueryByRoleIdReqDTO.setRoleId(1L);
        Result<SysRoleManageRoleInfoQueryByRoleIdRespDTO> result = sysRoleReadService.findSysRoleManageRoleInfoByRoleId(sysRoleManageRoleInfoQueryByRoleIdReqDTO);
        System.out.println(JSON.toJSONString(sysRoleReadService.findSysRoleManageRoleInfoByRoleId(sysRoleManageRoleInfoQueryByRoleIdReqDTO)));

    }
    @Test
    public void testAll() throws Exception {
        findSysRoleListByRoleIdList();
        findSysRoleManageRoleList();
        findSysRoleManageRoleInfo();
    }
}