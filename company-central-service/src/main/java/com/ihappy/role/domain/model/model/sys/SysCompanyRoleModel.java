package com.ihappy.role.domain.model.model.sys;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.role.domain.dbdo.sys.SysCompanyRole;

/**
 * Created by sunjd on 2018/4/4.
 */
public class SysCompanyRoleModel extends BaseModel<SysCompanyRole> {
    private SysCompanyRole sysCompanyRole;

    public SysCompanyRoleModel() {
        super(null);
    }

    public SysCompanyRoleModel(SysCompanyRole sysCompanyRole) {
        super(sysCompanyRole);
        this.sysCompanyRole=sysCompanyRole;
    }

    public String getRoleRights(){
        if (null == sysCompanyRole){
            return null;
        }
        return sysCompanyRole.getRoleRights();
    }
}
