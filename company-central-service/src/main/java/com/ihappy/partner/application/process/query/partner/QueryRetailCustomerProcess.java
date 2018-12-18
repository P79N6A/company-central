package com.ihappy.partner.application.process.query.partner;

import com.ihappy.common.util.DateUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.service.outside.trade.OrderSellerReadService;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.enumtype.IsDeletedEnum;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.trade.domain.dto.request.order.LastConsumeOrderQueryReqDTO;
import com.ihappy.trade.domain.dto.response.order.LastConsumeOrderQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
import com.ihappy.user.domain.dto.response.person.PersonInfoRespDTO;
import com.ihappy.user.domain.query.person.BaseinfoPersonCompanyOrgByComIdQuery;
import com.ihappy.user.domain.query.person.PersonInfoByPersonIdQuery;
import com.ihappy.user.service.person.BaseinfoPersonCompanyOrgReadRpcService;
import com.ihappy.user.service.person.BaseinfoPersonReadRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by sunjd on 2018/5/14.
 */
public class QueryRetailCustomerProcess extends DefaultQueryProcess<RetailCustomerQueryReqDTO,RetailCustomerQueryRespDTO> {
    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private BaseinfoPersonReadRpcService baseinfoPersonReadRpcServiceClient;
    @Autowired
    private BaseinfoPersonCompanyOrgReadRpcService baseinfoPersonCompanyOrgReadRpcService;

    @Autowired
    private OrderSellerReadService orderSellerReadService;


    @Override
    public void process(Context<RetailCustomerQueryReqDTO, RetailCustomerQueryRespDTO> context) {
        RetailCustomerQueryReqDTO reqDTO = context.getParam();
        final long compId = reqDTO.getLoginCompId();
        final long partnerId = reqDTO.getPartnerId();

        CompanyPartnerModel model = BaseInfoCompanyPartnerFactory.retailCustomerQueryReqDTOToModel(reqDTO);
        CompanyPartnerModel resModel = companyPartnerService.queryPartner(model);
        RetailCustomerQueryRespDTO respDTO = BaseInfoCompanyPartnerFactory.modelToRetailCustomerQueryReqDTO(resModel);

        //计算最近消费时间
        LastConsumeOrderQueryReqDTO lastConsumeOrderQueryReqDTO = new LastConsumeOrderQueryReqDTO();
        lastConsumeOrderQueryReqDTO.setCompId(compId);
        lastConsumeOrderQueryReqDTO.setPartnerId(partnerId);
        LastConsumeOrderQueryRespDTO lastConsumeOrderQueryRespDTO =
                orderSellerReadService.queryLastConsumeRetailOrder(lastConsumeOrderQueryReqDTO);
        if (lastConsumeOrderQueryRespDTO != null && lastConsumeOrderQueryRespDTO.getConfirmAt() != null) {
            Date date = DateUtil.parse(String.valueOf(lastConsumeOrderQueryRespDTO.getConfirmAt()));
            long diffDay = DateUtil.dateDiff(null, date, new Date());
            String lastConsumeTime = diffDay / CompanyConstant.YEAR_DAY == 0 ? diffDay + "天前" : diffDay / CompanyConstant.YEAR_DAY + "年前";
            respDTO.setLastConsumeTime(lastConsumeTime);
        }

        //查询门店信息
        if (respDTO.getStoreId() != null && respDTO.getStoreId() != 0){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("compId",Integer.valueOf(reqDTO.getLoginCompId().toString()));
            map.put("storeIds",Arrays.asList(respDTO.getStoreId()));
            List<CompanyStoreModel> stores = companyStoreService.findStoreListByCompIdAndStoreIds(map);
            if (!CollectionUtils.isEmpty(stores)){
                respDTO.setStoreName(stores.get(0).getDO().getStoreName());
            }
        }
        //查询导购员信息
        if (respDTO.getShoppingGuideId() != null && respDTO.getShoppingGuideId() != 0){
//            PersonInfoByPersonIdQuery personInfoByPersonIdQuery = new PersonInfoByPersonIdQuery();
//            personInfoByPersonIdQuery.setComId(reqDTO.getLoginCompId());
//            personInfoByPersonIdQuery.setPersonId(respDTO.getShoppingGuideId());
//            personInfoByPersonIdQuery.setDeletedFlag(IsDeletedEnum.NOT_DELETED.getKey());
            BaseinfoPersonCompanyOrgByComIdQuery baseinfoPersonCompanyOrgByComIdQuery=new BaseinfoPersonCompanyOrgByComIdQuery();
            baseinfoPersonCompanyOrgByComIdQuery.setCompId(reqDTO.getLoginCompId());
            baseinfoPersonCompanyOrgByComIdQuery.setPersonId(respDTO.getShoppingGuideId());
            baseinfoPersonCompanyOrgByComIdQuery.setDeletedFlag(IsDeletedEnum.NOT_DELETED.getKey());
            Result<PersonInfoRespDTO> baseinfoPersonRespDTO=baseinfoPersonCompanyOrgReadRpcService.queryAdminPersonInfoByPersonIdComId(baseinfoPersonCompanyOrgByComIdQuery);
          //  Result<BaseinfoPersonRespDTO> baseinfoPersonRespDTO = baseinfoPersonReadRpcServiceClient.getBaseinfoPersonByPersonId(personInfoByPersonIdQuery);
            if (baseinfoPersonRespDTO != null && baseinfoPersonRespDTO.getModule() != null){
                respDTO.setShoppingGuideName(baseinfoPersonRespDTO.getModule().getPersonName());
            }
        }
        context.getResult().setModule(respDTO);
    }

}
