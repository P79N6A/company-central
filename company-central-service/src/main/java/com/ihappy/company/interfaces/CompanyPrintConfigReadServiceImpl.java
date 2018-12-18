package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigInfoRespDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigListRespDTO;
import com.ihappy.company.infrastructure.service.CompanyPrintConfigReadService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 16:01
 */
@Deprecated
public class CompanyPrintConfigReadServiceImpl implements CompanyPrintConfigReadService {

    @Autowired
    private IProcess queryCompanyPrintConfigProcess;

    @Autowired
    private IProcess queryCompanyPrintConfigListProcess;
    @Override
    public Result<CompanyPrintConfigInfoRespDTO> findCompanyPrintConfigInfo(CompanyPrintConfigInfoQueryReqDTO companyPrintConfigInfoQeuryReqDTO) {
        Context<CompanyPrintConfigInfoQueryReqDTO, CompanyPrintConfigInfoRespDTO> context =
                new Context<>(companyPrintConfigInfoQeuryReqDTO, new Result<CompanyPrintConfigInfoRespDTO>(), Action.QUERY_PRINT_CONFIG);
        queryCompanyPrintConfigProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyPrintConfigListRespDTO>> findCompanyPrintConfigList(CompanyPrintConfigListQueryReqDTO companyPrintConfigListQueryReqDTO) {
        Context<CompanyPrintConfigListQueryReqDTO,List<CompanyPrintConfigListRespDTO>> context = new Context(companyPrintConfigListQueryReqDTO, new Result<List<CompanyPrintConfigListRespDTO>>(),
                Action.QUERY_PRINT_CONFIG_LIST);
        queryCompanyPrintConfigListProcess.start(context);
        return context.getResult();
    }
}
