package com.ihappy.partner.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.common.domain.Page;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 11:02
 * *@content
 **/
public class PartnerReadGatewayServiceTest extends BaseTest {
    /**
     * 会员编辑-详情查看 -测试通过
     * @throws Exception
     */
    @Test
    public void findRetailCustomer()throws Exception{
        PartnerReadGatewayService service = getBean("partnerReadGatewayService");
        RetailCustomerQueryReqDTO reqDTO=new RetailCustomerQueryReqDTO();
        reqDTO.setLoginCompId(78213L);
        reqDTO.setLoginPersonId(511899L);
        reqDTO.setPartnerId(72537528213L);
        Result<RetailCustomerQueryRespDTO> res = service.findRetailCustomer(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
        printResult(res);
    }
    /**
     * 查询会员列表
     * @throws Exception
     */
    @Test
    public void findRetailCustomerPage() throws Exception {
        PartnerReadGatewayService service = getBean("partnerReadGatewayService");
        RetailCustomerQueryPageReqDTO reqDTO = new RetailCustomerQueryPageReqDTO();
        reqDTO.setSearchStr("");
        reqDTO.setOffset(0);
        reqDTO.setLimit(10);
        reqDTO.setLoginCompId(78479L);
        reqDTO.setLoginPersonId(511897L);
        reqDTO.setFilterIsDefault(true);
        reqDTO.setFilterIsForbid(true);
        Result<Page<RetailCustomerQueryPageRespDTO>> res = service.findRetailCustomerPage(reqDTO);
        printResult(res);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
}
