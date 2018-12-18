package com.ihappy.store.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListByUserQueryReqDTO;
import com.ihappy.store.domain.dto.request.store.CompanyStoreListQueryReqDTO;
import com.ihappy.store.domain.dto.request.store.StoreInfoByLoginQueryReqDTO;
import com.ihappy.store.domain.dto.request.store.StoreQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopDetailQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopListQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopShareReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitDetailListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.dto.response.store.StorePrintIpAndPortQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopIndexDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopListQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopShareRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/10.
 */
public class CompanyStoreReadServiceTest extends BaseTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        companyStoreReadService = getBean("companyStoreReadService");
    }


    @Test
    public void findStoreListWithPublicByCompIdAndStoreIds() throws Exception {
        CompanyStoreReadService companyStoreReadService = getBean("companyStoreReadService");
        CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO = new CompanyStoreListQueryReqDTO();
        companyStoreListQueryReqDTO.setCompId(1);
        companyStoreListQueryReqDTO.setAvailable(2);
        List<Long> storeIds = new ArrayList<Long>(Arrays.asList(140001L));
        companyStoreListQueryReqDTO.setStoreIds(storeIds);

        Result<List<CompanyStoreListQueryRespDTO>> res = companyStoreReadService.findStoreListWithPublicByCompIdAndStoreIds(companyStoreListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void shareWeshop() throws Exception {
        CompanyStoreReadService service = getBean("companyStoreReadService");
        WeshopShareReqDTO reqDTO = new WeshopShareReqDTO();
        reqDTO.setCompId(1L);
        reqDTO.setStoreId(416960001L);
        reqDTO.setType(1);
        //companyStoreListQueryReqDTO.setStoreIds(storeIds);

        Result<WeshopShareRespDTO> res = service.shareWeshop(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findWeshopDetailWithoutLogin() throws Exception {
        CompanyStoreReadService service = getBean("companyStoreReadService");
        WeshopDetailQueryReqDTO reqDTO = new WeshopDetailQueryReqDTO();
        reqDTO.setCompId(1);
        //reqDTO.setFrom("collection");
        //reqDTO.setLoginTokenId("testtesttokenId");
        reqDTO.setStoreId(676270001L);
        reqDTO.setFrom("all");
        reqDTO.setLoginPersonId(123L);
        Result<WeshopDetailQueryRespDTO> res = service.findWeshopDetailWithoutLogin(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    private CompanyStoreReadService companyStoreReadService;



    @Test
    public void findPrintIpAndPort() throws Exception {
        CompanyStoreReadService companyStoreReadService = getBean("companyStoreReadService");
        StoreQueryReqDTO reqDTO = new StoreQueryReqDTO();
        reqDTO.setStoreId(10001L);
        reqDTO.setCompId(1L);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(110L);
        personUserInfoDTO.setPersonId(357L);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        reqDTO.setLoginCompId(1L);

        Result<StorePrintIpAndPortQueryRespDTO> res = companyStoreReadService.findPrintIpAndPort(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStoreListByCompIdAndStoreIds() throws Exception {
        CompanyStoreReadService companyStoreReadService = getBean("companyStoreReadService");
        CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO = new CompanyStoreListQueryReqDTO();
        companyStoreListQueryReqDTO.setCompId(233);
        //companyStoreListQueryReqDTO.setAvailable(2);
        List<Long> storeIds = new ArrayList<Long>(Arrays.asList(2020233L));
        companyStoreListQueryReqDTO.setStoreIds(storeIds);

        Result<List<CompanyStoreListQueryRespDTO>> res = companyStoreReadService.findStoreListByCompIdAndStoreIds(companyStoreListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStoreListByUser() throws Exception {
        CompanyStoreReadService companyStoreReadService = getBean("companyStoreReadService");
        CompanyStoreListByUserQueryReqDTO companyStoreListByUserQueryReqDTO = new CompanyStoreListByUserQueryReqDTO();
        //companyStoreListByUserQueryReqDTO.setStoreNameSearch("测试");

        companyStoreListByUserQueryReqDTO.setIsPerson(true);
        companyStoreListByUserQueryReqDTO.setLoginPersonId(512233L);
        companyStoreListByUserQueryReqDTO.setLoginCompId(78002L);
        companyStoreListByUserQueryReqDTO.setUsing(0);
        //companyStoreListByUserQueryReqDTO.setForbidden(0);

//        companyStoreListByUserQueryReqDTO.setLoginPersonId(219L);
//        companyStoreListByUserQueryReqDTO.setLoginCompId(1L);

        Result<List<CompanyStoreListQueryRespDTO>> res = companyStoreReadService.findStoreListByUser(companyStoreListByUserQueryReqDTO);
        printResult(res);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testQueryWeshopVisitDetailList(){
        WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO = new WeshopVisitDetailListQueryReqDTO();
        weshopVisitDetailListQueryReqDTO.setCompId(1);
        weshopVisitDetailListQueryReqDTO.setStoreId(676270001L);
        weshopVisitDetailListQueryReqDTO.setLoginCompId(1L);
        Result<WeshopIndexDetailQueryRespDTO> res = companyStoreReadService.queryWeshopVisitDetailList(weshopVisitDetailListQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testQueryCompanyStoreList(){
        WeshopListQueryReqDTO weshopListQueryReqDTO = new WeshopListQueryReqDTO();
        weshopListQueryReqDTO.setWeshopType(2);
        weshopListQueryReqDTO.setLimit(5);
        weshopListQueryReqDTO.setOffset(0);
        weshopListQueryReqDTO.setLoginPersonId(123L);
        Result<List<WeshopListQueryRespDTO>> weshopByPage = companyStoreReadService.findWeshopByPage(weshopListQueryReqDTO);
        System.out.println(weshopByPage.getModule());
    }

    @Test
    public void testQueryCompanyStoreDetail(){
        WeshopDetailQueryReqDTO weshopDetailQueryReqDTO = new WeshopDetailQueryReqDTO();
        weshopDetailQueryReqDTO.setCompId(1);
        //weshopDetailQueryReqDTO.setFrom("collection");
        weshopDetailQueryReqDTO.setLoginTokenId("testtesttokenId");
        weshopDetailQueryReqDTO.setStoreId(3183598211L);
        weshopDetailQueryReqDTO.setLoginPersonId(156L);
        weshopDetailQueryReqDTO.setLoginCompId(78211L);
        Result<WeshopDetailQueryRespDTO> res = companyStoreReadService.findWeshopDetail(weshopDetailQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStoreInfoByLogin(){
        StoreInfoByLoginQueryReqDTO storeInfoByLoginQueryReqDTO = new StoreInfoByLoginQueryReqDTO();
         storeInfoByLoginQueryReqDTO.setType(1);
         storeInfoByLoginQueryReqDTO.setPersonId(511884L);
         storeInfoByLoginQueryReqDTO.setCompId(78203L);
        System.out.println(JSON.toJSONString(companyStoreReadService.findStoreInfoByLogin(storeInfoByLoginQueryReqDTO)));
    }

    @Test
    public void testAll() throws Exception {
        findStoreListWithPublicByCompIdAndStoreIds();
        shareWeshop();
        findWeshopDetailWithoutLogin();
        findPrintIpAndPort();
        findStoreListByCompIdAndStoreIds();
        findStoreListByUser();
        testQueryWeshopVisitDetailList();
        testQueryCompanyStoreList();
        testQueryCompanyStoreDetail();
        findStoreInfoByLogin();
    }
}