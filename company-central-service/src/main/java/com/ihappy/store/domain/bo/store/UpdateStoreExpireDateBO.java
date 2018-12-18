package com.ihappy.store.domain.bo.store;

/**
 * Created by liuhc on 2018/10/18.
 */
public class UpdateStoreExpireDateBO {

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 公司ID
     */
    private Integer compId;

    /**
     * 过期时间
     */
    private Long expireDate;

    /**
     * 0:体验;1:付费
     */
    private Integer expireStatus;

    private Integer version;

    /**
     *更新时间
     */
    private Long updatedAt;

    /**
     *更新人
     */
    private Long updatedPersonId;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
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
}
