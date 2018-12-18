package com.ihappy.store.domain.dto.request.store;

import com.ihappy.gateway.dto.ICallRequestBaseDTO;

/**
 * @program: company-central
 * @description: 门店更新 微商铺等的信息，门店其他信息更新也可以在此增加字段进行更新。
 * @author: 汪正
 * @create: 2018-05-16 14:20
 **/
public class CompanyStoreUpdateReqDTO extends ICallRequestBaseDTO {

    private static final long serialVersionUID = 5390506506983027478L;

    /**
     * 门店id
     */
    private Long storeId;

    /**
     * 微商铺名称
     */
    private String weshopName;
    /**
     *  微商铺logo
     */
    private String  weshopLogoImages;

    /**
     *   微商铺管理人名称
     */
    private String weshopManagerName;
    /**
     *  微商铺管理人id
     */
    private Long weshopManagerId;
    /**
     *   微商铺联系方式
     */
    private String  weshopContactType;
    /**
     *   省
     */
    private String  weshopProvince;
    /**
     *   市
     */
    private String  weshopCity;
    /**
     *   区
     */
    private String  weshopZone;
    /**
     *   详细地址
     */
    private String  weshopAddress;

    /**
     *   微商铺主营商品分类
     */
    private String businessCategory;
    /**
     *   微商铺门头图片
     */
    private String weshopImages;
    /**
     *  微商铺公告
     */
    private String weshopNotice;
    /**
     *   为否开启微商铺公告
     */
    private Integer isOpenWeshopNotice;

    /**
     *   状态（0草稿，1发布）
     */
    private Integer weshopStatus;
    /**
     *   是否删除微商铺 0 未删除，1已删除
     */
    private Integer isDeletedWeshop;
    /**
     *   是否具有微商铺（默认0,0：无，1：有）
     */
    private Integer isHasWeshop;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWeshopName() {
        return weshopName;
    }

    public void setWeshopName(String weshopName) {
        this.weshopName = weshopName;
    }

    public String getWeshopLogoImages() {
        return weshopLogoImages;
    }

    public void setWeshopLogoImages(String weshopLogoImages) {
        this.weshopLogoImages = weshopLogoImages;
    }

    public String getWeshopManagerName() {
        return weshopManagerName;
    }

    public void setWeshopManagerName(String weshopManagerName) {
        this.weshopManagerName = weshopManagerName;
    }

    public Long getWeshopManagerId() {
        return weshopManagerId;
    }

    public void setWeshopManagerId(Long weshopManagerId) {
        this.weshopManagerId = weshopManagerId;
    }

    public String getWeshopContactType() {
        return weshopContactType;
    }

    public void setWeshopContactType(String weshopContactType) {
        this.weshopContactType = weshopContactType;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getWeshopImages() {
        return weshopImages;
    }

    public void setWeshopImages(String weshopImages) {
        this.weshopImages = weshopImages;
    }

    public String getWeshopNotice() {
        return weshopNotice;
    }

    public void setWeshopNotice(String weshopNotice) {
        this.weshopNotice = weshopNotice;
    }

    public Integer getIsOpenWeshopNotice() {
        return isOpenWeshopNotice;
    }

    public void setIsOpenWeshopNotice(Integer isOpenWeshopNotice) {
        this.isOpenWeshopNotice = isOpenWeshopNotice;
    }

    public Integer getWeshopStatus() {
        return weshopStatus;
    }

    public void setWeshopStatus(Integer weshopStatus) {
        this.weshopStatus = weshopStatus;
    }

    public Integer getIsDeletedWeshop() {
        return isDeletedWeshop;
    }

    public void setIsDeletedWeshop(Integer isDeletedWeshop) {
        this.isDeletedWeshop = isDeletedWeshop;
    }

    public Integer getIsHasWeshop() {
        return isHasWeshop;
    }

    public void setIsHasWeshop(Integer isHasWeshop) {
        this.isHasWeshop = isHasWeshop;
    }

    public String getWeshopProvince() {
        return weshopProvince;
    }

    public void setWeshopProvince(String weshopProvince) {
        this.weshopProvince = weshopProvince;
    }

    public String getWeshopCity() {
        return weshopCity;
    }

    public void setWeshopCity(String weshopCity) {
        this.weshopCity = weshopCity;
    }

    public String getWeshopZone() {
        return weshopZone;
    }

    public void setWeshopZone(String weshopZone) {
        this.weshopZone = weshopZone;
    }

    public String getWeshopAddress() {
        return weshopAddress;
    }

    public void setWeshopAddress(String weshopAddress) {
        this.weshopAddress = weshopAddress;
    }

    @Override
    public void validation() {

    }
}
