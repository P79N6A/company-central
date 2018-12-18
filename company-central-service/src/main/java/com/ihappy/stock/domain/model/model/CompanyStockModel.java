package com.ihappy.stock.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;

/**
 * Created by sunjd on 2018/4/13.
 */
public class CompanyStockModel extends BaseModel<BaseinfoCompanyStock> {
    private BaseinfoCompanyStock baseinfoCompanyStock;

    public CompanyStockModel() {
        super(null);
    }

    public CompanyStockModel(BaseinfoCompanyStock baseinfoCompanyStock) {
        super(baseinfoCompanyStock);
    }
}
