package com.ihappy.store.domain.dto.response.store;

import com.ihappy.store.domain.dto.response.BankInfoRespDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunjd on 2018/10/23.
 */
public class StoreQueryRespDTO implements Serializable {
    private static final long serialVersionUID = 7872495397244033409L;

    private Integer version;
    @FieldComment(value = "门店固定电话")
    private String storeTel;

    @FieldComment(value = "0:体验;1:付费")
    private Integer expireStatus;
    @FieldComment(value = "过期时间")
    private Long expireDate;
    @FieldComment(value = "付款备注")
    private String payRemark;
    @FieldComment(value = "备注者姓名")
    private String payRemarkUserName;
    @FieldComment(value = "备注者id")
    private Long payRemarkUserId;
    @FieldComment(value = "备注时间")
    private Long payRemarkTime;
    @FieldComment(value = "是否公共门店（总店） 0：不是  1：是")
    private Integer isPublic;
    @FieldComment(value = "是否默认门店   0：否   1：是")
    private Integer isDefault;

    private Long createdAt;

    private Long updatedAt;

    private Long createdPersonId;

    private Long updatedPersonId;

    /**
     * 微商铺名称
     */
    private String weshopName;
    /**
     * 微商铺logo
     */
    private String weshopLogoImages;
    /**
     * 微商铺管理人名称
     */
    private String weshopManagerName;
    /**
     * 微商铺管理人id
     */
    private Long weshopManagerId;
    /**
     * 微商铺联系方式
     */
    private String weshopContactType;
    /**
     * 微商铺主营商品分类
     */
    private String businessCategory;
    /**
     * 微商铺门头图片
     */
    private String weshopImages;
    /**
     * 微商铺公告
     */
    private String weshopNotice;
    /**
     * 为否开启微商铺公告
     */
    private Integer isOpenWeshopNotice;
    /**
     * 微商铺状态 0草稿，1发布, 2下线
     */
    private Integer weshopStatus;

    private Integer isDeletedWeshop;

    private String printIp;

    private String printPort;

    private Integer isHasWeshop;

    private String weshopProvince;

    private String weshopCity;

    private String weshopZone;

    private String weshopAddress;
    private Integer forbidden;
    private String alipayAccountName;
    private String alipayReceiptQrcode;
    private String alipayReceiptQrcodeContent;
    /**
     * 支付宝账号二维码
     */
    private String alipayAccountQrcode;
    /**
     * 支付宝账号二维码内容
     */
    private String alipayAccountQrcodeContent;
    private String wechatAccountName;
    private String wechatAccountQrcode;
    private String wechatAccountQrcodeContent;
    private String wechatReceiptQrcode;
    private String wechatReceiptQrcodeContent;

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

    private Integer isDeleted;

    @FieldComment(value = "是否公共门店  0-否 1-是")
    private Integer isPblic;
    @FieldComment(value = "银行信息")
    private List<BankInfoRespDTO> bankInfo;

    public List<BankInfoRespDTO> getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(List<BankInfoRespDTO> bankInfo) {
        this.bankInfo = bankInfo;
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

    public Integer getIsPblic() {
        return isPblic;
    }

    public void setIsPblic(Integer isPblic) {
        this.isPblic = isPblic;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getExpireStatus() {
        return expireStatus;
    }

    public void setExpireStatus(Integer expireStatus) {
        this.expireStatus = expireStatus;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getPayRemarkUserName() {
        return payRemarkUserName;
    }

    public void setPayRemarkUserName(String payRemarkUserName) {
        this.payRemarkUserName = payRemarkUserName;
    }

    public Long getPayRemarkUserId() {
        return payRemarkUserId;
    }

    public void setPayRemarkUserId(Long payRemarkUserId) {
        this.payRemarkUserId = payRemarkUserId;
    }

    public Long getPayRemarkTime() {
        return payRemarkTime;
    }

    public void setPayRemarkTime(Long payRemarkTime) {
        this.payRemarkTime = payRemarkTime;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Long getUpdatedPersonId() {
        return updatedPersonId;
    }

    public void setUpdatedPersonId(Long updatedPersonId) {
        this.updatedPersonId = updatedPersonId;
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

    public String getPrintIp() {
        return printIp;
    }

    public void setPrintIp(String printIp) {
        this.printIp = printIp;
    }

    public String getPrintPort() {
        return printPort;
    }

    public void setPrintPort(String printPort) {
        this.printPort = printPort;
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

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public String getAlipayAccountName() {
        return alipayAccountName;
    }

    public void setAlipayAccountName(String alipayAccountName) {
        this.alipayAccountName = alipayAccountName;
    }

    public String getAlipayReceiptQrcode() {
        return alipayReceiptQrcode;
    }

    public void setAlipayReceiptQrcode(String alipayReceiptQrcode) {
        this.alipayReceiptQrcode = alipayReceiptQrcode;
    }

    public String getAlipayReceiptQrcodeContent() {
        return alipayReceiptQrcodeContent;
    }

    public void setAlipayReceiptQrcodeContent(String alipayReceiptQrcodeContent) {
        this.alipayReceiptQrcodeContent = alipayReceiptQrcodeContent;
    }

    public String getAlipayAccountQrcode() {
        return alipayAccountQrcode;
    }

    public void setAlipayAccountQrcode(String alipayAccountQrcode) {
        this.alipayAccountQrcode = alipayAccountQrcode;
    }

    public String getAlipayAccountQrcodeContent() {
        return alipayAccountQrcodeContent;
    }

    public void setAlipayAccountQrcodeContent(String alipayAccountQrcodeContent) {
        this.alipayAccountQrcodeContent = alipayAccountQrcodeContent;
    }

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
    }

    public String getWechatAccountQrcode() {
        return wechatAccountQrcode;
    }

    public void setWechatAccountQrcode(String wechatAccountQrcode) {
        this.wechatAccountQrcode = wechatAccountQrcode;
    }

    public String getWechatAccountQrcodeContent() {
        return wechatAccountQrcodeContent;
    }

    public void setWechatAccountQrcodeContent(String wechatAccountQrcodeContent) {
        this.wechatAccountQrcodeContent = wechatAccountQrcodeContent;
    }

    public String getWechatReceiptQrcode() {
        return wechatReceiptQrcode;
    }

    public void setWechatReceiptQrcode(String wechatReceiptQrcode) {
        this.wechatReceiptQrcode = wechatReceiptQrcode;
    }

    public String getWechatReceiptQrcodeContent() {
        return wechatReceiptQrcodeContent;
    }

    public void setWechatReceiptQrcodeContent(String wechatReceiptQrcodeContent) {
        this.wechatReceiptQrcodeContent = wechatReceiptQrcodeContent;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }
}
