package com.ihappy.partner.domain.bo.partner;

/**
 * *@created by zhangmengdan
 * *@created at 2018/11/1 11:47
 * *@content
 **/
public class QueryPartnerBO {
    private Long userId;
    private String headPortraitAddress;
    private String partnerName;
    private Long storeId;
    private Long shoppingGuideId;
    private String wechatAccountName;
    private Long partnerId;
    private String mobile;
    private Integer partnerType;
    private String searchStr;
    private Integer compId;
    private Integer limit;
    private Integer offset;
    private Long createdAt;
    private Long createdPersonId;
    private Integer forbidden;
    private boolean filterIsDefault;
    private Integer isDefault;
    private Long updatedAt;
    private boolean filterIsForbid;

    public boolean isFilterIsForbid() {
        return filterIsForbid;
    }

    public void setFilterIsForbid(boolean filterIsForbid) {
        this.filterIsForbid = filterIsForbid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getHeadPortraitAddress() {
        return headPortraitAddress;
    }

    public void setHeadPortraitAddress(String headPortraitAddress) {
        this.headPortraitAddress = headPortraitAddress;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getShoppingGuideId() {
        return shoppingGuideId;
    }

    public void setShoppingGuideId(Long shoppingGuideId) {
        this.shoppingGuideId = shoppingGuideId;
    }

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
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

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public boolean isFilterIsDefault() {
        return filterIsDefault;
    }

    public void setFilterIsDefault(boolean filterIsDefault) {
        this.filterIsDefault = filterIsDefault;
    }
}
