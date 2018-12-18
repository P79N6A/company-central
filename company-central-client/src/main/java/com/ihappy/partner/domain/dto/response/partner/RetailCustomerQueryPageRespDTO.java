package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerQueryPageRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 1321225487118658300L;
    @FieldComment(value = "会员名称", defaultValue = "", required = false)
    private String partnerName;
    @FieldComment(value = "手机号", defaultValue = "", required = true)
    private String mobile;
    @FieldComment(value = "头像地址", defaultValue = "", required = false)
    private String headPortraitAddress;
    @FieldComment(value = "门店名称", defaultValue = "", required = false)
    private String storeName;
    @FieldComment(value = "门店id", defaultValue = "", required = false)
    private Long storeId;
    @FieldComment(value = "是否禁用：0.未禁用 1禁用")
    private Integer forbidden;
    @FieldComment(value = "会员id")
    private Long partnerId;
    @FieldComment(value = "预存款分")
    private Long prepaidDeposit;
    @FieldComment(value = "预存款元")
    private String prepaidDepositY;
    @FieldComment(value = "是否是散客：1-是，0-不是")
    private Integer isDefault;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
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

    public String getStoreName() {
        return storeName;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getPrepaidDeposit() {
        return prepaidDeposit;
    }

    public void setPrepaidDeposit(Long prepaidDeposit) {
        this.prepaidDeposit = prepaidDeposit;
    }

    public String getPrepaidDepositY() {
        return prepaidDepositY;
    }

    public void setPrepaidDepositY(String prepaidDepositY) {
        this.prepaidDepositY = prepaidDepositY;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
