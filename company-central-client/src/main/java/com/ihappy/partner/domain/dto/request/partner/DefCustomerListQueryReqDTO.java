package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/4/12.
 */
public class DefCustomerListQueryReqDTO extends UsopRequestBaseQuery {
    private static final long serialVersionUID = -3796353666045456952L;

    @FieldComment(value = "公司id  此字段已弃用",required = false,defaultValue = "78211")
    private Integer compId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    @Override
    public void validation() {
    }
}
