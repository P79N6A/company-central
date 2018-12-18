package com.ihappy.store.application.process.query.ordercompanyjournal;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.bo.OrderCompanyJournalByIdBO;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalByIdQuery;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalInfoRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhc on 2018/6/30.
 */
public class QueryOrderCompanyJournalDetailProcess extends DefaultQueryProcess<OrderCompanyJournalByIdQuery,OrderCompanyJournalInfoRespDTO> {

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<OrderCompanyJournalByIdQuery, OrderCompanyJournalInfoRespDTO> context) {
        OrderCompanyJournalByIdQuery orderCompanyJournalByIdQuery = context.getParam();
        OrderCompanyJournalByIdBO orderCompanyJournalByIdBO = new OrderCompanyJournalByIdBO();
        orderCompanyJournalByIdBO.setOrderId(orderCompanyJournalByIdQuery.getOrderId());
        OrderCompanyJournalModel model = orderCompanyJournalService.getOrderCompanyJournalDetailById(orderCompanyJournalByIdBO);
        OrderCompanyJournalInfoRespDTO respDTO = OrderCompanyJournalFactory.toOrderCompanyJournalInfoRespDTO(model.getDO());
        List<Integer> compIds = new ArrayList<>();
        compIds.add(Integer.parseInt(respDTO.getCompId()+""));
        Map<String,CompanyModel> map = companyInfoService.getCompNameById(compIds);
        CompanyModel companyModel = map.get(respDTO.getCompId()+"");
        if(companyModel != null){
            respDTO.setCompanyName(companyModel.getDO().getCompShortName());
            respDTO.setCtName(companyModel.getDO().getCtNames());
        }
        CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
        companyStoreModel.getDO().setCompId(respDTO.getCompId().intValue());
        companyStoreModel.getDO().setStoreId(respDTO.getStoreId());
        //查询门店详情
        CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(companyStoreModel);
        //如果门店为空，则不存在
        if (storeInfo != null) {
            respDTO.setStoreName(storeInfo.getDO().getStoreName());
        }
        context.getResult().setModule(respDTO);
    }
}
