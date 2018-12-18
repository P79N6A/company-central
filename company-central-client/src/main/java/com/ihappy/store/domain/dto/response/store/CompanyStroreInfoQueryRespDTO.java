package com.ihappy.store.domain.dto.response.store;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.ihappy.store.domain.dto.response.BankInfoRespDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.List;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/11 14:52
 * @Version
 */
public class CompanyStroreInfoQueryRespDTO extends ICallResponseBaseDTO {
    @FieldComment(value = "门店头像")
    private String logoUrl;
    @FieldComment(value = "门店地址", defaultValue = "", required = false)
    private String address;
    @FieldComment(value = "门店面积", defaultValue = "", required = false)
    private Integer storeAcreage;
    @FieldComment(value = "门店联系人", defaultValue = "", required = false)
    private String storeContact;
    @FieldComment(value = "门店id", defaultValue = "", required = false)
    private Long storeId;
    @FieldComment(value = "门店名称", defaultValue = "", required = true)
    private String storeName;
    @FieldComment(value = "门店电话", defaultValue = "", required = false)
    private String storePhone;
    @FieldComment(value = "门店固定电话", defaultValue = "", required = false)
    private String storeTel;
    @FieldComment(value = "省", defaultValue = "", required = false)
    private String province;
    @FieldComment(value = "市", defaultValue = "", required = false)
    private String city;
    @FieldComment(value = "区", defaultValue = "", required = false)
    private String zone;
    @FieldComment(value = "是否禁用 0未禁用 1禁用")
    private Integer forbidden;
    @FieldComment(value = "相关属性")
    private String attributes;
    @FieldComment(value = "支付宝账号")
    private String alipayAccountName;
    @FieldComment(value = "支付宝收款码")
    private String alipayReceiptQrcode;
    @FieldComment(value = "支付宝收款码内容")
    private String alipayReceiptQrcodeContent;
    @FieldComment(value = "微信账号")
    private String wechatAccountName;
    @FieldComment(value = "微信账号二维码")
    private String wechatAccountQrcode;
    @FieldComment(value = "微信账号二维码内容")
    private String wechatAccountQrcodeContent;
    @FieldComment(value = "微信收款码")
    private String wechatReceiptQrcode;
    @FieldComment(value = "微信收款码内容")
    private String wechatReceiptQrcodeContent;
    @FieldComment(value = "员工id")
    private Long personId;
    @FieldComment(value = "银行信息")
    private List<BankInfoRespDTO> bankInfo;
    @FieldComment(value = "是否公共门店（总店 名称为 总仓） 0：不是  1：是")
    private Integer isPublic;

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<BankInfoRespDTO> getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(List<BankInfoRespDTO> bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public String getStoreContact() {
        return storeContact;
    }

    public void setStoreContact(String storeContact) {
        this.storeContact = storeContact;
    }

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

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
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

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
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
}
