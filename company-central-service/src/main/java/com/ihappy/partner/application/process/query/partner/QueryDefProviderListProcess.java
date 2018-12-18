package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.DefProviderListQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.DefProviderListQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/11.
 */
public class QueryDefProviderListProcess extends DefaultQueryProcess<DefProviderListQueryReqDTO,DefProviderListQueryRespDTO> {
    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Override
    public void process(Context<DefProviderListQueryReqDTO, DefProviderListQueryRespDTO> context) {
        DefProviderListQueryReqDTO defProviderListQueryReqDTO = context.getParam();
        List<BaseinfoCompanyPartner> favorList = companyPartnerService.queryFavorList(BaseInfoCompanyPartnerFactory.defProviderListQueryReqDTOToModel(defProviderListQueryReqDTO).getDO(), OptConstans.DEFAULT_PARTNER_FAVOR_SIZE);
        List<BaseinfoCompanyPartner> lastContactList = companyPartnerService.queryLastContactList(BaseInfoCompanyPartnerFactory.defProviderListQueryReqDTOToModel(defProviderListQueryReqDTO).getDO(),OptConstans.DEFAULT_PARTNER_LAST_CONTACT_SIZE);

        DefProviderListQueryRespDTO defProviderListQueryRespDTO = new DefProviderListQueryRespDTO();
        defProviderListQueryRespDTO.setFavorList(BaseInfoCompanyPartnerFactory.modelListToProviderInfoQueryRespDTOList(favorList));
        defProviderListQueryRespDTO.setLastContactList(BaseInfoCompanyPartnerFactory.modelListToProviderInfoQueryRespDTOList(lastContactList));
        context.getResult().setModule(defProviderListQueryRespDTO);
    }
}