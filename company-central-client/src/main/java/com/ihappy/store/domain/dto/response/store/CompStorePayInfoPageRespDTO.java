package com.ihappy.store.domain.dto.response.store;

import com.konglong.dubbo.annotation.FieldComment;
import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by liuhc on 2018/10/18.
 */
public class CompStorePayInfoPageRespDTO extends ICallResponseBaseDTO {

    @FieldComment(value = "门店ID", required = true)
    private Long storeId;

    @FieldComment(value = "门店名称", required = true)
    private String storeName;

    @FieldComment(value = "支付金额", required = true)
    private String payMoneyY;

    @FieldComment(value = "单据编号", required = true)
    private String orderNo;

    @FieldComment(value = "支付类型 1:pos刷卡 2:现金 3微信 4支付宝", defaultValue = "" ,required = true)
    private Integer payType;

    @FieldComment(value = "门店ID", required = true)
    private String payTime;

    @FieldComment(value = "付款人姓名", required = true)
    private String payPersonName;

    @FieldComment(value = "门店图像", required = true)
    private String picture;

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

    public String getPayMoneyY() {
        return payMoneyY;
    }

    public void setPayMoneyY(String payMoneyY) {
        this.payMoneyY = payMoneyY;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayPersonName() {
        return payPersonName;
    }

    public void setPayPersonName(String payPersonName) {
        this.payPersonName = payPersonName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
