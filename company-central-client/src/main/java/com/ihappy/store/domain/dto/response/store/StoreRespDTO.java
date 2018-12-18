package com.ihappy.store.domain.dto.response.store;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/13.
 */
public class StoreRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 1744151084618440381L;
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
     * 片区id  可以没有片区
     */
    private Integer storeRegionId;
    /**
     * 片区  华东，华南，华北，东南，东北
     */
    private String storeRegionName;
    /**
     * 地区id 最小地区的id
     */
    private Integer areaId;
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
     * 店铺面积
     */
    private Integer storeAcreage;
    /**
     * 邮政编码
     */
    private String zip;
    /**
     * 门店电话
     */
    private String storePhone;
    /**
     * 门店联系人
     */
    private String storeContact;
    /**
     * 店铺类型 0 直营店 1 加盟店 2 联营店
     */
    private Integer storeType;
    /**
     * 是否正常 0 关闭 1 正常营业
     */
    private Integer isValid;
    /**
     * 门店创建时间 unix时间戳
     */
    private Integer createTime;
    /**
     * 门店关闭时间
     */
    private Integer closeTime;
    /**
     * 门店营业时间
     */
    private String businessHours;
    /**
     * 是否开通了线上商城 0 未开通（默认） 1开通
     */
    private Integer online;
    /**
     * 高德坐标
     */
    private String location;
    /**
     * 店铺图标url
     */
    private String logoUrl;
    /**
     * 所属企业id
     */
    private Integer compId;
    /**
     * 门店管理员id
     */
    private Long adminPersonId;
    /**
     * 门店状态 1 开店申请中（处于正在申请开店的状态） 2 营业中（处于营业中状态的门店）3 闭店申请中（申请关闭店铺状态） 4 已关闭（已经关闭的门店）
     */
    private Integer status;
    /**
     * 经营类型 1 正常加盟 2 买断 3 买断加盟
     */
    private Integer managePattern;
    /**
     * 渠道类型 1 街铺 2 百货 3 购物中心 4、市场
     */
    private Integer channelType;
    /**
     * 排序 根据该排序号来确定在页面上位置，越小越在前面
     */
    private Integer sort;
    /**
     * 店铺介绍 300个字介绍
     */
    private String description;
    /**
     * 线上显示销量 0 不显示 1显示
     */
    private Integer onlineShowSales;
    /**
     * 线上显示库存  0 不显示 1显示
     */
    private Integer onlineShowStocks;
    /**
     * 付款减库存 0 不是 1是
     */
    private Integer onlineReduceAfterPayed;

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

    public Integer getStoreRegionId() {
        return storeRegionId;
    }

    public void setStoreRegionId(Integer storeRegionId) {
        this.storeRegionId = storeRegionId;
    }

    public String getStoreRegionName() {
        return storeRegionName;
    }

    public void setStoreRegionName(String storeRegionName) {
        this.storeRegionName = storeRegionName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getStoreAcreage() {
        return storeAcreage;
    }

    public void setStoreAcreage(Integer storeAcreage) {
        this.storeAcreage = storeAcreage;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreContact() {
        return storeContact;
    }

    public void setStoreContact(String storeContact) {
        this.storeContact = storeContact;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Long getAdminPersonId() {
        return adminPersonId;
    }

    public void setAdminPersonId(Long adminPersonId) {
        this.adminPersonId = adminPersonId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getManagePattern() {
        return managePattern;
    }

    public void setManagePattern(Integer managePattern) {
        this.managePattern = managePattern;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOnlineShowSales() {
        return onlineShowSales;
    }

    public void setOnlineShowSales(Integer onlineShowSales) {
        this.onlineShowSales = onlineShowSales;
    }

    public Integer getOnlineShowStocks() {
        return onlineShowStocks;
    }

    public void setOnlineShowStocks(Integer onlineShowStocks) {
        this.onlineShowStocks = onlineShowStocks;
    }

    public Integer getOnlineReduceAfterPayed() {
        return onlineReduceAfterPayed;
    }

    public void setOnlineReduceAfterPayed(Integer onlineReduceAfterPayed) {
        this.onlineReduceAfterPayed = onlineReduceAfterPayed;
    }
}
