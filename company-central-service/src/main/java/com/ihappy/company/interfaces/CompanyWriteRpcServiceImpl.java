package com.ihappy.company.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExpireStatusUpdateReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.FactoryInfoConfigReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoAddRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.company.infrastructure.service.CompanyWriteRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/1.
 */
public class CompanyWriteRpcServiceImpl implements CompanyWriteRpcService {
    @Autowired
    private IProcess updateCompanyStatusProcess;

    @Autowired
    private IProcess updateCompanyInfoProcess;

    @Autowired
    private IProcess updateCompanyInfoRpcProcess;

    @Autowired
    private IProcess addCompanyInfoProcess;

    @Autowired
    private IProcess addCompanyInfoByRpcProcess;

    @Autowired
    private IProcess updateCompanyExpireStatusProcess;

    @Autowired
    private IProcess updateCompanyPayRemarkProcess;


    @Autowired
    private IProcess updateFactoryInfoProcess;

    @Autowired
    private IProcess addCompanyBrandProcess;

    @Autowired
    private IProcess addCompanyBrandInsideProcess;

    @Autowired
    private IProcess delCompanyBrandProcess;

    @Autowired
    private IProcess delCompanyBrandsProcess;
    @Autowired
    private IProcess addCompanyExtendServiceJournalProcess;
    @Autowired
    private IProcess updateCompanyPrintConfigProcess;
    @Autowired
    private IProcess addVerifyCompanyInfoProcess;

    @Autowired
    private IProcess verifyCompanyInfoProcess;

    @Autowired
    private IProcess updateCompanyPrintModeProcess;

    @Override
    public Result<String> updateCompanyPayRemark(CompanyInfoUpdateReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<String>(), Action.UPDATE_COMPANY_PAY_REMARK);
        updateCompanyPayRemarkProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateCompanyStatus(CompanyStatusReqDTO companyStatusReqDTO) {
        Context context = new Context(companyStatusReqDTO, new Result<String>(), Action.UPDATE_COMPANY_STATUS);
        updateCompanyStatusProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateCompanyInfo(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
        Context context = new Context(companyInfoUpdateReqDTO, new Result<String>(), Action.UPDATE_COMPANY_INFO);
        updateCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Void> updateCompanyInfoByRpc(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
        Context context = new Context(companyInfoUpdateReqDTO, new Result<String>(), Action.UPDATE_COMPANY_INFO);
        updateCompanyInfoRpcProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoAddRespDTO> addCompanyInfo(CompanyInfoAddReqDTO companyInfoAddReqDTO) {
        Context context = new Context(companyInfoAddReqDTO, new Result<CompanyInfoAddRespDTO>(), Action.ADD_COMPANY_INFO);
        addCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoAddRespDTO> addCompanyInfoByRpc(CompanyInfoAddByRpcReqDTO companyInfoAddByRpcReqDTO) {
        Context context = new Context(companyInfoAddByRpcReqDTO, new Result<CompanyInfoAddRespDTO>(), Action.ADD_COMPANY_INFO);
        addCompanyInfoByRpcProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Void> updateCompanyExpireStatus(CompanyExpireStatusUpdateReqDTO companyExpireStatusUpdateReqDTO) {
        Context context = new Context(companyExpireStatusUpdateReqDTO, new Result<Void>(), Action.UPDATE_COMPANY_INFO);
        updateCompanyExpireStatusProcess.start(context);
        return context.getResult();
    }


    @Override
    public Result<Void> updateFactoryInfo(FactoryInfoConfigReqDTO factoryInfoConfigReqDTO) {
        Context context = new Context(factoryInfoConfigReqDTO, new Result<Void>(), Action.UPDATE_FACTORY_INFO);
        updateFactoryInfoProcess.start(context);
        return context.getResult();
    }

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

    @Override
    public Result<CompanyExtendServiceAddRespDTO> addCompanyExtendServiceJournal(CompanyExtendServiceAddReqDTO req) {
        Context context = new Context(req, new Result<CompanyExtendServiceAddRespDTO>(), Action.ADD_COMPANY_EXTEND_SERVICE_JOURNAL);
        addCompanyExtendServiceJournalProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateCompanyPrintConfig(CompanyPrintConfigInfoUpdateReqDTO companyPrintConfigInfoUpdateReqDTO) {
        Context<CompanyPrintConfigInfoUpdateReqDTO, String> context =
                new Context<>(companyPrintConfigInfoUpdateReqDTO, new Result<String>(), Action.UPDATE_PRINT_CONFIG);
        updateCompanyPrintConfigProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoVerifyRespDTO> verifyCompanyInfo(CompanyInfoVerifyReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoVerifyRespDTO>(), Action.VERIFY_COMPANY_INFO);
        verifyCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoVerifyAddRespDTO> addVerifyCompanyInfo(CompanyInfoVerifyAddReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoVerifyAddRespDTO>(), Action.ADD_VERIFY_COMPANY_INFO);
        addVerifyCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<String> updateCompanyPrintMode(CompanyPrintModeUpdateReqDTO companyPrintModeUpdateReqDTO) {
        Context<CompanyPrintModeUpdateReqDTO, String> context =
                new Context<>(companyPrintModeUpdateReqDTO, new Result<String>(), Action.UPDATE_PRINT_CONFIG);
        updateCompanyPrintModeProcess.start(context);
        return context.getResult();
    }
}
