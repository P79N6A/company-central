package com.ihappy.stock.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.stock.domain.dto.request.stock.StockMapByUserInfoQueryReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockListByStoreIdsQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by sunjd on 2018/5/24.
 */
public class StockReadInsideRpcServiceTest extends BaseTest {
    @Test
    public void getStockMapByUserInfo() throws Exception {
        StockReadInsideRpcService service = getBean("stockReadInsideRpcService");
        StockMapByUserInfoQueryReqDTO reqDTO = new StockMapByUserInfoQueryReqDTO();

        reqDTO.setCompId(1L);
        reqDTO.setIsPublic(null);
        reqDTO.setPersonId(219L);

        Result<StockListByStoreIdsQueryRespDTO> res = service.getStockMapByUserInfo(reqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

}