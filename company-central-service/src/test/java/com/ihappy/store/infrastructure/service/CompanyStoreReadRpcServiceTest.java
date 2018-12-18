package com.ihappy.store.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ihappy.BaseTest;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.response.store.CompanyStoreListQueryRespDTO;
import com.ihappy.store.domain.dto.response.store.SalePerformanceRespDTO;
import com.ihappy.store.domain.dto.response.store.StorePerformanceRespDTO;
import com.ihappy.store.domain.dto.response.store.StoreQueryRespDTO;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunjd on 2018/10/23.
 */
public class CompanyStoreReadRpcServiceTest extends BaseTest {

    CompanyStoreReadRpcService companyStoreReadRpcService;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        companyStoreReadRpcService = getBean("companyStoreReadRpcService");
    }

    @Test
    public void queryStorePerformance() throws Exception {
        StorePerformanceReqDTO reqDTO = new StorePerformanceReqDTO();
        reqDTO.setLoginCompId(2846L);
        reqDTO.setYearMonth("2018-12");
        reqDTO.setLoginPersonId(140465L);
        //reqDTO.setStoreId(3181218213L);
        Result<StorePerformanceRespDTO> res = companyStoreReadRpcService.queryStorePerformance(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStoreListByCompIdAndStoreIds() throws Exception {
        CompanyStoreListQueryReqDTO reqDTO = new CompanyStoreListQueryReqDTO();
        reqDTO.setCompId(78211);
        Result<List<CompanyStoreListQueryRespDTO>> res = companyStoreReadRpcService.findStoreListByCompIdAndStoreIds(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStoreListByUser() throws Exception {
        CompanyStoreListByUserQueryReqDTO reqDTO = new CompanyStoreListByUserQueryReqDTO();
        reqDTO.setLoginCompId(2824L);
        reqDTO.setLoginPersonId(140396L);
        reqDTO.setUsing(0);
        Result<List<CompanyStoreListQueryRespDTO>> res = companyStoreReadRpcService.findStoreListByUser(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void queryStoreManager() throws Exception {
        StoreManagerQueryReqDTO reqDTO = new StoreManagerQueryReqDTO();
        reqDTO.setCompId(78211L);
        reqDTO.setStoreId(3183988211L);
        reqDTO.setType(1);
        Result<List<UserInfoRespDTO>> res = companyStoreReadRpcService.queryStoreManager(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
    @Test
    public void queryStoreList() throws Exception {
        StoreQueryReqDTO reqDTO = new StoreQueryReqDTO();
        reqDTO.setCompId(861L);
        reqDTO.setIsDeleted(null);

        Result<List<StoreQueryRespDTO>> res = companyStoreReadRpcService.queryStoreList(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void querySalePerformanceByCondition() throws Exception {
        SalePerformanceReqDTO reqDTO = new SalePerformanceReqDTO();
        reqDTO.setSalePerformanceId(0L);
        reqDTO.setCompId(0L);
        reqDTO.setStoreId(0L);
        reqDTO.setPersonId(1L);
        reqDTO.setYearMonth(0);
        reqDTO.setIsDelete(0);
        reqDTO.setStoreIds(Lists.newArrayList(1L));


        reqDTO.setCompId(78211L);

        Result<List<SalePerformanceRespDTO>> res = companyStoreReadRpcService.querySalePerformanceByCondition(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}