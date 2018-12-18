package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.partner.AddInvateRegisterPartnerRespDTO;
import com.ihappy.partner.domain.dto.response.partner.CustomerInfoAddRespDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoAddRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/3.
 * 单元测试通过
 */
public class PartnerWriteRpcServiceTest extends BaseTest {



    protected PersonUserInfoDTO personUserInfoDTO;

    PartnerWriteRpcService partnerWriteRpcService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        partnerWriteRpcService = (PartnerWriteRpcService)applicationContext.getBean("partnerWriteRpcService");
        personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(78211l);
        personUserInfoDTO.setPersonId(78211l);



    }    @Test
    public void addPartnerByInvateRegister() throws Exception {
        AddInvateRegisterPartnerReqDTO reqDTO = new AddInvateRegisterPartnerReqDTO();

        reqDTO.setCompId(201L);
        reqDTO.setPartnerCompId(109L);
        reqDTO.setPartnerType(0);
        reqDTO.setPartnerName("供应商");
        reqDTO.setReceiveUserId(1L);

        reqDTO.setRegisterCompanyMobile("17099351840");

        Result<AddInvateRegisterPartnerRespDTO> res = partnerWriteRpcService.addPartnerByInvateRegister(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void addProvider() throws Exception {
        PartnerWriteRpcService partnerWriteRpcService = getBean("partnerWriteRpcService");
        ProviderInfoAddReqDTO providerInfoAddReqDTO = new ProviderInfoAddReqDTO();
        providerInfoAddReqDTO.setUpdateId(1L);
        providerInfoAddReqDTO.setCreateTime(new Date());
        providerInfoAddReqDTO.setUpdateTime(new Date());
        providerInfoAddReqDTO.setCreateId(1L);
        providerInfoAddReqDTO.setCompId(18533);
        providerInfoAddReqDTO.setCompName("企业名称添加测试1");
        providerInfoAddReqDTO.setPartnerName("伙伴企业名");
        providerInfoAddReqDTO.setPartnerType(1);
        providerInfoAddReqDTO.setMobile("18205425865");
        providerInfoAddReqDTO.setCreatedPersonId(1);
        providerInfoAddReqDTO.setPartnerLinkman("联系人");
        providerInfoAddReqDTO.setProvince("省");
        providerInfoAddReqDTO.setCity("天津市");
        providerInfoAddReqDTO.setZone("河东区");
        providerInfoAddReqDTO.setPartnerAddress("伙伴公司详细地址");
        providerInfoAddReqDTO.setBankName("开户银行");
        providerInfoAddReqDTO.setBankAccountName("银行账户");
        providerInfoAddReqDTO.setBankAccountNumber("银行账号");
        providerInfoAddReqDTO.setMail("邮箱");
        providerInfoAddReqDTO.setFax("传真");
        providerInfoAddReqDTO.setPartnerMemo("伙伴备注");
        providerInfoAddReqDTO.setHeadPortraitAddress("/public/uploads/0/goods/20180526/201805261407565646214.png");
        providerInfoAddReqDTO.setPartnerArrears(1000L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        providerInfoAddReqDTO.setIsPerson(true);
        providerInfoAddReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<ProviderInfoAddRespDTO> res = partnerWriteRpcService.addProvider(providerInfoAddReqDTO);
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
    public void updateProvider() throws Exception {
        PartnerWriteRpcService partnerWriteRpcService = getBean("partnerWriteRpcService");
        ProviderInfoUpdateReqDTO providerInfoUpdateReqDTO = new ProviderInfoUpdateReqDTO();
        providerInfoUpdateReqDTO.setUpdateTime(new Date());
        providerInfoUpdateReqDTO.setPartnerId(570090L);
        providerInfoUpdateReqDTO.setPartnerName("伙伴企业名修改神其");
        providerInfoUpdateReqDTO.setMobile("手机号");

        providerInfoUpdateReqDTO.setPartnerType(0);
        providerInfoUpdateReqDTO.setPartnerLinkman("联系人");
        providerInfoUpdateReqDTO.setProvince("省");
        providerInfoUpdateReqDTO.setCity("市");
        providerInfoUpdateReqDTO.setZone("区");
        /*providerInfoUpdateReqDTO.setPartnerAddress("伙伴公司详细地址");
        providerInfoUpdateReqDTO.setBankName("开户银行");
        providerInfoUpdateReqDTO.setBankAccountName("银行账户");
        providerInfoUpdateReqDTO.setBankAccountNumber("银行账号");
        providerInfoUpdateReqDTO.setMail("邮箱");
        providerInfoUpdateReqDTO.setFax("传真");
        providerInfoUpdateReqDTO.setPartnerMemo("伙伴备注");
        providerInfoUpdateReqDTO.setHeadPortraitAddress("头像地址");*/
        providerInfoUpdateReqDTO.setPartnerArrears(100L);
        providerInfoUpdateReqDTO.setTel("");
        providerInfoUpdateReqDTO.setUpdateId(1L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(90L);
        providerInfoUpdateReqDTO.setIsPerson(true);
        providerInfoUpdateReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<String> res = partnerWriteRpcService.updateProvider(providerInfoUpdateReqDTO);
        System.out.println(JSON.toJSONString(providerInfoUpdateReqDTO));
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
    public void addCustomer() throws Exception {
        PartnerWriteRpcService partnerWriteRpcService = getBean("partnerWriteRpcService");
        CustomerInfoAddReqDTO customerInfoAddReqDTO = new CustomerInfoAddReqDTO();
        customerInfoAddReqDTO.setUpdateId(1L);
        customerInfoAddReqDTO.setCreateTime(new Date());
        customerInfoAddReqDTO.setUpdateTime(new Date());
        customerInfoAddReqDTO.setCreateId(1L);
        customerInfoAddReqDTO.setCompId(1);
        customerInfoAddReqDTO.setCompName("企业名称");
        customerInfoAddReqDTO.setPartnerName("");
        customerInfoAddReqDTO.setPartnerType(0);
        customerInfoAddReqDTO.setMobile("手机号");
        customerInfoAddReqDTO.setCreatedPersonId(1);
        customerInfoAddReqDTO.setPartnerLinkman("");
        customerInfoAddReqDTO.setWechatAccountName("");
        customerInfoAddReqDTO.setProvince("省");
        customerInfoAddReqDTO.setCity("市");
        customerInfoAddReqDTO.setZone("区");
        customerInfoAddReqDTO.setPartnerAddress("伙伴公司详细地址");
        customerInfoAddReqDTO.setBankName("开户银行");
        customerInfoAddReqDTO.setBankAccountName("银行账户");
        customerInfoAddReqDTO.setBankAccountNumber("银行账号");
        customerInfoAddReqDTO.setMail("邮箱");
        customerInfoAddReqDTO.setFax("传真");
        customerInfoAddReqDTO.setPartnerMemo("伙伴备注");
        customerInfoAddReqDTO.setHeadPortraitAddress("头像地址");
        customerInfoAddReqDTO.setPartnerArrears(1L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(90L);
        customerInfoAddReqDTO.setIsPerson(true);
        customerInfoAddReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<CustomerInfoAddRespDTO> res = partnerWriteRpcService.addCustomer(customerInfoAddReqDTO);
        System.out.println(JSON.toJSONString(customerInfoAddReqDTO));
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     *单元测试通过
     * @throws Exception
     */
    @Test
    public void updateCustomer() throws Exception {
        PartnerWriteRpcService partnerWriteRpcService = getBean("partnerWriteRpcService");
        CustomerInfoUpdateReqDTO customerInfoUpdateReqDTO = new CustomerInfoUpdateReqDTO();
        customerInfoUpdateReqDTO.setPartnerId(570090L);
        customerInfoUpdateReqDTO.setPartnerName("客户名称");
//        customerInfoUpdateReqDTO.setPartnerLinkman("联系人名称");
        customerInfoUpdateReqDTO.setPartnerType(1);
        customerInfoUpdateReqDTO.setMobile("18205485675");
//        customerInfoUpdateReqDTO.setPartnerLinkman("联系人");
        customerInfoUpdateReqDTO.setWechatAccountName("");
        customerInfoUpdateReqDTO.setProvince("省");
        customerInfoUpdateReqDTO.setCity("市");
        customerInfoUpdateReqDTO.setZone("区");
        customerInfoUpdateReqDTO.setPartnerAddress("伙伴公司详细地址");
        customerInfoUpdateReqDTO.setBankName("开户银行");
        customerInfoUpdateReqDTO.setBankAccountName("银行账户");
        customerInfoUpdateReqDTO.setBankAccountNumber("银行账号");
        customerInfoUpdateReqDTO.setMail("邮箱");
        customerInfoUpdateReqDTO.setFax("传真");
        customerInfoUpdateReqDTO.setPartnerMemo("伙伴备注");
        customerInfoUpdateReqDTO.setHeadPortraitAddress("/public/uploads/0/goods/20180526/201805261407565646214.png");
        //customerInfoUpdateReqDTO.setPartnerArrears(-1L);
        customerInfoUpdateReqDTO.setLoginCompId(90L);
        customerInfoUpdateReqDTO.setWechatAccountName("32323123");
        customerInfoUpdateReqDTO.setLoginPersonId(137642L);

        Result<String> res = partnerWriteRpcService.updateCustomer(customerInfoUpdateReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void partnerQueryOrAdd() throws Exception {
        PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO = new PartnerQueryOrAddReqDTO();
        partnerQueryOrAddReqDTO.setCompId(78211l);
        partnerQueryOrAddReqDTO.setPartnerCompId(78118l);
        partnerQueryOrAddReqDTO.setType(2);
        partnerQueryOrAddReqDTO.setMobile("15555555556");
        partnerQueryOrAddReqDTO.setPartnerType(1);

        partnerQueryOrAddReqDTO.setLoginCompId(personUserInfoDTO.getCompId());
        partnerQueryOrAddReqDTO.setLoginPersonId(personUserInfoDTO.getPersonId());

        Result<PartnerInfoQueryRespDTO> respDTOResult = partnerWriteRpcService.partnerQueryOrAdd(partnerQueryOrAddReqDTO);
        System.out.print(JSON.toJSONString(respDTOResult));
    }

    @Test
    public void delCompanyPartner() throws Exception {
        PartnerWriteRpcService partnerWriteRpcService = getBean("partnerWriteRpcService");
        CompanyPartnerDelReqDTO companyPartnerDelReqDTO = new CompanyPartnerDelReqDTO();
        companyPartnerDelReqDTO.setPartnerId(74102358328L);
        companyPartnerDelReqDTO.setLoginCompId(78328L);
        companyPartnerDelReqDTO.setLoginPersonId(512046L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(512046L);
        companyPartnerDelReqDTO.setIsPerson(true);
        companyPartnerDelReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<String> res = partnerWriteRpcService.delCompanyPartner(companyPartnerDelReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        addPartnerByInvateRegister();
        addProvider();
        updateProvider();
        addCustomer();
        updateCustomer();
    //    delCompanyPartner();
    }
}