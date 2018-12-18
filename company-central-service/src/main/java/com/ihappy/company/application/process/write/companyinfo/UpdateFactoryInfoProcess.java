package com.ihappy.company.application.process.write.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.request.companyinfo.FactoryInfoConfigReqDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class UpdateFactoryInfoProcess extends DefaultProcess<FactoryInfoConfigReqDTO,Void> {

   private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<FactoryInfoConfigReqDTO, Void> context) {

        FactoryInfoConfigReqDTO factoryInfoConfigReqDTO  =  context.getParam();

        CompanyInfoByCompIdQuery companyInfoByCompIdQuery =new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setLongCompId(factoryInfoConfigReqDTO.getPersonUserInfoDTOV2().getCompId());

        CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);

        if(companyModel==null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }

        companyModel.addFactoryInfoInAttributes(factoryInfoConfigReqDTO.getFactoryInfo());
        companyModel.factoryInfoPutRedis();

        companyInfoService.updateFactoryInfo(companyModel);

    }

    public void setCompanyInfoService(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }
}
