package com.ihappy.company.domain.dto.response.companyverify;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyInfoVerifyReadRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -4647588807129992816L;
    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 企业名称
     */
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    private Integer nature;
    /**
     * 公司性质汉字
     */
    private String natureStr;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String zone;
    /**
     * 详细地址
     */
    private String compAddress;
    /**
     * 公司业务分类名
     */
    private String ctNames;
    /**
     * 公司业务分类id
     */
    private String ctIds;
    /**
     *经营类目
     */
    private String businessCategory;
    /**
     *经营类目汉字
     */
    private String businessCategoryStr;
    /**
     * 公司管理员id
     */
    private Long adminPersonId;
    /**
     * 公司管理员账号
     */
    private String adminPersonAccount;
    /**
     * 企业法人
     */
    private String legalMan;
    /**
     * 身份证正面url
     */
    private String cardFrontUrl;
    /**
     * 身份证反面url
     */
    private String cardBackUrl;
    /**
     * 企业号(企业/个体户号)
     */
    private String license;
    /**
     * 企业号照片地址(企业/个体户号的照片)
     */
    private String licensePicurl;
    /**
     * 审核状态(0:未认证 1:待审核 2:审核通过 3:审核不通过)
     */
    private Integer isVerified;
    /**
     * 审核状态-汉字
     */
    private String isVerifiedStr;
    /**
     * 备注-审核原因
     */
    private String verifiedReason;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getNatureStr() {
        return natureStr;
    }

    public void setNatureStr(String natureStr) {
        this.natureStr = natureStr;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCtNames() {
        return ctNames;
    }

    public void setCtNames(String ctNames) {
        this.ctNames = ctNames;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessCategoryStr() {
        return businessCategoryStr;
    }

    public void setBusinessCategoryStr(String businessCategoryStr) {
        this.businessCategoryStr = businessCategoryStr;
    }

    public Long getAdminPersonId() {
        return adminPersonId;
    }

    public void setAdminPersonId(Long adminPersonId) {
        this.adminPersonId = adminPersonId;
    }

    public String getAdminPersonAccount() {
        return adminPersonAccount;
    }

    public void setAdminPersonAccount(String adminPersonAccount) {
        this.adminPersonAccount = adminPersonAccount;
    }

    public String getLegalMan() {
        return legalMan;
    }

    public void setLegalMan(String legalMan) {
        this.legalMan = legalMan;
    }

    public String getCardFrontUrl() {
        return cardFrontUrl;
    }

    public void setCardFrontUrl(String cardFrontUrl) {
        this.cardFrontUrl = cardFrontUrl;
    }

    public String getCardBackUrl() {
        return cardBackUrl;
    }

    public void setCardBackUrl(String cardBackUrl) {
        this.cardBackUrl = cardBackUrl;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicensePicurl() {
        return licensePicurl;
    }

    public void setLicensePicurl(String licensePicurl) {
        this.licensePicurl = licensePicurl;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getIsVerifiedStr() {
        return isVerifiedStr;
    }

    public void setIsVerifiedStr(String isVerifiedStr) {
        this.isVerifiedStr = isVerifiedStr;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }
}
