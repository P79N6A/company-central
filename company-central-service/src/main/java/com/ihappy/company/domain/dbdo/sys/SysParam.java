package com.ihappy.company.domain.dbdo.sys;

public class SysParam {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private Long paramId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.key
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private String paramKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.value
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private String paramValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.name
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private String paramName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.memo
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private String memo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.created_at
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.updated_at
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.created_person_id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private Long createdPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.updated_person_id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private Long updatedPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.is_deleted
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    private Integer isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.memo
     *
     * @return the value of sys_param.memo
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.memo
     *
     * @param memo the value for sys_param.memo
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.created_at
     *
     * @return the value of sys_param.created_at
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.created_at
     *
     * @param createdAt the value for sys_param.created_at
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.updated_at
     *
     * @return the value of sys_param.updated_at
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.updated_at
     *
     * @param updatedAt the value for sys_param.updated_at
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.created_person_id
     *
     * @return the value of sys_param.created_person_id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.created_person_id
     *
     * @param createdPersonId the value for sys_param.created_person_id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.updated_person_id
     *
     * @return the value of sys_param.updated_person_id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.updated_person_id
     *
     * @param updatedPersonId the value for sys_param.updated_person_id
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}