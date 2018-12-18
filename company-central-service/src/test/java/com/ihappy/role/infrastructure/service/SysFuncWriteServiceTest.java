package com.ihappy.role.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuAddReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuInfoDelReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncMenuBackstageMenuUptateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuAddRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuInfoDelRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysFuncMenuBackstageMenuUptateRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;


public class SysFuncWriteServiceTest extends BaseTest {
    /**
     * 运营后台-平台设定-功能菜单-后台-菜单删除-测试通过
     *
     * @throws Exception
     */
    @Test
    public void delSysFuncMenuBackstageMenu() throws Exception {
        SysFuncWriteService sysFuncWriteService = getBean("sysFuncWriteService");
        SysFuncMenuBackstageMenuInfoDelReqDTO sysFuncMenuBackstageMenuInfoDelReqDTO = new SysFuncMenuBackstageMenuInfoDelReqDTO();
        sysFuncMenuBackstageMenuInfoDelReqDTO.setCtFuncId(195);
        sysFuncMenuBackstageMenuInfoDelReqDTO.setUpdateTime(new Date());
        sysFuncMenuBackstageMenuInfoDelReqDTO.setUpdateId(511703);
        Result<SysFuncMenuBackstageMenuInfoDelRespDTO> result = sysFuncWriteService.delSysFuncMenuBackstageMenuInfo(sysFuncMenuBackstageMenuInfoDelReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单添加-测试通过
     *
     * @throws Exception
     */
    @Test
    public void addSysFuncMenuBackstageMenu() throws Exception {
        SysFuncWriteService sysFuncWriteService = getBean("sysFuncWriteService");
        SysFuncMenuBackstageMenuAddReqDTO sysFuncMenuBackstageMenuAddReqDTO = new SysFuncMenuBackstageMenuAddReqDTO();
        sysFuncMenuBackstageMenuAddReqDTO.setFuncType(1);
        sysFuncMenuBackstageMenuAddReqDTO.setCtFuncName("hehe");
        sysFuncMenuBackstageMenuAddReqDTO.setCtFuncNo("0099");
        sysFuncMenuBackstageMenuAddReqDTO.setParentCtFuncId(111);
        sysFuncMenuBackstageMenuAddReqDTO.setSourceCodes("");
        sysFuncMenuBackstageMenuAddReqDTO.setCtFuncLink("");
        sysFuncMenuBackstageMenuAddReqDTO.setCtSort(1);
        sysFuncMenuBackstageMenuAddReqDTO.setCtMemo("");
        sysFuncMenuBackstageMenuAddReqDTO.setCreateTime(new Date());
        sysFuncMenuBackstageMenuAddReqDTO.setCreateId(511703);
        Result<SysFuncMenuBackstageMenuAddRespDTO> result = sysFuncWriteService.addSysFuncMenuBackstageMenu(sysFuncMenuBackstageMenuAddReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));
    }

    /**
     * 运营后台-平台设定-功能菜单-后台-菜单修改--测试通过
     *
     * @throws Exception
     */
    @Test
    public void updateSysFuncMenuBackstageMenuInfo() throws Exception {
        SysFuncWriteService sysFuncWriteService = getBean("sysFuncWriteService");
        SysFuncMenuBackstageMenuUptateReqDTO sysFuncMenuBackstageMenuUptateReqDTO = new SysFuncMenuBackstageMenuUptateReqDTO();
        sysFuncMenuBackstageMenuUptateReqDTO.setCtFuncId(196);
        sysFuncMenuBackstageMenuUptateReqDTO.setFuncType(1);
        sysFuncMenuBackstageMenuUptateReqDTO.setCtFuncName("用");
        sysFuncMenuBackstageMenuUptateReqDTO.setCtFuncNo("H");
        sysFuncMenuBackstageMenuUptateReqDTO.setParentCtFuncId(111);
        sysFuncMenuBackstageMenuUptateReqDTO.setCtFuncLink("");
        sysFuncMenuBackstageMenuUptateReqDTO.setCtSort(1);
        sysFuncMenuBackstageMenuUptateReqDTO.setSourceCodes("");
        sysFuncMenuBackstageMenuUptateReqDTO.setCtMemo("");
        sysFuncMenuBackstageMenuUptateReqDTO.setUpdateTime(new Date());
        sysFuncMenuBackstageMenuUptateReqDTO.setUpdateId(511703);
        Result<SysFuncMenuBackstageMenuUptateRespDTO> result = sysFuncWriteService.updateSysFuncMenuBackstageMenuInfo(sysFuncMenuBackstageMenuUptateReqDTO);
        System.out.println(JSON.toJSONString(result.getModule()));
        System.out.println(JSON.toJSONString(result.isSuccess()));
        System.out.println(JSON.toJSONString(result.getErrCode()));
        System.out.println(JSON.toJSONString(result.getErrMsg()));


    }

    @Test
    public void testAll() throws Exception {
        delSysFuncMenuBackstageMenu();
        addSysFuncMenuBackstageMenu();
        updateSysFuncMenuBackstageMenuInfo();
    }
}
