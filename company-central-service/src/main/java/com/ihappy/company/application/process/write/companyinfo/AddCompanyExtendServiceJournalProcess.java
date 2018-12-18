package com.ihappy.company.application.process.write.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExtendServiceAddRespDTO;
import com.ihappy.company.domain.model.factory.CompanyExtendServiceFactory;
import com.ihappy.company.domain.model.model.CompanyExtendServiceJournalModel;
import com.ihappy.company.infrastructure.service.inside.CompanyExtendService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/28.
 */
public class AddCompanyExtendServiceJournalProcess extends DefaultProcess<CompanyExtendServiceAddReqDTO, CompanyExtendServiceAddRespDTO> {
    @Autowired
    private CompanyExtendService companyExtendService;

    @Override
    public void process(Context<CompanyExtendServiceAddReqDTO, CompanyExtendServiceAddRespDTO> context) {
        CompanyExtendServiceAddReqDTO reqDTO = context.getParam();
        CompanyExtendServiceJournalModel reqModel = CompanyExtendServiceFactory.companyExtendServiceAddReqDTOToModel(reqDTO);
        Long res = companyExtendService.addCompanyExtendServiceJournalWithTransaction(reqModel);
        CompanyExtendServiceAddRespDTO respDTO = new CompanyExtendServiceAddRespDTO();
        respDTO.setJournalId(res);
        context.getResult().setModule(respDTO);
    }
}
