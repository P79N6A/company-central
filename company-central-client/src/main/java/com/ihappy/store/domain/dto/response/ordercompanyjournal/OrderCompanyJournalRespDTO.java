package com.ihappy.store.domain.dto.response.ordercompanyjournal;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/6/28.
 */
public class OrderCompanyJournalRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 4066170386522057494L;
    /**
     * 返回消息
     */
    @FieldComment(value = "返回消息",required = true)
    private String message;

    @FieldComment(value = "单据ID",required = true)
    private Long orderId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
