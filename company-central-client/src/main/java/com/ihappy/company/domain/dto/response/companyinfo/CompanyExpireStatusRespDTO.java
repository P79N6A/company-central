package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by liuhc on 2018/7/12.
 */
public class CompanyExpireStatusRespDTO extends ICallResponseBaseDTO {

    private static final long serialVersionUID = -4689856010064463843L;

    /**
     * 公司id
     */
    private Integer compId;

    /**
     * 公司名称
     */
    private String compName;

    /**
     * 公司状态(1正常在线 0 停业下线
     */
    private Integer status;

    /**
     * 0:付费;1:永久
     */
    private Integer expireStatus;

    /**
     * 备注
     */
    private String memo;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
