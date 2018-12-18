package com.ihappy.role.domain.model.model.sys;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.role.domain.dbdo.sys.SysFunc;

/**
 * Created by Administrator on 2018/6/16.
 */
public class SysFuncModel extends BaseModel<SysFunc> {

    private SysFunc sysFunc;

    public SysFuncModel(SysFunc doObject) {
        super(doObject);
        this.sysFunc = doObject;
    }
}
