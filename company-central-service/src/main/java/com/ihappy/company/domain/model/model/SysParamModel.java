package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.company.common.util.RegexUtil;
import com.ihappy.company.domain.dbdo.sys.SysParam;

/**
 * Created by sunjd on 2018/12/4.
 */
public class SysParamModel extends BaseModel<SysParam> {
    private SysParam sysParam;

    public SysParamModel(SysParam doObject) {
        super(doObject);
        this.sysParam = doObject;
    }

    public boolean needUpdate(String version){
        if (RegexUtil.isVersion(version) && RegexUtil.isVersion(sysParam.getParamValue())){
            String[] versionArray = version.replaceAll("(\\.0)+$","").split("\\.");
            String[] curVersionArray = sysParam.getParamValue().replaceAll("(\\.0)+$","").split("\\.");
            int n = versionArray.length < curVersionArray.length ? versionArray.length : curVersionArray.length;
            for (int i = 0;i < n;i++){
                int curVersionNum = Integer.valueOf(curVersionArray[i]);
                int versionNum = Integer.valueOf(versionArray[i]);
                if (curVersionNum > versionNum){
                    return true;
                }else if (versionNum > curVersionNum){
                    return false;
                }
            }
            return curVersionArray.length > versionArray.length;
        }
        return false;
    }
}
