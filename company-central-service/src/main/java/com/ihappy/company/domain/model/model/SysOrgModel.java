package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.company.domain.dbdo.SysOrg;

/**
 * Created by liuhc on 2018/6/14.
 */
public class SysOrgModel extends BaseModel<SysOrg> {

    private SysOrg sysOrg;

    public SysOrgModel(SysOrg doObject) {
        super(doObject);
        this.sysOrg = doObject;
    }
}
