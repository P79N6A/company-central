package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunjd on 2018/5/1.
 */
public class PartnerLevelReadRpcServiceTest extends BaseTest {

    @Test
    public void findPartnerLevel() throws Exception {
        PartnerLevelReadRpcService partnerLevelReadRpcService = getBean("partnerLevelReadRpcService");
        PartnerLevelQueryReqDTO reqDTO = new PartnerLevelQueryReqDTO();
        reqDTO.setPartnerLevelId(30001L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<PartnerLevelQueryRespDTO> res = partnerLevelReadRpcService.findPartnerLevel(reqDTO);

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
    public void findPartnerLevelList() throws Exception {
        PartnerLevelReadRpcService partnerLevelReadRpcService = getBean("partnerLevelReadRpcService");
        PartnerLevelListQueryReqDTO reqDTO = new PartnerLevelListQueryReqDTO();
        reqDTO.setPartnerLevel("VIP1");

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<List<PartnerLevelQueryRespDTO>> res = partnerLevelReadRpcService.findPartnerLevelList(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        findPartnerLevel();
        findPartnerLevelList();
    }

}