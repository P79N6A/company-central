package com.ihappy.store.domain.dto.request.store;

import com.ihappy.store.exception.StoreException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;

import java.util.Date;

/**
 * Created by sunjd on 2018/5/16.
 */
public class StorePrintIpAndPortUpdateReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 7384115919345402441L;

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
    /**
     * 企业id
     */
    private Long compId;

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

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    @Override
    public void validation() {
        if (storeId == null || storeId <= 0) {
            throw new StoreException(StoreErrorCodeEnum.
                    STORE_ID_IS_ILLEGAL.getErrCode(),
                    StoreErrorCodeEnum.STORE_ID_IS_ILLEGAL.getErrMsg());
        }
        if (compId == null || compId <= 0) {
            throw new StoreException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_ILLEGAL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_ILLEGAL.getErrMsg());
        }
        if (printPort == null && printIp == null){
            throw new StoreException(CompanyErrorCodeEnum.
                    PRINTPORT_OR_PRINTIP_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.PRINTPORT_OR_PRINTIP_IS_NULL.getErrMsg());
        }
        this.setUpdateTime(new Date());
    }
}
