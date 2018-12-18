package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sunjd on 2018/6/25.
 */
public class CompanyCompletionInfoWriteRpcServiceTest extends BaseTest {
    @Test
    public void completionInfo() throws Exception {
        CompanyCompletionInfoWriteRpcService service = getBean("companyCompletionInfoWriteRpcService");
        CompanyCompletionInfoReqDTO reqDTO = new CompanyCompletionInfoReqDTO();
        reqDTO.setBusinessCategory("1,2,3,4,5");
        reqDTO.setCompId(2);

        Result<String> res = service.completionInfo(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}