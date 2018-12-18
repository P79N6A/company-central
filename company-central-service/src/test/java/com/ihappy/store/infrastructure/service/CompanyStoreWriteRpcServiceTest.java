package com.ihappy.store.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.store.domain.dto.request.store.StoreInfoQueryReqDTO;
import com.ihappy.store.domain.dto.request.store.StorePrintIpAndPortUpdateReqDTO;
import com.ihappy.store.domain.dto.response.store.StoreInfoQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/5/16.
 */
public class CompanyStoreWriteRpcServiceTest extends BaseTest {
    CompanyStoreReadRpcService companyStoreReadRpcService;

    CompanyStoreWriteRpcService companyStoreWriteRpcService;

    @Override
    public void setUp() throws Exception{
        super.setUp();
        companyStoreReadRpcService = (CompanyStoreReadRpcService) applicationContext.getBean
                ("companyStoreReadRpcService");
        companyStoreWriteRpcService = (CompanyStoreWriteRpcService) applicationContext.getBean
                ("companyStoreWriteRpcService");
        //模拟公司id
        personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(1l);
        personUserInfoDTO.setPersonId(219l);
        personUserInfoDTO.setStoreId(0l);
    }

    @Test
    public void updatePrintIpAndPort() throws Exception {
        StorePrintIpAndPortUpdateReqDTO reqDTO = new StorePrintIpAndPortUpdateReqDTO();
        reqDTO.setCompId(132L);
        reqDTO.setPrintIp("192.168.17.121");
        reqDTO.setPrintPort("8086");
        reqDTO.setStoreId(70132L);
        reqDTO.setLoginCompId(1l);
        reqDTO.setLoginPersonId(219l);
        reqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        Result<String>  res  = companyStoreWriteRpcService.updatePrintIpAndPort(reqDTO);
        System.out.println(JSON.toJSONString(res));
    }

    /**
     *      查询新建门店
     * @throws InterruptedException
     */
    @Test
    public void testBatchGoodsStock() {

        StoreInfoQueryReqDTO storeInfoQueryReqDTO = new StoreInfoQueryReqDTO();
        storeInfoQueryReqDTO.setCompId(1l);
        storeInfoQueryReqDTO.setStoreName("海贝1号");
        storeInfoQueryReqDTO.setLoginCompId(1l);
        storeInfoQueryReqDTO.setLoginPersonId(219l);
        storeInfoQueryReqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        Result<StoreInfoQueryRespDTO>  listResult
                = companyStoreReadRpcService.queryStoreInfoByStoreName(storeInfoQueryReqDTO);
        StoreInfoQueryRespDTO listResultModule = listResult.getModule();
        System.out.println(JSON.toJSONString(listResultModule));
    }

}
