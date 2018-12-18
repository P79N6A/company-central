package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

import java.util.Date;

/**
 * Created by sunjd on 2018/6/28.
 */
public class CompanyExtendServiceAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -150482790148327451L;
    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 来源订单号
     */
    private String orderNo;
    /**
     * 金额-单位分
     */
    private Long money;
    /**
     * 来源  0、充值
     */
    private Integer sourceType;
    /**
     * 延长时间 单位（天）
     */
    private Integer time;
    /**
     * 来源订单的原始类型
     */
    private String orderType;
    /**
     * 资金状态 1-支付，2-收入
     */
    private Integer fundStatus;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(Integer fundStatus) {
        this.fundStatus = fundStatus;
    }

    @Override
    public void validation() {
        if (time == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    TIME_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.TIME_IS_NULL.getErrMsg());
        }
        if (compId == null || compId == 0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
