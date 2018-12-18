package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.CompanyInfoUpdateReqDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/8.
 */
public class UpdateCompanyInfoRpcProcess extends DefaultProcess<CompanyInfoUpdateReqDTO, String> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<CompanyInfoUpdateReqDTO, String> context) {
        CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO = context.getParam();
        //查询公司是否重名
        /*List<BaseinfoCompany> baseinfoCompanys = baseinfoCompanyMapper.selectByCompName(companyModel.getDO().getCompName());
        if(baseinfoCompanys != null && baseinfoCompanys.size() > 0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_NAME_REPEAT.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_NAME_REPEAT.getErrMsg());
        }*/
        Integer res = baseinfoCompanyMapper.updateCompanyInfo(BaseinfoCompanyFactory.companyInfoUpdateReqDTORpcTOModel(companyInfoUpdateReqDTO));
        if(res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_COMPANY_INFO_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_COMPANY_INFO_ERROR.getErrMsg());
        }
    }
}
