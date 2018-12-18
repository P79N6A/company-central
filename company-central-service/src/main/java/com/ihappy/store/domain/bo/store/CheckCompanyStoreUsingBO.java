package com.ihappy.store.domain.bo.store;

import com.ihappy.company.common.enumtype.CompanyWhiteBlackEnum;
import com.ihappy.company.common.enumtype.ExpireStatusEnum;

/**
 * @author gongwenqiang
 * @version V1.0.0
 * @date 2018/11/7 2:40 PM
 */
public class CheckCompanyStoreUsingBO {
    //门店创建时间
    private Long createdAt;
    //门店过期时间
    private Long expireDateLong;
    //门店付费状态
    private ExpireStatusEnum expireStatusEnum;
    //公司白名单状态
    private CompanyWhiteBlackEnum companyWhiteBlackEnum;

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getExpireDateLong() {
        return expireDateLong;
    }

    public void setExpireDateLong(Long expireDateLong) {
        this.expireDateLong = expireDateLong;
    }

    public ExpireStatusEnum getExpireStatusEnum() {
        return expireStatusEnum;
    }

    public void setExpireStatusEnum(ExpireStatusEnum expireStatusEnum) {
        this.expireStatusEnum = expireStatusEnum;
    }

    public CompanyWhiteBlackEnum getCompanyWhiteBlackEnum() {
        return companyWhiteBlackEnum;
    }

    public void setCompanyWhiteBlackEnum(CompanyWhiteBlackEnum companyWhiteBlackEnum) {
        this.companyWhiteBlackEnum = companyWhiteBlackEnum;
    }
}
