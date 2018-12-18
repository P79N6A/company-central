package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeListQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.comp.SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO;
import org.junit.Test;

/**
 * zhangmengdan
 * create at 2018/8/23
 */
public class SysCompanyFuncMenuReadServiceTest extends BaseTest {
    SysCompanyFuncMenuReadService sysCompanyFuncMenuReadService;
    @Override
    public void setUp() throws Exception{
        super.setUp();
        sysCompanyFuncMenuReadService= (SysCompanyFuncMenuReadService) applicationContext.getBean("sysCompanyFuncMenuReadService");
    }
    /**
     * 运营后台-平台设定-功能菜单-应用-类型列表 -- 测试通过
     * @throws Exception
     */
    @Test
    public void findSysCompanyFuncMenuApplyTypeList() throws Exception{
        SysCompanyFuncMenuApplyTypeListQueryReqDTO sysCompanyFuncMenuApplyTypeListQueryReqDTO =new SysCompanyFuncMenuApplyTypeListQueryReqDTO();
        sysCompanyFuncMenuApplyTypeListQueryReqDTO.setIsSys(0);
        System.out.println(JSON.toJSONString(sysCompanyFuncMenuReadService.findSysFuncMenuApplyTypeList(sysCompanyFuncMenuApplyTypeListQueryReqDTO)));
    }
    /**
     * 运营后台-平台设定-功能菜单-应用-类型-菜单列表
     * @throws Exception
     */
    @Test
    public void findSysCompanyFuncMenuApplyTypeMenuList()throws Exception{
        SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO =new SysCompanyFuncMenuApplyTypeMenuListQueryReqDTO();
        sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.setCtId(1);
        sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.setClId(1);
        sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO.setName("大");
        System.out.println(JSON.toJSONString(sysCompanyFuncMenuReadService.findSysFuncMenuApplyTypeMenuList(sysCompanyFuncMenuApplyTypeMenuListQueryReqDTO)));
    }
    /**
     * 运营后台-平台设定-功能菜单-应用-类型-菜单详情-- 测试通过
     * @throws Exception
     */
    @Test
    public void findSysCompanyFuncMenuApplyTypeMenuInfo()throws Exception{
        SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO=new SysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO();
        sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO.setCtFuncId(201);
        System.out.println(JSON.toJSONString(sysCompanyFuncMenuReadService.findSysCompanyFuncMenuApplyTypeMenuInfo(sysCompanyFuncMenuApplyTypeMenuInfoQueryReqDTO)));
    }

    @Test
    public void testAll() throws Exception {
        findSysCompanyFuncMenuApplyTypeList();
        findSysCompanyFuncMenuApplyTypeMenuList();
        findSysCompanyFuncMenuApplyTypeMenuInfo();
    }
}
