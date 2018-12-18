package com.ihappy.company.domain.dto.response;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

/**
 * Created by sunjd on 2018/3/30.
 */
public class CompanyInfoQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = 1931697766605522405L;
    /**
     * 公司id
     */
    @FieldComment(value = "公司id")
    private Integer compId;
    /**
     * 企业名称（已认证才会有值）
     */
    @FieldComment(value = "公司名称")
    private String compName;
    /**
     * 企业名称
     */
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
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
     * 经营类目 按逗号隔开
     */
    private String businessCategory;
    /**
     * 经营类目汉字 按逗号隔开
     */
    private String businessCategoryStr;
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

    /**
     * 公司电话
     */
    private String tel;
    /**
     * 联系人电话
     */
    private String compLinkmanTel;
    /**
     * 所在地区
     */
    private String area;

    /**
     * 公司头像
     *
     * @return
     */
    private String companyHead;
    @FieldComment(value = "公司管理员id")
    private Long adminPersonId;

    /**
     * 0：测试用户 1：线上用户
     */
    private Integer onlineOrTest;

    @FieldComment(value = "打印模式0-蓝牙 1-服务")
    private Integer printMode;

    @FieldComment(value = "0黑名单  1普通 2白名单")
    private Integer status;
    @FieldComment(value = "销售单是否通知客户")
    private Integer orderSellerNotify;
    @FieldComment(value = "采购单是否通知供应商")
    private Integer orderBuyerNotify;

    public Integer getOrderBuyerNotify() {
        return orderBuyerNotify;
    }

    public void setOrderBuyerNotify(Integer orderBuyerNotify) {
        this.orderBuyerNotify = orderBuyerNotify;
    }

    public Integer getOrderSellerNotify() {
        return orderSellerNotify;
    }

    public void setOrderSellerNotify(Integer orderSellerNotify) {
        this.orderSellerNotify = orderSellerNotify;
    }

    public String getCompanyHead() {
        return companyHead;
    }

    public void setCompanyHead(String companyHead) {
        this.companyHead = companyHead;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCompLinkmanTel() {
        return compLinkmanTel;
    }

    public void setCompLinkmanTel(String compLinkmanTel) {
        this.compLinkmanTel = compLinkmanTel;
    }

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

    public String getBusinessCategoryStr() {
        return businessCategoryStr;
    }

    public void setBusinessCategoryStr(String businessCategoryStr) {
        this.businessCategoryStr = businessCategoryStr;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
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

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
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

    public Long getAdminPersonId() {
        return adminPersonId;
    }

    public void setAdminPersonId(Long adminPersonId) {
        this.adminPersonId = adminPersonId;
    }

    public Integer getOnlineOrTest() {
        return onlineOrTest;
    }

    public void setOnlineOrTest(Integer onlineOrTest) {
        this.onlineOrTest = onlineOrTest;
    }

    public Integer getPrintMode() {
        return printMode;
    }

    public void setPrintMode(Integer printMode) {
        this.printMode = printMode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
