package com.ihappy.company.domain.bo.trade;

import com.ihappy.common.util.DateUtil;
import com.ihappy.partner.common.constans.PartnerConstants;
import com.ihappy.partner.common.enumtype.partner.PartnerArrearsOperateTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoPartnerArrearsOrder;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;
import com.ihappy.trade.common.constants.OrderConstant;
import com.ihappy.trade.common.constants.PayConstants;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-27 下午5:07
 */
public class PayJournalBO {
    /**
     * 主流水id
     */
    private Long mainPayJournalId;
    /**
     * 流水id
     */
    private Long payJournalId;
    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 支付金额
     */
    private Long payAmount;
    /**
     * 公司id
     */
    private Long compId;
    /**
     * 客户或供应商id
     */
    private Long partnerId;
    /**
     * 收入类型 1:收入 2:支出
     */
    private Integer fundType;
    /**
     * 订单No
     */
    private String orderNo;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 创建人ID
     */
    private Long createdPersonId;
    /**
     * 更新人ID
     */
    private Long updatedPersonId;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
    }

    public Long getMainPayJournalId() {
        return mainPayJournalId;
    }

    public void setMainPayJournalId(Long mainPayJournalId) {
        this.mainPayJournalId = mainPayJournalId;
    }

    public Long getPayJournalId() {
        return payJournalId;
    }

    public void setPayJournalId(Long payJournalId) {
        this.payJournalId = payJournalId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getIncomeType() {
        if (OrderConstant.ORDER_SELLER_TYPES.contains(orderType) || OrderConstant.ORDER_RETAIL_REFUND == orderType) {
            // 销售单
            // 收入预存款,相当于客户预存款减少,或者支出欠款,相当于客户欠款减少
            if (getFundType().equals(PayConstants.FUND_INCOME) && getPayType().equals(PayConstants.PRE_PAID)
                    || getFundType().equals(PayConstants.FUND_PAYOUT) && getPayType().equals(PayConstants.DEBT_PAID)) {
                return PartnerConstants.INCOME_TYPE_DECREASE;
            }
            // 收入欠款,相当于客户欠款增加, 支出预存款,相当于客户预存款增加
            if (getFundType().equals(PayConstants.FUND_INCOME) && getPayType().equals(PayConstants.DEBT_PAID)
                    || getFundType().equals(PayConstants.FUND_PAYOUT) && getPayType().equals(PayConstants.PRE_PAID)) {
                return PartnerConstants.INCOME_TYPE_INCREASE;
            }
        } else if (OrderConstant.ORDER_BUYER_ALL_TYPES.contains(orderType)) {
            // 采购单/采购退货单
            // 收入预存款, 供应商预存款增加; 支出欠款, 供应商欠款增加
            if (PayConstants.FUND_INCOME == getFundType() && PayConstants.PRE_PAID == getPayType()
                    || PayConstants.FUND_PAYOUT == getFundType() && PayConstants.DEBT_PAID == getPayType()) {
                return PartnerConstants.INCOME_TYPE_INCREASE;
            }
            // 支出预存款, 供应商预存款减少; 收入欠款, 供应商欠款减少
            if (PayConstants.FUND_PAYOUT == getFundType() && PayConstants.PRE_PAID == getPayType()
                    || PayConstants.FUND_INCOME == getFundType() && PayConstants.DEBT_PAID == getPayType()) {
                return PartnerConstants.INCOME_TYPE_DECREASE;
            }
        }
        return null;
    }

    public BaseinfoPartnerArrearsOrder acquireArrearsQueryParam() {
        BaseinfoPartnerArrearsOrder baseinfoPartnerArrearsOrder = new BaseinfoPartnerArrearsOrder();
        baseinfoPartnerArrearsOrder.setOrderNum(getMainPayJournalId().toString());
        baseinfoPartnerArrearsOrder.setIncomeType(getIncomeType());
        baseinfoPartnerArrearsOrder.setType(payType2ArrearsType());
        return baseinfoPartnerArrearsOrder;
    }

    public PartnerArrearsOrderModel acquireInsertPartnerArrearsOrderModel() {
        BaseinfoPartnerArrearsOrder partnerArrearsOrder = new BaseinfoPartnerArrearsOrder();
        partnerArrearsOrder.setType(payType2ArrearsType());
        partnerArrearsOrder.setOrderNo(getOrderNo());
        partnerArrearsOrder.setOrderType(getOrderType().toString());
        partnerArrearsOrder.setOrderNum(getMainPayJournalId().toString());
        partnerArrearsOrder.setPartnerId(getPartnerId());
        partnerArrearsOrder.setCompId(getCompId().intValue());
        partnerArrearsOrder.setMoney(getPayAmount());
        partnerArrearsOrder.setSourceType(0);
        partnerArrearsOrder.setIncomeType(getIncomeType());
        partnerArrearsOrder.setCreatedAt(DateUtil.getCurrentDate());
        partnerArrearsOrder.setUpdatedAt(DateUtil.getCurrentDate());
        partnerArrearsOrder.setIsDeleted(false);
        partnerArrearsOrder.setCreatedPersonId(getCreatedPersonId());
        partnerArrearsOrder.setUpdatedPersonId(getUpdatedPersonId());
        return new PartnerArrearsOrderModel(partnerArrearsOrder);
    }

    private Integer payType2ArrearsType() {
        if (getPayType().equals(PayConstants.DEBT_PAID)) {
            return PartnerArrearsOperateTypeEnum.ARREARS.getKey();
        } else if (getPayType().equals(PayConstants.PRE_PAID)) {
            return PartnerArrearsOperateTypeEnum.PREPAID_DEPOSIT.getKey();
        }
        return null;
    }
}
