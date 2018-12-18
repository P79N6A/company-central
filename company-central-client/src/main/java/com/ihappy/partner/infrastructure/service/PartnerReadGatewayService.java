package com.ihappy.partner.infrastructure.service;

import com.ihappy.common.domain.Page;
import com.ihappy.partner.domain.dto.request.partner.PartnerInfoQueryReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/10/11.
 * Partner查询接口-面向统一网关
 */

public interface PartnerReadGatewayService {
    /**
     * 查询单个零售会员
     * @param reqDTO
     * @return
     */
    Result<RetailCustomerQueryRespDTO> findRetailCustomer(RetailCustomerQueryReqDTO reqDTO);

    /**
     * 查询零售会员分页列表
     * @param reqDTO
     * @return
     */
    Result<Page<RetailCustomerQueryPageRespDTO>> findRetailCustomerPage(RetailCustomerQueryPageReqDTO reqDTO);

    /**
        * @Description: 查询供应商客户是否需要打通, 打通开关打开并且根据手机号能找到用户
        * @Param:
        * @return:
        * @Author: zhangtengpo
        * @Date: 18-12-7 上午10:24
        */
    Result<Boolean> queryShouldPartnerBeNotified(PartnerInfoQueryReqDTO partnerInfoQueryReqDTO);
}
