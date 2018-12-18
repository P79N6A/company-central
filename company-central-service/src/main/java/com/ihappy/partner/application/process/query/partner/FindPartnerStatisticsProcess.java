package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.bo.partner.PartnerBO;
import com.ihappy.partner.domain.dto.request.partner.PartnerStatisticsReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerStatisticsRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/8/9.
 */
public class FindPartnerStatisticsProcess extends DefaultProcess<PartnerStatisticsReqDTO,PartnerStatisticsRespDTO> {
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Override
    public void process(Context<PartnerStatisticsReqDTO, PartnerStatisticsRespDTO> context) {
        PartnerStatisticsReqDTO reqDTO = context.getParam();
        BaseinfoCompanyPartner param = BaseInfoCompanyPartnerFactory.statisticsReqDTO2DO(reqDTO);
        PartnerBO bo = companyPartnerService.findPartnerStatistics(param);
        PartnerStatisticsRespDTO respDTO = BaseInfoCompanyPartnerFactory.partnerBO2StatisticsRespDTO(bo);
        context.getResult().setModule(respDTO);
    }
}
