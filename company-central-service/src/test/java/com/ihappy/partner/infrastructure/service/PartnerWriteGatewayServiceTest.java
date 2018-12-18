package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.partner.domain.dto.request.partner.CompanyPartnerDelReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerInfoEnableReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.CompanyPartnerDelRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerInfoEnableRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 13:26
 * *@content
 **/
public class PartnerWriteGatewayServiceTest extends BaseTest {
    /**
     * 添加会员 --测试通过
     * @throws Exception
     */
    @Test
    public void addRetailCustomer() throws Exception {
        PartnerWriteGatewayService service = getBean("partnerWriteGatewayService");
        RetailCustomerAddReqDTO reqDTO = new RetailCustomerAddReqDTO();
        reqDTO.setPartnerName("ccccccccccccc");
        reqDTO.setMobile("18205426503");
        reqDTO.setHeadPortraitAddress("");
        reqDTO.setShoppingGuideId(31L);
        reqDTO.setStoreId(10001L);
        reqDTO.setWechatAccountName("ccccccccccccccc");
        reqDTO.setLoginCompId(1L);
        reqDTO.setLoginPersonId(1L);
        System.out.println(JSON.toJSONString(reqDTO));
        Result<RetailCustomerAddRespDTO> res = service.addRetailCustomer(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
    /**
     * 修改会员 --测试通过
     * @throws Exception
     */
    @Test
    public void updateRetailCustomer() throws Exception {
        PartnerWriteGatewayService service = getBean("partnerWriteGatewayService");
        RetailCustomerUpdateReqDTO reqDTO = new RetailCustomerUpdateReqDTO();
        reqDTO.setPartnerId(74103568213L);
        reqDTO.setPartnerName("hhh");
        reqDTO.setHeadPortraitAddress("xxxxxxx头像");
        reqDTO.setShoppingGuideId(511908L);
        reqDTO.setStoreId(678348213L);
        reqDTO.setMobile("13958028036");
        reqDTO.setWechatAccountName("zmd1xxxxx92");
        reqDTO.setLoginCompId(78213L);
        reqDTO.setLoginPersonId(511907L);
        System.out.println(JSON.toJSONString(reqDTO));
        Result<RetailCustomerUpdateRespDTO> res = service.updateRetailCustomer(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 禁用会员-测试通过
     * @throws Exception
     */
    @Test
    public void forbidCompanyPartner() throws Exception {
        PartnerWriteGatewayService service = getBean("partnerWriteGatewayService");
        CompanyPartnerDelReqDTO companyPartnerDelReqDTO = new CompanyPartnerDelReqDTO();
        companyPartnerDelReqDTO.setPartnerId(74104008491L);
        companyPartnerDelReqDTO.setLoginCompId(78491L);
        companyPartnerDelReqDTO.setLoginPersonId(512261L);
        Result<CompanyPartnerDelRespDTO> res = service.forbidCompanyPartner(companyPartnerDelReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 启用会员信息 -- 测试通过
     * @throws Exception
     */
    @Test
    public void enableRetailCustomerInfo() throws Exception {
        PartnerWriteGatewayService service = getBean("partnerWriteGatewayService");
        RetailCustomerInfoEnableReqDTO reqDTO = new RetailCustomerInfoEnableReqDTO();
        reqDTO.setPartnerId(74103038211L);
        reqDTO.setLoginCompId(78211L);
        reqDTO.setLoginPersonId(511897L);
        Result<RetailCustomerInfoEnableRespDTO> res = service.unforbidCompanyPartner(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
}
