package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.CompanyBrandListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandListQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyBrandReadRpcServiceTest extends BaseTest {
    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void findCompanyBrandList() throws Exception {
        CompanyBrandReadRpcService companyBrandReadRpcService = getBean("companyBrandReadRpcService");
        CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO = new CompanyBrandListQueryReqDTO();
        companyBrandListQueryReqDTO.setCompId(1);
        //companyBrandListQueryReqDTO.setBrandName("公司名称");
        companyBrandListQueryReqDTO.setFuzzyBrandName("公司");
        Result<List<CompanyBrandListQueryRespDTO>> res = companyBrandReadRpcService.findCompanyBrandList(companyBrandListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}