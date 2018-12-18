package com.ihappy.company.domain.dbdo;

public class BaseinfoCompanyExtendServiceJournal {
    /**
     * 资金状态 1-支付，2-收入
     */
    private Integer fundStatus;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.journal_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Long journalId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.comp_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Integer compId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.order_no
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private String orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.money
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Long money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.source_type
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Integer sourceType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.time
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Integer time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.order_type
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private String orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.created_at
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.updated_at
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.created_person_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Long createdPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.updated_person_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Long updatedPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_extend_service_journal.is_deleted
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    private Boolean isDeleted;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.journal_id
     *
     * @return the value of baseinfo_company_extend_service_journal.journal_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Long getJournalId() {
        return journalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.journal_id
     *
     * @param journalId the value for baseinfo_company_extend_service_journal.journal_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.comp_id
     *
     * @return the value of baseinfo_company_extend_service_journal.comp_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.comp_id
     *
     * @param compId the value for baseinfo_company_extend_service_journal.comp_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.order_no
     *
     * @return the value of baseinfo_company_extend_service_journal.order_no
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.order_no
     *
     * @param orderNo the value for baseinfo_company_extend_service_journal.order_no
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.money
     *
     * @return the value of baseinfo_company_extend_service_journal.money
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Long getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.money
     *
     * @param money the value for baseinfo_company_extend_service_journal.money
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.source_type
     *
     * @return the value of baseinfo_company_extend_service_journal.source_type
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.source_type
     *
     * @param sourceType the value for baseinfo_company_extend_service_journal.source_type
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.time
     *
     * @return the value of baseinfo_company_extend_service_journal.time
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Integer getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.time
     *
     * @param time the value for baseinfo_company_extend_service_journal.time
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.order_type
     *
     * @return the value of baseinfo_company_extend_service_journal.order_type
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.order_type
     *
     * @param orderType the value for baseinfo_company_extend_service_journal.order_type
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.created_at
     *
     * @return the value of baseinfo_company_extend_service_journal.created_at
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.created_at
     *
     * @param createdAt the value for baseinfo_company_extend_service_journal.created_at
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.updated_at
     *
     * @return the value of baseinfo_company_extend_service_journal.updated_at
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.updated_at
     *
     * @param updatedAt the value for baseinfo_company_extend_service_journal.updated_at
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.created_person_id
     *
     * @return the value of baseinfo_company_extend_service_journal.created_person_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.created_person_id
     *
     * @param createdPersonId the value for baseinfo_company_extend_service_journal.created_person_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.updated_person_id
     *
     * @return the value of baseinfo_company_extend_service_journal.updated_person_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.updated_person_id
     *
     * @param updatedPersonId the value for baseinfo_company_extend_service_journal.updated_person_id
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_extend_service_journal.is_deleted
     *
     * @return the value of baseinfo_company_extend_service_journal.is_deleted
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_extend_service_journal.is_deleted
     *
     * @param isDeleted the value for baseinfo_company_extend_service_journal.is_deleted
     *
     * @mbg.generated Thu Jun 28 14:04:31 CST 2018
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(Integer fundStatus) {
        this.fundStatus = fundStatus;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}