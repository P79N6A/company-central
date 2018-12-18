package com.ihappy.store.domain.dto.response.weshop;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-11 11:24
 */
public class WeshopDetailQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 482396353294019207L;

    /**
     * 门店 Id
     */
    private Long storeId;
    /**
     * 门店编号 同一个公司下编号唯一
     */
    private String storeNo;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 省 可以没有片区，直接从省开始
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
     * 门店地址
     */
    private String address;

    /**
     * 所属企业id
     */
    private Integer compId;

    /**
     *  微商铺名称
     */
    private String weshopName;
    /**
     *   微商铺logo
     */
    private String weshopLogoImages;
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
     *   微商铺主营商品分类
     */
    private String businessCategory;
    /**
     * 微商铺主营商品分类 汉字
     */
    private String businessCategoryStr;

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
     *   微商铺发布状态  状态（0草稿，1发布 , 2下线）
     */
    private Integer weshopStatus;

    /**
     *   微商铺上下架情况（0上架，1下架）
     */
    private Integer isDeletedWeshop;

    /**
     *  门店是否有效
     */
    private Boolean storeIsValidate;
    /**
     *  微商铺商品数量
     */
    private Integer itemNum;
    /**
     *   累计收藏量
     */
    private  Integer totalCollectionCount;
    /**
     * 微商铺地址
     */
    private String weshopAddress;

    private String weshopProvince;

    private String weshopCity;

    private String weshopZone;

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

    public Integer getTotalCollectionCount() {
        return totalCollectionCount;
    }

    public void setTotalCollectionCount(Integer totalCollectionCount) {
        this.totalCollectionCount = totalCollectionCount;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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

    public Boolean getStoreIsValidate() {
        return storeIsValidate;
    }

    public void setStoreIsValidate(Boolean storeIsValidate) {
        this.storeIsValidate = storeIsValidate;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public String getBusinessCategoryStr() {
        return businessCategoryStr;
    }

    public void setBusinessCategoryStr(String businessCategoryStr) {
        this.businessCategoryStr = businessCategoryStr;
    }
}
