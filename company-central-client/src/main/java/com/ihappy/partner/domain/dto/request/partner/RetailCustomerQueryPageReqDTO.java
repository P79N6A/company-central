package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerQueryPageReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 6805209718943057483L;
    @FieldComment(value = "查询字符串", defaultValue = "", required = false)
    private String searchStr;
    @FieldComment(value = "是否过滤散客， true-是， false或者空-否 ", defaultValue = "", required = false)
    private Boolean filterIsDefault;
    @FieldComment(value = "是否过滤禁用的， true-是， false或者空-否 ", defaultValue = "", required = false)
    private Boolean filterIsForbid;

    public Boolean getFilterIsForbid() {
        return filterIsForbid;
    }

    public void setFilterIsForbid(Boolean filterIsForbid) {
        this.filterIsForbid = filterIsForbid;
    }

    public Boolean getFilterIsDefault() {
        return filterIsDefault;
    }

    public void setFilterIsDefault(Boolean filterIsDefault) {
        this.filterIsDefault = filterIsDefault;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginCompId() <= 0 || getLoginPersonId() == null || getLoginPersonId() <= 0) {
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        if (getLimit() == null)  {
            throw new CompanyException(CompanyErrorCodeEnum.PAGE_LIMIT_IS_NULL);
        }
        if (getOffset() == null ) {
            throw new CompanyException(CompanyErrorCodeEnum.OFFSET_IS_NULL);
        }
    }
}
