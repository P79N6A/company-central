package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.CompanyBrandListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandListQueryRespDTO;
import com.ihappy.company.infrastructure.service.CompanyBrandReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/1.
 */
@Deprecated
public class CompanyBrandReadRpcServiceImpl implements CompanyBrandReadRpcService {
    @Autowired
    private IProcess queryCompanyBrandListProcess;

    @Override
    public Result<List<CompanyBrandListQueryRespDTO>> findCompanyBrandList(CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO) {
        Context context = new Context(companyBrandListQueryReqDTO, new Result<List<CompanyBrandListQueryRespDTO>>(), Action.QUERY_COMPANY_BRAND_LIST);
        queryCompanyBrandListProcess.start(context);
        return context.getResult();
    }
}
