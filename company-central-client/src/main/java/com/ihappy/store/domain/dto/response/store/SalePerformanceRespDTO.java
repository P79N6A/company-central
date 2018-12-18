package com.ihappy.store.domain.dto.response.store;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/11/3.
 */
public class SalePerformanceRespDTO implements Serializable {
    private static final long serialVersionUID = -5349868165408596477L;
    @FieldComment(value = "业绩目标id 修改业绩时用")
    private Long salePerformanceId;
    @FieldComment(value = "公司id")
    private Long compId;
    @FieldComment(value = "门店id")
    private Long storeId;
    @FieldComment(value = "门店名称")
    private String storeName;
    @FieldComment(value = "用户id")
    private Long personId;
    @FieldComment(value = "用户名")
    private String personName;
    @FieldComment(value = "用户头像")
    private String avatar;
    @FieldComment(value = "业绩目标-分")
    private Long aimAmount;
    @FieldComment(value = "年月",defaultValue = "格式：20181103")
    private Integer yearonth;

    public Long getSalePerformanceId() {
        return salePerformanceId;
    }

    public void setSalePerformanceId(Long salePerformanceId) {
        this.salePerformanceId = salePerformanceId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getAimAmount() {
        return aimAmount;
    }

    public void setAimAmount(Long aimAmount) {
        this.aimAmount = aimAmount;
    }

    public Integer getYearonth() {
        return yearonth;
    }

    public void setYearonth(Integer yearonth) {
        this.yearonth = yearonth;
    }
}
