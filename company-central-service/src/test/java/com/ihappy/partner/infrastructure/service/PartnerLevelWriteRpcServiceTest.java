package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;

/**
 * Created by sunjd on 2018/5/1.
 */
public class PartnerLevelWriteRpcServiceTest extends BaseTest {
    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void addPartnerLevel() throws Exception {
        PartnerLevelWriteRpcService service = getBean("partnerLevelWriteRpcService");
        PartnerLevelAddReqDTO reqDTO = new PartnerLevelAddReqDTO();
        reqDTO.setDiscount(70);
        reqDTO.setPartnerLevel("超级sssssssssss会员");
        //reqDTO.setPartnerType(0);
        //reqDTO.setStoreId(1L);
        reqDTO.setPartnerMemo("备注");

        reqDTO.setCreateTime(new Date());
        reqDTO.setUpdateTime(new Date());
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        System.out.println(JSON.toJSONString(reqDTO));
        Result<PartnerLevelAddRespDTO> res = service.addPartnerLevel(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void updatePartnerLevel() throws Exception {
        PartnerLevelWriteRpcService service = getBean("partnerLevelWriteRpcService");
        PartnerLevelUpdateReqDTO reqDTO = new PartnerLevelUpdateReqDTO();
        reqDTO.setPartnerLevelId(30001L);
        reqDTO.setDiscount(72);
        reqDTO.setPartnerLevel("高级会sssssssssssssssssssssssss员1");
        //reqDTO.setPartnerType(0);
        //reqDTO.setStoreId(1L);
        reqDTO.setPartnerMemo("备注1");

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        System.out.println(JSON.toJSONString(reqDTO));
        Result<String> res = service.updatePartnerLevel(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void delPartnerLevel() throws Exception {
        PartnerLevelWriteRpcService service = getBean("partnerLevelWriteRpcService");
        PartnerLevelDelReqDTO reqDTO = new PartnerLevelDelReqDTO();
        reqDTO.setPartnerLevelId(30001L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(1L);
        reqDTO.setIsPerson(true);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        System.out.println(JSON.toJSONString(reqDTO));
        Result<String> res = service.delPartnerLevel(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        addPartnerLevel();
        updatePartnerLevel();
        delPartnerLevel();
    }

}