package com.ihappy.partner.domain.dto.response.level;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/26.
 */
public class PartnerLevelAddRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -4854166530856681205L;
    /**
     * 客户等级id
     */
    private Long partnerLevelId;

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }
}
