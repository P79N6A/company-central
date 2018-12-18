package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/9/20.
 */
public class CompanyRedisServiceRpcServiceTest extends BaseTest {
    @Test
    public void getAllPrivilegeByCtIdAndCLientIdQuery() throws Exception {
    }

    @Test
    public void getAllPrivilegeCLientIdQuery() throws Exception {
    }

    @Test
    public void getSysCompanyRoleList() throws Exception {
        CompanyRedisServiceRpcService service = getBean("companyRedisServiceRpcService");
        SysCompanyRoleQueryReqDTO reqDTO = new SysCompanyRoleQueryReqDTO();
        reqDTO.setRoleIds(Arrays.asList(1L,2L,3L));
        Result<List<SysCompanyRoleQueryRespDTO>> res = service.getSysCompanyRoleList(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}