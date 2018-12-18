package com.ihappy.store.domain.bo.store;

import com.ihappy.store.domain.dto.response.store.StorePageQueryRespDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/16 9:37
 * *@content
 **/
public class StoreInfoBO {
    //公司字段
    @FieldComment(value = "公司名称")
    private String compShortName;
    @FieldComment(value = "老板手机号")
    private String adminPersonMobile;
    @FieldComment(value = "企业类型")
    private String ctIds;
    @FieldComment(value = "0黑名单  1普通 2白名单")
    private Integer status;

    //门店字段
    @FieldComment(value = "公司id")
    private Integer compId;
    @FieldComment(value = "门店id")
    private Long storeId;
    @FieldComment(value = "门店名称")
    private String storeName;
    @FieldComment(value = "创建时间")
    private Long createdAt;
    @FieldComment(value = "到期时间")
    private Long expireDate;
    @FieldComment(value = "0:体验;1:付费")
    private Integer expireStatus;
    @FieldComment(value = "付款备注者 姓名")
    private String payRemarkUserName;
    @FieldComment(value = "付款备注者 id")
    private Long payRemarkUserId;
    @FieldComment(value = "付款备注时间")
    private Long payRemarkTime;
    @FieldComment(value = "付款备注")
    private String payRemark;
    @FieldComment(value = "业务类型名称")
    private String ctNames;

    private Integer isDeleted;
    private Long updatedAt;
    private Long updatedPersonId;
    private Integer forbidden;

    public StorePageQueryRespDTO generateStorePageQueryRespDTO(){
        StorePageQueryRespDTO storePageQueryRespDTO = new StorePageQueryRespDTO();
        return storePageQueryRespDTO;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
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

    public String getCtNames() {
        return ctNames;
    }

    public void setCtNames(String ctNames) {
        this.ctNames = ctNames;
    }
}
