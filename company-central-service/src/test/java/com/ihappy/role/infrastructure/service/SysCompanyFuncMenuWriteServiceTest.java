package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuDelReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO;
import org.junit.Test;

import java.util.Date;

/**
 * created by zhangmengdan
 * create at 2018/8/23
 */
public class SysCompanyFuncMenuWriteServiceTest extends BaseTest {
    SysCompanyFuncMenuWriteService sysCompanyFuncMenuWriteService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sysCompanyFuncMenuWriteService = (SysCompanyFuncMenuWriteService) applicationContext.getBean("sysCompanyFuncMenuWriteService");
    }
    /**
     * 运营后台-平台设定-功能菜单-应用-类型-添加菜单--测试成功
     *
     * @throws Exception
     */
    @Test
    public void addSysCompanyFuncMenuApplyTypeMenu() throws Exception {
        SysCompanyFuncMenuApplyTypeMenuAddReqDTO sysCompanyFuncMenuApplyTypeMenuAddReqDTO = new SysCompanyFuncMenuApplyTypeMenuAddReqDTO();
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setClId(1);
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCtId(1);
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCtFuncName("lfflll");
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCtFuncLink("");
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCtFuncNo("879");
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCtMemo("");
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCtSort(1);
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setParentCtFuncId(0);
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setFuncType(1);
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setSourceCodes("");
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCreateTime(new Date());
        sysCompanyFuncMenuApplyTypeMenuAddReqDTO.setCreateId(511703);
        System.out.println(JSON.toJSONString(sysCompanyFuncMenuWriteService.addSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncMenuApplyTypeMenuAddReqDTO)));
    }

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-修改菜单--测试成功
     *
     * @throws Exception
     */
    @Test
    public void updateSysCompanyFuncMenuApplyTypeMenu() throws Exception {
        SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO = new SysCompanyFuncMenuApplyTypeMenuUpdateReqDTO();
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtId(1);
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setClId(2);
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtFuncId(283);
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtFuncName("lK");
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtFuncLink("");
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtFuncNo("09000");
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtMemo("");
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setCtSort(1);
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setParentCtFuncId(62);
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setFuncType(1);
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setSourceCodes("");
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setUpdateTime(new Date());
        sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO.setUpdateId(511703);
        System.out.println(JSON.toJSONString(sysCompanyFuncMenuWriteService.updateSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncMenuApplyTypeMenuUpdateReqDTO)));
    }

    /**
     * 运营后台-平台设定-功能菜单-应用-类型-删除菜单-测试成功
     *
     * @throws Exception
     */
    @Test
    public void delSysCompanyFuncMenuApplyTypeMenu() throws Exception {
        SysCompanyFuncMenuApplyTypeMenuDelReqDTO sysCompanyFuncMenuApplyTypeMenuDelReqDTO = new SysCompanyFuncMenuApplyTypeMenuDelReqDTO();
        sysCompanyFuncMenuApplyTypeMenuDelReqDTO.setCtFuncId(276);
        sysCompanyFuncMenuApplyTypeMenuDelReqDTO.setUpdateTime(new Date());
        sysCompanyFuncMenuApplyTypeMenuDelReqDTO.setUpdateId(511703);
        System.out.println(JSON.toJSONString(sysCompanyFuncMenuWriteService.removeSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncMenuApplyTypeMenuDelReqDTO)));
    }

    @Test
    public void testAll() throws Exception {
        addSysCompanyFuncMenuApplyTypeMenu();
        updateSysCompanyFuncMenuApplyTypeMenu();
        delSysCompanyFuncMenuApplyTypeMenu();
    }
}
