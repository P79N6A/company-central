package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/29.
 */
public class CompanyServiceStatusPageQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 8908622352585675026L;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 企业名称
     */
    private String compShortName;
    /**
     * 注册人手机号
     */
    private String adminPersonMobile;
    /**
     * 注册时间字符串
     */
    private String registerDateStr;
    /**
     * 到期时间
     */
    private String expireDateStr;
    /**
     * 剩余有效日期
     */
    private String periodOfValidity;
    /**
     * 备注
     */
    private String payRemark;
    /**
     * 备注者
     */
    private String payRemarkUserName;
    /**
     * 付款备注时间
     */
    private String payRemarkTimeStr;

    /**
     * 名称
     */
    private String expireStatusName;

    /**
     * 名称
     */
    private String statusName;


    private String updatedAt;

    private String updatedPersonName;

    private Long updatedPersonId;

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

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public String getAdminPersonMobile() {
        return adminPersonMobile;
    }

    public void setAdminPersonMobile(String adminPersonMobile) {
        this.adminPersonMobile = adminPersonMobile;
    }

    public String getRegisterDateStr() {
        return registerDateStr;
    }

    public void setRegisterDateStr(String registerDateStr) {
        this.registerDateStr = registerDateStr;
    }

    public String getExpireDateStr() {
        return expireDateStr;
    }

    public void setExpireDateStr(String expireDateStr) {
        this.expireDateStr = expireDateStr;
    }

    public String getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(String periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getPayRemarkUserName() {
        return payRemarkUserName;
    }

    public void setPayRemarkUserName(String payRemarkUserName) {
        this.payRemarkUserName = payRemarkUserName;
    }

    public String getPayRemarkTimeStr() {
        return payRemarkTimeStr;
    }

    public void setPayRemarkTimeStr(String payRemarkTimeStr) {
        this.payRemarkTimeStr = payRemarkTimeStr;
    }

    public String getExpireStatusName() {
        return expireStatusName;
    }

    public void setExpireStatusName(String expireStatusName) {
        this.expireStatusName = expireStatusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedPersonName() {
        return updatedPersonName;
    }

    public void setUpdatedPersonName(String updatedPersonName) {
        this.updatedPersonName = updatedPersonName;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
