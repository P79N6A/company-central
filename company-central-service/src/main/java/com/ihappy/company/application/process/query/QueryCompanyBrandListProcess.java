package com.ihappy.company.application.process.query;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.dto.request.CompanyBrandListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandListQueryRespDTO;
import com.ihappy.company.domain.model.factory.CompanyBrandFactory;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import com.ihappy.company.infrastructure.service.inside.CompanyBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/3.
 */
public class QueryCompanyBrandListProcess extends DefaultQueryProcess<CompanyBrandListQueryReqDTO,List<CompanyBrandListQueryRespDTO>> {
    @Autowired
    private CompanyBrandService companyBrandService;

    @Override
    public void process(Context<CompanyBrandListQueryReqDTO, List<CompanyBrandListQueryRespDTO>> context) {
        CompanyBrandListQueryReqDTO companyBrandListQueryReqDTO = context.getParam();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("compId",companyBrandListQueryReqDTO.getCompId());
        if (companyBrandListQueryReqDTO.getBrandName() != null){
            map.put("brandName",companyBrandListQueryReqDTO.getBrandName());
        }
        if (companyBrandListQueryReqDTO.getFuzzyBrandName() != null){
            map.put("fuzzyBrandName",companyBrandListQueryReqDTO.getFuzzyBrandName());
        }
        List<CompanyBrandModel> companyBrandModels = companyBrandService.findCompanyBrandListByCompIdAndCondition(map);
        List<CompanyBrandListQueryRespDTO> companyBrandListQueryRespDTOs = CompanyBrandFactory.modelListToRespDTOList(companyBrandModels);
        context.getResult().setModule(companyBrandListQueryRespDTOs);
    }
}
