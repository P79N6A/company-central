package com.ihappy.partner.infrastructure.service;

import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.partner.CompanyPartnerDelRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerInfoEnableRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerUpdateRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/10/11.
 * Partner修改接口-面向统一网关
 */
public interface PartnerWriteGatewayService {
    /**
     * 添加零售会员
     *
     * @param reqDTO
     * @return
     */
    Result<RetailCustomerAddRespDTO> addRetailCustomer(RetailCustomerAddReqDTO reqDTO);

    /**
     * 编辑零售会员
     *
     * @param reqDTO
     * @return
     */
    Result<RetailCustomerUpdateRespDTO> updateRetailCustomer(RetailCustomerUpdateReqDTO reqDTO);

    /**
     * 禁用会员信息
     * @param companyPartnerDelReqDTO
     * @return   //forbidCompanyPartner
     */
    Result<CompanyPartnerDelRespDTO> forbidCompanyPartner(CompanyPartnerDelReqDTO companyPartnerDelReqDTO);

    /**
     * 启用会员信息
     * @param retailCustomerInfoEnableReqTO
     * @return   //unforbidCompanyPartner
     */
    Result<RetailCustomerInfoEnableRespDTO> unforbidCompanyPartner(RetailCustomerInfoEnableReqDTO retailCustomerInfoEnableReqTO);
}
