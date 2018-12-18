package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/5/3.
 */
public class PartnerLevelInsideRpcServiceTest extends BaseTest {
    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void updateReferenceCount() throws Exception {
        PartnerLevelInsideRpcService service = getBean("partnerLevelInsideRpcService");
        PartnerLevelReferenceCountReqDTO reqDTO = new PartnerLevelReferenceCountReqDTO();
        reqDTO.setOperation(-1);
        List<Long> partnerLevelIds = Arrays.asList(10001L,20001L,30001L);
        reqDTO.setPartnerLevelIds(partnerLevelIds);
        Result<PartnerLevelReferenceCountRespDTO> res = service.updateReferenceCount(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}