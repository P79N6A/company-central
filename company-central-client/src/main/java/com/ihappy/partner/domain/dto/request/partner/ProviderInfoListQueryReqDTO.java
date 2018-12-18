package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/3/31.
 * 查询伙伴企业
 */
public class ProviderInfoListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -8177007451499066630L;

    @FieldComment(value = "查询字符串",required = false,defaultValue = "")
    private String searchStr;

    @FieldComment(value = "查询字符串是否加粗  true 加粗 false /null 不加粗",required = false,defaultValue = "false")
    private Boolean overstriking;

    @FieldComment(value = "是否默认供应商  1-是默认，0-不是默认  null-所有",required = false,defaultValue = "")
    private Integer isDefault;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public Boolean getOverstriking() {
        return overstriking;
    }

    public void setOverstriking(Boolean overstriking) {
        this.overstriking = overstriking;
    }

    @Override
    public void validation() {
    }
}
