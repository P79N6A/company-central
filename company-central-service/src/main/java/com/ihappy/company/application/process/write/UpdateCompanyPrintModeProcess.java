package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.bo.CompanyPrintModeBO;
import com.ihappy.company.domain.dto.request.CompanyPrintModeUpdateReqDTO;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyPrintConfigService;
import com.ihappy.user.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by chenying on 2018/11/15.
 */
public class UpdateCompanyPrintModeProcess extends DefaultProcess<CompanyPrintModeUpdateReqDTO, String> {

    @Autowired
    private CompanyPrintConfigService companyPrintConfigService;


    @Override
    public void process(Context<CompanyPrintModeUpdateReqDTO, String> context) {
        CompanyPrintModeUpdateReqDTO companyPrintModeUpdateReqDTO = context.getParam();
        if (companyPrintModeUpdateReqDTO.getCompId() == null||companyPrintModeUpdateReqDTO.getCompId()<=0){
            companyPrintModeUpdateReqDTO.setCompId(companyPrintModeUpdateReqDTO.getLoginCompId());
        }
        CompanyPrintModeBO companyPrintModeBO = getBO(companyPrintModeUpdateReqDTO);
        Integer res = companyPrintConfigService.updateCompanyPrintMode(companyPrintModeBO);
        if(res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_COMPANY_PRINT_MODE_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_COMPANY_PRINT_MODE_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }

    public CompanyPrintModeBO getBO(CompanyPrintModeUpdateReqDTO companyPrintModeUpdateReqDTO){
        CompanyPrintModeBO companyPrintModeBO = new CompanyPrintModeBO();
        companyPrintModeBO.setUpdatedAt(DateUtil.dateConvertlong(new Date()));
        companyPrintModeBO.setUpdatedPersonId(companyPrintModeUpdateReqDTO.getLoginPersonId());
        companyPrintModeBO.setCompId(companyPrintModeUpdateReqDTO.getCompId());
        companyPrintModeBO.setPrintMode(companyPrintModeUpdateReqDTO.getPrintMode());
        return companyPrintModeBO;
    }
}
