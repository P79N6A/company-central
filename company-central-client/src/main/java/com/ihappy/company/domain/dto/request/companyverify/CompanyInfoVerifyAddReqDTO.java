package com.ihappy.company.domain.dto.request.companyverify;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

import java.util.Date;

/**
 * Created by sunjd on 2018/6/6.
 */
public class CompanyInfoVerifyAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 5525807837792241738L;

    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 企业简称
     */
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    private Integer nature;
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

    @Override
    public void validation() {
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
