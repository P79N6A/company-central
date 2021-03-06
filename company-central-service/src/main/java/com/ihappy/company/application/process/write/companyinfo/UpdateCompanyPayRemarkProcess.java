package com.ihappy.company.application.process.write.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.CompanyInfoUpdateReqDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/6/29.
 */
public class UpdateCompanyPayRemarkProcess extends DefaultProcess<CompanyInfoUpdateReqDTO, String> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Override
    public void process(Context<CompanyInfoUpdateReqDTO, String> context) {
        CompanyInfoUpdateReqDTO reqDTO = context.getParam();
        BaseinfoCompany param = BaseinfoCompanyFactory.toPayRemark(reqDTO);
        Integer res = baseinfoCompanyMapper.updateCompanyInfo(param);
        if(res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_COMPANY_INFO_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_COMPANY_INFO_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}
