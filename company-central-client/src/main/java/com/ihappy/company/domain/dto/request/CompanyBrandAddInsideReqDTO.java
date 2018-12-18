package com.ihappy.company.domain.dto.request;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;

import java.util.Date;

/**
 * Created by sunjd on 2018/5/9.
 */
public class CompanyBrandAddInsideReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -8982498526621074820L;
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
    private Long compId;
    /**
     * 品牌排序
     */
    private Integer brandSort;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandPicurl() {
        return brandPicurl;
    }

    public void setBrandPicurl(String brandPicurl) {
        this.brandPicurl = brandPicurl;
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

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getBrandSort() {
        return brandSort;
    }

    public void setBrandSort(Integer brandSort) {
        this.brandSort = brandSort;
    }

    @Override
    public void validation() {
        if (brandName == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    BRAND_NAME_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.BRAND_NAME_IS_NULL.getErrMsg());
        }
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
