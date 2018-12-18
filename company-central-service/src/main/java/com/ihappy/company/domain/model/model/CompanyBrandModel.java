package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyBrand;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyBrandModel extends BaseModel<BaseinfoCompanyBrand> {
    public CompanyBrandModel() {
        super(null);
    }

    public CompanyBrandModel(BaseinfoCompanyBrand baseinfoCompanyBrand) {
        super(baseinfoCompanyBrand);
    }
}
