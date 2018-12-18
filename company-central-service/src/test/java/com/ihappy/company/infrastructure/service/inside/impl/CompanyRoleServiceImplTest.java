package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.BaseTest;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CompanyRoleServiceImplTest  extends BaseTest {

    @Test
    public void findOneRoleByCompIdAndRoleId() {
        CompanyRoleService companyRoleService = getBean("companyRoleService");
        Map map = new HashMap<>();
        map.put("compId", 1L);
        map.put("roleId", 1L);
        companyRoleService.findOneRoleByCompIdAndRoleId(map);
    }
}