package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.role.domain.dbdo.sys.SysClient;

public class SysClientModel extends BaseModel<SysClient> {
    private SysClient sysClient;


    public SysClientModel() {
        super(null);
    }

    public SysClientModel(SysClient sysClient) {
        super(sysClient);
        this.sysClient = sysClient;
    }
}
