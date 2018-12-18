package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/4/1.
 */
public class ProviderInfoQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 3522430381040956438L;

    @FieldComment(value = "伙伴ID",required = false,defaultValue = "")
    private Long partnerId;

    @FieldComment(value = "伙伴企业id",required = false,defaultValue = "")
    private Integer partnerCompId;

    @FieldComment(value = "收藏状态 0、未收藏 1、已收藏",required = false,defaultValue = "")
    private Integer isFavor;

    @FieldComment(value = "企业id",required = false,defaultValue = "100")
    private Integer compId;

    @FieldComment(value = "企业名称",required = false,defaultValue = "海贝")
    private String compName;

    @FieldComment(value = "伙伴企业名",required = false,defaultValue = "")
    private String partnerName;

    @FieldComment(value = "类型 0、供应商 1、客户",required = false,defaultValue = "")
    private Integer partnerType;

    @FieldComment(value = "手机号",required = false,defaultValue = "18205425618")
    private String mobile;

    @FieldComment(value = "创建人ID",required = false,defaultValue = "")
    private Integer createdPersonId;

    @FieldComment(value = "联系人",required = false,defaultValue = "王大锤")
    private String partnerLinkman;

    @FieldComment(value = "省",required = false,defaultValue = "")
    private String province;

    @FieldComment(value = "市",required = false,defaultValue = "")
    private String city;

    @FieldComment(value = "区县",required = false,defaultValue = "")
    private String zone;

    @FieldComment(value = "详细地址",required = false,defaultValue = "")
    private String partnerAddress;

    @FieldComment(value = "开户银行",required = false,defaultValue = "")
    private String bankName;

    @FieldComment(value = "银行账户",required = false,defaultValue = "")
    private String bankAccountName;

    @FieldComment(value = "银行账号",required = false,defaultValue = "")
    private String bankAccountNumber;

    @FieldComment(value = "邮箱",required = false,defaultValue = "")
    private String mail;

    @FieldComment(value = "传真",required = false,defaultValue = "")
    private String fax;

    @FieldComment(value = "伙伴备注",required = false,defaultValue = "")
    private String partnerMemo;

    @FieldComment(value = "头像地址",required = false,defaultValue = "")
    private String headPortraitAddress;

    @FieldComment(value = "欠款-分",required = false,defaultValue = "10000")
    private Long partnerArrears;

    @FieldComment(value = "欠款-圆",required = false,defaultValue = "100")
    private String partnerArrearsY;

    @FieldComment(value = "电话",required = false,defaultValue = "")
    private String tel;

    @FieldComment(value = "合伙人等级",required = false,defaultValue = "12012")
    private Long partnerLevelId;

    @FieldComment(value = "伙伴等级",required = false,defaultValue = "VIP1")
    private String partnerLevel;

    @FieldComment(value = "折扣率",required = false,defaultValue = "100")
    private Integer discount;

    @FieldComment(value = "交易总额-分",required = false,defaultValue = "100000000")
    private Long dueAmount;

    @FieldComment(value = "交易总额-圆",required = false,defaultValue = "1000000")
    private String dueAmountY;

    @FieldComment(value = "待发货总数",required = false,defaultValue = "1000")
    private Long onthewayNumber;

    @FieldComment(value = "总交易件数",required = false,defaultValue = "10000")
    private Long totalNumber;

    @FieldComment(value = "交易单数",required = false,defaultValue = "100")
    private Long orderCount;

    @FieldComment(value = "最长欠款时间",required = false,defaultValue = "20180710162512")
    private Long debtDate;

    @FieldComment(value = "最长欠款天数",required = false,defaultValue = "30天")
    private String debtDay;

    @FieldComment(value = "预存款-分",required = false,defaultValue = "10000")
    private Long prepaidDeposit;

    @FieldComment(value = "预存款-圆",required = false,defaultValue = "100")
    private String prepaidDepositY;

    @FieldComment(value = "上次交易日期",required = false,defaultValue = "2018-08-10 17:30:22")
    private String lastContactDate;

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

    public Integer getIsFavor() {
        return isFavor;
    }

    public void setIsFavor(Integer isFavor) {
        this.isFavor = isFavor;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Integer createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public String getPartnerLinkman() {
        return partnerLinkman;
    }

    public void setPartnerLinkman(String partnerLinkman) {
        this.partnerLinkman = partnerLinkman;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getPartnerAddress() {
        return partnerAddress;
    }

    public void setPartnerAddress(String partnerAddress) {
        this.partnerAddress = partnerAddress;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPartnerMemo() {
        return partnerMemo;
    }

    public void setPartnerMemo(String partnerMemo) {
        this.partnerMemo = partnerMemo;
    }

    public String getHeadPortraitAddress() {
        return headPortraitAddress;
    }

    public void setHeadPortraitAddress(String headPortraitAddress) {
        this.headPortraitAddress = headPortraitAddress;
    }

    public Long getPartnerArrears() {
        return partnerArrears;
    }

    public void setPartnerArrears(Long partnerArrears) {
        this.partnerArrears = partnerArrears;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPartnerArrearsY() {
        return partnerArrearsY;
    }

    public void setPartnerArrearsY(String partnerArrearsY) {
        this.partnerArrearsY = partnerArrearsY;
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

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getDueAmountY() {
        return dueAmountY;
    }

    public void setDueAmountY(String dueAmountY) {
        this.dueAmountY = dueAmountY;
    }

    public Long getOnthewayNumber() {
        return onthewayNumber;
    }

    public void setOnthewayNumber(Long onthewayNumber) {
        this.onthewayNumber = onthewayNumber;
    }

    public Long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public Long getDebtDate() {
        return debtDate;
    }

    public void setDebtDate(Long debtDate) {
        this.debtDate = debtDate;
    }

    public String getDebtDay() {
        return debtDay;
    }

    public void setDebtDay(String debtDay) {
        this.debtDay = debtDay;
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

    public String getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(String lastContactDate) {
        this.lastContactDate = lastContactDate;
    }
}
