package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

public class SysFuncReadServiceTest extends BaseTest {
    /**
     * 运营后台-平台设定-功能菜单-后台-菜单列表查询
     * @throws Exception
     */
    @Test
    public void findFuncMenuBackstageMenuList() throws Exception{
        SysFuncReadService sysFuncReadService=getBean("sysFuncReadService");
        SysFuncMenuBackstageMenuListQueryReqDTO sysFuncMenuBackstageMenuListQueryReqDTO=new SysFuncMenuBackstageMenuListQueryReqDTO();
        sysFuncMenuBackstageMenuListQueryReqDTO.setName("工");
        Result<List<SysFuncMenuBackstageMenuListQueryRespDTO>> result=sysFuncReadService.findSysFuncMenuBackstageMenuList(sysFuncMenuBackstageMenuListQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    /**
     * 运营后台-平台设定-功能菜单-后台=-菜单详情查询 -- 测试通过
     * @throws Exception
     */
    @Test
    public void findFuncMenuBackstageMenuInfo()throws Exception{
        SysFuncReadService sysFuncReadService=getBean("sysFuncReadService");
        SysFuncMenuBackstageMenuInfoQueryReqDTO sysFuncMenuBackstageMenuInfoQueryReqDTO=new SysFuncMenuBackstageMenuInfoQueryReqDTO();
        sysFuncMenuBackstageMenuInfoQueryReqDTO.setCtFuncId(118);
        Result<SysFuncMenuBackstageMenuInfoQueryRespDTO> result=sysFuncReadService.findSysFuncMenuBackstageMenuInfo(sysFuncMenuBackstageMenuInfoQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        findFuncMenuBackstageMenuList();
        findFuncMenuBackstageMenuInfo();
    }
}
