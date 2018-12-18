package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/4/1.
 * 客户信息
 */
public class CustomerInfoListQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -8319119425399822396L;
    @FieldComment(value = "伙伴ID",required = false,defaultValue = "10001")
    private Long partnerId;

    @FieldComment(value = "伙伴企业id",required = false,defaultValue = "10001")
    private Integer partnerCompId;

    @FieldComment(value = "0、供应商 1、客户",required = false,defaultValue = "0")
    private Integer partnerType;

    @FieldComment(value = "伙伴企业名",required = false,defaultValue = "海贝")
    private String partnerName;

    @FieldComment(value = "是否收藏  0：未收藏  1：已收藏",required = false,defaultValue = "0")
    private Integer isFavor;

    @FieldComment(value = "手机号",required = false,defaultValue = "18205463528")
    private String mobile;

    @FieldComment(value = "联系人",required = false,defaultValue = "10001")
    private String partnerLinkman;

    @FieldComment(value = "头像地址",required = false,defaultValue = "www.picture.com/1254")
    private String headPortraitAddress;

    @FieldComment(value = "电话",required = false,defaultValue = "0578-1254256")
    private String tel;

    @FieldComment(value = "最近往来时间戳",required = false,defaultValue = "20180824153200")
    private Long lastContactTime;

    @FieldComment(value = "最近往来时间  当天显示 HH:MM  24小时制  当天之前显示  X天前",required = false,defaultValue = "1天前")
    private String lastContactTimeShow;

    @FieldComment(value = "合伙人等级",required = false,defaultValue = "10001")
    private Long partnerLevelId;

    @FieldComment(value = "伙伴等级",required = false,defaultValue = "")
    private String partnerLevel;

    @FieldComment(value = "折扣率 1-99 整数",required = false,defaultValue = "10")
    private Integer discount;

    @FieldComment(value = "是否默认供应商  1-是默认，0-不是默认",required = false,defaultValue = "0")
    private Integer isDefault;

    @FieldComment(value = "预存款-分",required = false,defaultValue = "10000")
    private Long prepaidDeposit;

    @FieldComment(value = "预存款-圆",required = false,defaultValue = "100")
    private String prepaidDepositY;

    @FieldComment(value = "欠款-分",required = false,defaultValue = "10000")
    private Long partnerArrears;

    @FieldComment(value = "欠款-圆",required = false,defaultValue = "100")
    private String partnerArrearsY;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }

    public String getPartnerLevel() {
        return partnerLevel;
    }

    public void setPartnerLevel(String partnerLevel) {
        this.partnerLevel = partnerLevel;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getPartnerCompId() {
        return partnerCompId;
    }

    public void setPartnerCompId(Integer partnerCompId) {
        this.partnerCompId = partnerCompId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getIsFavor() {
        return isFavor;
    }

    public void setIsFavor(Integer isFavor) {
        this.isFavor = isFavor;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPartnerLinkman() {
        if(partnerType!=null && partnerType.intValue()==1){
            return partnerName;
        }

        return partnerLinkman;
    }

    public void setPartnerLinkman(String partnerLinkman) {
        this.partnerLinkman = partnerLinkman;
    }

    public String getHeadPortraitAddress() {
        return headPortraitAddress;
    }

    public void setHeadPortraitAddress(String headPortraitAddress) {
        this.headPortraitAddress = headPortraitAddress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getLastContactTime() {
        return lastContactTime;
    }

    public void setLastContactTime(Long lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    public String getLastContactTimeShow() {
        return lastContactTimeShow;
    }

    public void setLastContactTimeShow(String lastContactTimeShow) {
        this.lastContactTimeShow = lastContactTimeShow;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
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

    public Long getPartnerArrears() {
        return partnerArrears;
    }

    public void setPartnerArrears(Long partnerArrears) {
        this.partnerArrears = partnerArrears;
    }

    public String getPartnerArrearsY() {
        return partnerArrearsY;
    }

    public void setPartnerArrearsY(String partnerArrearsY) {
        this.partnerArrearsY = partnerArrearsY;
    }
}
