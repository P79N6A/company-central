package com.ihappy.company.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.domain.dbdo.CommonParam;
import com.ihappy.company.domain.model.model.CommonParamModel;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CommonParamFactory {
    public static CommonParamModel buildDefaultModel(String keyName) {
        Date date = new Date();
        CommonParam commonParam = new CommonParam();
        commonParam.setKeyName(keyName);
        commonParam.setCreatedAt(CompanyDateUtil.getDate14Long(date));
        commonParam.setUpdatedAt(CompanyDateUtil.getDate14Long(date));
        return new CommonParamModel(commonParam);
    }
}
