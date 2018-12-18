package com.ihappy.company.domain.model.model;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.company.domain.dbdo.SysCompanyType;
import com.ihappy.company.domain.dto.response.companytype.SysCompanyTypeInfoRespDTO;
import com.ihappy.company.domain.model.factory.SysCompanyTypeFactory;

/**
 * Created by liuhc on 2018/5/16.
 */
public class SysCompanyTypeModel extends BaseModel<SysCompanyType> {

    private SysCompanyType sysCompanyType;

    public SysCompanyTypeModel(SysCompanyType doObject) {
        super(doObject);
        sysCompanyType = doObject;
    }

    public SysCompanyTypeInfoRespDTO toSysCompanyTypeInfoRespDTO(){
        return SysCompanyTypeFactory.toSysCompanyTypeInfoRespDTO(sysCompanyType);
    }

}
