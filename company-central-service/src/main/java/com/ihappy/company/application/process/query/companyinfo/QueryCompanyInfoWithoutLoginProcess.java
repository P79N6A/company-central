package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoWithoutLoginQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyInfoWithoutLoginQueryRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/7.
 */
public class QueryCompanyInfoWithoutLoginProcess extends DefaultQueryProcess<CompanyInfoWithoutLoginQueryReqDTO,CompanyInfoWithoutLoginQueryRespDTO> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<CompanyInfoWithoutLoginQueryReqDTO, CompanyInfoWithoutLoginQueryRespDTO> context) {
        CompanyInfoWithoutLoginQueryReqDTO reqDTO = context.getParam();
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(BaseinfoCompanyFactory.companyInfoWithoutLoginQueryReqDTOTOBaseinfoCompany(reqDTO));
        CompanyInfoWithoutLoginQueryRespDTO respDTO = new CompanyInfoWithoutLoginQueryRespDTO();
        respDTO.setCompShortName(baseinfoCompany.getCompShortName());
        respDTO.setCompId(baseinfoCompany.getCompId());
        context.getResult().setModule(respDTO);
    }
}
