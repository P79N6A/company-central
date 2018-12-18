package com.ihappy.company.domain.dto.request.companyinfo;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by sunjd on 2018/6/29.
 */
public class CompanyServiceStatusPageQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = 3652828454839709306L;
    /**
     * 注册开始时间
     */
    private Long registerStartTime;
    /**
     * 注册结束时间
     */
    private Long registerEndTime;
    /**
     * 公司账号
     */
    private String adminPersonMobile;
    /**
     * 剩余有效日期
     */
    private Integer periodOfValidity;
    /**
     * 备注者
     */
    private String payRemarkUserName;
    /**
     * 备注者id
     */
    private Long payRemarkUserId;
    /**
     * 公司业务类型id  一批/二批的id
     */
    private String ctId;

    /**
     * 0黑名单 1普通 2白名单
     */
    private Integer status;

    /**
     * 0:体验;1:付费-表示付过费了;
     */
    private Integer expireStatus;

    /**
     * 开始天数
     */
    private Integer startDay;

    /**
     * 结束天数
     */
    private Integer endDay;

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }

    public Long getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(Long registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public Long getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(Long registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public String getAdminPersonMobile() {
        return adminPersonMobile;
    }

    public void setAdminPersonMobile(String adminPersonMobile) {
        this.adminPersonMobile = adminPersonMobile;
    }

    public Integer getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Integer periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public String getPayRemarkUserName() {
        return payRemarkUserName;
    }

    public void setPayRemarkUserName(String payRemarkUserName) {
        this.payRemarkUserName = payRemarkUserName;
    }

    public Long getPayRemarkUserId() {
        return payRemarkUserId;
    }

    public void setPayRemarkUserId(Long payRemarkUserId) {
        this.payRemarkUserId = payRemarkUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
    }

    @Override
    public void validation() {
        if(startDay != null && startDay <0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }

        if(endDay != null && endDay <0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }

        if(endDay != null && startDay != null && startDay > endDay){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
