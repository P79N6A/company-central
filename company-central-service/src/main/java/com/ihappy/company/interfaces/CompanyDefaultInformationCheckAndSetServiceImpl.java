package com.ihappy.company.interfaces;

import com.ihappy.common.domain.dto.BaseReqDTO;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.VoidReqDTO;
import com.ihappy.company.infrastructure.service.CompanyDefaultInformationCheckAndSetService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-05-30 14:22
 */
@Deprecated
public class CompanyDefaultInformationCheckAndSetServiceImpl implements CompanyDefaultInformationCheckAndSetService {

    @Autowired
    private IProcess generateDefaultInformationProcess;

    @Override
    public Result<String> generateDefaultInformation(VoidReqDTO voidReqDTO) {
        Context<BaseReqDTO, String> context = new Context<>(voidReqDTO, new Result<String>(),
                Action.GENERATE_DEFAULT_INFOMATION_FOR_ALL_COMPANY);
        generateDefaultInformationProcess.start(context);
        return context.getResult();
    }
}
