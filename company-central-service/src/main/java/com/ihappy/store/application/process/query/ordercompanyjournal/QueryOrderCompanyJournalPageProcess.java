package com.ihappy.store.application.process.query.ordercompanyjournal;

import com.ihappy.common.domain.Page;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.bo.OrderCompanyJournalPageQueryBO;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalQuery;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by chenying on 2018/6/29.
 */
public class QueryOrderCompanyJournalPageProcess extends DefaultQueryProcess<OrderCompanyJournalQuery,Page<OrderCompanyJournalInfoRespDTO>> {

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<OrderCompanyJournalQuery, Page<OrderCompanyJournalInfoRespDTO>> context) {

        OrderCompanyJournalQuery orderCompanyJournalQuery = context.getParam();

        if (!StringUtil.isBlank(orderCompanyJournalQuery.getPayTimeStart())){
            orderCompanyJournalQuery.setPayTimeStart(String.valueOf(DateUtil.formatDate(DateUtil.Y_M_D_H_M_S,orderCompanyJournalQuery.getPayTimeStart())+"00:00:00"));
        }else {
            orderCompanyJournalQuery.setPayTimeStart(null);
        }

        if (!StringUtil.isBlank(orderCompanyJournalQuery.getPayTimeEnd())){
            orderCompanyJournalQuery.setPayTimeEnd(String.valueOf(DateUtil.formatDate(DateUtil.Y_M_D_H_M_S,orderCompanyJournalQuery.getPayTimeEnd())+"23:59:59"));
        }else {
            orderCompanyJournalQuery.setPayTimeEnd(null);
        }

        List<OrderCompanyJournalInfoRespDTO> result = new ArrayList<>();
        OrderCompanyJournalPageQueryBO orderCompanyJournalPageQueryBO = OrderCompanyJournalFactory.toOrderCompanyJournalPageQueryBO(orderCompanyJournalQuery);

        int count = orderCompanyJournalService.getOrderCompanyJournalCount(orderCompanyJournalPageQueryBO);
        if(count == 0){
            Page resultPage = new Page(orderCompanyJournalQuery.getPageSize(),orderCompanyJournalQuery.getCurrentPage(),count,result);
            context.getResult().setModule(resultPage);
            return;
        }
        List<OrderCompanyJournalModel> orderList = orderCompanyJournalService.getOrderCompanyJournalList(orderCompanyJournalPageQueryBO);
        Set<Integer> compSet = new HashSet<>();
        Set<Long> storeIdSet = new HashSet<>();
        for(OrderCompanyJournalModel orderCompanyJournalModel : orderList){
            OrderCompanyJournalInfoRespDTO dto = OrderCompanyJournalFactory.toOrderCompanyJournalInfoRespDTO(orderCompanyJournalModel.getDO());
            result.add(dto);
            compSet.add(Integer.parseInt(dto.getCompId()+""));
            storeIdSet.add(dto.getStoreId());
        }

        if (!CollectionUtil.isEmpty(compSet)) {
            Map<String,CompanyModel> compMap = companyInfoService.getCompNameById(new ArrayList<>(compSet));
            Map<String,Object> storeIdMap = new HashMap<>();
            storeIdMap.put("storeIds",storeIdSet);
            Map<Long,CompanyStoreModel> storeMap = companyStoreService.selectByStoreIds(storeIdMap);
            for(OrderCompanyJournalInfoRespDTO orderCompanyJournalInfoRespDTO : result){
                CompanyModel companyModel = compMap.get(orderCompanyJournalInfoRespDTO.getCompId()+"");
                if(companyModel != null){
                    orderCompanyJournalInfoRespDTO.setCompanyName(companyModel.getDO().getCompShortName());
                    orderCompanyJournalInfoRespDTO.setCtName(companyModel.getDO().getCtNames());
                }
                CompanyStoreModel storeModel = storeMap.get(orderCompanyJournalInfoRespDTO.getStoreId());
                if(storeModel != null){
                    orderCompanyJournalInfoRespDTO.setStoreName(storeModel.getDO().getStoreName());
                }
            }
        }


        Page resultPage = new Page(orderCompanyJournalQuery.getPageSize(),orderCompanyJournalQuery.getCurrentPage(),count,result);
        context.getResult().setModule(resultPage);
    }
}

