package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/18.
 */
public class PartnerArrearsOrderAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 276120898379318904L;

    /**
     * 订单号
     */
    @FieldComment(value = "订单号" ,required = false,defaultValue = "" )
    private String  orderNum;
    /**
     * 合伙人ID redis序列 和 后四位由comp_id组成
     */
    @FieldComment(value = "合伙人ID redis序列 和 后四位由comp_id组成" ,required = true,defaultValue = "" )
    private Long  partnerId;
    /**
     * 企业id
     */
    @FieldComment(value = "企业id" ,required = false,defaultValue = "" )
    private Integer  compId;
    /**
     * 金额-单位分
     */
    @FieldComment(value = "金额-单位分" ,required = true,defaultValue = "" )
    private Long  money;
    /**
     * 收入类型  1、欠款增加 2、欠款减少
     */
    @FieldComment(value = "收入类型  1、欠款/预存款增加 2、欠款/预存款减少" ,required = false,defaultValue = "" )
    private Integer  incomeType;
    /**
     * 订单创建用户id
     */
    @FieldComment(value = "订单创建用户id" ,required = false,defaultValue = "" )
    private Long createdPersonId;
    /**
     * 订单编号
     */
    @FieldComment(value = "订单编号" ,required = false,defaultValue = "" )
    private String orderNo;
    /**
     * 订单类型
     */
    @FieldComment(value = "订单类型" ,required = false,defaultValue = "" )
    private Integer orderType;
    /**
     * 操作类型   0：保留值   null/1：欠款   2：预存款
     */
    @FieldComment(value = "操作类型   0：保留值   null/1：欠款   2：预存款" ,required = false,defaultValue = "" )
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Integer getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Override
    public void validation() {
        if (money == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    MONEY_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.MONEY_IS_NULL.getErrMsg());
        }
        if (partnerId == null || partnerId == 0){
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_ID_IS_NULL.getErrMsg());
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
