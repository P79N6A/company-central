package com.ihappy.store.domain.dto.response.store;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/8/27.
 */
public class StorePerformanceRespDTO implements Serializable {
    private static final long serialVersionUID = -6418739875243620988L;
    @FieldComment(value = "门店id",required = false,defaultValue = "10001")
    private Long storeId;
    @FieldComment(value = "门店名称",required = false,defaultValue = "门店名称")
    private String storeName;
    @FieldComment(value = "指标-分",required = false,defaultValue = "100000000")
    private Long aimAmount;
    @FieldComment(value = "达成额-分",required = false,defaultValue = "100000")
    private Long dueAmount;
    @FieldComment(value = "完成率",required = false,defaultValue = "133.28")
    private String rate;
    @FieldComment(value = "指标-圆",required = false,defaultValue = "100000")
    private String aimAmountY;
    @FieldComment(value = "达成额-圆",required = false,defaultValue = "1000")
    private String dueAmountY;
    @FieldComment(value = "门店头像")
    private String logoUrl;

    public StorePerformanceRespDTO(){

    }

    public StorePerformanceRespDTO(Integer type){
        if (Integer.valueOf(0).equals(type)){
            aimAmount = 0L;
            dueAmount = 0L;
            rate = "0";
            aimAmountY = "0.00";
            dueAmountY = "0.00";
        }
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

    public Long getAimAmount() {
        return aimAmount;
    }

    public void setAimAmount(Long aimAmount) {
        this.aimAmount = aimAmount;
    }

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAimAmountY() {
        return aimAmountY;
    }

    public void setAimAmountY(String aimAmountY) {
        this.aimAmountY = aimAmountY;
    }

    public String getDueAmountY() {
        return dueAmountY;
    }

    public void setDueAmountY(String dueAmountY) {
        this.dueAmountY = dueAmountY;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
