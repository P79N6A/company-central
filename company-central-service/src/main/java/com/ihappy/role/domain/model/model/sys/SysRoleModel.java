package com.ihappy.role.domain.model.model.sys;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.role.domain.dbdo.sys.SysRole;

/**
 * Created by sunjd on 2018/6/17.
 */
public class SysRoleModel extends BaseModel<SysRole> {
    private SysRole sysRole;


    public SysRoleModel(SysRole sysRole) {
        super(sysRole);
        this.sysRole = sysRole;
    }


    public String getRoleRights() {
        if (null == sysRole) {
            return null;
        }
        return sysRole.getRoleRights();
    }
}
