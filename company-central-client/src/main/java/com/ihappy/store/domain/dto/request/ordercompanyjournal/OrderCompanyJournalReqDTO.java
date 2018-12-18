package com.ihappy.store.domain.dto.request.ordercompanyjournal;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by liuhc on 2018/6/28.
 */
public class OrderCompanyJournalReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 5525807837792241738L;

    @FieldComment(value = "付款流水号", required = true)
    private String sourceOrderNo;

    @FieldComment(value = "付款时间", required = true)
    private String payTime;

    @FieldComment(value = "付款人账户", required = true)
    private String payPersonLogin;

    @FieldComment(value = "付款人", required = true)
    private String payPersonName;

    /**
     * 付款方式
     */
    @FieldComment(value = "付款方式 1:pos刷卡 2:现金 3微信 4支付宝", required = true)
    private Integer payType;

    /**
     * 付款金额
     */
    @FieldComment(value = "付款金额", required = true)
    private Long payMoney;

    /**
     * 生效企业id
     */
    @FieldComment(value = "生效企业id", required = true)
    private Long compId;

    @FieldComment(value = "生效企业门店id", required = true)
    private Long storeId;
    /**
     * 购买内容
     */
    @FieldComment(value = "购买内容", required = true)
    private String payContent;

    /**
     * 是否开发票
     */
    @FieldComment(value = "是否开发票", required = true)
    private Integer billFlag;

    /**
     * 发票抬头
     */
    @FieldComment(value = "发票抬头", required = false)
    private String payTitle;

    /**
     * 税号
     */
    @FieldComment(value = "税号", required = false)
    private String taxNo;

    /**
     * 备注
     */
    @FieldComment(value = "备注", required = false)
    private String memo;

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

    public Integer getBillFlag() {
        return billFlag;
    }

    public void setBillFlag(Integer billFlag) {
        this.billFlag = billFlag;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public void validation() {
        if (compId == null || storeId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
