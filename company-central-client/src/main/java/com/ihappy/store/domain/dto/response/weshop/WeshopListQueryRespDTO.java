package com.ihappy.store.domain.dto.response.weshop;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by zhangtengpo on 2018/6/11.
 */
public class WeshopListQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -7493001207208478463L;
    /**
     * 门店 Id
     */
    private Long storeId;
    /**
     * 门店编号 同一个公司下编号唯一
     */
    private String storeNo;
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
     *  是否已收藏
     */
    private Boolean isCollected;

    public Boolean getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Boolean collected) {
        isCollected = collected;
    }

    public Integer getIsDeletedWeshop() {
        return isDeletedWeshop;
    }

    public void setIsDeletedWeshop(Integer isDeletedWeshop) {
        this.isDeletedWeshop = isDeletedWeshop;
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

    public Integer getWeshopStatus() {
        return weshopStatus;
    }

    public void setWeshopStatus(Integer weshopStatus) {
        this.weshopStatus = weshopStatus;
    }

    public Boolean getStoreIsValidate() {
        return storeIsValidate;
    }

    public void setStoreIsValidate(Boolean storeIsValidate) {
        this.storeIsValidate = storeIsValidate;
    }

}
