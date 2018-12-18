package com.ihappy.partner.application.process.query.partner;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.AmountUtils;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.bo.partner.QueryPartnerBO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerQueryPageReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerQueryPageRespDTO;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhangmengdan on 2018/11/1.
 */
public class QueryRetailCustomerPageProcess extends DefaultQueryProcess<RetailCustomerQueryPageReqDTO, Page<RetailCustomerQueryPageRespDTO>> {
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<RetailCustomerQueryPageReqDTO, Page<RetailCustomerQueryPageRespDTO>> context) {
        RetailCustomerQueryPageReqDTO reqDTO = context.getParam();
        final long loginCompId = reqDTO.getLoginCompId();
        //根据公司id查询公司信息
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery =new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(Long.valueOf(loginCompId).intValue());
        companyInfoByCompIdQuery.setLoginPersonId(reqDTO.getLoginPersonId());
        CompanyModel companyInfo = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
        //判断公司是否存在
        if (companyInfo == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }
        QueryPartnerBO queryPartnerBO = new QueryPartnerBO();
        queryPartnerBO.setCompId(reqDTO.getLoginCompId().intValue());
        queryPartnerBO.setLimit(reqDTO.getLimit());
        queryPartnerBO.setOffset(reqDTO.getOffset());
        queryPartnerBO.setSearchStr(reqDTO.getSearchStr());
        queryPartnerBO.setPartnerType(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        queryPartnerBO.setFilterIsDefault(reqDTO.getFilterIsDefault() == null ? false : reqDTO.getFilterIsDefault());
        queryPartnerBO.setFilterIsForbid(reqDTO.getFilterIsForbid() == null ? false : reqDTO.getFilterIsForbid());
        //根据公司id查询会员列表会员数量
        Integer count = companyPartnerService.queryPartnerPageByCompIdCount(queryPartnerBO);
        List<RetailCustomerQueryPageRespDTO> respDTOList = new ArrayList<>();
        if(count != 0) {
            //根据公司id查询会员列表
            BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
            baseinfoCompanyStore.setCompId(Long.valueOf(loginCompId).intValue());
            List<CompanyStoreModel> companyStoreModelList = companyStoreService.selectStoreByCondition(baseinfoCompanyStore);
            Map<Long, String> idAndNamesMap = companyStoreModelList.stream().collect(Collectors.toMap(CompanyStoreModel::getStoreId, CompanyStoreModel::getStoreName));
            List<CompanyPartnerModel> partnerModelList = companyPartnerService.queryPartnerPageByCompId(queryPartnerBO);
            for (CompanyPartnerModel companyPartner : partnerModelList) {
                RetailCustomerQueryPageRespDTO respDTO = new RetailCustomerQueryPageRespDTO();
                respDTO.setHeadPortraitAddress(companyPartner.getDO().getHeadPortraitAddress());
                respDTO.setPartnerName(companyPartner.getDO().getPartnerName());
                respDTO.setMobile(companyPartner.getDO().getMobile());
                respDTO.setForbidden(companyPartner.getDO().getForbidden());
                respDTO.setStoreId(companyPartner.getDO().getStoreId());
                //根据门店id查询门店名称
                respDTO.setStoreName(idAndNamesMap.get(respDTO.getStoreId()) == null ? "" : idAndNamesMap.get(respDTO.getStoreId()));
                respDTO.setPartnerId(companyPartner.getDO().getPartnerId());
                respDTO.setPrepaidDeposit(companyPartner.getDO().getPrepaidDeposit());
                respDTO.setPrepaidDepositY(AmountUtils.changeF2Y(respDTO.getPrepaidDeposit()));
                respDTO.setIsDefault(companyPartner.getDO().getIsDefault());
                respDTOList.add(respDTO);
            }
        }
        Page<RetailCustomerQueryPageRespDTO> pageRespDTOPage = new Page(1, 1, count, respDTOList);

        context.setResultModule(pageRespDTOPage);
    }
}
