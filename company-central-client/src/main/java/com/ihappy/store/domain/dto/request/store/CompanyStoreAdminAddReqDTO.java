package com.ihappy.store.domain.dto.request.store;


import com.ihappy.common.util.StringUtil;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dto.response.BankInfoRespDTO;
import com.ihappy.store.exception.StoreException;
import com.konglong.dubbo.annotation.FieldComment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 新增门店
 * Created by chenying on 2018/8/24.
 */
public class CompanyStoreAdminAddReqDTO extends ICallRequestBaseDTO {

    @FieldComment(value = "门店名称")
    private String storeName;

    @FieldComment(value = "地址")
    private String address;

    @FieldComment(value = "店铺面积")
    private Integer storeAcreage;

    @FieldComment(value = "门店固定电话")
    private String storeTel;

    @FieldComment(value = "门店电话")
    private String storePhone;

    @FieldComment(value = "省", defaultValue = "", required = false)
    private String province;
    @FieldComment(value = "市", defaultValue = "", required = false)
    private String city;
    @FieldComment(value = "区", defaultValue = "", required = false)
    private String zone;
    @FieldComment(value = "相关属性")
    private String bankInfo;
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
    @FieldComment(value = "联系人")
    private String storeContact;
    @FieldComment(value = "联系人ID")
    private Long storeContactId;

    public Long getStoreContactId() {
        return storeContactId;
    }

    public void setStoreContactId(Long storeContactId) {
        this.storeContactId = storeContactId;
    }

    public String getStoreContact() {
        return storeContact;
    }

    public void setStoreContact(String storeContact) {
        this.storeContact = storeContact;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    @Override
    public void validation() {
        if (StringUtil.isBlank(storeName)) {
            throw new StoreException(StoreErrorCodeEnum.
                    STORE_NAME_IS_NULL.getErrCode(),
                    StoreErrorCodeEnum.STORE_NAME_IS_NULL.getErrMsg());
        }
        if (this.getLoginCompId() ==null ||this.getLoginPersonId() ==null ||
                this.getLoginCompId() <=0 || this.getLoginPersonId() <=0 ){
            throw new StoreException(StoreErrorCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
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

}
