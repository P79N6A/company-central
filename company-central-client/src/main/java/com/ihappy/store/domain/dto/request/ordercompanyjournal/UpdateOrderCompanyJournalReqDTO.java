package com.ihappy.store.domain.dto.request.ordercompanyjournal;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by liuhc on 2018/6/30.
 */
public class UpdateOrderCompanyJournalReqDTO extends ICallRequestBaseDTO {

    private static final long serialVersionUID = 5525807837792241738L;

    @FieldComment(value = "单据ID",required = true)
    private Long orderId;

    @FieldComment(value = "版本号",required = true)
    private Integer version;

    /**
     * 付款流水号
     */
    @FieldComment(value = "付款流水号",required = true)
    private String sourceOrderNo;

    /**
     * 付款时间
     */
    @FieldComment(value = "付款时间",required = true)
    private String payTime;

    /**
     * 付款人账户
     */
    @FieldComment(value = "付款人账户",required = true)
    private String payPersonLogin;

    /**
     * 付款人
     */
    @FieldComment(value = "付款人",required = true)
    private String payPersonName;

    /**
     * 付款方式
     */
    @FieldComment(value = "付款方式",required = true)
    private Integer payType;

    /**
     * 付款金额
     */
    @FieldComment(value = "付款金额",required = true)
    private Long payMoney;

    /**
     * 生效企业id
     */
    @FieldComment(value = "生效企业id",required = true)
    private Long compId;

    /**
     * 生效企业门店ID
     */
    @FieldComment(value = "生效企业门店ID",required = true)
    private Long storeId;

    /**
     * 购买内容
     */
    @FieldComment(value = "购买内容",required = true)
    private String payContent;

    /**
     * 是否开发票
     */
    @FieldComment(value = "是否开发票",required = true)
    private Integer billFlag;

    /**
     * 发票抬头
     */
    @FieldComment(value = "发票抬头",required = true)
    private String payTitle;

    /**
     * 税号
     */
    @FieldComment(value = "税号",required = true)
    private String taxNo;

    /**
     * 备注
     */
    @FieldComment(value = "备注",required = true)
    private String memo;

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

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginPersonId() == null || getLoginCompId() == 0 || getLoginPersonId() <=0 ||
                orderId == null || orderId <=0L || version == null || storeId == null || storeId <= 0) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
