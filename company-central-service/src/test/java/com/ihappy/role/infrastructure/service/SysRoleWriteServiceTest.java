package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleManageRoleInfoDeleteByRoleIdReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysRoleMangeRoleUpdateReqDTO;
import org.junit.Test;

import java.util.Date;

public class SysRoleWriteServiceTest extends BaseTest {
    SysRoleWriteService sysRoleWriteService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sysRoleWriteService = (SysRoleWriteService) applicationContext.getBean("sysRoleWriteService");
    }

    /**
     * 添加运营后台角色管理角色信息 --测试通过
     *
     * @throws Exception
     */
    @Test
    public void addSysRoleManageRoleInfo() throws Exception {
        SysRoleManageRoleAddReqDTO sysRoleManageRoleAddReqDTO = new SysRoleManageRoleAddReqDTO();
        sysRoleManageRoleAddReqDTO.setRoleName("tt");
        sysRoleManageRoleAddReqDTO.setRoleMemo("ddd");
        sysRoleManageRoleAddReqDTO.setCreateTime(new Date());
        sysRoleManageRoleAddReqDTO.setCreateId(511703);
        sysRoleManageRoleAddReqDTO.setRoleRights("[{\"clId\":1,\"func\":\"1,3,13\"}]");
        System.out.println(JSON.toJSONString(sysRoleWriteService.addSysRoleManageRole(sysRoleManageRoleAddReqDTO)));
    }

    /**
     * 修改运营后台角色管理角色信息-- 测试通过
     *
     * @throws Exception
     */
    @Test
    public void updateSysRoleManageRoleInfo() throws Exception {
        SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO = new SysRoleMangeRoleUpdateReqDTO();
        sysRoleMangeRoleUpdateReqDTO.setRoleId(22L);
        sysRoleMangeRoleUpdateReqDTO.setRoleName("劳动法kk");
        sysRoleMangeRoleUpdateReqDTO.setRoleMemo("enne");
        sysRoleMangeRoleUpdateReqDTO.setRoleRights("[{\"clId\":1,\"func\":\"1,3\"}]");
        sysRoleMangeRoleUpdateReqDTO.setUpdateTime(new Date());
        sysRoleMangeRoleUpdateReqDTO.setUpdateId(511703);
        System.out.println(JSON.toJSONString(sysRoleWriteService.editSysRoleManageRoleInfoByRoleId(sysRoleMangeRoleUpdateReqDTO)));
    }

    /**
     * 删除运营后台角色管理角色信息 --测试通过
     *
     * @throws Exception
     */
    @Test
    public void deleteSysRoleManageRoleInfo() throws Exception {
        SysRoleManageRoleInfoDeleteByRoleIdReqDTO sysRoleManageRoleInfoDeleteByRoleIdReqDTO = new SysRoleManageRoleInfoDeleteByRoleIdReqDTO();
        sysRoleManageRoleInfoDeleteByRoleIdReqDTO.setRoleId(22L);
        sysRoleManageRoleInfoDeleteByRoleIdReqDTO.setUpdateTime(new Date());
        sysRoleManageRoleInfoDeleteByRoleIdReqDTO.setUpdateId(511703);
        System.out.println(JSON.toJSONString(sysRoleWriteService.removeSysRoleManageRoleInfoByRoleId(sysRoleManageRoleInfoDeleteByRoleIdReqDTO)));
    }
    @Test
    public void testAll() throws Exception {
        addSysRoleManageRoleInfo();
        updateSysRoleManageRoleInfo();
        deleteSysRoleManageRoleInfo();
    }
}
