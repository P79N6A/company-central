package com.ihappy.store.domain.dto.request.ordercompanyjournal;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/7/8.
 */
public class PassOrFailReviewOrderCompanyJournalReqDTO extends ICallRequestBaseDTO {

    private static final long serialVersionUID = 5525807837792241738L;

    @FieldComment(value = "单据ID",required = true)
    private Long orderId;

    @FieldComment(value = "版本号",required = true)
    private Integer version;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginPersonId() == null || getLoginCompId() == 0 || getLoginPersonId() <=0 ||
                orderId == null || orderId <=0L || version == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
