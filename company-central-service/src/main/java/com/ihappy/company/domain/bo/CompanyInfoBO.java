package com.ihappy.company.domain.bo;

/**
 * Created by sunjd on 2018/6/29.
 */
public class CompanyInfoBO {
    /**
     * 注册开始时间
     */
    private Long registerStartTime;
    /**
     * 注册结束时间
     */
    private Long registerEndTime;
    /**
     * 公司账号
     */
    private String adminPersonMobile;
    /**
     * 剩余有效日期 起始值
     */
    private Long startValidTime;
    /**
     * 剩余有效日期 起始值
     */
    private Long endValidTime;
    /**
     * 备注者
     */
    private String payRemarkUserName;
    /**
     * 备注者id
     */
    private Long payRemarkUserId;
    /**
     * 公司业务类型  一批/二批
     */
    private String ctId;

    /**
     * 公司状态(1正常在线 0 停业下线
     */
    private Integer status;

    /**
     * 0:付费;1:永久
     */
    private Integer expireStatus;

    private Integer limit;
    private Integer offset;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Long getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(Long registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public Long getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(Long registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public String getAdminPersonMobile() {
        return adminPersonMobile;
    }

    public void setAdminPersonMobile(String adminPersonMobile) {
        this.adminPersonMobile = adminPersonMobile;
    }

    public Long getStartValidTime() {
        return startValidTime;
    }

    public void setStartValidTime(Long startValidTime) {
        this.startValidTime = startValidTime;
    }

    public Long getEndValidTime() {
        return endValidTime;
    }

    public void setEndValidTime(Long endValidTime) {
        this.endValidTime = endValidTime;
    }

    public String getPayRemarkUserName() {
        return payRemarkUserName;
    }

    public void setPayRemarkUserName(String payRemarkUserName) {
        this.payRemarkUserName = payRemarkUserName;
    }

    public Long getPayRemarkUserId() {
        return payRemarkUserId;
    }

    public void setPayRemarkUserId(Long payRemarkUserId) {
        this.payRemarkUserId = payRemarkUserId;
    }

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
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
}
