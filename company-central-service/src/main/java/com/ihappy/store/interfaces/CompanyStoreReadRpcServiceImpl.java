package com.ihappy.store.interfaces;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.communal.common.enumtype.Action;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import com.ihappy.store.domain.dto.request.store.*;
import com.ihappy.store.domain.dto.request.weshop.WeshopDetailQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopListQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopShareReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitDetailListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.*;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopIndexDetailQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopListQueryRespDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopShareRespDTO;
import com.ihappy.store.infrastructure.service.CompanyStoreReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: company-central
 * @description: 门店信息查询
 * @author: 汪正
 * @create: 2018-07-30 13:57
 **/
public class CompanyStoreReadRpcServiceImpl implements CompanyStoreReadRpcService {

    @Autowired
    private IProcess queryStoreInfoByNameProcess;
    @Autowired
    private IProcess queryStoreListByCompIdAndStoreIdsProcess;

    @Autowired
    private IProcess queryStoreListByUserProcess;

    @Autowired
    private IProcess queryPrintIpAndPortProcess;

    @Autowired
    private IProcess queryWeshopVisitDetailListProcess;

    @Autowired
    private IProcess queryWeshopListByPageProcess;

    @Autowired
    private IProcess queryWeshopDetailProcess;

    @Autowired
    private IProcess queryWeshopDetailProcessWithoutLogin;

    @Autowired
    private IProcess queryStoreInfoByInfoProcess;

    @Autowired
    private IProcess shareWeshopProcess;

    @Autowired
    private IProcess queryStoreListWithPublicByCompIdAndStoreIdsProcess;

    @Autowired
    private IProcess rpcQueryStoreListProcess;

    @Autowired
    private IProcess queryAllStoreByCompIdProcess;

    @Autowired
    private IProcess queryStoreManagerProcess;

    @Autowired
    private IProcess querySalePerformanceByConditionProcess;

    @Autowired
    private IProcess queryStorePerformanceProcess;

    @Override
    public Result<StoreInfoQueryRespDTO> queryStoreInfoByStoreName(StoreInfoQueryReqDTO storeInfoQueryReqDTO) {
        Context context = new Context(storeInfoQueryReqDTO, new Result<CompanyRoleQueryRespDTO>(), Action.QUERY_COMPANY_SOTRE);
        queryStoreInfoByNameProcess.start(context);
        return context.getResult();
    }
    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        Context context = new Context(companyStoreListQueryReqDTO, new Result<List<CompanyStoreListQueryRespDTO>>(), Action.QUERY_COMPANY_SOTRE_LIST);
        queryStoreListByCompIdAndStoreIdsProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListWithPublicByCompIdAndStoreIds(CompanyStoreListQueryReqDTO companyStoreListQueryReqDTO) {
        Context context = new Context(companyStoreListQueryReqDTO, new Result<List<CompanyStoreListQueryRespDTO>>(), Action.QUERY_STORE_LIST_WITH_PUBLIC_BY_COMPID_AND_STOREIDS);
        queryStoreListWithPublicByCompIdAndStoreIdsProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreListByUser(CompanyStoreListByUserQueryReqDTO companyStoreListByUserQueryReqDTO) {
        Context context = new Context(companyStoreListByUserQueryReqDTO, new Result<List<CompanyStoreListQueryRespDTO>>(), Action.QUERY_COMPANY_SOTRE_LIST);
        queryStoreListByUserProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<WeshopListQueryRespDTO>> findWeshopByPage(WeshopListQueryReqDTO weshopListQueryReqDTO) {
        Context context = new Context(weshopListQueryReqDTO, new Result<List<WeshopListQueryRespDTO>>(), Action.QUERY_COMPANY_SOTRE_LIST);
        queryWeshopListByPageProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<WeshopDetailQueryRespDTO> findWeshopDetail(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO) {
        Context context = new Context(weshopDetailQueryReqDTO, new Result<List<WeshopDetailQueryRespDTO>>(), Action.QUERY_COMPANY_SOTRE_DETAIL);
        queryWeshopDetailProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<WeshopDetailQueryRespDTO> findWeshopDetailWithoutLogin(WeshopDetailQueryReqDTO weshopDetailQueryReqDTO) {
        Context context = new Context(weshopDetailQueryReqDTO, new Result<List<WeshopDetailQueryRespDTO>>(), Action.QUERY_COMPANY_SOTRE_DETAIL_WITHOUT_LOGIN);
        queryWeshopDetailProcessWithoutLogin.start(context);
        return context.getResult();
    }

    @Override
    public Result<WeshopIndexDetailQueryRespDTO> queryWeshopVisitDetailList(WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO) {
        Context context = new Context(weshopVisitDetailListQueryReqDTO, new Result<List<WeshopListQueryRespDTO>>(), Action.QUERY_WESHOP_VISIT_DETAIL_LIST);
        queryWeshopVisitDetailListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<StorePrintIpAndPortQueryRespDTO> findPrintIpAndPort(StoreQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<StorePrintIpAndPortQueryRespDTO>(), Action.QUERY_PRINT_IP_AND_PORT);
        queryPrintIpAndPortProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> findStoreInfoByInfoQuery(StoreInfoByInfoQuery storeInfoByInfoQuery) {
        Context context = new Context(storeInfoByInfoQuery, new Result<List<CompanyStoreListQueryRespDTO>>(), Action.QUERY_PRINT_IP_AND_PORT);
        queryStoreInfoByInfoProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<WeshopShareRespDTO> shareWeshop(WeshopShareReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<WeshopShareRespDTO>(), Action.SHARE_WESHOP);
        shareWeshopProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<StoreQueryRespDTO>> queryStoreList(StoreQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<StoreQueryRespDTO>>(), Action.QUERY_STORE_LIST);
        rpcQueryStoreListProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<CompanyStoreListQueryRespDTO>> queryAllStoreByCompId(CompanyStoreListQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<StoreQueryRespDTO>>(), Action.QUERY_STORE_LIST);
        queryAllStoreByCompIdProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<SalePerformanceRespDTO>> querySalePerformanceByCondition(SalePerformanceReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<SalePerformanceRespDTO>>(), Action.QUERY_SALE_PERFORMANCE_BY_CONDITION);
        querySalePerformanceByConditionProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<StorePerformanceRespDTO> queryStorePerformance(StorePerformanceReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<StorePerformanceRespDTO>(), Action.QUERY_PERFORMANCE);
        queryStorePerformanceProcess.start(context);
        return context.getResult();
    }

    @Override
    public Result<List<UserInfoRespDTO>> queryStoreManager(StoreManagerQueryReqDTO reqDTO) {
        Context context = new Context(reqDTO, new Result<List<UserInfoRespDTO>>(), Action.QUERY_STORE_MANAGER);
        queryStoreManagerProcess.start(context);
        return context.getResult();
    }
}
