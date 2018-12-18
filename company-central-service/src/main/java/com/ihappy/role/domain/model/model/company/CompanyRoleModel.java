package com.ihappy.role.domain.model.model.company;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.role.domain.dbdo.company.BaseinfoCompanyRole;

/**
 * Created by sunjd on 2018/3/31.
 */
public class CompanyRoleModel extends BaseModel<BaseinfoCompanyRole> {
    private BaseinfoCompanyRole baseinfoCompanyRole;

    public CompanyRoleModel() {
        super(null);
    }

    public CompanyRoleModel(BaseinfoCompanyRole baseinfoCompanyRole) {
        super(baseinfoCompanyRole);
        this.baseinfoCompanyRole=baseinfoCompanyRole;
    }

}
