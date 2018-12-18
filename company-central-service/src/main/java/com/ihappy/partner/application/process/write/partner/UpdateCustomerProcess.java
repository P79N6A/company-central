package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dto.request.partner.CustomerInfoUpdateReqDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/3.
 */
public class UpdateCustomerProcess extends DefaultProcess<CustomerInfoUpdateReqDTO, String> {
    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Override
    public void process(Context<CustomerInfoUpdateReqDTO, String> context) {
        CustomerInfoUpdateReqDTO customerInfoUpdateReqDTO = context.getParam();
        CompanyPartnerModel model = BaseInfoCompanyPartnerFactory.customerInfoUpdateReqDTOToModel(customerInfoUpdateReqDTO);
        Integer res = companyPartnerService.updateProvider(model.getDO());
        if(res != 1){
            throw new CompanyException(PartnerErrorCodeEnum.
                    UPDATE_COMPANY_CUSTOMER_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.UPDATE_COMPANY_CUSTOMER_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}
