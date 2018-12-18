package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 9:54
 * *@content
 **/
public class CompanyInfoQueryReqDTO extends ICallRequestBaseQuery {
    @FieldComment(value = "公司id",defaultValue = "",required = false)
    private Integer compId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    @Override
    public void validation(){
        if (compId == null || compId <0){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
    }
}
