package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.domain.bo.PersonBO;
import com.ihappy.communal.infrastructure.service.outside.user.UserInfoOutSideService;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.partner.common.constans.PartnerConstants;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.PartnerInfoQueryReqDTO;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-12-7 上午10:28
 */
public class QueryShouldPartnerBeNotifiedProcess extends DefaultQueryProcess<PartnerInfoQueryReqDTO, Boolean> {
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Autowired
    private UserInfoOutSideService userInfoOutSideService;

    @Override
    public void process(Context<PartnerInfoQueryReqDTO, Boolean> context) {
        CompanyModel companyModel = getCompanyModel(context);
        CompanyPartnerModel partnerModel = getPartnerModel(context);
        if (partnerModel == null || StringUtils.isBlank(partnerModel.getDO().getMobile())
                || partnerModel.getDO().getIsDefault() == 1) {
            context.setResultModule(false);
            return;
        }
        // 允许打通开关打开才去根据手机号查询用户
        boolean shouldNotifyPartner
                = companyModel.getDO().getOrderSellerNotify() == 1
                && (partnerModel.getDO().getPartnerType() == CompanyPartnerTypeEnum.CUSTOMER.getKey()
                || partnerModel.getDO().getPartnerType() == CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey());
        shouldNotifyPartner = shouldNotifyPartner || (companyModel.getDO().getOrderBuyerNotify() == 1
                && partnerModel.getDO().getPartnerType() == CompanyPartnerTypeEnum.PROVIDER.getKey());
        if (!shouldNotifyPartner) {
            context.setResultModule(false);
            return;
        }

        PersonBO existUser = userInfoOutSideService.queryPersonInfoByMobile(partnerModel.getDO().getMobile());
        if (existUser == null) {
            context.setResultModule(false);
            return;
        }
        context.setResultModule(true);
    }

    private CompanyPartnerModel getPartnerModel(Context<PartnerInfoQueryReqDTO, Boolean> context) {
        BaseinfoCompanyPartner partnerQueryParam = new BaseinfoCompanyPartner();
        partnerQueryParam.setCompId(context.getParam().getLoginCompId().intValue());
        partnerQueryParam.setPartnerId(context.getParam().getPartnerId());
        return companyPartnerService.queryPartner(new CompanyPartnerModel(partnerQueryParam));
    }

    private CompanyModel getCompanyModel(Context<PartnerInfoQueryReqDTO, Boolean> context) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(context.getParam().getLoginCompId().intValue());
        return companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
    }
}
