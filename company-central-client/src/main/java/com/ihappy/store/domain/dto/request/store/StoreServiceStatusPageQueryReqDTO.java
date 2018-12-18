package com.ihappy.store.domain.dto.request.store;

import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/10/19.
 */
public class StoreServiceStatusPageQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -8765293790075174551L;

    @FieldComment(value = "注册开始时间",required = false,defaultValue = "2018-10-16")
    private String registerStartTime;

    @FieldComment(value = "注册结束时间",required = false,defaultValue = "2018-10-17")
    private String registerEndTime;

    @FieldComment(value = "剩余有效日期",required = false,defaultValue = "")
    private Integer periodOfValidity;

    @FieldComment(value = "企业查询字段，企业名称，企业id",required = false,defaultValue = "")
    private String compShortName;
    @FieldComment(value = "企业id",required = false,defaultValue = "")
    private Long compId;

    @FieldComment(value = "门店查询字段，门店名称，门店id",required = false,defaultValue = "")
    private String storeName;

    @FieldComment(value = "门店id",required = false,defaultValue = "")
    private Long  storeId;

    @FieldComment(value = "老板手机号",required = false,defaultValue = "")
    private String bossMobile;

    @FieldComment(value = "业务类型 一批/二批的id",required = false,defaultValue = "")
    private String ctIds;

    @FieldComment(value = "过期时间",required = false,defaultValue = "")
    private Integer expireStatus;

    @FieldComment(value = "开始天数",required = false,defaultValue = "")
    private Integer startDay;

    @FieldComment(value = "结束天数",required = false,defaultValue = "")
    private Integer endDay;

    @FieldComment(value = "0黑名单 1普通 2白名单",required = false,defaultValue = "")
    private Integer status;

    @FieldComment(value = "备注者")
    private String payRemarkUserName;

    @FieldComment(value = "备注者id")
    private Long payRemarkUserId;

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

    public Integer getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Integer periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBossMobile() {
        return bossMobile;
    }

    public void setBossMobile(String bossMobile) {
        this.bossMobile = bossMobile;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
