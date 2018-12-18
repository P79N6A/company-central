package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import org.junit.Test;

/**
 * Created by liuhc on 2018/5/16.
 */
public class SysCompanyTypeRpcServiceTest extends BaseTest {

    @Test
    public void findSysRoleListByRoleIdList() throws Exception {
        SysCompanyTypeRpcService sysCompanyTypeRpcService = getBean("sysCompanyTypeRpcService");
        SysCompanyTypeAllQuery sysCompanyTypeAllQuery = new SysCompanyTypeAllQuery();
        System.out.println(JSON.toJSONString(sysCompanyTypeRpcService.queryAllSysCompanyType(sysCompanyTypeAllQuery)));
    }
}
