package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExpireStatusByCompIdQuery;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExpireStatusRespDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuhc on 2018/7/12.
 */
public class QueryCompInfoExpireStatueProcess extends DefaultQueryProcess<CompanyExpireStatusByCompIdQuery,CompanyExpireStatusRespDTO> {

    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<CompanyExpireStatusByCompIdQuery, CompanyExpireStatusRespDTO> context) {

        CompanyExpireStatusByCompIdQuery companyExpireStatusByCompIdQuery = context.getParam();

        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(companyExpireStatusByCompIdQuery.getCompId());

        CompanyModel companyModel =  companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);

        if (companyModel == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_NOT_EXIT.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT.getErrMsg());
        }

        CompanyExpireStatusRespDTO companyExpireStatusRespDTO = new  CompanyExpireStatusRespDTO();
        companyExpireStatusRespDTO.setCompId(companyModel.getCompId());
        if(!StringUtil.isBlank(companyModel.getDO().getCompShortName())){
            companyExpireStatusRespDTO.setCompName(companyModel.getDO().getCompShortName());
        }
        if(!StringUtil.isBlank(companyModel.getDO().getCompName())){
            companyExpireStatusRespDTO.setCompName(companyModel.getDO().getCompName());
        }
        companyExpireStatusRespDTO.setExpireStatus(companyModel.getExpireStatus());
        companyExpireStatusRespDTO.setMemo(companyModel.getDO().getMemo());
        companyExpireStatusRespDTO.setStatus(companyModel.getDO().getStatus());

        context.getResult().setModule(companyExpireStatusRespDTO);
    }
}
