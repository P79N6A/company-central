package com.ihappy.company.domain.dbdo;

public class BaseinfoCompanyPrintConfig {


    /**
     * 模板类型 ：0-简易模板
     */
    private Integer barCodeTemplateType;

    /**
     * 是否优先打印单品条码:0- 不优先1-优先
     */
    private Integer firstPrintFlag;
    /**
     * 0：不立即打印  1：立即打印
     */
    private Integer immediatelyPrint;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.config_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Long configId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.comp_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Integer compId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.store_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Long storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.bill_type
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Integer billType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.bill_type_code
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Integer billTypeCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.print_bill
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Boolean printBill;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.print_num
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Integer printNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.print_size
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private String printSize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.bill_name
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private String billName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.print_warn
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private String printWarn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.created_at
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Long createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.updated_at
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Long updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.created_person_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Long createdPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.updated_person_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Long updatedPersonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.is_deleted
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column baseinfo_company_print_config.version
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    private Integer version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.config_id
     *
     * @return the value of baseinfo_company_print_config.config_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */

    private String billTypeName;

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public Long getConfigId() {
        return configId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.config_id
     *
     * @param configId the value for baseinfo_company_print_config.config_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.comp_id
     *
     * @return the value of baseinfo_company_print_config.comp_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.comp_id
     *
     * @param compId the value for baseinfo_company_print_config.comp_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.store_id
     *
     * @return the value of baseinfo_company_print_config.store_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.store_id
     *
     * @param storeId the value for baseinfo_company_print_config.store_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.bill_type
     *
     * @return the value of baseinfo_company_print_config.bill_type
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Integer getBillType() {
        return billType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.bill_type
     *
     * @param billType the value for baseinfo_company_print_config.bill_type
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.bill_type_code
     *
     * @return the value of baseinfo_company_print_config.bill_type_code
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Integer getBillTypeCode() {
        return billTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.bill_type_code
     *
     * @param billTypeCode the value for baseinfo_company_print_config.bill_type_code
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setBillTypeCode(Integer billTypeCode) {
        this.billTypeCode = billTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.print_bill
     *
     * @return the value of baseinfo_company_print_config.print_bill
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Boolean getPrintBill() {
        return printBill;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.print_bill
     *
     * @param printBill the value for baseinfo_company_print_config.print_bill
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setPrintBill(Boolean printBill) {
        this.printBill = printBill;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.print_num
     *
     * @return the value of baseinfo_company_print_config.print_num
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Integer getPrintNum() {
        return printNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.print_num
     *
     * @param printNum the value for baseinfo_company_print_config.print_num
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.print_size
     *
     * @return the value of baseinfo_company_print_config.print_size
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public String getPrintSize() {
        return printSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.print_size
     *
     * @param printSize the value for baseinfo_company_print_config.print_size
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setPrintSize(String printSize) {
        this.printSize = printSize == null ? null : printSize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.bill_name
     *
     * @return the value of baseinfo_company_print_config.bill_name
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public String getBillName() {
        return billName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.bill_name
     *
     * @param billName the value for baseinfo_company_print_config.bill_name
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.print_warn
     *
     * @return the value of baseinfo_company_print_config.print_warn
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public String getPrintWarn() {
        return printWarn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.print_warn
     *
     * @param printWarn the value for baseinfo_company_print_config.print_warn
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setPrintWarn(String printWarn) {
        this.printWarn = printWarn == null ? null : printWarn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.created_at
     *
     * @return the value of baseinfo_company_print_config.created_at
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.created_at
     *
     * @param createdAt the value for baseinfo_company_print_config.created_at
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.updated_at
     *
     * @return the value of baseinfo_company_print_config.updated_at
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.updated_at
     *
     * @param updatedAt the value for baseinfo_company_print_config.updated_at
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.created_person_id
     *
     * @return the value of baseinfo_company_print_config.created_person_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.created_person_id
     *
     * @param createdPersonId the value for baseinfo_company_print_config.created_person_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.updated_person_id
     *
     * @return the value of baseinfo_company_print_config.updated_person_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.updated_person_id
     *
     * @param updatedPersonId the value for baseinfo_company_print_config.updated_person_id
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.is_deleted
     *
     * @return the value of baseinfo_company_print_config.is_deleted
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.is_deleted
     *
     * @param isDeleted the value for baseinfo_company_print_config.is_deleted
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column baseinfo_company_print_config.version
     *
     * @return the value of baseinfo_company_print_config.version
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column baseinfo_company_print_config.version
     *
     * @param version the value for baseinfo_company_print_config.version
     *
     * @mbg.generated Fri Jun 01 14:33:11 CST 2018
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getImmediatelyPrint() {
        return immediatelyPrint;
    }

    public void setImmediatelyPrint(Integer immediatelyPrint) {
        this.immediatelyPrint = immediatelyPrint;
    }

    public Integer getBarCodeTemplateType() {
        return barCodeTemplateType;
    }

    public void setBarCodeTemplateType(Integer barCodeTemplateType) {
        this.barCodeTemplateType = barCodeTemplateType;
    }

    public Integer getFirstPrintFlag() {
        return firstPrintFlag;
    }

    public void setFirstPrintFlag(Integer firstPrintFlag) {
        this.firstPrintFlag = firstPrintFlag;
    }
}