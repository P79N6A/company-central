package com.ihappy.partner.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.common.domain.Page;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.request.partner.*;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.domain.dto.response.partner.*;
import com.ihappy.partner.infrastructure.service.PartnerReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
public class PartnerReadRpcServiceImpl implements PartnerReadRpcService {
    @Autowired
    private IProcess queryPartnerListProcess;

    @Autowired
    private IProcess queryPartnerProcess;

    @Autowired
    private IProcess queryCustomerListProcess;

    @Autowired
    private IProcess queryCustomerProcess;

    @Autowired
    private IProcess queryDefProviderListProcess;

    @Autowired
    private IProcess queryDefCustomerListProcess;

    @Autowired
    private IProcess findPartnerProcess;
    @Autowired
    private IProcess findPartnerStatisticsProcess;
    @Autowired
    private IProcess findPartnerPageProcess;
    @Autowired
    private IProcess queryPartnerLevelProcess;
    @Autowired
    private IProcess queryPartnerLevelListProcess;
    @Autowired
    private IProcess queryRetailCustomerProcess;
    @Autowired
    private IProcess findDefaultPartnerProcess;

    @Autowired
    private IProcess queryRetailCustomerPageProcess;
    @Autowired
    private IProcess findPartnerListProcess;
    @Override
    public Result<List<ProviderInfoListQueryRespDTO>> findProviderList(ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO) {
        Context context = new Context(providerInfoListQueryReqDTO, new Result<List<ProviderInfoListQueryRespDTO>>(), Action.QUERY_PROVIDER_LIST);
        queryPartnerListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<ProviderInfoQueryRespDTO> findProvider(ProviderInfoQueryReqDTO providerInfoQueryReqDTO) {
        Context context = new Context(providerInfoQueryReqDTO, new Result<List<ProviderInfoQueryRespDTO>>(), Action.QUERY_PROVIDER);
        queryPartnerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CustomerInfoListQueryRespDTO>> findCustomerList(CustomerInfoListQueryReqDTO customerInfoQueryReqDTO) {
        Context context = new Context(customerInfoQueryReqDTO, new Result<List<CustomerInfoListQueryRespDTO>>(), Action.QUERY_CUSTOMER_LIST);
        queryCustomerListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CustomerInfoQueryRespDTO> findCustomer(CustomerInfoQueryReqDTO customerInfoQueryReqDTO) {
        Context context = new Context(customerInfoQueryReqDTO, new Result<List<CustomerInfoQueryRespDTO>>(), Action.QUERY_CUSTOMER_LIST);
        queryCustomerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<DefProviderListQueryRespDTO> findDefProviderList(DefProviderListQueryReqDTO defProviderListQueryReqDTO) {
        Context context = new Context(defProviderListQueryReqDTO, new Result<DefProviderListQueryReqDTO>(), Action.QUERY_DEF_PROVIDER_LIST);
        queryDefProviderListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<DefCustomerListQueryRespDTO> findDefCustomerList(DefCustomerListQueryReqDTO defCustomerListQueryReqDTO) {
        Context context = new Context(defCustomerListQueryReqDTO, new Result<DefCustomerListQueryRespDTO>(), Action.QUERY_DEF_CUSTOMER_LIST);
        queryDefCustomerListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PartnerInfoQueryRespDTO> findPartner(PartnerInfoQueryReqDTO partnerInfoQueryReqDTO) {
        Context context = new Context(partnerInfoQueryReqDTO, new Result<PartnerInfoQueryRespDTO>(), Action.QUERY_PROVIDER);
        findPartnerProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PartnerInfoQueryRespDTO> findDefaultPartner(PartnerDefQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerInfoQueryRespDTO>(), Action.QUERY_DEF_PROVIDER);
        findDefaultPartnerProcess.start(context);
        return context.getResult();
    }


    @Override
    public Result<PartnerStatisticsRespDTO> findPartnerStatistics(PartnerStatisticsReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerStatisticsRespDTO>(), Action.FIND_PARTNER_STATISTICS);
        findPartnerStatisticsProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<PartnerInfoQueryRespDTO>> findPartnerPage(PartnerPageReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<Page<PartnerInfoQueryRespDTO>>(), Action.FIND_PARTNER_PAGE);
        findPartnerPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<PartnerInfoQueryRespDTO>> findPartnerList(PartnerListQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<PartnerInfoQueryRespDTO>>(), Action.FIND_PARTNER_PAGE);
        findPartnerListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<PartnerLevelQueryRespDTO> findPartnerLevel(PartnerLevelQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<PartnerLevelQueryRespDTO>(), Action.QUERY_PARTNER_LEVEL);
        queryPartnerLevelProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<PartnerLevelQueryRespDTO>> findPartnerLevelList(PartnerLevelListQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<PartnerLevelQueryRespDTO>>(), Action.QUERY_PARTNER_LEVEL_LIST);
        queryPartnerLevelListProcess.start(context);
        return context.getResult();
    }
}
