package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 5572107734851779437L;
    @FieldComment(value = "会员名称", defaultValue = "", required = false)
    private String partnerName;
    @FieldComment(value = "会员id", defaultValue = "", required = false)
    private Long partnerId;
    @FieldComment(value = "手机号", defaultValue = "", required = false)
    private String mobile;
    @FieldComment(value = "头像地址", defaultValue = "", required = false)
    private String headPortraitAddress;
    @FieldComment(value = "开卡导购员id", defaultValue = "", required = false)
    private Long shoppingGuideId;
    @FieldComment(value = "门店id", defaultValue = "", required = false)
    private Long storeId;
    @FieldComment(value = "微信号", defaultValue = "", required = false)
    private String wechatAccountName;
    @FieldComment(value = "门店名称",defaultValue = "",required = false)
    private String storeName;
    @FieldComment(value = "导购员名称",defaultValue = "",required = false)
    private String shoppingGuideName;
    @FieldComment(value = "消费次数",defaultValue = "",required = false)
    private Integer orderCount;
    @FieldComment(value = "消费件数",defaultValue = "",required = false)
    private Long totalNumber;
    @FieldComment(value = "消费金额元",defaultValue = "",required = false)
    private String dueAmountY;
    @FieldComment(value = "退款次数",defaultValue = "",required = false)
    private Integer sellerRefundTimes;
    @FieldComment(value = "连带率", defaultValue ="", required = false)
    private String associatedPurchaseRate;
    @FieldComment(value = "客单价", defaultValue = "", required = false)
    private String perTicketSales;
    @FieldComment(value = "件单价", defaultValue ="", required = false)
    private String unitPrice;
    @FieldComment(value = "最近消费时间", defaultValue ="", required = false)
    private String lastConsumeTime;
    @FieldComment(value = "预存款分")
    private Long prepaidDeposit;
    @FieldComment(value = "预存款元")
    private String prepaidDepositY;
    @FieldComment(value = "是否默认  0：否  1：是")
    private Integer isDefault;
    @FieldComment(value = "是否禁用 0未禁用 1禁用 默认0")
    private Integer forbidden;

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public String getPrepaidDepositY() {
        return prepaidDepositY;
    }

    public void setPrepaidDepositY(String prepaidDepositY) {
        this.prepaidDepositY = prepaidDepositY;
    }

    public Long getPrepaidDeposit() {
        return prepaidDeposit;
    }

    public void setPrepaidDeposit(Long prepaidDeposit) {
        this.prepaidDeposit = prepaidDeposit;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getDueAmountY() {
        return dueAmountY;
    }

    public void setDueAmountY(String dueAmountY) {
        this.dueAmountY = dueAmountY;
    }

    public Integer getSellerRefundTimes() {
        return sellerRefundTimes;
    }

    public void setSellerRefundTimes(Integer sellerRefundTimes) {
        this.sellerRefundTimes = sellerRefundTimes;
    }

    public String getAssociatedPurchaseRate() {
        return associatedPurchaseRate;
    }

    public void setAssociatedPurchaseRate(String associatedPurchaseRate) {
        this.associatedPurchaseRate = associatedPurchaseRate;
    }

    public String getPerTicketSales() {
        return perTicketSales;
    }

    public void setPerTicketSales(String perTicketSales) {
        this.perTicketSales = perTicketSales;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getLastConsumeTime() {
        return lastConsumeTime;
    }

    public void setLastConsumeTime(String lastConsumeTime) {
        this.lastConsumeTime = lastConsumeTime;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadPortraitAddress() {
        return headPortraitAddress;
    }

    public void setHeadPortraitAddress(String headPortraitAddress) {
        this.headPortraitAddress = headPortraitAddress;
    }

    public Long getShoppingGuideId() {
        return shoppingGuideId;
    }

    public void setShoppingGuideId(Long shoppingGuideId) {
        this.shoppingGuideId = shoppingGuideId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getShoppingGuideName() {
        return shoppingGuideName;
    }

    public void setShoppingGuideName(String shoppingGuideName) {
        this.shoppingGuideName = shoppingGuideName;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
