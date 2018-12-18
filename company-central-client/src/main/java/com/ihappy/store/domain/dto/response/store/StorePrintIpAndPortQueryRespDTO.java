package com.ihappy.store.domain.dto.response.store;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/5/16.
 */
public class StorePrintIpAndPortQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -7585487349197080214L;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 打印ip
     */
    private String printIp;
    /**
     * 打印端口
     */
    private String printPort;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPrintIp() {
        return printIp;
    }

    public void setPrintIp(String printIp) {
        this.printIp = printIp;
    }

    public String getPrintPort() {
        return printPort;
    }

    public void setPrintPort(String printPort) {
        this.printPort = printPort;
    }
}
