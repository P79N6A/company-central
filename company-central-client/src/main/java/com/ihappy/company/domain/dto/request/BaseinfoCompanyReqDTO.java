package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;

/**
 * Created by sunjd on 2018/3/29.
 */
public class BaseinfoCompanyReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -2328776143893589479L;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 企业名称(模糊查询)
     */
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    private Integer nature;
    /**
     * 公司业务分类id
     */
    private String ctIds;
    /**
     * 是否审核(0:待审核 1:审核通过 2:审核不通过)
     */
    private Integer isVerified;

    /**
     * 注册开始时间
     */
    private String registerStartTime;
    /**
     * 注册结束时间
     */
    private String registerEndTime;
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

    /**
     * 老板手机号
     */
    private String bossMobile;

    /**
     * 分页最大公司ID
     */
    private Integer maxCompId;

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public String getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(String registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public String getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(String registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public String getBossMobile() {
        return bossMobile;
    }

    public void setBossMobile(String bossMobile) {
        this.bossMobile = bossMobile;
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

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
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

    public Integer getMaxCompId() {
        return maxCompId;
    }

    public void setMaxCompId(Integer maxCompId) {
        this.maxCompId = maxCompId;
    }

    @Override
    public void validation() {
        if (this.getLimit() == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    PAGE_LIMIT_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.PAGE_LIMIT_IS_NULL.getErrMsg());
        }
        if (this.getLimit() > OptConstans.PAGE_LIMIT_MAX) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    PAGE_LIMIT_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.PAGE_LIMIT_IS_NULL.getErrMsg());
        }
        if (this.getOffset() == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    OFFSET_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.OFFSET_IS_NULL.getErrMsg());
        }
    }
}
