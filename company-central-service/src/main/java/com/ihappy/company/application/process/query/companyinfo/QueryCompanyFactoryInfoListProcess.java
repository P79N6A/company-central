package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.request.companyinfo.FactoryInfoConfigQuery;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfoRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;

import java.util.List;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class QueryCompanyFactoryInfoListProcess extends DefaultQueryProcess<FactoryInfoConfigQuery,List<FactoryInfoRespDTO>> {

    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<FactoryInfoConfigQuery, List<FactoryInfoRespDTO>> context) {


        FactoryInfoConfigQuery factoryInfoConfigQuery = context.getParam();

        String json =  CompanyRedisUtil.getFactoryInfoInRedis(factoryInfoConfigQuery.getCompId()+"");

        if(!StringUtil.isBlank(json)){

           List<FactoryInfoRespDTO> list = BaseinfoCompanyFactory.jsonToListFactoryInfoRespDTO(json);
           context.setResultModule(list);
           return ;
        }


        if(StringUtil.isBlank(json)){
            CompanyInfoByCompIdQuery companyInfoByCompIdQuery =new CompanyInfoByCompIdQuery();
            companyInfoByCompIdQuery.setLongCompId(factoryInfoConfigQuery.getCompId());

            CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);

            if(companyModel==null){
                throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
            }


            context.setResultModule(companyModel.getListFactoryInfoRespDTO());

        }

    }

    public void setCompanyInfoService(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }
}
