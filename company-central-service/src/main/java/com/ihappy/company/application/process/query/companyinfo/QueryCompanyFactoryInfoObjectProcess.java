package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfosRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class QueryCompanyFactoryInfoObjectProcess  extends DefaultQueryProcess<UsopRequestBaseQuery,FactoryInfosRespDTO> {

    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<UsopRequestBaseQuery, FactoryInfosRespDTO> context) {
        UsopRequestBaseQuery usopRequestBaseQuery = context.getParam();

        String json =  CompanyRedisUtil.getFactoryInfoInRedis(usopRequestBaseQuery.getPersonUserInfoDTOV2().getCompId().toString());

        if(!StringUtil.isBlank(json)){

            FactoryInfosRespDTO factoryInfosRespDTO = BaseinfoCompanyFactory.jsonFactoryInfoToFactoryInfosRespDTO(json);
            context.setResultModule(factoryInfosRespDTO);
            return ;
        }


        if(StringUtil.isBlank(json)){
            CompanyInfoByCompIdQuery companyInfoByCompIdQuery =new CompanyInfoByCompIdQuery();
            companyInfoByCompIdQuery.setLongCompId(usopRequestBaseQuery.getPersonUserInfoDTOV2().getCompId());

            CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);

            if(companyModel==null){
                throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
            }


            context.setResultModule(companyModel.getFactoryInfosRespDTO());

        }
    }
}
