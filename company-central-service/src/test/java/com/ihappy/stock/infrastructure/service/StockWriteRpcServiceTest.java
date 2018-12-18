package com.ihappy.stock.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.stock.domain.dto.request.stock.*;
import com.ihappy.stock.domain.dto.response.stock.StockAddRespDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/16.
 */
public class StockWriteRpcServiceTest extends BaseTest {
    @Test
    public void clearStockInventorying() throws Exception {
        StockWriteRpcService service = getBean("stockWriteRpcService");
        ClearStockInventoryingReqDTO reqDTO = new ClearStockInventoryingReqDTO();
        reqDTO.setCompId(78211L);
        reqDTO.setStockChangeIds(Arrays.asList(27130208211L));
        //reqDTO.setStockIds(Arrays.asList(682668211L));
        Result<String> res = service.clearStockInventorying(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void addOrQueryStock() throws Exception {
        StockWriteRpcService service = getBean("stockWriteRpcService");
        StockAddReqDTO reqDTO = new StockAddReqDTO();
        reqDTO.setLoginCompId(1L);
        reqDTO.setStockName("n1默认仓库1");
        reqDTO.setStoreId(1L);
        //reqDTO.setQueryType(1);
        Result<StockRespDTO> res = service.addOrQueryStock(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void updateStockInventorying() throws Exception {
        StockWriteRpcService service = getBean("stockWriteRpcService");
        StockInventoryingReqDTO reqDTO = new StockInventoryingReqDTO();
        reqDTO.setStockIds(Arrays.asList(396342824L));
        reqDTO.setStockChangeId(27133352824L);
        reqDTO.setLock(true);

        Result<List<StockRespDTO>> res = service.updateStockInventorying(reqDTO);

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
    public void addStock() throws Exception {
        StockWriteRpcService stockWriteRpcService = getBean("stockWriteRpcService");
        StockAddReqDTO stockAddReqDTO = new StockAddReqDTO();
        stockAddReqDTO.setStockName("测试门店3仓库2221");
        stockAddReqDTO.setStockLinkman("负责人");
        stockAddReqDTO.setStoreId(90001L);
        stockAddReqDTO.setAddress("仓库地址");
        stockAddReqDTO.setStockAcreage(125);
        stockAddReqDTO.setIsPerson(true);

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(110L);
        personUserInfoDTO.setPersonId(357L);
        stockAddReqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        stockAddReqDTO.setLoginCompId(110L);

        Result<StockAddRespDTO> res = stockWriteRpcService.addStock(stockAddReqDTO);
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
    public void updateStock() throws Exception {
        StockWriteRpcService stockWriteRpcService = getBean("stockWriteRpcService");
        StockUpdateReqDTO stockUpdateReqDTO = new StockUpdateReqDTO();
        stockUpdateReqDTO.setStockId(680710110L);
        stockUpdateReqDTO.setAddress("测试门店3仓库221");
        stockUpdateReqDTO.setStoreId(90001);
        stockUpdateReqDTO.setStockName("测试门店3仓库223331");

        stockUpdateReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(110L);
        personUserInfoDTO.setPersonId(357L);
        stockUpdateReqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        stockUpdateReqDTO.setLoginCompId(110L);

        Result<String> res = stockWriteRpcService.updateStock(stockUpdateReqDTO);
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
    public void updateStockStatus() throws Exception {
        StockWriteRpcService stockWriteRpcService = getBean("stockWriteRpcService");
        StockStatusReqDTO stockStatusReqDTO = new StockStatusReqDTO();
        stockStatusReqDTO.setForbidden(0);
        stockStatusReqDTO.setStockId(120001L);

        stockStatusReqDTO.setIsPerson(true);
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setCompId(1L);
        personUserInfoDTO.setPersonId(1L);
        stockStatusReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<String> res = stockWriteRpcService.updateStockStatus(stockStatusReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void testAll() throws Exception {
        addOrQueryStock();
        updateStockInventorying();
        addStock();
        updateStock();
        updateStockStatus();
    }

}