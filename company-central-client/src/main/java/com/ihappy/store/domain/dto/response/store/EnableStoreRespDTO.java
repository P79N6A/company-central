package com.ihappy.store.domain.dto.response.store;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/16 13:05
 * *@content
 **/
public class EnableStoreRespDTO extends ICallResponseBaseDTO {
    /**
     * 返回信息
     */
    @FieldComment(value = "返回信息")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
