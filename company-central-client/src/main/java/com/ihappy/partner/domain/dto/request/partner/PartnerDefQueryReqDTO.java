package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.usop.client.dto.UsopRequestBaseDTO;
import com.ihappy.usop.client.dto.UsopRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/8/23.
 */
public class PartnerDefQueryReqDTO extends UsopRequestBaseDTO {
    @FieldComment(value = "Partner 类型 0：供应商 1：客户 2：零售会员",required = true,defaultValue = "1")
    private Integer partnerType;
    @FieldComment(value = "查询标识 1：隐去欠款和预存款",required = false,defaultValue = "")
    private Integer type;

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean hideDebtAndPrepaidDeposit(){
        return Integer.valueOf(1).equals(type);
    }

    @Override
    public void validation() {
        if (partnerType == null){
            partnerType = 1;
        }
    }
}
