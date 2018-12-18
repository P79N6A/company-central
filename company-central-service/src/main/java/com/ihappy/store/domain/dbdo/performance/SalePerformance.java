package com.ihappy.store.domain.dbdo.performance;

public class SalePerformance {
    /**
     * 状态标识  1-表示改员工未设置业绩
     */
    private Integer performanceStatus;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.sale_performance_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long salePerformanceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.comp_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long compId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.store_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.store_name
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private String storeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long personId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.person_name
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private String personName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.avatar
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.aim_amount
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long aimAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.year_month
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Integer yearMonth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.created_at
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.updated_at
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.created_person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long createdPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.updated_person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Long updatedPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_performance_1.is_deleted
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    private Integer isDeleted;

    public Boolean noPerformance() {
        if (performanceStatus != null && performanceStatus == 1){
            return true;
        }else {
            return false;
        }
    }

    public Integer getPerformanceStatus() {
        return performanceStatus;
    }

    public void setPerformanceStatus(Integer performanceStatus) {
        this.performanceStatus = performanceStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.sale_performance_id
     *
     * @return the value of sale_performance_1.sale_performance_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getSalePerformanceId() {
        return salePerformanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.sale_performance_id
     *
     * @param salePerformanceId the value for sale_performance_1.sale_performance_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setSalePerformanceId(Long salePerformanceId) {
        this.salePerformanceId = salePerformanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.comp_id
     *
     * @return the value of sale_performance_1.comp_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.comp_id
     *
     * @param compId the value for sale_performance_1.comp_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.store_id
     *
     * @return the value of sale_performance_1.store_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.store_id
     *
     * @param storeId the value for sale_performance_1.store_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.store_name
     *
     * @return the value of sale_performance_1.store_name
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.store_name
     *
     * @param storeName the value for sale_performance_1.store_name
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.person_id
     *
     * @return the value of sale_performance_1.person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.person_id
     *
     * @param personId the value for sale_performance_1.person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.person_name
     *
     * @return the value of sale_performance_1.person_name
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.person_name
     *
     * @param personName the value for sale_performance_1.person_name
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.avatar
     *
     * @return the value of sale_performance_1.avatar
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.avatar
     *
     * @param avatar the value for sale_performance_1.avatar
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.aim_amount
     *
     * @return the value of sale_performance_1.aim_amount
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getAimAmount() {
        return aimAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.aim_amount
     *
     * @param aimAmount the value for sale_performance_1.aim_amount
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setAimAmount(Long aimAmount) {
        this.aimAmount = aimAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.year_month
     *
     * @return the value of sale_performance_1.year_month
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Integer getYearMonth() {
        return yearMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.year_month
     *
     * @param yearMonth the value for sale_performance_1.year_month
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.created_at
     *
     * @return the value of sale_performance_1.created_at
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.created_at
     *
     * @param createdAt the value for sale_performance_1.created_at
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.updated_at
     *
     * @return the value of sale_performance_1.updated_at
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.updated_at
     *
     * @param updatedAt the value for sale_performance_1.updated_at
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.created_person_id
     *
     * @return the value of sale_performance_1.created_person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.created_person_id
     *
     * @param createdPersonId the value for sale_performance_1.created_person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.updated_person_id
     *
     * @return the value of sale_performance_1.updated_person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.updated_person_id
     *
     * @param updatedPersonId the value for sale_performance_1.updated_person_id
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_performance_1.is_deleted
     *
     * @return the value of sale_performance_1.is_deleted
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_performance_1.is_deleted
     *
     * @param isDeleted the value for sale_performance_1.is_deleted
     *
     * @mbg.generated Tue Aug 28 14:41:42 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}