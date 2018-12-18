package com.ihappy.partner.domain.dto.request.level;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.common.enumtype.partner.PartnerLevelEnum;

import java.util.Date;
import java.util.List;

/**
 * Created by sunjd on 2018/5/3.
 */
public class PartnerLevelReferenceCountReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -8040378101002240857L;
    /**
     * 会员等级id列表
     */
    private List<Long> partnerLevelIds;
    /**
     * 操作
     * 1.引用计数+1  -1.引用计数-1
     */
    private Integer operation;

    public List<Long> getPartnerLevelIds() {
        return partnerLevelIds;
    }

    public void setPartnerLevelIds(List<Long> partnerLevelIds) {
        this.partnerLevelIds = partnerLevelIds;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    @Override
    public void validation() {
        if (partnerLevelIds == null || partnerLevelIds.size() == 0) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_LEVEL_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_LEVEL_ID_IS_NULL.getErrMsg());
        }
        if (PartnerLevelEnum.getEnum(operation) == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_OPERATION_ILLEGALITY.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_OPERATION_ILLEGALITY.getErrMsg());
        }
        setUpdateTime(new Date());
    }
}
