package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.partner.CompanyPartnerDelReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerInfoEnableReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.CompanyPartnerDelRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerInfoEnableRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerUpdateRespDTO;
import com.ihappy.partner.infrastructure.service.PartnerWriteGatewayService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/10/11.
 */
public class PartnerWriteGatewayServiceImpl implements PartnerWriteGatewayService {
    @Autowired
    private IProcess forbidCompanyPartnerProcess;
    @Autowired
    private IProcess addRetailCustomerProcess;
    @Autowired
    private IProcess updateRetailCustomerProcess;
    @Autowired
    private IProcess enableRetailCustomerInfoProcess;
    @Override
    public Result<RetailCustomerAddRespDTO> addRetailCustomer(RetailCustomerAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<RetailCustomerAddRespDTO>(), Action.ADD_RETAIL_CUSTOMER);
        addRetailCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<RetailCustomerUpdateRespDTO> updateRetailCustomer(RetailCustomerUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<RetailCustomerUpdateRespDTO>(), Action.UPDATE_RETAIL_CUSTOMER);
        updateRetailCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyPartnerDelRespDTO> forbidCompanyPartner(CompanyPartnerDelReqDTO companyPartnerDelReqDTO) {
        Context context = new Context(companyPartnerDelReqDTO, new Result<CompanyPartnerDelRespDTO>(), Action.DEL_COMPANY_PARTNER);
        forbidCompanyPartnerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<RetailCustomerInfoEnableRespDTO> unforbidCompanyPartner(RetailCustomerInfoEnableReqDTO retailCustomerInfoEnableReqTO) {
        Context context = new Context(retailCustomerInfoEnableReqTO, new Result<RetailCustomerUpdateRespDTO>(), Action.ENABLE_RETAIL_CUSTOMER);
        enableRetailCustomerInfoProcess.start(context);
        return context.getResult();
    }
}
