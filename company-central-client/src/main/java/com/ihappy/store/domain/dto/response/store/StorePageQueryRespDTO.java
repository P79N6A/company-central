package com.ihappy.store.domain.dto.response.store;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/10/16.
 */
public class StorePageQueryRespDTO implements Serializable {
    private static final long serialVersionUID = -1727067752808055656L;
    @FieldComment(value = "门店id")
    private Long storeId;
    @FieldComment(value = "门店名称")
    private String storeName;
    @FieldComment(value = "企业id")
    private Integer compId;
    @FieldComment(value = "企业名称")
    private String compShortName;
    @FieldComment(value = "企业业务类型")
    private String ctIds;
    @FieldComment(value = "企业业务类型名称")
    private String ctNames;
    @FieldComment(value = "老板电话")
    private String adminPersonMobile;
    @FieldComment(value = "注册时间字符串")
    private String registerDateStr;
    @FieldComment(value = "到期时间")
    private String expireDateStr;
    @FieldComment(value = "剩余有效日期")
    private String periodOfValidity;
    @FieldComment(value = "0:体验;1:付费-表示付过费了;")
    private Integer expireStatus;
    @FieldComment(value = "0黑名单 1普通 2白名单")
    private Integer status;
    @FieldComment(value = "付款备注者 姓名")
    private String payRemarkUserName;
    @FieldComment(value = "付款备注者 id")
    private Long payRemarkUserId;
    @FieldComment(value = "付款备注时间")
    private Long payRemarkTime;
    @FieldComment(value = "付款备注")
    private String payRemark;
    @FieldComment(value = "审核状态字符串")
    private String isVerifiedStr;
    @FieldComment(value = "付费状态字符串")
    private String expireStatusName;
    @FieldComment(value = "付款备注时间")
    private String payRemarkTimeStr;
    @FieldComment(value = "白名单状态字符串")
    private String statusName;
    @FieldComment(value = "更新时间")
    private String updatedAt;
    @FieldComment(value = "更新人名称")
    private String updatedPersonName;
    @FieldComment(value = "更新人id")
    private Long updatedPersonId;
    @FieldComment(value = "创建时间")
    private String createdAt;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public String getCtNames() {
        return ctNames;
    }

    public void setCtNames(String ctNames) {
        this.ctNames = ctNames;
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

    public Long getPayRemarkTime() {
        return payRemarkTime;
    }

    public void setPayRemarkTime(Long payRemarkTime) {
        this.payRemarkTime = payRemarkTime;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getIsVerifiedStr() {
        return isVerifiedStr;
    }

    public void setIsVerifiedStr(String isVerifiedStr) {
        this.isVerifiedStr = isVerifiedStr;
    }

    public String getExpireStatusName() {
        return expireStatusName;
    }

    public void setExpireStatusName(String expireStatusName) {
        this.expireStatusName = expireStatusName;
    }

    public String getPayRemarkTimeStr() {
        return payRemarkTimeStr;
    }

    public void setPayRemarkTimeStr(String payRemarkTimeStr) {
        this.payRemarkTimeStr = payRemarkTimeStr;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
