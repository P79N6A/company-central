package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/2.
 */
public class QueryPartnerProcess extends DefaultQueryProcess<ProviderInfoQueryReqDTO,ProviderInfoQueryRespDTO> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;

    @Override
    public void process(Context<ProviderInfoQueryReqDTO, ProviderInfoQueryRespDTO> context) {
        ProviderInfoQueryReqDTO providerInfoQueryReqDTO = context.getParam();
        BaseinfoCompanyPartner baseinfoCompanyPartner = baseinfoCompanyPartnerMapper.selectByPrimaryKey(providerInfoQueryReqDTO.getPartnerId());
        if (baseinfoCompanyPartner == null || (baseinfoCompanyPartner.getPartnerType() != CompanyPartnerTypeEnum.PROVIDER.getKey())){
            context.getResult().setModule(new ProviderInfoQueryRespDTO());
            return;
        }
        //零售会员，没有partnerLinkman 则设为 partnerName
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(baseinfoCompanyPartner);
        ProviderInfoQueryRespDTO providerInfoQueryRespDTO = BaseInfoCompanyPartnerFactory.modelToProviderInfoQueryRespDTO(baseinfoCompanyPartner);
        context.getResult().setModule(providerInfoQueryRespDTO);
    }
}
