package com.ihappy.role.domain.model.model.sys;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.role.domain.dbdo.sys.SysCompanyFunc;

public class SysCompanyFuncModel extends BaseModel<SysCompanyFunc> {
    private SysCompanyFunc sysCompanyFunc;
    public SysCompanyFuncModel() {
        super(null);
    }

    public SysCompanyFuncModel(SysCompanyFunc sysCompanyFunc) {
        super(sysCompanyFunc);
        this.sysCompanyFunc=sysCompanyFunc;
    }

}
