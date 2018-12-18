package com.ihappy.company.domain.dto.request;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.constans.ValidatorConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.RegexUtil;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyInfoAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -6631093558370476330L;

    /**
     * 获取修改创建人id
     * @return
     */
    public Long personId(){
        if (super.getPerson()){
            return super.getPersonUserInfoDTO().getPersonId();
        }else if(super.getSys()){
            return super.getSysUserInfoDTO().getPersonId();
        }else{
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
        }
    }
    /**
     * 企业名称
     */
    private String compName;
    /**
     * 企业简称
     */
    private String compShortName;
    /**
     * 公司介绍(富文本图文混编)
     */
     private String compMemo;
    /**
     * 大区id
     */
    private Integer regionId;
    /**
     * 大区名称
     */
     private String regionName;
    /**
     * 邮编
     */
    private String compZip;
    /**
     * 企业号(企业/个体户号)
     */
     private String license;
    /**
     * 企业号照片地址(企业/个体户号的照片)
     */
    private String licensePicurl;
    /**
     * 联系人电话
     */
    private String compLinkmanTel;
    /**
     * 页面显示排序(根据该排序号来确定在页面上位置，越小越在前面)
     */
     private Integer compSort;

    /**
     * 是否平台企业(0 不是平台企业，1是平台企业（只能有1个企业是平台企业，该字段是预置的，不能修改)
     */
    private Integer isPlatform;

    /**
     * 是否审核(0:待审核 1:审核通过 2:审核不通过)
     */
    private Integer isVerified;
    /**
     * 审核原因
     */
    private String verifiedReason;
    /**
     * 审核通过时间
     */
    private Integer verifiedTime;
    /**
     * 公司状态(1正常在线 0 停业下线)
     */
    private Integer status ;

    /**
     * 公司管理员id(必填字段，否则该公司无法自行管理)
     */
    @NotNull
    private Long adminPersonId;

    /**
     * 公司管理员姓名
     */
    private String adminPersonName;
    /**
     * 公司管理员手机号
     */
    private String adminPersonMobile;
    /**
     * 公司电话
     */
    private String tel;
    /**
     * 传真
     */
    private String fax;
    /**
     * 网址
     */
    private String website;
    /**
     * 备注
     */
    private String memo;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    @NotNull
    private Integer nature;
    /**
     * 公司业务分类名
     */
    private String ctNames;
    /**
     * 公司业务分类id
     */
    private String ctIds;
    /**
     *经营类目
     */
    private String businessCategory;
    /**
     * 省
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
     * 详细地址
     */
    private String compAddress;
    /**
     * 联系人
     */
    private String compLinkman;
    /**
     * 创建人id
     */
    private Long createdPersonId;

    /**
     * 开户银行
     */
    private String bankName;
    /**
     * 账户名称
     */
    private String bankAccountName;
    /**
     * 银行账号
     */
    private String bankAccountNumber;
    /**
     * 支付宝账号
     */
    private String alipayAccountName;
    /**
     * 微信账号
     */
    private String wechatAccountName;
    /**
     * 打印尺寸
     */
    private String printSize;
    /**
     * 单据名称
     */
    private String billName;
    /**
     * 微信账号二维码
     */
    private String wechatAccountQrcode;
    /**
     * 微信账号二维码内容
     */
    private String wechatAccountQrcodeContent;
    /**
     * 微信收款码
     */
    private String wechatReceiptQrcode;
    /**
     * 微信收款码内容
     */
    private String wechatReceiptQrcodeContent;
    /**
     * 支付宝账号二维码
     */
    private String alipayAccountQrcode;
    /**
     * 支付宝账号二维码内容
     */
    private String alipayAccountQrcodeContent;
    /**
     * 支付宝收款码
     */
    private String alipayReceiptQrcode;
    /**
     * 支付宝收款码内容
     */
    private String alipayReceiptQrcodeContent;

    /**
     * 是否打印账单 0：否  1：是（数据库默认1）
     */
    private Integer printBill;
    /**
     * 打印提醒
     * 提醒：钱款、件数请当面点清，离店概不负责，货物如有缺漏、损坏、到货请即通知，次品必需七天调换，不可退款，人为因素或逾期恕不退换，多谢合作！
     */
    private String printWarn;
    /**
     * 允许负库存销售标志  0：不允许  1：允许   默认：允许
     */
    private Integer allowNegativeOnHandSell;

    public Integer getAllowNegativeOnHandSell() {
        return allowNegativeOnHandSell;
    }

    public void setAllowNegativeOnHandSell(Integer allowNegativeOnHandSell) {
        this.allowNegativeOnHandSell = allowNegativeOnHandSell;
    }

    public String getPrintWarn() {
        return printWarn;
    }

    public void setPrintWarn(String printWarn) {
        this.printWarn = printWarn;
    }

    public Integer getPrintBill() {
        return printBill;
    }

    public void setPrintBill(Integer printBill) {
        this.printBill = printBill;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getAlipayAccountName() {
        return alipayAccountName;
    }

    public void setAlipayAccountName(String alipayAccountName) {
        this.alipayAccountName = alipayAccountName;
    }

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
    }

    public String getPrintSize() {
        return printSize;
    }

    public void setPrintSize(String printSize) {
        this.printSize = printSize;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public String getCompMemo() {
        return compMemo;
    }

    public void setCompMemo(String compMemo) {
        this.compMemo = compMemo;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCompZip() {
        return compZip;
    }

    public void setCompZip(String compZip) {
        this.compZip = compZip;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicensePicurl() {
        return licensePicurl;
    }

    public void setLicensePicurl(String licensePicurl) {
        this.licensePicurl = licensePicurl;
    }

    public String getCompLinkmanTel() {
        return compLinkmanTel;
    }

    public void setCompLinkmanTel(String compLinkmanTel) {
        this.compLinkmanTel = compLinkmanTel;
    }

    public Integer getCompSort() {
        return compSort;
    }

    public void setCompSort(Integer compSort) {
        this.compSort = compSort;
    }

    public Integer getIsPlatform() {
        return isPlatform;
    }

    public void setIsPlatform(Integer isPlatform) {
        this.isPlatform = isPlatform;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }

    public Integer getVerifiedTime() {
        return verifiedTime;
    }

    public void setVerifiedTime(Integer verifiedTime) {
        this.verifiedTime = verifiedTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAdminPersonId() {
        return adminPersonId;
    }

    public void setAdminPersonId(Long adminPersonId) {
        this.adminPersonId = adminPersonId;
    }

    public String getAdminPersonName() {
        return adminPersonName;
    }

    public void setAdminPersonName(String adminPersonName) {
        this.adminPersonName = adminPersonName;
    }

    public String getAdminPersonMobile() {
        return adminPersonMobile;
    }

    public void setAdminPersonMobile(String adminPersonMobile) {
        this.adminPersonMobile = adminPersonMobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getCtNames() {
        return ctNames;
    }

    public void setCtNames(String ctNames) {
        this.ctNames = ctNames;
    }

    public String getCtIds() {
        return ctIds;
    }

    public void setCtIds(String ctIds) {
        this.ctIds = ctIds;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
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

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompLinkman() {
        return compLinkman;
    }

    public void setCompLinkman(String compLinkman) {
        this.compLinkman = compLinkman;
    }

    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
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

    @Override
    public void validation() {
        if (nature == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_NATURE_ILLEGAL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_NATURE_ILLEGAL.getErrMsg());
        }
        if (adminPersonId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ADMIN_PERSON_ID_NULL_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.ADMIN_PERSON_ID_NULL_ERROR.getErrMsg());
        }
        if(compShortName != null &&  compShortName.length() > ValidatorConstans.MAX_ORGANIZATION_NAME_LENGTH){
            throw new CompanyException(CompanyErrorCodeEnum.
                    GREATER_THAN_MAX_ORGANIZATION_NAME_LENGTH.getErrCode(),
                    CompanyErrorCodeEnum.GREATER_THAN_MAX_ORGANIZATION_NAME_LENGTH.getErrMsg());
        }
        if (compLinkman != null && compLinkman.length() > ValidatorConstans.MAX_INDIVIDUAL_NAME_LENGTH){
            throw new CompanyException(CompanyErrorCodeEnum.
                    GREATER_THAN_MAX_INDIVIDUAL_NAME_LENGTH.getErrCode(),
                    CompanyErrorCodeEnum.GREATER_THAN_MAX_INDIVIDUAL_NAME_LENGTH.getErrMsg());
        }
        if (adminPersonMobile != null && !RegexUtil.isMobile(adminPersonMobile)){
            throw new CompanyException(CompanyErrorCodeEnum.
                    MOBILE_ILLLEGAL.getErrCode(),
                    CompanyErrorCodeEnum.MOBILE_ILLLEGAL.getErrMsg());
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
