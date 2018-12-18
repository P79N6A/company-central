package com.ihappy.partner.domain.dbdo;

public class BaseinfoCompanyPartnerLevel {
    /**
     * 是否默认 1-是默认，0-不是默认
     */
    private Integer isDefault;
    /**
     * 是否可编辑，0-不可以，1-可以
     */
    private Integer isCanEdit;
    private Integer referenceCount;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.partner_level_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Long partnerLevelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.comp_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Integer compId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.store_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Long storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.partner_level
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private String partnerLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.partner_memo
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private String partnerMemo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.partner_type
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Integer partnerType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.discount
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Integer discount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.sort
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.created_at
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.updated_at
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.created_person_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Long createdPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.updated_person_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Long updatedPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_partner_level_0.is_deleted
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    private Integer isDeleted;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getIsCanEdit() {
        return isCanEdit;
    }

    public void setIsCanEdit(Integer isCanEdit) {
        this.isCanEdit = isCanEdit;
    }

    public Integer getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(Integer referenceCount) {
        this.referenceCount = referenceCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.partner_level_id
     *
     * @return the value of baseinfo_company_partner_level_0.partner_level_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.partner_level_id
     *
     * @param partnerLevelId the value for baseinfo_company_partner_level_0.partner_level_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.comp_id
     *
     * @return the value of baseinfo_company_partner_level_0.comp_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.comp_id
     *
     * @param compId the value for baseinfo_company_partner_level_0.comp_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.store_id
     *
     * @return the value of baseinfo_company_partner_level_0.store_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.store_id
     *
     * @param storeId the value for baseinfo_company_partner_level_0.store_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.partner_level
     *
     * @return the value of baseinfo_company_partner_level_0.partner_level
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public String getPartnerLevel() {
        return partnerLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.partner_level
     *
     * @param partnerLevel the value for baseinfo_company_partner_level_0.partner_level
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setPartnerLevel(String partnerLevel) {
        this.partnerLevel = partnerLevel == null ? null : partnerLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.partner_memo
     *
     * @return the value of baseinfo_company_partner_level_0.partner_memo
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public String getPartnerMemo() {
        return partnerMemo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.partner_memo
     *
     * @param partnerMemo the value for baseinfo_company_partner_level_0.partner_memo
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setPartnerMemo(String partnerMemo) {
        this.partnerMemo = partnerMemo == null ? null : partnerMemo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.partner_type
     *
     * @return the value of baseinfo_company_partner_level_0.partner_type
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Integer getPartnerType() {
        return partnerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.partner_type
     *
     * @param partnerType the value for baseinfo_company_partner_level_0.partner_type
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.discount
     *
     * @return the value of baseinfo_company_partner_level_0.discount
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.discount
     *
     * @param discount the value for baseinfo_company_partner_level_0.discount
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.sort
     *
     * @return the value of baseinfo_company_partner_level_0.sort
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.sort
     *
     * @param sort the value for baseinfo_company_partner_level_0.sort
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.created_at
     *
     * @return the value of baseinfo_company_partner_level_0.created_at
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.created_at
     *
     * @param createdAt the value for baseinfo_company_partner_level_0.created_at
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.updated_at
     *
     * @return the value of baseinfo_company_partner_level_0.updated_at
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.updated_at
     *
     * @param updatedAt the value for baseinfo_company_partner_level_0.updated_at
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.created_person_id
     *
     * @return the value of baseinfo_company_partner_level_0.created_person_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.created_person_id
     *
     * @param createdPersonId the value for baseinfo_company_partner_level_0.created_person_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.updated_person_id
     *
     * @return the value of baseinfo_company_partner_level_0.updated_person_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.updated_person_id
     *
     * @param updatedPersonId the value for baseinfo_company_partner_level_0.updated_person_id
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_partner_level_0.is_deleted
     *
     * @return the value of baseinfo_company_partner_level_0.is_deleted
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_partner_level_0.is_deleted
     *
     * @param isDeleted the value for baseinfo_company_partner_level_0.is_deleted
     *
     * @mbg.generated Thu Apr 26 13:23:57 CST 2018
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}