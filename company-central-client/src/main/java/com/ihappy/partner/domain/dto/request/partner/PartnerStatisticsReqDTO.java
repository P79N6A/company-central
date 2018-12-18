package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.usop.client.dto.UsopRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/8/9.
 */
public class PartnerStatisticsReqDTO extends UsopRequestBaseDTO {
    private static final long serialVersionUID = 5772076226209282420L;
    @FieldComment(value = "Partner类型 0：供应商 1：客户 2：零售会员",required = true,defaultValue = "1")
    private Integer partnerType;
    @FieldComment(value = "查询字段",required = false,defaultValue = "")
    private String searchStr;

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
        if (partnerType == null){
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_TYPE_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_TYPE_IS_NULL.getErrMsg());
        }
    }
}
