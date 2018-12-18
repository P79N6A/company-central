package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyVerifiedHistory;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyVerifiedHistoryModel extends BaseModel<BaseinfoCompanyVerifiedHistory> {
    public CompanyVerifiedHistoryModel() {
        super(null);
    }

    public CompanyVerifiedHistoryModel(BaseinfoCompanyVerifiedHistory baseinfoCompanyVerifiedHistory) {
        super(baseinfoCompanyVerifiedHistory);
    }
}
