package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleAddReqDTO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleDelReqDTO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleDelRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;

public class CompanyRoleWriteServiceTest extends BaseTest {

    /**
     * APP-管理-角色管理-角色添加--测试成功
     * @throws Exception
     */
    @Test
    public void addCompanyRole() throws Exception{
        CompanyRoleWriteService companyRoleWriteService=getBean("companyRoleWriteService");
        CompanyRoleAddReqDTO companyRoleAddReqDTO=new CompanyRoleAddReqDTO();
        companyRoleAddReqDTO.setLoginCompId(1L);
        companyRoleAddReqDTO.setRoleName("dy");
        companyRoleAddReqDTO.setRoleNo("xc");
        companyRoleAddReqDTO.setRoleMemo("xhng");
        companyRoleAddReqDTO.setRoleRights("[{\"clId\":2,\"ctId\":1,\"func\":\"256,259,5,7,8,9,265,10,20,22,34,35,232,233,36,37,40,42,43,44,46,60,61,62,191,222,224\"},{\"clId\":2,\"ctId\":2,\"func\":\"67,69,70,71,72,82,93,94,236,238,95,96,99,101,102,103,105,119,120,121,192,223,225,257,260,266\"},{\"ctId\":1,\"clId\":2,\"func\":\"1,2,3\"}]");
        companyRoleAddReqDTO.setLoginPersonId(511703L);
        companyRoleAddReqDTO.setIsHide(0);
        companyRoleAddReqDTO.setCreateTime(new Date());
        companyRoleAddReqDTO.setCreateId(511703);
        System.out.println(JSON.toJSONString(companyRoleWriteService.addCompanyRoleByCompId(companyRoleAddReqDTO)));


    }

    /**
     * APP-管理-角色管理-角色修改--测试通过
     * @throws Exception
     */
    @Test
    public void updateCompanyRoleInfo() throws Exception{
        CompanyRoleWriteService companyRoleWriteService=getBean("companyRoleWriteService");
        CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO=new CompanyRoleUpdateReqDTO();
        companyRoleUpdateReqDTO.setLoginPersonId(140172L);
        companyRoleUpdateReqDTO.setLoginCompId(2742L);
        companyRoleUpdateReqDTO.setRoleId(71349882742L);
        companyRoleUpdateReqDTO.setRoleName("店长1");
        companyRoleUpdateReqDTO.setRoleNo("2");
        companyRoleUpdateReqDTO.setRoleMemo("店长");
        companyRoleUpdateReqDTO.setIsHide(0);
        companyRoleUpdateReqDTO.setRoleRights("[{\"ctId\":1,\"clId\":2,\"func\":\"4,6,262,7,8,265,10,273,275,20,276,277,22,278,23,279,24,280,25,281,26,282,34,35,232,233,234,247,38,39,40,41,42,43,44,46,47,48,49,50,52,54,55,56,269,57,60,61,62,63,191,331,333,222,224,244\"}]");
        companyRoleUpdateReqDTO.setUpdateTime(new Date());
        companyRoleUpdateReqDTO.setUpdateId(140172L);
        Result<CompanyRoleUpdateRespDTO> result=companyRoleWriteService.editCompanyRoleByRoleId(companyRoleUpdateReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    /**
     * APP-管理-角色管理-角色-角色删除 --测试成功
     * @throws Exception
     */
    @Test
    public void deleteCompanyRoleByRoleId() throws Exception{
        CompanyRoleWriteService companyRoleWriteService=getBean("companyRoleWriteService");
        CompanyRoleDelReqDTO companyRoleDelReqDTO=new CompanyRoleDelReqDTO();
        companyRoleDelReqDTO.setLoginPersonId(511703L);
        companyRoleDelReqDTO.setLoginCompId(78002L);
        companyRoleDelReqDTO.setRoleId(72403978002L);
        companyRoleDelReqDTO.setUpdateTime(new Date());
        companyRoleDelReqDTO.setUpdateId(511703);
        Result<CompanyRoleDelRespDTO> result = companyRoleWriteService.removeCompanyRoleByRoleId(companyRoleDelReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        addCompanyRole();
        updateCompanyRoleInfo();
        deleteCompanyRoleByRoleId();
    }
}
