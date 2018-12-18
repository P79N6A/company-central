package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.bo.partner.QueryPartnerBO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerAddRespDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerUpdateRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zmd on 2018/11/1.
 */
public class UpdateRetailCustomerProcess extends DefaultProcess<RetailCustomerUpdateReqDTO, RetailCustomerUpdateRespDTO> {
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<RetailCustomerUpdateReqDTO, RetailCustomerUpdateRespDTO> context) {

        RetailCustomerUpdateReqDTO reqDTO = context.getParam();
        //根据公司id查询公司信息
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(reqDTO.getLoginCompId().intValue());
        companyInfoByCompIdQuery.setLoginPersonId(reqDTO.getLoginPersonId());
        CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
        if (companyModel == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }
        reqDTO.setCompName(companyModel.getCompName());
        Integer updateNum = companyPartnerService.updateRetailCustomer((BaseInfoCompanyPartnerFactory.retailCustomerUpdateReqDTOToModule(reqDTO)));
        if (updateNum != 1) {
            throw new CompanyException(PartnerErrorCodeEnum.
                    UPDATE_RETAIL_CUSTOMER_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.UPDATE_RETAIL_CUSTOMER_ERROR.getErrMsg());
        }
        context.getResult().setModule(new RetailCustomerUpdateRespDTO("修改成功"));
    }
}
