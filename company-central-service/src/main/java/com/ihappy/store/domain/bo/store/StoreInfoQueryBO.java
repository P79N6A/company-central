package com.ihappy.store.domain.bo.store;

import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/6/16.
 */
public class StoreInfoQueryBO {

    private Long compId;

    private Integer defaultFlag;

    @FieldComment(value = "注册开始时间")
    private Long registerStartTime;

    @FieldComment(value = "注册结束时间")
    private Long registerEndTime;

    @FieldComment(value = "企业查询字段，企业名称，企业id")
    private String compShortName;

    @FieldComment(value = "门店查询字段，门店名称，门店id")
    private  String storeName;

    @FieldComment(value = "门店id")
    private Long  storeId;

    @FieldComment(value = "老板手机号")
    private String bossMobile;

    @FieldComment(value = "业务类型 一批/二批的id")
    private String ctIds;

    @FieldComment(value = "过期时间")
    private Integer expireStatus;

    @FieldComment(value = "过期开始时间")
    private Long startValidTime;

    @FieldComment(value = "过期结束时间")
    private Long endValidTime;

    @FieldComment(value = "0黑名单 1普通 2白名单")
    private Integer status;

    @FieldComment(value = "分页条数")
    private Integer limit;

    @FieldComment(value = "分页偏移量")
    private Integer offset;

    @FieldComment(value = "备注者")
    private String payRemarkUserName;

    @FieldComment(value = "备注者id")
    private Long payRemarkUserId;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
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

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBossMobile() {
        return bossMobile;
    }

    public void setBossMobile(String bossMobile) {
        this.bossMobile = bossMobile;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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
}
