package com.ihappy.company.application.process.query;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.domain.Page;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.domain.bo.BaseinfoCompanyBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.BaseinfoCompanyReqDTO;
import com.ihappy.company.domain.dto.response.BaseinfoCompanyRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.yx.eweb.util.DateUtil;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/3/29.
 */
public class QueryCompanyListProcess extends DefaultQueryProcess<BaseinfoCompanyReqDTO,Page<BaseinfoCompanyRespDTO>> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<BaseinfoCompanyReqDTO, Page<BaseinfoCompanyRespDTO>> context) {
        BaseinfoCompanyReqDTO reqDTO = context.getParam();

        BaseinfoCompanyBO companyBO = BaseinfoCompanyFactory.toBaseinfoCompanyBO(reqDTO);
        //企业管理新增管理范围字段
        if(reqDTO.getStartDay() != null){
            companyBO.setStartValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getStartDay(),0)));
        }
        if(reqDTO.getEndDay() != null){
            companyBO.setEndValidTime(CompanyDateUtil.getDate14Long(CompanyDateUtil.addDays(new Date(), reqDTO.getEndDay(),1)));
        }
        if(!StringUtil.isBlank(reqDTO.getRegisterStartTime())){
            companyBO.setRegisterStartTime(CompanyDateUtil.getDate14Long(DateUtil.parse(reqDTO.getRegisterStartTime())));
        }
        if(!StringUtil.isBlank(reqDTO.getRegisterEndTime())){
            companyBO.setRegisterEndTime(CompanyDateUtil.getDate14Long(DateUtil.parse(reqDTO.getRegisterEndTime())));
        }
        List<BaseinfoCompany> list = new ArrayList<>();
        Integer total = baseinfoCompanyMapper.selectByBaseinfoCompanyReqDTOCount(companyBO);
        if(total != 0){
            list = baseinfoCompanyMapper.selectByBaseinfoCompanyReqDTO(companyBO);
        }
        Page<BaseinfoCompanyRespDTO> resPage = new Page(1, 1, total, BaseinfoCompanyFactory.modelListToRespDTOList(list));
        context.getResult().setModule(resPage);
    }
}
