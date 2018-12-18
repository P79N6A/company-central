package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.partner.exception.PartnerException;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/10/31.
 */
public class PartnerListQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 3466038022249073535L;
    @FieldComment(value = "公司id",required = true,defaultValue = "")
    private Long compId;
    @FieldComment(value = "类型 0-供应商 1-客户 2-零售会员",required = false)
    private Integer partnerType;
    @FieldComment(value = "是否默认 0-非默认 1-默认")
    private Integer isDefault;
    @FieldComment(value = "是否删除 0-未删除 1-已删除",required = false,defaultValue = "false")
    private Integer isDeleted;

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public void validation() {
        if (compId == null) {
            if (getLoginCompId() != null){
                compId = getLoginCompId();
            }else {
                throw new PartnerException(CompanyErrorCodeEnum.
                        COMPANY_ID_IS_NULL.getErrCode(),
                        CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
            }
        }
    }
}
