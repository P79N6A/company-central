package com.ihappy.store.application.process.query.store;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.bo.OrderCompanyJournalPageQueryBO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompStorePayInfoPageQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.CompStorePayInfoPageRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liuhc on 2018/10/18.
 */
public class QueryStoreInfoPayPageProcess extends DefaultQueryProcess<CompStorePayInfoPageQueryReqDTO,Page<CompStorePayInfoPageRespDTO>> {

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<CompStorePayInfoPageQueryReqDTO, Page<CompStorePayInfoPageRespDTO>> context) {

        CompStorePayInfoPageQueryReqDTO payInfoPageQueryReqDTO = context.getParam();

        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(payInfoPageQueryReqDTO.getLoginCompId().intValue());

        CompanyModel companyInfo = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
        //判断公司是否存在
        if (companyInfo == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }

        CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
        companyStoreModel.getDO().setCompId(payInfoPageQueryReqDTO.getLoginCompId().intValue());
        companyStoreModel.getDO().setStoreId(payInfoPageQueryReqDTO.getStoreId());
        //查询门店详情
        CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(companyStoreModel);
        //如果门店为空，则不存在
        if (storeInfo == null) {
            throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
        }

        OrderCompanyJournalPageQueryBO journalByCompIdBO = new OrderCompanyJournalPageQueryBO();
        journalByCompIdBO.setCompId(payInfoPageQueryReqDTO.getLoginCompId());
        journalByCompIdBO.setStoreId(payInfoPageQueryReqDTO.getStoreId());
        journalByCompIdBO.setLimit(payInfoPageQueryReqDTO.getLimit());
        journalByCompIdBO.setOffset(payInfoPageQueryReqDTO.getOffset());
        List<CompStorePayInfoPageRespDTO> result = new ArrayList<>();
        int count = orderCompanyJournalService.getOrderCompanyJournalCount(journalByCompIdBO);
        if(count == 0){
            Page resultPage = new Page(payInfoPageQueryReqDTO.getPageSize(),payInfoPageQueryReqDTO.getCurrentPage(),count,result);
            context.getResult().setModule(resultPage);
            return;
        }
        List<OrderCompanyJournalModel> orderList = orderCompanyJournalService.getOrderCompanyJournalList(journalByCompIdBO);
        Set<Integer> compSet = new HashSet<>();
        for(OrderCompanyJournalModel orderCompanyJournalModel : orderList){
            CompStorePayInfoPageRespDTO dto = OrderCompanyJournalFactory.toCompStorePayInfoPageRespDTO(orderCompanyJournalModel.getDO());
            dto.setStoreName(storeInfo.getDO().getStoreName()+" - 账号使用权1年");
            dto.setPicture(companyInfo.getDO().getCompanyHead());
            result.add(dto);
        }
        Page resultPage = new Page(payInfoPageQueryReqDTO.getPageSize(),payInfoPageQueryReqDTO.getCurrentPage(),count,result);
        context.getResult().setModule(resultPage);
    }
}
