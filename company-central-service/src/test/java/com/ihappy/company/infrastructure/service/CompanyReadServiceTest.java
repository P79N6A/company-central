package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSONObject;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.company.interfaces.CompanyReadServiceImpl;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 11:34
 * *@content
 **/
public class CompanyReadServiceTest extends BaseTest {
    /**
     * 管理-查看公司信息
     * @throws Exception
     */
    @Test
    public void findBaseInfoCompany() throws Exception{
        CompanyReadService companyReadService=getBean("companyReadService");
        CompanyInfoQueryReqDTO companyInfoQueryReqDTO=new CompanyInfoQueryReqDTO();
        companyInfoQueryReqDTO.setCompId(78002);
        System.out.println(JSONObject.toJSONString(companyReadService.queryCompanyInfo(companyInfoQueryReqDTO)));
    }
}
