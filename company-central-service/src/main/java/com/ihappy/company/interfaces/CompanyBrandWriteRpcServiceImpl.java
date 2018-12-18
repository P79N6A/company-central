package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.CompanyBrandAddInsideReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandAddReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandDelReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandsDelReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.company.infrastructure.service.CompanyBrandWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/3.
 */
@Deprecated
public class CompanyBrandWriteRpcServiceImpl implements CompanyBrandWriteRpcService {
    @Autowired
    private IProcess addCompanyBrandProcess;

    @Autowired
    private IProcess addCompanyBrandInsideProcess;

    @Autowired
    private IProcess delCompanyBrandProcess;

    @Autowired
    private IProcess delCompanyBrandsProcess;

    @Override
    public Result<CompanyBrandAddRespDTO> addCompanyBrand(CompanyBrandAddReqDTO companyBrandAddReqDTO) {
        Context context = new Context(companyBrandAddReqDTO, new Result<CompanyBrandAddRespDTO>(), Action.ADD_COMPANY_BRAND);
        addCompanyBrandProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyBrandAddInsideRespDTO> addCompanyBrandInside(CompanyBrandAddInsideReqDTO companyBrandAddInsideReqDTO) {
        Context context = new Context(companyBrandAddInsideReqDTO, new Result<CompanyBrandAddInsideRespDTO>(), Action.ADD_COMPANY_BRAND);
        addCompanyBrandInsideProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> delCompanyBrand(CompanyBrandDelReqDTO companyBrandDelReqDTO) {
        Context context = new Context(companyBrandDelReqDTO, new Result<String>(), Action.DEL_COMPANY_BRAND);
        delCompanyBrandProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> delCompanyBrands(CompanyBrandsDelReqDTO companyBrandsDelReqDTO) {
        Context context = new Context(companyBrandsDelReqDTO, new Result<String>(), Action.DEL_COMPANY_BRANDS);
        delCompanyBrandsProcess.start(context);
        return context.getResult();
    }
}
