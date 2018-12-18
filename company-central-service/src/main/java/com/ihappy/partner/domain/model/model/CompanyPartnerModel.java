package com.ihappy.partner.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyPartnerModel extends BaseModel<BaseinfoCompanyPartner> {
    private BaseinfoCompanyPartner baseinfoCompanyPartner;


    public CompanyPartnerModel() {
        super(null);
    }

    public CompanyPartnerModel(BaseinfoCompanyPartner baseinfoCompanyPartner) {
        super(baseinfoCompanyPartner);
        this.baseinfoCompanyPartner=baseinfoCompanyPartner;
    }

    public boolean isRetailCustomer() {
        return this.getDO().getPartnerType() == CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey();
    }
}
