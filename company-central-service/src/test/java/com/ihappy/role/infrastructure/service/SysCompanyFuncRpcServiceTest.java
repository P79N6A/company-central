package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;
import java.util.List;


public class SysCompanyFuncRpcServiceTest extends BaseTest {

    @Test
    public void querySysCompanyFuncList() throws Exception {
        SysCompanyFuncReadRpcService sysCompanyFuncReadRpcService = getBean("sysCompanyFuncReadRpcService");
        SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO = new SysCompanyFuncListQueryReqDTO();
        sysCompanyFuncListQueryReqDTO.setClientId(2);
        sysCompanyFuncListQueryReqDTO.setCtId(2);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(1L);
        sysCompanyFuncListQueryReqDTO.setIsPerson(true);
        sysCompanyFuncListQueryReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<List<PrivilegeAllRespDTO>> result = sysCompanyFuncReadRpcService.selectSysCompanyFunctListByCtId(sysCompanyFuncListQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));


    }

    @Test
    public void querySysCompanyFuncList1() throws Exception {
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getAllPriv("dev", "2", "2")));


    }

    @Test
    public void queryRedisRoleTest() throws Exception {
        long startTime1 = new Date().getTime();
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getAllPriv(ConfigCenterUtil.ENV, "2", "2")));
        long endTime1 = new Date().getTime();
        System.out.println(endTime1 - startTime1);

        RolePrivilegeRedisUtil.delAllPriv(ConfigCenterUtil.ENV, "2", "2");

        long startTime2 = new Date().getTime();
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getAllPriv(ConfigCenterUtil.ENV, "2", "2")));
        long endTime2 = new Date().getTime();
        System.out.println(endTime2 - startTime2);

    }

    @Test
    public void querySysRedisRoleTest() throws Exception {
        long startTime1 = new Date().getTime();
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getAllSysPriv(ConfigCenterUtil.ENV, "1")));
        long endTime1 = new Date().getTime();
        System.out.println(endTime1 - startTime1);

        RolePrivilegeRedisUtil.delAllSysPriv(ConfigCenterUtil.ENV, "1");

        long startTime2 = new Date().getTime();
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getAllSysPriv(ConfigCenterUtil.ENV, "1")));
        long endTime2 = new Date().getTime();
        System.out.println(endTime2 - startTime2);

    }

    @Test
    public void testAll() throws Exception {
        querySysCompanyFuncList();
        querySysCompanyFuncList1();
        queryRedisRoleTest();
        querySysRedisRoleTest();
    }
}
