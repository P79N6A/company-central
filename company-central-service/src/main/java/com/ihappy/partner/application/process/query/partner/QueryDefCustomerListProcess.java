package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.DefCustomerListQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.DefCustomerListQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/12.
 */
public class QueryDefCustomerListProcess extends DefaultQueryProcess<DefCustomerListQueryReqDTO,DefCustomerListQueryRespDTO> {
    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Override
    public void process(Context<DefCustomerListQueryReqDTO, DefCustomerListQueryRespDTO> context) {
        DefCustomerListQueryReqDTO defCustomerListQueryReqDTO = context.getParam();
        List<BaseinfoCompanyPartner> favorList = companyPartnerService.queryFavorList(BaseInfoCompanyPartnerFactory.defCustomerListQueryReqDTOToModel(defCustomerListQueryReqDTO).getDO(), OptConstans.DEFAULT_PARTNER_FAVOR_SIZE);
        List<BaseinfoCompanyPartner> lastContactList = companyPartnerService.queryLastContactList(BaseInfoCompanyPartnerFactory.defCustomerListQueryReqDTOToModel(defCustomerListQueryReqDTO).getDO(),OptConstans.DEFAULT_PARTNER_FAVOR_SIZE);
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(favorList);
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(lastContactList);
        DefCustomerListQueryRespDTO defCustomerListQueryRespDTO = new DefCustomerListQueryRespDTO();
        defCustomerListQueryRespDTO.setFavorList(BaseInfoCompanyPartnerFactory.modelListToCustomerInfoQueryRespDTOList(favorList));
        defCustomerListQueryRespDTO.setLastContactList(BaseInfoCompanyPartnerFactory.modelListToCustomerInfoQueryRespDTOList(lastContactList));
        context.getResult().setModule(defCustomerListQueryRespDTO);
    }
}
