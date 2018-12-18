package com.ihappy.partner.domain.dto.response.level;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/5/3.
 */
public class PartnerLevelReferenceCountRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -6849981662461573573L;
    /**
     * 成功标志
     */
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
