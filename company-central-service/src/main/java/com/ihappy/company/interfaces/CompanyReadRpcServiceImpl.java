package com.ihappy.company.interfaces;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.company.domain.dto.request.*;
import com.ihappy.company.domain.dto.request.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.*;
import com.ihappy.company.domain.dto.request.companytype.SysCompanyTypeAllQuery;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.*;
import com.ihappy.company.domain.dto.response.companyinfo.*;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.company.infrastructure.service.CompanyReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/3/29.
 */
public class CompanyReadRpcServiceImpl implements CompanyReadRpcService {
    @Autowired
    private IProcess queryCompanyListProcess;

    @Autowired
    private IProcess queryCompanyInfoProcess;

    @Autowired
    private IProcess queryCompanyInfoWithoutLoginProcess;
    @Autowired
    private IProcess queryCompanyInfoListByIdsProcess;

    @Autowired
    private IProcess queryCompanyExpireDateProcess;

    @Autowired
    private IProcess queryCompInfoExpireStatueProcess;

    @Autowired
    private IProcess queryCompanyServiceStatusPageProcess;

    @Autowired
    private IProcess queryCompanyFactoryInfoListProcess;


    @Autowired
    private IProcess queryCompanyFactoryInfoObjectProcess;
    @Autowired
    private IProcess queryCompanyBrandListProcess;
    @Autowired
    private IProcess queryCompanyPrintConfigProcess;

    @Autowired
    private IProcess queryCompanyPrintConfigListProcess;
    @Autowired
    private IProcess queryVerifyCompanyInfoProcess;
    @Autowired
    private IProcess queryAllSysCompanyTypeProcess;
    @Override
    public Result<Page<BaseinfoCompanyRespDTO>> findBaseinfoCompanyPage(BaseinfoCompanyReqDTO baseinfoCompanyReqDTO) {
        Context context = new Context(baseinfoCompanyReqDTO, new Result<List<BaseinfoCompanyRespDTO>>(), Action.QUERY_COMPANY_LIST);
        queryCompanyListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoQueryRespDTO> findCompanyInfo(CompanyInfoQueryReqDTO companyInfoQueryReqDTO) {
        Context context = new Context(companyInfoQueryReqDTO, new Result<CompanyInfoQueryRespDTO>(), Action.QUERY_COMPANY_INFO);
        queryCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyInfoListQueryRespDTO>> findCompanyInfoListByIds(CompanyInfoListQueryReqDTO companyInfoListQueryReqDTO) {
        Context context = new Context(companyInfoListQueryReqDTO, new Result<List<CompanyInfoListQueryRespDTO>>(), Action.QUERY_COMPANY_LIST);
        queryCompanyInfoListByIdsProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyInfoWithoutLoginQueryRespDTO> findCompanyInfoWithoutLogin(CompanyInfoWithoutLoginQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoWithoutLoginQueryRespDTO>(), Action.QUERY_COMPANY_INFO_WITHOUT_LOGIN);
        queryCompanyInfoWithoutLoginProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyExpireDateQueryRespDTO> queryCompanyExpireDate(CompanyInfoByCompIdQuery companyInfoByCompIdQuery) {
        Context context = new Context(companyInfoByCompIdQuery, new Result<CompanyExpireDateQueryRespDTO>(), Action.QUERY_COMPANY_EXPIRE_INFO);
        queryCompanyExpireDateProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<CompanyExpireStatusRespDTO> queryCompanyExpireStatue(CompanyExpireStatusByCompIdQuery companyExpireStatusByCompIdQuery) {
        Context context = new Context(companyExpireStatusByCompIdQuery, new Result<CompanyExpireStatusRespDTO>(), Action.QUERY_COMPANY_EXPIRE_INFO);
        queryCompInfoExpireStatueProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<Page<CompanyServiceStatusPageQueryRespDTO>> queryCompanyServiceStatusPage(CompanyServiceStatusPageQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyServiceStatusPageQueryRespDTO>(), Action.QUERY_COMPANY_SERVICE_STATUS_PAGE);
        queryCompanyServiceStatusPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<FactoryInfoRespDTO>> queryCompanyFactoryInfoForList(UsopRequestBaseQuery usopRequestBaseQuery) {

        FactoryInfoConfigQuery factoryInfoConfigQuery =new FactoryInfoConfigQuery();
        factoryInfoConfigQuery.setCompId(usopRequestBaseQuery.getPersonUserInfoDTOV2().getCompId());
        return queryCompanyFactoryInfoForListByCompId(factoryInfoConfigQuery);
    }

    @Override
    public Result<FactoryInfosRespDTO> queryFactoryInfosRespDTO(UsopRequestBaseQuery usopRequestBaseQuery) {


        Context context = new Context(usopRequestBaseQuery, new Result<FactoryInfosRespDTO>(), Action.QUERY_COMPANY_FACTORYINFO_OBJECT);
        queryCompanyFactoryInfoObjectProcess.start(context);
        return context.getResult();
    }


    @Override
    public Result<List<FactoryInfoRespDTO>> queryCompanyFactoryInfoForListByCompId(FactoryInfoConfigQuery factoryInfoConfigQuery) {
        Context context = new Context(factoryInfoConfigQuery, new Result<List<FactoryInfoRespDTO>>(), Action.QUERY_COMPANY_FACTORYINFO_LIST);
        queryCompanyFactoryInfoListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyBrandListQueryRespDTO>> findCompanyBrandList(CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO) {
        Context context = new Context(companyBrandListQueryReqDTO, new Result<List<CompanyBrandListQueryRespDTO>>(), Action.QUERY_COMPANY_BRAND_LIST);
        queryCompanyBrandListProcess.start(context);
        return context.getResult();
    }
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

    @Override
    public Result<CompanyInfoVerifyReadRespDTO> findVerifyCompanyInfo(CompanyInfoVerifyReadReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<CompanyInfoVerifyReadRespDTO>(), Action.QUERY_VERIFY_COMPANY_INFO);
        queryVerifyCompanyInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SysCompanyTypeInfoRespDTO>> queryAllSysCompanyType(SysCompanyTypeAllQuery sysCompanyTypeAllQuery) {
        Context context = new Context(sysCompanyTypeAllQuery, new Result<List<SysCompanyTypeInfoRespDTO>>(), Action.QUERY_COMPANY_TYPE);
        queryAllSysCompanyTypeProcess.start(context);
        return context.getResult();
    }
}
