package com.ihappy.store.domain.dto.response.ordercompanyjournal;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by chenying on 2018/6/29.
 */
public class OrderCompanyJournalInfoRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -4137527615907575513L;

    @FieldComment(value = "单据ID",required = true)
    private Long orderId;

    @FieldComment(value = "付款流水号", required = true)
    private String orderNo;
    /**
     * 付款时间
     */
    @FieldComment(value = "付款流水号", required = true)
    private String payTime;
    /**
     * 付款人
     */
    @FieldComment(value = "付款流水号", required = true)
    private String payPersonName;
    /**
     * 付款方式
     * 1:pos刷卡 2:现金 3微信 4支付宝
     */
    @FieldComment(value = "付款流水号", defaultValue = "1:pos刷卡 2:现金 3微信 4支付宝" , required = true)
    private Integer payType;

    /**
     * 付款名称
     */
    @FieldComment(value = "付款名称", required = true)
    private String payTypeName;
    /**
     * 付款账户
     */
    @FieldComment(value = "付款账户", required = true)
    private String payPersonLogin;
    /**
     * 付款金额
     */
    @FieldComment(value = "付款金额", required = true)
    private Long payMoney;
    /**
     * 付款金额
     */
    @FieldComment(value = "付款金额", required = true)
    private String payMoneyY;
    /**
     * 生效企业
     */
    @FieldComment(value = "生效企业", required = true)
    private Long compId;
    /**
     * 公司名称
     */
    @FieldComment(value = "公司名称", required = true)
    private String companyName;
    /**
     * 生效企业门店Id
     */
    @FieldComment(value = "生效企业门店Id", required = true)
    private Long storeId;

    /**
     * 生效企业门店名称
     */
    @FieldComment(value = "生效门店名称", required = true)
    private String storeName;
    /**
     * 企业类型
     */
    @FieldComment(value = "企业类型", required = true)
    private Integer ctId;

    /**
     * 业务类型名称
     */
    @FieldComment(value = "业务类型名称", required = true)
    private String ctName;
    /**
     * 购买内容
     */
    @FieldComment(value = "购买内容", required = true)
    private String payContent;
    /**
     * 是否开票
     */
    @FieldComment(value = "是否开票", required = true)
    private Integer billFlag;

    /**
     * 开票抬头
     */
    @FieldComment(value = "开票抬头", required = true)
    private String payTitle;
    /**
     * 税号
     */
    @FieldComment(value = "税号", required = true)
    private String taxNo;
    /**
     * 邀请人账号
     */
    @FieldComment(value = "邀请人账号", required = true)
    private String invitePersonMobile;
    /**
     * 备注人id
     */
    @FieldComment(value = "备注人id", required = true)
    private Long momoPersonId;
    /**
     * 备注人名称
     */
    @FieldComment(value = "备注人名称", required = true)
    private String memoPersonName;
    /**
     * 更新时间
     */
    @FieldComment(value = "更新时间", required = true)
    private String updatedAt;
    /**
     * 备注
     */
    @FieldComment(value = "备注", required = true)
    private String memo;

    /**
     * 0:正常 1作废
     */
    @FieldComment(value = "付款流水号", defaultValue = "0:正常 1作废",required = true)
    private Integer cancelFlag;

    private Integer version;

    private String sourceOrderNo;
    /**
     *  审核人姓名
     */
    @FieldComment(value = "审核人姓名", required = false)
    private String auditorName;

    @FieldComment(value = "创建时间")
    private String createdAt;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayPersonLogin() {
        return payPersonLogin;
    }

    public void setPayPersonLogin(String payPersonLogin) {
        this.payPersonLogin = payPersonLogin;
    }

    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getPayContent() {
        return payContent;
    }

    public void setPayContent(String payContent) {
        this.payContent = payContent;
    }

    public Integer getBillFlag() {
        return billFlag;
    }

    public void setBillFlag(Integer billFlag) {
        this.billFlag = billFlag;
    }

    public String getPayTitle() {
        return payTitle;
    }

    public void setPayTitle(String payTitle) {
        this.payTitle = payTitle;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getInvitePersonMobile() {
        return invitePersonMobile;
    }

    public void setInvitePersonMobile(String invitePersonMobile) {
        this.invitePersonMobile = invitePersonMobile;
    }

    public Long getMomoPersonId() {
        return momoPersonId;
    }

    public void setMomoPersonId(Long momoPersonId) {
        this.momoPersonId = momoPersonId;
    }

    public String getMemoPersonName() {
        return memoPersonName;
    }

    public void setMemoPersonName(String memoPersonName) {
        this.memoPersonName = memoPersonName;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public Integer getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(Integer cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
