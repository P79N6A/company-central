package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/1.
 */
public class CompanyBrandListQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -7129548762609485649L;
    /**
     * 公司品牌id
     */
    private Integer brandId;
    /**
     * 公司品牌名称
     */
    private String brandName;
    /**
     * 品牌图标
     */
    private String brandPicurl;
    /**
     * 品牌注册商标号
     */
    private String brandLicense;
    /**
     * 品牌证书照片
     */
    private String brandLicensePicurl;
    /**
     * 品牌介绍
     */
    private String brandMemo;
    /**
     * 公司id
     */
    private Integer compId;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandPicurl() {
        return brandPicurl;
    }

    public void setBrandPicurl(String brandPicurl) {
        this.brandPicurl = brandPicurl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    public String getBrandLicense() {
        return brandLicense;
    }

    public void setBrandLicense(String brandLicense) {
        this.brandLicense = brandLicense;
    }

    public String getBrandLicensePicurl() {
        return brandLicensePicurl;
    }

    public void setBrandLicensePicurl(String brandLicensePicurl) {
        this.brandLicensePicurl = brandLicensePicurl;
    }

    public String getBrandMemo() {
        return brandMemo;
    }

    public void setBrandMemo(String brandMemo) {
        this.brandMemo = brandMemo;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
