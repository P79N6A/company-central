package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/8/10.
 */
public class PartnerPageReqDTO extends UsopRequestBaseQuery {
    private static final long serialVersionUID = -3513413423981422993L;
    @FieldComment(value = "排序方式 空/asc:升序  desc:降序",required = true,defaultValue = "desc")
    private String sort;
    @FieldComment(value = "排序字段 交易金额：due_amount 欠款金额：partner_arrears 预存款金额：prepaid_deposit 代发货数：ontheway_number" ,required = true,defaultValue = "due_amount")
    private String order;
    @FieldComment(value = "Partner类型  0：供应商 1：客户 2：零售会员",required = true,defaultValue = "0")
    private Integer partnerType;
    @FieldComment(value = "查询字段",required = false,defaultValue = "")
    private String searchStr;

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

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    @Override
    public void validation() {
        if (getLimit() == null || getLimit() <= 0){
            setLimit(10);
        }
        if (getOffset() == null || getOffset() <= 0){
            setOffset(0);
        }
    }
}
