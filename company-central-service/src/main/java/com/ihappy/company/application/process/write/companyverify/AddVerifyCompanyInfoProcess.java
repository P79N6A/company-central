package com.ihappy.company.application.process.write.companyverify;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyAddRespDTO;
import com.ihappy.company.domain.model.factory.VerifyCompanyInfoFactory;
import com.ihappy.company.domain.model.model.CompanyVerifiedHistoryModel;
import com.ihappy.company.infrastructure.service.inside.VerifyCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/7.
 */
public class AddVerifyCompanyInfoProcess extends DefaultProcess<CompanyInfoVerifyAddReqDTO, CompanyInfoVerifyAddRespDTO> {
    @Autowired
    private VerifyCompanyInfoService verifyCompanyInfoService;

    @Override
    public void process(Context<CompanyInfoVerifyAddReqDTO, CompanyInfoVerifyAddRespDTO> context) {
        CompanyInfoVerifyAddReqDTO reqDTO = context.getParam();
        CompanyVerifiedHistoryModel companyVerifiedHistoryModel = VerifyCompanyInfoFactory.companyInfoVerifyAddReqDTOToModel(reqDTO);
        CompanyVerifiedHistoryModel insertModel = verifyCompanyInfoService.addVerifyCompanyInfo(companyVerifiedHistoryModel);
        CompanyInfoVerifyAddRespDTO respDTO = new CompanyInfoVerifyAddRespDTO();
        respDTO.setMessage("提交成功");
        context.getResult().setModule(respDTO);
    }
}
