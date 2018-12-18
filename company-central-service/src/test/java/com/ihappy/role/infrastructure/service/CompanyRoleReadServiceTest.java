package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.dto.request.comp.*;
import com.ihappy.role.domain.dto.response.comp.*;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyRoleReadServiceTest extends BaseTest {
    @Test
    public void findRoleListByCompIdList() throws Exception {
        CompanyRoleReadService companyRoleReadService = getBean("companyRoleReadService");
        CompanyRoleByCompIdQueryReqDTO reqDTO = new CompanyRoleByCompIdQueryReqDTO();
        List<Long> roleIds = new ArrayList<Long>(Arrays.asList(1L));
        reqDTO.setCompIds(roleIds);
        Result<List<CompanyRoleQueryRespDTO>> res = companyRoleReadService.findRoleListByCompIdList(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }


    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findRoleListByRoleIdList() throws Exception {
        CompanyRoleReadService companyRoleReadService = getBean("companyRoleReadService");
        CompanyRoleQueryReqDTO companyRoleQueryReqDTO = new CompanyRoleQueryReqDTO();
        List<Long> roleIds = new ArrayList<Long>(Arrays.asList(30001L,2L));
        companyRoleQueryReqDTO.setRoleIds(roleIds);
        Result<List<CompanyRoleQueryRespDTO>> res = companyRoleReadService.findRoleListByRoleIdList(companyRoleQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void rolePrivilegeRedisUtil() throws Exception {
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getSysCompanyRole(ConfigCenterUtil.ENV,"3")));
        System.out.println(JSON.toJSONString(RolePrivilegeRedisUtil.getSysCompanyRole(ConfigCenterUtil.ENV,"3","1","2")));
    }

    /**
     * 查询公司角色列表 --测试通过
     * @throws Exception
     */
    @Test
    public void findRoleListByCompId() throws Exception{
        CompanyRoleReadService companyRoleReadService=getBean("companyRoleReadService");
        CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO=new CompanyRoleListQueryReqDTO();
        companyRoleListQueryReqDTO.setLoginPersonId(512023L);
        companyRoleListQueryReqDTO.setLoginCompId(78317L);
        Result<CompanyRoleListQueryRespDTO> result=companyRoleReadService.findRoleListByCompId(companyRoleListQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }
    /**
     * 查询单个角色信息-测试通过
     * @throws Exception
     */
    @Test
    public void findCompanyRoleInfoByRoleId() throws Exception{
        CompanyRoleReadService companyRoleReadService=getBean("companyRoleReadService");
        CompanyRoleInfoQueryReqDTO companyRoleInfoQueryReqDTO=new CompanyRoleInfoQueryReqDTO();
        companyRoleInfoQueryReqDTO.setLoginPersonId(511703L);
        companyRoleInfoQueryReqDTO.setLoginCompId(78002L);
        companyRoleInfoQueryReqDTO.setRoleId(72399718002L);
        Result<CompanyRoleAndFuncQueryRespDTO> result=companyRoleReadService.findRoleByRoleId(companyRoleInfoQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    /**
     * 公司角色类型列表 -- 测试通过
     * @throws Exception
     */
    @Test
    public void querySysCompanyRoleList()throws Exception{
        CompanyRoleReadService companyRoleReadService=getBean("companyRoleReadService");
        SysCompanyRoleListQueryReqDTO sysCompanyRoleListQueryReqDTO=new SysCompanyRoleListQueryReqDTO();
        sysCompanyRoleListQueryReqDTO.setLoginCompId(511703L);
        sysCompanyRoleListQueryReqDTO.setLoginPersonId(78002L);
        Result<SysCompanyRoleListQueryRespDTO> result=companyRoleReadService.findSysCompanyRoleList(sysCompanyRoleListQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
}
    /**
     * APP管理 角色管理 添加角色 角色菜单--测试成功
     * @throws Exception
     */
    @Test
    public void findCompanyRoleMenuList() throws Exception{
        CompanyRoleReadService companyRoleReadService=getBean("companyRoleReadService");
        CompanyRoleMenuQueryReqDTO companyRoleMenuQueryReqDTO=new CompanyRoleMenuQueryReqDTO();
        companyRoleMenuQueryReqDTO.setLoginCompId(78002L);
        companyRoleMenuQueryReqDTO.setLoginPersonId(511703L);
        Result<CompanyRoleMenuQueryRespDTO> result=companyRoleReadService.findCompanyRoleMenu(companyRoleMenuQueryReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        findRoleListByCompIdList();
        findRoleListByRoleIdList();
        rolePrivilegeRedisUtil();
        findRoleListByCompId();
        findCompanyRoleInfoByRoleId();
        querySysCompanyRoleList();
        findCompanyRoleMenuList();
    }

    /**
     * 通过不同的权限查询角色列表
     * @throws Exception
     */
    @Test
    public void findAppRoleListByDiffPower() throws Exception{
        CompanyRoleReadService companyRoleReadService=getBean("companyRoleReadService");
        AppRoleListQueryByDiffPowerReqDTO reqDTO=new AppRoleListQueryByDiffPowerReqDTO();
        reqDTO.setLoginPersonId(512023L);
        reqDTO.setLoginCompId(78317L);
        printResult(companyRoleReadService.findAppRoleListByDiffPower(reqDTO));
        System.out.println(JSON.toJSONString(companyRoleReadService.findAppRoleListByDiffPower(reqDTO)));
    }

}