package com.ihappy.company.domain.bo;

import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/6/30.
 */
public class UpdateOrderCompanyJournalBO {

    /**
     * 订单ID
     */
    private Long orderId;

    private Integer version;

    /**
     * 付款流水号
     */
    private String sourceOrderNo;

    /**
     * 付款时间
     */
    private Long payTime;

    /**
     * 付款人账户
     */
    private String payPersonLogin;

    /**
     * 付款人
     */
    private String payPersonName;

    /**
     * 付款方式
     */
    private Integer payType;

    /**
     * 付款金额
     */
    private Long payMoney;

    /**
     * 生效企业id
     */
    private Long compId;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 购买内容
     */
    private String payContent;

    /**
     * 是否开发票
     */
    private Integer billFlag;

    /**
     * 发票抬头
     */
    private String payTitle;

    /**
     * 税号
     */
    private String taxNo;

    /**
     * 备注
     */
    private String memo;

    /**
     * 修改时间
     */
    private Long updatedAt;

    /**
     * 修改人
     */
    private Long updatedPersonId;

    /**
     *业务类型
     */
    private Integer ctId;

    /**
     *邀请人
     */
    private Long invitePersonId;

    /**
     *邀请人手机号
     */
    private String invitePersonMobile;

    /**
     * 备注人id
     */
    private Long memoPersonId;

    /**
     *备注人姓名
     */
    private String memoPersonName;

    /**
     *注册时间
     */
    private Long registerTime;

    /**
     *注册人id
     */
    private Long registerPersonId;

    /**
     *注册人手机号
     */
    private String registerPersonMobile;
    @FieldComment(value = "审核员id")
    private Long auditorId;
    @FieldComment(value = "审核员名称")
    private String auditorName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public String getPayPersonLogin() {
        return payPersonLogin;
    }

    public void setPayPersonLogin(String payPersonLogin) {
        this.payPersonLogin = payPersonLogin;
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

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Long getInvitePersonId() {
        return invitePersonId;
    }

    public void setInvitePersonId(Long invitePersonId) {
        this.invitePersonId = invitePersonId;
    }

    public String getInvitePersonMobile() {
        return invitePersonMobile;
    }

    public void setInvitePersonMobile(String invitePersonMobile) {
        this.invitePersonMobile = invitePersonMobile;
    }

    public Long getMemoPersonId() {
        return memoPersonId;
    }

    public void setMemoPersonId(Long memoPersonId) {
        this.memoPersonId = memoPersonId;
    }

    public String getMemoPersonName() {
        return memoPersonName;
    }

    public void setMemoPersonName(String memoPersonName) {
        this.memoPersonName = memoPersonName;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getRegisterPersonId() {
        return registerPersonId;
    }

    public void setRegisterPersonId(Long registerPersonId) {
        this.registerPersonId = registerPersonId;
    }

    public String getRegisterPersonMobile() {
        return registerPersonMobile;
    }

    public void setRegisterPersonMobile(String registerPersonMobile) {
        this.registerPersonMobile = registerPersonMobile;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }
}
