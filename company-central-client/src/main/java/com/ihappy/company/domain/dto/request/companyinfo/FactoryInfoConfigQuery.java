package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.common.domain.dto.BaseQuery;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;

/**
 * Created by renyueliang on 2018/8/10.
 */
public class FactoryInfoConfigQuery extends BaseQuery {


    private long compId;


    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    @Override
    public void validation() {

        if(compId<=0){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }

    }
}
