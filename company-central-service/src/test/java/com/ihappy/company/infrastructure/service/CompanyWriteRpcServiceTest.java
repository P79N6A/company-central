package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExpireStatusUpdateReqDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoAddRespDTO;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyWriteRpcServiceTest extends BaseTest {
    @Test
    public void updateCompanyPayRemark() throws Exception {
        CompanyWriteRpcService service = getBean("companyWriteRpcService");
        CompanyInfoUpdateReqDTO reqDTO = new CompanyInfoUpdateReqDTO();

        reqDTO.setLoginCompId(78203L);
        reqDTO.setLoginPersonId(511884L);
        reqDTO.setPayRemark("呵呵呵");
        reqDTO.setCompId(1);

        Result<String> res = service.updateCompanyPayRemark(reqDTO);
        System.out.println(JSON.toJSONString(res.isSuccess()));
    }

    @Test
    public void updateCompanyStatus() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyStatusReqDTO companyStatusReqDTO = new CompanyStatusReqDTO();
        companyStatusReqDTO.setCompId(89);
        companyStatusReqDTO.setStatus(0);

        companyStatusReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        companyStatusReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<String> res = companyWriteRpcService.updateCompanyStatus(companyStatusReqDTO);
        System.out.println(JSON.toJSONString(res.isSuccess()));
    }

    /**
     *单元测试通过
     * @throws Exception
     */
    @Test
    public void updateCompanyInfo() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO = new CompanyInfoUpdateReqDTO();
        companyInfoUpdateReqDTO.setCompId(78002);
       companyInfoUpdateReqDTO.setCompanyHead("");
        companyInfoUpdateReqDTO.setCompShortName("紫薇22");
        companyInfoUpdateReqDTO.setNature(0);
        companyInfoUpdateReqDTO.setBusinessCategory("女装");
        companyInfoUpdateReqDTO.setCtIds("3");
        companyInfoUpdateReqDTO.setArea("");
//        companyInfoUpdateReqDTO.setBankName("招商银行2");
//        companyInfoUpdateReqDTO.setBankAccountName("张三2");
//        companyInfoUpdateReqDTO.setBankAccountNumber("1234562");
//        companyInfoUpdateReqDTO.setAlipayAccountName("支付宝账号2");
//        companyInfoUpdateReqDTO.setPrintSize("80MM");
//        companyInfoUpdateReqDTO.setBillName("单据名称2");
//        companyInfoUpdateReqDTO.setWechatAccountName("微信账号2");
//
//        companyInfoUpdateReqDTO.setWechatAccountQrcode("01");
//        companyInfoUpdateReqDTO.setWechatAccountQrcodeContent("02");
//        companyInfoUpdateReqDTO.setWechatReceiptQrcode("03");
//        companyInfoUpdateReqDTO.setWechatReceiptQrcodeContent("04");
//        companyInfoUpdateReqDTO.setAlipayAccountQrcode("05");
//        companyInfoUpdateReqDTO.setAlipayAccountQrcodeContent("06");
//        companyInfoUpdateReqDTO.setAlipayReceiptQrcode("07");
//        companyInfoUpdateReqDTO.setAlipayReceiptQrcodeContent("08");
//        companyInfoUpdateReqDTO.setPrintBill(0);
        companyInfoUpdateReqDTO.setAllowNegativeOnHandSell(1);
        //companyInfoUpdateReqDTO.setPrintWarn("33");
      companyInfoUpdateReqDTO.setProvince("浙江");
        companyInfoUpdateReqDTO.setCity("杭州");
        companyInfoUpdateReqDTO.setCompAddress("");
        companyInfoUpdateReqDTO.setCompLinkman("");
        companyInfoUpdateReqDTO.setCompLinkmanTel("123434");
       companyInfoUpdateReqDTO.setZone("滨江区");
        companyInfoUpdateReqDTO.setCreateId(1);
        companyInfoUpdateReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        companyInfoUpdateReqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        Result<String> res = companyWriteRpcService.updateCompanyInfo(companyInfoUpdateReqDTO);
        System.out.println(JSON.toJSONString(companyInfoUpdateReqDTO));
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void updateCompanyInfoByRpc() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO = new CompanyInfoUpdateReqDTO();
        companyInfoUpdateReqDTO.setCompId(78051);
        companyInfoUpdateReqDTO.setCompShortName("紫薇5");
        companyInfoUpdateReqDTO.setNature(0);
        companyInfoUpdateReqDTO.setBusinessCategory("女装");
        companyInfoUpdateReqDTO.setCtIds("3");
        /*companyInfoUpdateReqDTO.setProvince("浙江");
        companyInfoUpdateReqDTO.setCity("杭州");*/
        companyInfoUpdateReqDTO.setCompAddress("");
        companyInfoUpdateReqDTO.setCompLinkman("");
        companyInfoUpdateReqDTO.setZone("");
        companyInfoUpdateReqDTO.setCreateId(1);
        companyInfoUpdateReqDTO.setIsPerson(true);

        companyInfoUpdateReqDTO.setBankName("招商银行1");
        companyInfoUpdateReqDTO.setBankAccountName("张三1");
        companyInfoUpdateReqDTO.setBankAccountNumber("1234561");
        companyInfoUpdateReqDTO.setAlipayAccountName("支付宝账号1");
        companyInfoUpdateReqDTO.setPrintSize("110MM");
        companyInfoUpdateReqDTO.setBillName("单据名称1");
        companyInfoUpdateReqDTO.setWechatAccountName("微信账号1");

        companyInfoUpdateReqDTO.setWechatAccountQrcode("11");
        companyInfoUpdateReqDTO.setWechatAccountQrcodeContent("22");
        companyInfoUpdateReqDTO.setWechatReceiptQrcode("33");
        companyInfoUpdateReqDTO.setWechatReceiptQrcodeContent("44");
        companyInfoUpdateReqDTO.setAlipayAccountQrcode("55");
        companyInfoUpdateReqDTO.setAlipayAccountQrcodeContent("66");
        companyInfoUpdateReqDTO.setAlipayReceiptQrcode("77");
        companyInfoUpdateReqDTO.setAlipayReceiptQrcodeContent("88");
        companyInfoUpdateReqDTO.setPrintBill(0);
        companyInfoUpdateReqDTO.setPrintWarn("22");
        companyInfoUpdateReqDTO.setAllowNegativeOnHandSell(0);

        Result<Void> res = companyWriteRpcService.updateCompanyInfoByRpc(companyInfoUpdateReqDTO);
        System.out.println(JSON.toJSONString(companyInfoUpdateReqDTO));
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
    public void addCompanyInfo() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyInfoAddReqDTO companyInfoAddReqDTO = new CompanyInfoAddReqDTO();
        companyInfoAddReqDTO.setAdminPersonId(512148L);
        companyInfoAddReqDTO.setAdminPersonName("");
        companyInfoAddReqDTO.setAdminPersonMobile("15099999977");
        companyInfoAddReqDTO.setCtNames("一级批发商");
        companyInfoAddReqDTO.setStatus(1);
        companyInfoAddReqDTO.setNature(1);
        companyInfoAddReqDTO.setCtIds("1");
        companyInfoAddReqDTO.setCompMemo("紫涵");
        companyInfoAddReqDTO.setBankName("招商银行");
        companyInfoAddReqDTO.setProvince("浙江");
        companyInfoAddReqDTO.setCity("杭州");
        companyInfoAddReqDTO.setZone("滨江");
        companyInfoAddReqDTO.setCompAddress("建业路伯盛渡口大厦");
        companyInfoAddReqDTO.setBankAccountName("张三");
        companyInfoAddReqDTO.setBankAccountNumber("123456");
        companyInfoAddReqDTO.setAlipayAccountName("支付宝账号");
        companyInfoAddReqDTO.setPrintSize("80MM");
        companyInfoAddReqDTO.setBillName("单据名称");
        companyInfoAddReqDTO.setWechatAccountName("微信账号");

        companyInfoAddReqDTO.setWechatAccountQrcode("1");
        companyInfoAddReqDTO.setWechatAccountQrcodeContent("2");
        companyInfoAddReqDTO.setWechatReceiptQrcode("3");
        companyInfoAddReqDTO.setWechatReceiptQrcodeContent("4");
        companyInfoAddReqDTO.setAlipayAccountQrcode("5");
        companyInfoAddReqDTO.setAlipayAccountQrcodeContent("6");
        companyInfoAddReqDTO.setAlipayReceiptQrcode("7");
        companyInfoAddReqDTO.setAlipayReceiptQrcodeContent("8");
        companyInfoAddReqDTO.setPrintBill(0);
        companyInfoAddReqDTO.setPrintWarn("11");
        companyInfoAddReqDTO.setAllowNegativeOnHandSell(0);
        companyInfoAddReqDTO.setBusinessCategory("2,3");

        companyInfoAddReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        companyInfoAddReqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        /*companyInfoAddReqDTO.setAdminPersonMobile();
        companyInfoAddReqDTO.setBusinessCategory();
        companyInfoAddReqDTO.setCity();
        companyInfoAddReqDTO.setCompAddress();
        companyInfoAddReqDTO.setCompLinkman();
        companyInfoAddReqDTO.setCompLinkmanTel();
        companyInfoAddReqDTO.setCompMemo();
        companyInfoAddReqDTO.setCompShortName();
        companyInfoAddReqDTO.setCompSort();
        companyInfoAddReqDTO.setCompZip();
        companyInfoAddReqDTO.setCtIds();

        companyInfoAddReqDTO.setFax();
        companyInfoAddReqDTO.setIsPlatform();
        companyInfoAddReqDTO.setNature();
        companyInfoAddReqDTO.setProvince();
        companyInfoAddReqDTO.setLicense();
        companyInfoAddReqDTO.setLicensePicurl();
        companyInfoAddReqDTO.setRegionId();
        companyInfoAddReqDTO.setVerifiedReason();
        companyInfoAddReqDTO.setZone();
        companyInfoAddReqDTO.setWebsite();
        companyInfoAddReqDTO.setVerifiedTime();
        companyInfoAddReqDTO.setTel();*/
        Result<CompanyInfoAddRespDTO> res = companyWriteRpcService.addCompanyInfo(companyInfoAddReqDTO);
        System.out.println(JSON.toJSONString(companyInfoAddReqDTO));
        System.out.println(JSON.toJSONString(res.getModule()));
    }

    @Test
    public void addCompanyInfoByRpc() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyInfoAddByRpcReqDTO companyInfoAddReqDTO = new CompanyInfoAddByRpcReqDTO();
        companyInfoAddReqDTO.setAdminPersonId(1L);
        companyInfoAddReqDTO.setCtIds("1");
        companyInfoAddReqDTO.setCreateId(0);
        companyInfoAddReqDTO.setCtNames("一级批发商");
        companyInfoAddReqDTO.setBankName("招商银行");
        companyInfoAddReqDTO.setBankAccountName("张三");
        companyInfoAddReqDTO.setBankAccountNumber("123456");
        companyInfoAddReqDTO.setAlipayAccountName("支付宝账号");
        companyInfoAddReqDTO.setPrintSize("80MM");
        companyInfoAddReqDTO.setBillName("单据名称");
        companyInfoAddReqDTO.setWechatAccountName("微信账号");

        companyInfoAddReqDTO.setWechatAccountQrcode("1");
        companyInfoAddReqDTO.setWechatAccountQrcodeContent("2");
        companyInfoAddReqDTO.setWechatReceiptQrcode("3");
        companyInfoAddReqDTO.setWechatReceiptQrcodeContent("4");
        companyInfoAddReqDTO.setAlipayAccountQrcode("5");
        companyInfoAddReqDTO.setAlipayAccountQrcodeContent("6");
        companyInfoAddReqDTO.setAlipayReceiptQrcode("7");
        companyInfoAddReqDTO.setAlipayReceiptQrcodeContent("8");
        companyInfoAddReqDTO.setPrintBill(0);
        companyInfoAddReqDTO.setPrintWarn("11");
        companyInfoAddReqDTO.setAllowNegativeOnHandSell(0);
        companyInfoAddReqDTO.setBusinessCategory("1");
        /*companyInfoAddReqDTO.setCtIds("45");
        companyInfoAddReqDTO.setAdminPersonName("负责人");
        companyInfoAddReqDTO.setCompName("测试添加公司12346");
        companyInfoAddReqDTO.setStatus(1);
        companyInfoAddReqDTO.setNature(1);
        companyInfoAddReqDTO.setAdminPersonId(1);
        companyInfoAddReqDTO.setCompMemo("测试");
        companyInfoAddReqDTO.setCreateId(1);
        companyInfoAddReqDTO.setCreatedPersonId(1L);*/
        /*companyInfoAddReqDTO.setAdminPersonMobile();
        companyInfoAddReqDTO.setBusinessCategory();
        companyInfoAddReqDTO.setCity();
        companyInfoAddReqDTO.setCompAddress();
        companyInfoAddReqDTO.setCompLinkman();
        companyInfoAddReqDTO.setCompLinkmanTel();
        companyInfoAddReqDTO.setCompMemo();
        companyInfoAddReqDTO.setCompShortName();
        companyInfoAddReqDTO.setCompSort();
        companyInfoAddReqDTO.setCompZip();
        companyInfoAddReqDTO.setCtIds();

        companyInfoAddReqDTO.setFax();
        companyInfoAddReqDTO.setIsPlatform();
        companyInfoAddReqDTO.setNature();
        companyInfoAddReqDTO.setProvince();
        companyInfoAddReqDTO.setLicense();
        companyInfoAddReqDTO.setLicensePicurl();
        companyInfoAddReqDTO.setRegionId();
        companyInfoAddReqDTO.setVerifiedReason();
        companyInfoAddReqDTO.setZone();
        companyInfoAddReqDTO.setWebsite();
        companyInfoAddReqDTO.setVerifiedTime();
        companyInfoAddReqDTO.setTel();*/
        Result<CompanyInfoAddRespDTO> res = companyWriteRpcService.addCompanyInfoByRpc(companyInfoAddReqDTO);
        System.out.println(JSON.toJSONString(companyInfoAddReqDTO));
        System.out.println(JSON.toJSONString(res.getModule()));
    }
    @Test
    public void updateCompanyExpireStatus() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyExpireStatusUpdateReqDTO companyExpireStatusUpdateReqDTO = new CompanyExpireStatusUpdateReqDTO();
        //companyExpireStatusUpdateReqDTO.setMemo("我在加备注哦");
        companyExpireStatusUpdateReqDTO.setCompId(1);
//        companyExpireStatusUpdateReqDTO.setExpireStatus(1);
        companyExpireStatusUpdateReqDTO.setExperienceDate(0);
        companyExpireStatusUpdateReqDTO.setStoreId(30001L);
        companyExpireStatusUpdateReqDTO.setStatus(1);
        companyExpireStatusUpdateReqDTO.setLoginPersonId(219L);
        companyExpireStatusUpdateReqDTO.setLoginCompId(78470L);
        Result<Void> res = companyWriteRpcService.updateCompanyExpireStatus(companyExpireStatusUpdateReqDTO);
        System.out.println(JSON.toJSONString(companyExpireStatusUpdateReqDTO));
        System.out.println(JSON.toJSONString(res.getModule()));
    }

    @Test
    public void updateCompanyPrintMode() throws Exception {
        CompanyWriteRpcService companyWriteRpcService = getBean("companyWriteRpcService");
        CompanyPrintModeUpdateReqDTO companyPrintModeUpdateReqDTO = new CompanyPrintModeUpdateReqDTO();

        companyPrintModeUpdateReqDTO.setCompId(109L);
        companyPrintModeUpdateReqDTO.setPrintMode(0);
        companyPrintModeUpdateReqDTO.setLoginPersonId(219L);
        companyPrintModeUpdateReqDTO.setLoginCompId(108L);
        Result<String> res = companyWriteRpcService.updateCompanyPrintMode(companyPrintModeUpdateReqDTO);
        System.out.println(JSON.toJSONString(res));

    }

}