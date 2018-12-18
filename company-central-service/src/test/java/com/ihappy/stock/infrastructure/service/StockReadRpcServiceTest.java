package com.ihappy.stock.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.stock.domain.dto.request.user.UserInfoOutSideByIdQuery;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.response.stock.StockBasicInfoRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListQueryRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/17.
 */
public class StockReadRpcServiceTest extends BaseTest {
    @Test
    public void getStockListByStoreIdList() throws Exception {
        StockReadRpcService service = getBean("stockReadRpcService");
        StockListByStoreIdsQueryReqDTO reqDTO = new StockListByStoreIdsQueryReqDTO();
        reqDTO.setCompId(1L);
        reqDTO.setStoreIds(Arrays.asList(10001L, 20001L));
        reqDTO.setIsPublic(null);

        Result<StockListByStoreIdsQueryRespDTO> res = service.getStockListByStoreIdList(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStockListByIds() throws Exception {
        StockReadRpcService service = getBean("stockReadRpcService");
        StockListByIdsQueryReqDTO reqDTO = new StockListByIdsQueryReqDTO();
        reqDTO.setStockIds(Arrays.asList(10001L, 20001L));

        Result<List<StockRespDTO>> res = service.findStockListByIds(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     *
     * @throws Exception
     */
    @Test
    public void findStoreStockList() throws Exception {
        StockReadRpcService stockReadRpcService = getBean("stockReadRpcService");
        StockListQueryReqDTO stockListQueryReqDTO = new StockListQueryReqDTO();
        stockListQueryReqDTO.setForbidden(0);
        stockListQueryReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(1L);
        personUserInfoDTO.setPersonId(219L);
        stockListQueryReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<StockListQueryRespDTO> res = stockReadRpcService.findStoreStockList(stockListQueryReqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void findStock() throws Exception {
        StockReadRpcService stockReadRpcService = getBean("stockReadRpcService");
        StockQueryReqDTO stockQueryReqDTO = new StockQueryReqDTO();
        stockQueryReqDTO.setStockId(20001L);

        stockQueryReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(1L);
        personUserInfoDTO.setPersonId(1L);
        stockQueryReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<StockRespDTO> res = stockReadRpcService.findStock(stockQueryReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void getStockListByPersonId() throws Exception {
        StockReadRpcService stockReadRpcService = getBean("stockReadRpcService");
        UserInfoOutSideByIdQuery stockQueryReqDTO = new UserInfoOutSideByIdQuery();

        stockQueryReqDTO.setLoginPersonId(512123L);
        stockQueryReqDTO.setLoginCompId(78410L);
        Result<List<StockBasicInfoRespDTO>> res = stockReadRpcService.getStockListByPersonId(stockQueryReqDTO);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void getStockListByCondition() throws Exception {
        StockReadRpcService stockReadRpcService = getBean("stockReadRpcService");
        StockReqDTO reqDTO = new StockReqDTO();
        //reqDTO.setStoreId(377962824L);
        reqDTO.setCompId(78211);

        Result<List<StockRespDTO>> res = stockReadRpcService.getStockListByCondition(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        getStockListByStoreIdList();
        findStockListByIds();
        findStoreStockList();
        findStock();
        getStockListByPersonId();
        getStockListByCondition();
    }
}