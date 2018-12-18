package com.ihappy.company.interfaces;

import com.ihappy.common.domain.dto.BaseReqDTO;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.communal.template.ServiceExecuteTemplate;
import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.company.infrastructure.service.BackdoorRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.activation.ActivationInstantiator;

/**
 * Created by sunjd on 2018/8/11.
 */
public class BackdoorRpcServiceImpl implements BackdoorRpcService {
    @Autowired
    private IProcess refreshPartnerStaticsProcess;
    @Autowired
    private IProcess completionCompanyInfoProcess;
    @Autowired
    private IProcess generateDefaultInformationProcess;
    @Autowired
    private IProcess deleteRedisProcess;
    @Override
    public Result<String> refreshPartnerStatics(VoidReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.REFRESH_PARTNER_STATICS);
        refreshPartnerStaticsProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> completionInfo(CompanyCompletionInfoReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.COMPLETION_COMPANY_INFO);
        completionCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> generateDefaultInformation(VoidReqDTO voidReqDTO) {
        Context<BaseReqDTO, String> context = new Context<>(voidReqDTO, new Result<String>(),
                Action.GENERATE_DEFAULT_INFOMATION_FOR_ALL_COMPANY);
        generateDefaultInformationProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> deleteRedisInfo(VoidReqDTO voidReqDTO) {
        return ServiceExecuteTemplate.executeCommon(deleteRedisProcess, voidReqDTO,
                String.class, Action.DELETE_REDIS);
    }
}
