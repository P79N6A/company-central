package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.domain.Page;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.domain.bo.CompanyInfoBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyServiceStatusPageQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyServiceStatusPageQueryRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/6/29.
 */
public class QueryCompanyServiceStatusPageProcess extends DefaultQueryProcess<CompanyServiceStatusPageQueryReqDTO,Page<CompanyServiceStatusPageQueryRespDTO>> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Override
    public void process(Context<CompanyServiceStatusPageQueryReqDTO, Page<CompanyServiceStatusPageQueryRespDTO>> context) {
        CompanyServiceStatusPageQueryReqDTO reqDTO = context.getParam();
        CompanyInfoBO bo = BaseinfoCompanyFactory.companyServiceStatusPageQueryReqDTOToBO(reqDTO);
        //企业管理新增管理范围字段
        if(reqDTO.getStartDay() != null){
            bo.setStartValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getStartDay(),0)));
        }
        if(reqDTO.getEndDay() != null){
            bo.setEndValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getEndDay(),1)));
        }
        int count = baseinfoCompanyMapper.selectCompanyServiceStatusCount(bo);

        List<BaseinfoCompany> companys = new ArrayList<>();
        if(count !=0 ){
            companys = baseinfoCompanyMapper.selectCompanyServiceStatus(bo);
        }
        List<CompanyServiceStatusPageQueryRespDTO> pageRespDTOList = BaseinfoCompanyFactory.companysToCompanyServiceStatusPageQueryRespDTOList(companys);

        Page<CompanyServiceStatusPageQueryRespDTO> pageRespDTOPage = new Page(1, 1, count, pageRespDTOList);
        context.setResultModule(pageRespDTOPage);
    }
}
