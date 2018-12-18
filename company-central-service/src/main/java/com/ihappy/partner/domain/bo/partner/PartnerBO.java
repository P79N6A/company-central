package com.ihappy.partner.domain.bo.partner;

/**
 * Created by sunjd on 2018/8/9.
 */
public class PartnerBO {
    private Long totalPartnerNum;

    private Long dueAmount;

    private String dueAmountY;

    private Long partnerArrearsNum;

    private Long partnerArrears;

    private String partnerArrearsY;

    private Long onthewayPartnerNumber;

    private Long onthewayNumber;

    private Long prepaidDepositNum;

    private Long prepaidDeposit;

    private String prepaidDepositY;

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
