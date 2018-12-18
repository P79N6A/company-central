package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.RetailCustomerInfoEnableReqDTO;
import com.ihappy.partner.domain.dto.response.partner.RetailCustomerInfoEnableRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 17:41
 * *@content
 **/
public class EnableRetailCustomerInfoProcess extends DefaultProcess<RetailCustomerInfoEnableReqDTO, RetailCustomerInfoEnableRespDTO> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Override
    public void process(Context<RetailCustomerInfoEnableReqDTO, RetailCustomerInfoEnableRespDTO> context) {
        RetailCustomerInfoEnableReqDTO reqDTO = context.getParam();
        final long partnerId = reqDTO.getPartnerId();
        final long loginPersonId = reqDTO.getLoginPersonId();

        CompanyPartnerModel model = BaseInfoCompanyPartnerFactory.reqDTOToCompanyPartnerModel(reqDTO);
        CompanyPartnerModel companyPartnerModel = companyPartnerService.queryPartner(model);
        BaseinfoCompanyPartner retailCustomer = companyPartnerModel.getDO();
        if (null == retailCustomer) {
            throw new CompanyException(PartnerErrorCodeEnum.
                    RETAIL_CUSTOMER_IS_NOT_EXISIT.getErrCode(),
                    PartnerErrorCodeEnum.RETAIL_CUSTOMER_IS_NOT_EXISIT.getErrMsg());
        }
        RetailCustomerInfoEnableRespDTO retailCustomerInfoEnableRespDTO = new RetailCustomerInfoEnableRespDTO();
        //如果会员信息是禁用状态，启用会员
        if (retailCustomer.getForbidden() == 1){


            BaseinfoCompanyPartner baseInfoCompanyPartner = new BaseinfoCompanyPartner();
            baseInfoCompanyPartner.setPartnerId(partnerId);
            baseInfoCompanyPartner.setUpdatedPersonId(loginPersonId);
            baseInfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
            Integer res = baseinfoCompanyPartnerMapper.unforbidRetailCustomer(baseInfoCompanyPartner);
            if (res != 1) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        ENABLE_RETAIL_CUSTOMER.getErrCode(),
                        PartnerErrorCodeEnum.ENABLE_RETAIL_CUSTOMER.getErrMsg());
            }
            if (res == 1) {
                retailCustomerInfoEnableRespDTO.setMessage("启用成功");
            }
            context.getResult().setModule(retailCustomerInfoEnableRespDTO);
        }else{
            retailCustomerInfoEnableRespDTO.setMessage("已经启用");
            context.getResult().setModule(retailCustomerInfoEnableRespDTO);
        }
    }
}
