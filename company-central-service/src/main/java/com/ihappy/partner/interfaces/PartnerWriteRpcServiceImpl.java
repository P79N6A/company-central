package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.partner.infrastructure.service.PartnerWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/1.
 */
public class PartnerWriteRpcServiceImpl implements PartnerWriteRpcService {
    @Autowired
    private IProcess addProviderProcess;

    @Autowired
    private IProcess updateProviderProcess;

    @Autowired
    private IProcess addCustomerProcess;

    @Autowired
    private IProcess updateCustomerProcess;

    @Autowired
    private IProcess delCompanyPartnerProcess;

    @Autowired
    private IProcess addPartnerByInvateRegisterProcess;
    @Autowired
    private IProcess addPartnerArrearsOrderProcess;
    @Autowired
    private IProcess updateReferenceCountProcess;
    @Autowired
    private IProcess addPartnerLevelProcess;
    @Autowired
    private IProcess updatePartnerLevelProcess;
    @Autowired
    private IProcess delPartnerLevelProcess;
    @Autowired
    private IProcess partnerQueryOrAddProcess;


    @Override
    public Result<ProviderInfoAddRespDTO> addProvider(ProviderInfoAddReqDTO providerInfoAddReqDTO) {
        Context context = new Context(providerInfoAddReqDTO, new Result<ProviderInfoAddRespDTO>(), Action.ADD_PROVIDER);
        addProviderProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateProvider(ProviderInfoUpdateReqDTO providerInfoUpdateReqDTO) {
        Context context = new Context(providerInfoUpdateReqDTO, new Result<String>(), Action.UPDATE_PROVIDER);
        updateProviderProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CustomerInfoAddRespDTO> addCustomer(CustomerInfoAddReqDTO customerInfoAddReqDTO) {
        Context context = new Context(customerInfoAddReqDTO, new Result<CustomerInfoAddRespDTO>(), Action.ADD_CUSTOMER);
        addCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateCustomer(CustomerInfoUpdateReqDTO customerInfoUpdateReqDTO) {
        Context context = new Context(customerInfoUpdateReqDTO, new Result<String>(), Action.UPDATE_CUSTOMER);
        updateCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> delCompanyPartner(CompanyPartnerDelReqDTO companyPartnerDelReqDTO) {
        Context context = new Context(companyPartnerDelReqDTO, new Result<String>(), Action.DEL_COMPANY_PARTNER);
        delCompanyPartnerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<AddInvateRegisterPartnerRespDTO> addPartnerByInvateRegister(AddInvateRegisterPartnerReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<AddInvateRegisterPartnerRespDTO>(), Action.ADD_PARTNER_BY_INVATE_REGISTER);
        addPartnerByInvateRegisterProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PartnerArrearsOrderAddRespDTO> addPartnerArrearsOrder(PartnerArrearsOrderAddReqDTO req) {
        Context context = new Context(req, new Result<PartnerArrearsOrderAddRespDTO>(), Action.ADD_PARTNER_ARREARS_ORDER);
        addPartnerArrearsOrderProcess.start(context);
        return context.getResult();
    }
    @Override
    public Result<PartnerLevelReferenceCountRespDTO> updateReferenceCount(PartnerLevelReferenceCountReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerLevelReferenceCountRespDTO>(), Action.UPDATE_REFERENCE_COUNT);
        updateReferenceCountProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PartnerLevelAddRespDTO> addPartnerLevel(PartnerLevelAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerLevelAddRespDTO>(), Action.ADD_PARTNER_LEVEL);
        addPartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updatePartnerLevel(PartnerLevelUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_PARTNER_LEVEL);
        updatePartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> delPartnerLevel(PartnerLevelDelReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.DEL_PARTNER_LEVEL);
        delPartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PartnerInfoQueryRespDTO> partnerQueryOrAdd(PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO) {
        Context context = new Context(partnerQueryOrAddReqDTO, new Result<PartnerInfoQueryRespDTO>(), Action.PARTNER_QUERY_OR_ADD);
        partnerQueryOrAddProcess.start(context);
        return context.getResult();    }
}
