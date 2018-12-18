package com.ihappy.company.domain.bo;

/**
 * Created by liuhc on 2018/6/30.
 */
public class CancelOrderCompanyJournalBO {

    private Long orderId;

    /**
     * 修改时间
     */
    private Long updatedAt;

    /**
     * 审核人
     */
    private String auditorName;

    /**
     * 修改人
     */
    private Long updatedPersonId;

    private Integer version;

    /**
     * 0待审核.1作废,2审核通过
     */
    private Integer isCancel;

    /**
     * 服务时间
     */
    private Long serviceDueTime;

    /**
     *服务开始时间
     */
    private Long serviceStartTime;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public void setServiceDueTime(Long serviceDueTime) {
        this.serviceDueTime = serviceDueTime;
    }

    public Long getServiceDueTime() {
        return serviceDueTime;
    }

    public Long getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Long serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }
}
