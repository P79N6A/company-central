package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.CompanyStatusReqDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/3/30.
 */
public class UpdateCompanyStatusProcess extends DefaultProcess<CompanyStatusReqDTO, String> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<CompanyStatusReqDTO, String> context) {
        CompanyStatusReqDTO companyStatusReqDTO = context.getParam();
        Integer res = baseinfoCompanyMapper.updateCompanyStatus(BaseinfoCompanyFactory.companyStatusReqDTOToModel(companyStatusReqDTO));
        if(res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_COMPANY_STATUS_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_COMPANY_STATUS_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}
