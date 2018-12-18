package com.ihappy.company.domain.bo;

/**
 * Created by liuhc on 2018/7/19.
 */
public class BaseinfoCompanyBO {
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 企业名称(模糊查询)
     */
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    private Integer nature;
    /**
     * 公司业务分类id
     */
    private String ctIds;
    /**
     * 是否审核(0:待审核 1:审核通过 2:审核不通过)
     */
    private Integer isVerified;
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
     * 公司状态 0黑名单 1普通 2白名单
     */
    private Integer status;

    private Integer expireStatus;

    private Integer limit;

    private Integer offset;

    /**
     * 老板手机号
     */
    private String bossMobile;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 分页最大公司ID
     */
    private Integer maxCompId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
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

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
    }

    public String getBossMobile() {
        return bossMobile;
    }

    public void setBossMobile(String bossMobile) {
        this.bossMobile = bossMobile;
    }

    public Integer getMaxCompId() {
        return maxCompId;
    }

    public void setMaxCompId(Integer maxCompId) {
        this.maxCompId = maxCompId;
    }
}
