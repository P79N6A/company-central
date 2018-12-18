package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/8/13.
 */
public class BackdoorRpcServiceTest extends BaseTest {
    @Test
    public void refreshPartnerStatics() throws Exception {
        BackdoorRpcService service = getBean("backdoorRpcService");
        VoidReqDTO reqDTO = new VoidReqDTO();
        Result<String> res = service.refreshPartnerStatics(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}