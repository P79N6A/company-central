package com.ihappy.store.domain.dto.response.weshop;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by 汪正 on 2018/5/21.
 */
public class WeshopIndexDetailQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -7493001207208478463L;
    /**
     * 门店 Id
     */
    private Long storeId;

    /**
     * 门店名称
     */
    private String storeName;

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
     *  门店是否有效
     */
    private Boolean storeIsValidate;

    /**
     *   今日浏览量
     */
    private  Integer todayVisitCount;

    /**
     *  今日访问人数
     */
    private  Integer todayVisitUserCount;

    /**
     *   今日收藏量
     */
    private  Integer todayCollectionCount;

    /**
     *   累计浏览量
     */
    private  Integer totalVisitCount;
    /**
     *   累计访问人数
     */
    private  Integer totalVisitUserCount;

    /**
     *   累计收藏量
     */
    private  Integer totalCollectionCount;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public Boolean getStoreIsValidate() {
        return storeIsValidate;
    }

    public void setStoreIsValidate(Boolean storeIsValidate) {
        this.storeIsValidate = storeIsValidate;
    }

    public Integer getTodayVisitCount() {
        return todayVisitCount;
    }

    public void setTodayVisitCount(Integer todayVisitCount) {
        this.todayVisitCount = todayVisitCount;
    }

    public Integer getTodayVisitUserCount() {
        return todayVisitUserCount;
    }

    public void setTodayVisitUserCount(Integer todayVisitUserCount) {
        this.todayVisitUserCount = todayVisitUserCount;
    }

    public Integer getTodayCollectionCount() {
        return todayCollectionCount;
    }

    public void setTodayCollectionCount(Integer todayCollectionCount) {
        this.todayCollectionCount = todayCollectionCount;
    }

    public Integer getTotalVisitCount() {
        return totalVisitCount;
    }

    public void setTotalVisitCount(Integer totalVisitCount) {
        this.totalVisitCount = totalVisitCount;
    }

    public Integer getTotalVisitUserCount() {
        return totalVisitUserCount;
    }

    public void setTotalVisitUserCount(Integer totalVisitUserCount) {
        this.totalVisitUserCount = totalVisitUserCount;
    }

    public Integer getTotalCollectionCount() {
        return totalCollectionCount;
    }

    public void setTotalCollectionCount(Integer totalCollectionCount) {
        this.totalCollectionCount = totalCollectionCount;
    }
}
