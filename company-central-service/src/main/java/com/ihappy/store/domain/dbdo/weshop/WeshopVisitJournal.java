package com.ihappy.store.domain.dbdo.weshop;

public class WeshopVisitJournal {
    private String uid; //用户身份标识
    private Integer uidType;  //表示 uid 存储的内容类型  0-未知  1-用户id  2-访问ip
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.weshop_visit_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Long weshopVisitId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.visit_token
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private String visitToken;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.visit_user_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Long visitUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.goods_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.visit_time
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Long visitTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.store_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Long storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.comp_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Integer compId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.created_at
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.updated_at
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.created_person_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Integer createdPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.updated_person_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Integer updatedPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weshop_visit_journal_0.is_deleted
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    private Boolean isDeleted;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getUidType() {
        return uidType;
    }

    public void setUidType(Integer uidType) {
        this.uidType = uidType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.weshop_visit_id
     *
     * @return the value of weshop_visit_journal_0.weshop_visit_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Long getWeshopVisitId() {
        return weshopVisitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.weshop_visit_id
     *
     * @param weshopVisitId the value for weshop_visit_journal_0.weshop_visit_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setWeshopVisitId(Long weshopVisitId) {
        this.weshopVisitId = weshopVisitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.visit_token
     *
     * @return the value of weshop_visit_journal_0.visit_token
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public String getVisitToken() {
        return visitToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.visit_token
     *
     * @param visitToken the value for weshop_visit_journal_0.visit_token
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setVisitToken(String visitToken) {
        this.visitToken = visitToken == null ? null : visitToken.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.visit_user_id
     *
     * @return the value of weshop_visit_journal_0.visit_user_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Long getVisitUserId() {
        return visitUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.visit_user_id
     *
     * @param visitUserId the value for weshop_visit_journal_0.visit_user_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setVisitUserId(Long visitUserId) {
        this.visitUserId = visitUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.goods_id
     *
     * @return the value of weshop_visit_journal_0.goods_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.goods_id
     *
     * @param goodsId the value for weshop_visit_journal_0.goods_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.visit_time
     *
     * @return the value of weshop_visit_journal_0.visit_time
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Long getVisitTime() {
        return visitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.visit_time
     *
     * @param visitTime the value for weshop_visit_journal_0.visit_time
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.store_id
     *
     * @return the value of weshop_visit_journal_0.store_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.store_id
     *
     * @param storeId the value for weshop_visit_journal_0.store_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.comp_id
     *
     * @return the value of weshop_visit_journal_0.comp_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.comp_id
     *
     * @param compId the value for weshop_visit_journal_0.comp_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.created_at
     *
     * @return the value of weshop_visit_journal_0.created_at
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.created_at
     *
     * @param createdAt the value for weshop_visit_journal_0.created_at
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.updated_at
     *
     * @return the value of weshop_visit_journal_0.updated_at
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.updated_at
     *
     * @param updatedAt the value for weshop_visit_journal_0.updated_at
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.created_person_id
     *
     * @return the value of weshop_visit_journal_0.created_person_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Integer getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.created_person_id
     *
     * @param createdPersonId the value for weshop_visit_journal_0.created_person_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setCreatedPersonId(Integer createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.updated_person_id
     *
     * @return the value of weshop_visit_journal_0.updated_person_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Integer getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.updated_person_id
     *
     * @param updatedPersonId the value for weshop_visit_journal_0.updated_person_id
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setUpdatedPersonId(Integer updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weshop_visit_journal_0.is_deleted
     *
     * @return the value of weshop_visit_journal_0.is_deleted
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weshop_visit_journal_0.is_deleted
     *
     * @param isDeleted the value for weshop_visit_journal_0.is_deleted
     *
     * @mbg.generated Mon May 21 13:08:46 CST 2018
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}