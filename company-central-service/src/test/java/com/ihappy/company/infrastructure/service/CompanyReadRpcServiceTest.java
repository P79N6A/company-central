package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.company.domain.dto.request.BaseinfoCompanyReqDTO;
import com.ihappy.company.domain.dto.request.CompanyInfoListQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigListQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoWithoutLoginQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyServiceStatusPageQueryReqDTO;
import com.ihappy.company.domain.dto.response.BaseinfoCompanyRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoListQueryRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoQueryRespDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigListRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExpireDateQueryRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyInfoWithoutLoginQueryRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyServiceStatusPageQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyReadRpcServiceTest extends BaseTest {
    @Test
    public void queryCompanyServiceStatusPage() throws Exception {
        CompanyReadRpcService service = getBean("companyReadRpcService");
        CompanyServiceStatusPageQueryReqDTO reqDTO = new CompanyServiceStatusPageQueryReqDTO();
        //reqDTO.setPeriodOfValidity(1);
        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        reqDTO.setPeriodOfValidity(-1);

        Result<Page<CompanyServiceStatusPageQueryRespDTO>> res = service.queryCompanyServiceStatusPage(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findCompanyInfoWithoutLogin() throws Exception {
        CompanyReadRpcService service = getBean("companyReadRpcService");
        CompanyInfoWithoutLoginQueryReqDTO reqDTO = new CompanyInfoWithoutLoginQueryReqDTO();
        reqDTO.setCompId(78211);
        Result<CompanyInfoWithoutLoginQueryRespDTO> res = service.findCompanyInfoWithoutLogin(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findBaseinfoCompanyPage() throws Exception {
        CompanyReadRpcService service = getBean("companyReadRpcService");
        BaseinfoCompanyReqDTO reqDTO = new BaseinfoCompanyReqDTO();
        reqDTO.setLimit(10);
        reqDTO.setOffset(0);
        //reqDTO.setCompShortName("78466");
        //reqDTO.setBossMobile("1833333");
        //reqDTO.setCompShortName("大师傅似的1");
        Result<Page<BaseinfoCompanyRespDTO>> res = service.findBaseinfoCompanyPage(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findBaseinfoCompanyList() throws Exception {
        CompanyReadRpcService companyReadRpcService = getBean("companyReadRpcService");
        BaseinfoCompanyReqDTO baseinfoCompanyReqDTO = new BaseinfoCompanyReqDTO();
        /*baseinfoCompanyReqDTO.setCompName("海贝");
        baseinfoCompanyReqDTO.setStatus(1);*/
        baseinfoCompanyReqDTO.setCompShortName("紫");
        baseinfoCompanyReqDTO.setCtIds("86");
        baseinfoCompanyReqDTO.setOffset(0);
        baseinfoCompanyReqDTO.setLimit(10);
        baseinfoCompanyReqDTO.setIsVerified(2);
        Result<Page<BaseinfoCompanyRespDTO>> res = companyReadRpcService.findBaseinfoCompanyPage(baseinfoCompanyReqDTO);
        System.out.println(JSON.toJSONString(res.getModule().getResult()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findCompanyInfo() throws Exception {
        CompanyReadRpcService companyReadRpcService = getBean("companyReadRpcService");
        CompanyInfoQueryReqDTO companyInfoQueryReqDTO = new CompanyInfoQueryReqDTO();
        companyInfoQueryReqDTO.setCompId(78211);
        Result<CompanyInfoQueryRespDTO> res = companyReadRpcService.findCompanyInfo(companyInfoQueryReqDTO);
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
    public void findCompanyInfoListByIds() throws Exception {
        CompanyReadRpcService companyReadRpcService = getBean("companyReadRpcService");
        CompanyInfoListQueryReqDTO companyInfoListQueryReqDTO = new CompanyInfoListQueryReqDTO();
        List<Integer> compIds = new ArrayList<Integer>(Arrays.asList(108,78051,1));
        companyInfoListQueryReqDTO.setCompIds(compIds);
        Result<List<CompanyInfoListQueryRespDTO>> res = companyReadRpcService.findCompanyInfoListByIds(companyInfoListQueryReqDTO);
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
    public void queryCompanyExpireDate() throws Exception {
        CompanyReadRpcService companyReadRpcService = getBean("companyReadRpcService");
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setLoginCompId(1L);
        companyInfoByCompIdQuery.setLoginPersonId(219L);
        Result<CompanyExpireDateQueryRespDTO> res = companyReadRpcService.queryCompanyExpireDate(companyInfoByCompIdQuery);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
    @Test
    public void testFindCompanyPrintConfigList(){
        CompanyReadRpcService companyReadRpcService = getBean("companyReadRpcService");
        CompanyPrintConfigListQueryReqDTO reqDTO = new CompanyPrintConfigListQueryReqDTO();
        reqDTO.setCompId(109L);
        Result<List<CompanyPrintConfigListRespDTO>> result = companyReadRpcService.findCompanyPrintConfigList(reqDTO);
        System.out.println(JSON.toJSON(result.getModule()));
    }

}