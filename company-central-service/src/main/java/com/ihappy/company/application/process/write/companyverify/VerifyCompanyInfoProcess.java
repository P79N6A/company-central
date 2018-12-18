package com.ihappy.company.application.process.write.companyverify;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyRespDTO;
import com.ihappy.company.domain.model.factory.VerifyCompanyInfoFactory;
import com.ihappy.company.domain.model.model.CompanyVerifiedHistoryModel;
import com.ihappy.company.infrastructure.service.inside.VerifyCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/7.
 */
public class VerifyCompanyInfoProcess extends DefaultProcess<CompanyInfoVerifyReqDTO, CompanyInfoVerifyRespDTO> {
    @Autowired
    private VerifyCompanyInfoService verifyCompanyInfoService;

    @Override
    public void process(Context<CompanyInfoVerifyReqDTO, CompanyInfoVerifyRespDTO> context) {
        CompanyInfoVerifyReqDTO reqDTO = context.getParam();
        CompanyVerifiedHistoryModel companyVerifiedHistoryModel = VerifyCompanyInfoFactory.companyInfoVerifyReqDTOToModel(reqDTO);
        CompanyVerifiedHistoryModel verifieModel = verifyCompanyInfoService.verifyCompanyInfo(companyVerifiedHistoryModel);
        CompanyInfoVerifyRespDTO respDTO = new CompanyInfoVerifyRespDTO();
        respDTO.setMessage("保存成功");
        context.getResult().setModule(respDTO);
    }
}
