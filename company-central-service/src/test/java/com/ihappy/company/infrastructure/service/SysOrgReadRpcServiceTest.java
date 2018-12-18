package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByIdQueryRpcReqDTO;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByOrgIdListQuery;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoByIdQueryRpcRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhc on 2018/6/14.
 */
public class SysOrgReadRpcServiceTest extends BaseTest {
    @Test
    public void getAllChildSysOrgById() throws Exception {
        SysOrgReadRpcService service = getBean("sysOrgReadRpcService");
        SysOrgBasicInfoByIdQueryRpcReqDTO reqDTO = new SysOrgBasicInfoByIdQueryRpcReqDTO();
        reqDTO.setOrgId(29L);
        Result<SysOrgBasicInfoByIdQueryRpcRespDTO> res = service.getAllChildSysOrgById(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findSysRoleListByRoleIdList() throws Exception {
        SysOrgReadRpcService sysOrgReadRpcService = getBean("sysOrgReadRpcService");
        SysOrgBasicInfoByOrgIdListQuery sysOrgBasicInfoByOrgIdListQuery = new SysOrgBasicInfoByOrgIdListQuery();
        List<Long> orgList = new ArrayList<Long>();
        orgList.add(1L);
        orgList.add(2L);
        sysOrgBasicInfoByOrgIdListQuery.setOrgIdList(orgList);
        System.out.println(JSON.toJSONString(sysOrgReadRpcService.getSysOrgBasicInfo(sysOrgBasicInfoByOrgIdListQuery)));
    }
}
