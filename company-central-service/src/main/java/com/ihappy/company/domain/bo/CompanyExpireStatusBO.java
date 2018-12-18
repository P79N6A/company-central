package com.ihappy.company.domain.bo;

/**
 * Created by liuhc on 2018/7/12.
 */
public class CompanyExpireStatusBO {

    /**
     * 公司id
     */
    private Integer compId;

    /**
     * 公司状态(1正常在线 0 停业下线
     */
    private Integer status;


    /**
     * 过期时间
     */
    private Long expireDate;

    /**
     * 备注
     */
    private String memo;

    /**
     * 修改时间
     */
    private Long updatedAt;

    /**
     * 修改人
     */
    private Long updatedPersonId;


    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }
}
