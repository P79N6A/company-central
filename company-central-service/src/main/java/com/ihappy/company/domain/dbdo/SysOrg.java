package com.ihappy.company.domain.dbdo;

public class SysOrg {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Long orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_name
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private String orgName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_path
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private String orgPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_no
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private String orgNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_memo
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private String orgMemo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.parent_orgid
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Integer parentOrgid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_depth
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Boolean orgDepth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.org_sort
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Integer orgSort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.comp_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Integer compId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.created_at
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Long createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.updated_at
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Long updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.created_person_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Long createdPersonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.updated_person_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Long updatedPersonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_org.is_deleted
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    private Boolean isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_id
     *
     * @return the value of sys_org.org_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_id
     *
     * @param orgId the value for sys_org.org_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_name
     *
     * @return the value of sys_org.org_name
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_name
     *
     * @param orgName the value for sys_org.org_name
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_path
     *
     * @return the value of sys_org.org_path
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public String getOrgPath() {
        return orgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_path
     *
     * @param orgPath the value for sys_org.org_path
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_no
     *
     * @return the value of sys_org.org_no
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public String getOrgNo() {
        return orgNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_no
     *
     * @param orgNo the value for sys_org.org_no
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_memo
     *
     * @return the value of sys_org.org_memo
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public String getOrgMemo() {
        return orgMemo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_memo
     *
     * @param orgMemo the value for sys_org.org_memo
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgMemo(String orgMemo) {
        this.orgMemo = orgMemo == null ? null : orgMemo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.parent_orgid
     *
     * @return the value of sys_org.parent_orgid
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Integer getParentOrgid() {
        return parentOrgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.parent_orgid
     *
     * @param parentOrgid the value for sys_org.parent_orgid
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setParentOrgid(Integer parentOrgid) {
        this.parentOrgid = parentOrgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_depth
     *
     * @return the value of sys_org.org_depth
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Boolean getOrgDepth() {
        return orgDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_depth
     *
     * @param orgDepth the value for sys_org.org_depth
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgDepth(Boolean orgDepth) {
        this.orgDepth = orgDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.org_sort
     *
     * @return the value of sys_org.org_sort
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Integer getOrgSort() {
        return orgSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.org_sort
     *
     * @param orgSort the value for sys_org.org_sort
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setOrgSort(Integer orgSort) {
        this.orgSort = orgSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.comp_id
     *
     * @return the value of sys_org.comp_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.comp_id
     *
     * @param compId the value for sys_org.comp_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.created_at
     *
     * @return the value of sys_org.created_at
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.created_at
     *
     * @param createdAt the value for sys_org.created_at
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.updated_at
     *
     * @return the value of sys_org.updated_at
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.updated_at
     *
     * @param updatedAt the value for sys_org.updated_at
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.created_person_id
     *
     * @return the value of sys_org.created_person_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.created_person_id
     *
     * @param createdPersonId the value for sys_org.created_person_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.updated_person_id
     *
     * @return the value of sys_org.updated_person_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.updated_person_id
     *
     * @param updatedPersonId the value for sys_org.updated_person_id
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org.is_deleted
     *
     * @return the value of sys_org.is_deleted
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org.is_deleted
     *
     * @param isDeleted the value for sys_org.is_deleted
     *
     * @mbggenerated Thu Jun 14 10:24:55 CST 2018
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}