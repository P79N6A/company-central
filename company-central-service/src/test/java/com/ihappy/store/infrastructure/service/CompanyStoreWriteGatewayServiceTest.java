package com.ihappy.store.infrastructure.service;
import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/8/30.
 */
public class CompanyStoreWriteGatewayServiceTest extends BaseTest {
    CompanyStoreWriteGatewayService service;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = (CompanyStoreWriteGatewayService) applicationContext.getBean("companyStoreWriteGatewayService");
    }

    @Test
    public void updateStorePayRemark() throws Exception {
        StoreInfoUpdateReqDTO reqDTO = new StoreInfoUpdateReqDTO();
        reqDTO.setLoginCompId(1L);
        reqDTO.setLoginPersonId(1L);
        reqDTO.setCompId(1L);
        reqDTO.setStoreId(30001L);
        reqDTO.setPayRemark("dsfdsfsd大师傅大师傅");
        Result<String> res = service.updateStorePayRemark(reqDTO);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void addCompanyStoreAdmin() throws Exception {
        CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO = new CompanyStoreAdminAddReqDTO();
        PersonUserInfoDTO personUserInfoDTO=new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(78002L);
        companyStoreAdminAddReqDTO.setLoginCompId(personUserInfoDTO.getCompId());
        companyStoreAdminAddReqDTO.setStoreName("nnv");
        companyStoreAdminAddReqDTO.setAddress("110");
        companyStoreAdminAddReqDTO.setStoreAcreage(100);
        companyStoreAdminAddReqDTO.setStoreContact("");
        companyStoreAdminAddReqDTO.setStorePhone("");
        companyStoreAdminAddReqDTO.setStoreTel("110");
        companyStoreAdminAddReqDTO.setLoginPersonId(512043L);
        companyStoreAdminAddReqDTO.setLoginCompId(78002L);
        companyStoreAdminAddReqDTO.setProvince("1214");
        companyStoreAdminAddReqDTO.setCity("4854");
        companyStoreAdminAddReqDTO.setZone("454");
        companyStoreAdminAddReqDTO.setAlipayAccountName("243434");
        companyStoreAdminAddReqDTO.setAlipayReceiptQrcode("现在");
        companyStoreAdminAddReqDTO.setAlipayReceiptQrcodeContent("只想");
        companyStoreAdminAddReqDTO.setWechatAccountName("在线咨询");
        companyStoreAdminAddReqDTO.setWechatAccountQrcode("现在");
        companyStoreAdminAddReqDTO.setWechatAccountQrcodeContent("在线咨询");
        companyStoreAdminAddReqDTO.setWechatReceiptQrcode("在线咨询");
        companyStoreAdminAddReqDTO.setWechatReceiptQrcodeContent("紫霞仙子");
        companyStoreAdminAddReqDTO.setBankInfo("[{\"bankAccountNumber\":\"6217908000000722346\",\"bankName\":\"中国银行\",\"bankAccountName\":\"王宾\"}]");
        System.out.println(JSON.toJSONString(service.addCompanyStoreAdmin(companyStoreAdminAddReqDTO)));

    }
    @Test
    public void updateCompanyStoreAdmin() throws Exception {
        CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO = new CompanyStoreAdminUpdateReqDTO();
        companyStoreAdminUpdateReqDTO.setLoginCompId(78002L);
        companyStoreAdminUpdateReqDTO.setLoginPersonId(511703L);
        companyStoreAdminUpdateReqDTO.setStoreId(3186788002L);
        companyStoreAdminUpdateReqDTO.setLogoUrl("sds");
        companyStoreAdminUpdateReqDTO.setStoreName("ttpp");
        companyStoreAdminUpdateReqDTO.setAddress("1110");
        companyStoreAdminUpdateReqDTO.setStoreAcreage(null);
        companyStoreAdminUpdateReqDTO.setStoreTel("1110");
        companyStoreAdminUpdateReqDTO.setStorePhone("1110");
        companyStoreAdminUpdateReqDTO.setLoginPersonId(511703L);
        companyStoreAdminUpdateReqDTO.setLoginCompId(78002L);
        companyStoreAdminUpdateReqDTO.setStoreContact("员工");
        companyStoreAdminUpdateReqDTO.setProvince("888");
        companyStoreAdminUpdateReqDTO.setCity("999");
        companyStoreAdminUpdateReqDTO.setZone("100");
        companyStoreAdminUpdateReqDTO.setAlipayAccountName("sds");
        companyStoreAdminUpdateReqDTO.setAlipayReceiptQrcode("sda");
        companyStoreAdminUpdateReqDTO.setAlipayReceiptQrcodeContent("sdss");
        companyStoreAdminUpdateReqDTO.setWechatAccountName("sadsa");
        companyStoreAdminUpdateReqDTO.setWechatAccountQrcode("asdasd");
        companyStoreAdminUpdateReqDTO.setWechatAccountQrcodeContent("sadas");
        companyStoreAdminUpdateReqDTO.setWechatReceiptQrcode("sadas");
        companyStoreAdminUpdateReqDTO.setWechatReceiptQrcodeContent("xcxcx");
        companyStoreAdminUpdateReqDTO.setBankInfo("[{\"bankAccountNumber\":\"234\",\"bank\":\"\"," +
                "\"bankAccountName\":\"6666\",\"bankName\":\"1234\"}]");
        System.out.println(JSON.toJSONString(service.updateCompanyStoreAdmin(companyStoreAdminUpdateReqDTO)));

    }
    @Test
    public void deleteCompanyStoreAdmin() throws Exception {
        CompanyStoreAdminDeleteReqDTO companyStoreAdminDeleteReqDTO = new CompanyStoreAdminDeleteReqDTO();

        companyStoreAdminDeleteReqDTO.setStoreId(3185228002L);
        companyStoreAdminDeleteReqDTO.setLoginPersonId(511703L);
        companyStoreAdminDeleteReqDTO.setLoginCompId(78002L);
        System.out.println(JSON.toJSONString(service.deleteCompanyStoreAdmin(companyStoreAdminDeleteReqDTO)));

    }
    @Test
    public void addPersonPerformance() throws Exception {
        AddPersonPerformanceReqDTO reqDTO = new AddPersonPerformanceReqDTO();
        reqDTO.setLoginCompId(78211L);
        reqDTO.setYearMonth("2018-08");
        reqDTO.setStoreId(678328211L);
        reqDTO.setLoginPersonId(511897L);
        reqDTO.setSalePerformanceId(1498211L);
        reqDTO.setPersonId(512133L);
        reqDTO.setAimAmount(69555L);
        Result<String> res = service.addPersonPerformance(reqDTO);
        System.out.println(JSON.toJSONString(res));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        addCompanyStoreAdmin();
        updateCompanyStoreAdmin();
        deleteCompanyStoreAdmin();
        addPersonPerformance();

    }

    /**
     * 启用门店
     * @throws Exception
     */
    @Test
    public void enableStore() throws Exception{
        EnableStoreReqDTO enableStoreReqDTO=new EnableStoreReqDTO();
        enableStoreReqDTO.setLoginCompId(78002L);
        enableStoreReqDTO.setLoginPersonId(511703L);
        enableStoreReqDTO.setStoreId(3185238002L);
        System.out.println(JSON.toJSONString(service.enableStore(enableStoreReqDTO)));
    }
    /**
     * 禁用门店
     * @throws Exception
     */
    @Test
    public void disableStore() throws Exception{
        DisableStoreReqDTO disableStoreReqDTO=new DisableStoreReqDTO();
        disableStoreReqDTO.setLoginCompId(1L);
        disableStoreReqDTO.setLoginPersonId(511703L);
        disableStoreReqDTO.setStoreId(30001L);
        System.out.println(JSON.toJSONString(service.disableStore(disableStoreReqDTO)));
    }
}