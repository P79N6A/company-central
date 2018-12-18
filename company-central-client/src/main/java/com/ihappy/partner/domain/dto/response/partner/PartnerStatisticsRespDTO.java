package com.ihappy.partner.domain.dto.response.partner;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/8/9.
 */
public class PartnerStatisticsRespDTO implements Serializable {
    private static final long serialVersionUID = -4672837680087253290L;

    @FieldComment(value = "Partner总数",required = false,defaultValue = "100")
    private Long totalPartnerNum;

    @FieldComment(value = "交易总额-分",required = false,defaultValue = "100")
    private Long dueAmount;

    @FieldComment(value = "交易总额-圆",required = false,defaultValue = "1.00")
    private String dueAmountY;

    @FieldComment(value = "欠款Partner数",required = false,defaultValue = "100")
    private Long partnerArrearsNum;

    @FieldComment(value = "欠款总额-分",required = false,defaultValue = "100")
    private Long partnerArrears;

    @FieldComment(value = "欠款总额-圆",required = false,defaultValue = "100")
    private String partnerArrearsY;

    @FieldComment(value = "代发货供应商",required = false,defaultValue = "100")
    private Long onthewayPartnerNumber;

    @FieldComment(value = "待发货总数",required = false,defaultValue = "100")
    private Long onthewayNumber;

    @FieldComment(value = "预存款Partner数",required = false,defaultValue = "100")
    private Long prepaidDepositNum;

    @FieldComment(value = "预存款-分",required = false,defaultValue = "100")
    private Long prepaidDeposit;

    @FieldComment(value = "预存款-圆",required = false,defaultValue = "1.00")
    private String prepaidDepositY;

    @FieldComment(value = "交易件数")
    private Long totalNumber;

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


    public Long getOnthewayPartnerNumber() {
        return onthewayPartnerNumber;
    }

    public void setOnthewayPartnerNumber(Long onthewayPartnerNumber) {
        this.onthewayPartnerNumber = onthewayPartnerNumber;
    }

    public Long getTotalPartnerNum() {
        return totalPartnerNum;
    }

    public void setTotalPartnerNum(Long totalPartnerNum) {
        this.totalPartnerNum = totalPartnerNum;
    }

    public Long getPartnerArrearsNum() {
        return partnerArrearsNum;
    }

    public void setPartnerArrearsNum(Long partnerArrearsNum) {
        this.partnerArrearsNum = partnerArrearsNum;
    }

    public Long getPrepaidDepositNum() {
        return prepaidDepositNum;
    }

    public void setPrepaidDepositNum(Long prepaidDepositNum) {
        this.prepaidDepositNum = prepaidDepositNum;
    }

    public Long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }
}
