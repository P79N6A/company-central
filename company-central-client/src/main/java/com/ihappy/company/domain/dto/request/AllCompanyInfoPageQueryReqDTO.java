package com.ihappy.company.domain.dto.request;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-05-30 14:48
 */
public class AllCompanyInfoPageQueryReqDTO extends ICallRequestBaseQuery {
    @FieldComment(value = "排序字段",required = false)
    private String sort;  // 排序字段
    private String order;  // 排序方式 升序或降序

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
