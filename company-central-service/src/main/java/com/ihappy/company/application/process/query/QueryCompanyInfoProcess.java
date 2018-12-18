package com.ihappy.company.application.process.query;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoQueryRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/3/30.
 */
public class QueryCompanyInfoProcess extends DefaultQueryProcess<CompanyInfoQueryReqDTO,CompanyInfoQueryRespDTO> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<CompanyInfoQueryReqDTO, CompanyInfoQueryRespDTO> context) {
        CompanyInfoQueryReqDTO companyInfoQueryReqDTO = context.getParam();

        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(BaseinfoCompanyFactory.companyInfoQueryReqDTOBaseinfoCompany(companyInfoQueryReqDTO));
        CompanyInfoQueryRespDTO respDTO = BaseinfoCompanyFactory.modelTOCompanyInfoQueryRespDTO(baseinfoCompany);

        //填充公司业务分类名称
        respDTO.setCtNames(companyInfoService.getCtNamesByCtIds(respDTO.getCtIds()));

        //填充经营类目名称
        respDTO.setBusinessCategoryStr(companyInfoService.getBusinessCategoryStrByIds(respDTO.getBusinessCategory()));

        context.getResult().setModule(respDTO);
    }
}
