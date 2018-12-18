package com.ihappy.company.domain.dto.request;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.common.constans.ValidatorConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/3/30.
 * 修改公司信息
 */
public class CompanyInfoUpdateReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 7398101527003542855L;

    /**
     * 获取修改创建人id
     *
     * @return
     */
    public Long personId() {
        if (super.getPerson()) {
            return super.getPersonUserInfoDTO().getPersonId();
        } else if (super.getSys()) {
            return super.getSysUserInfoDTO().getPersonId();
        } else {
            throw new CompanyException(CompanyErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
        }
    }

    @FieldComment(value = "LOGO")
    private String companyHead;
    /**
     * 公司id
     */
    private Integer compId;
    /**
     * 企业名称
     */
    @FieldComment(value = "名称")
    private String compShortName;
    /**
     * 公司性质(1 企业单位 2 个体经营)
     */
    @FieldComment(value = "企业类型")
    private Integer nature;
    /**
     * 公司业务分类名
     */
    private String ctIds;
    /**
     * 经营类目 按逗号隔开
     */
    @FieldComment(value = "经营范围")
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
    @FieldComment(value = "所在地区")
    private String area;
    /**
     * 详细地址
     */
    @FieldComment(value = "详细地址")
    private String compAddress;
    /**
     * 联系人
     */
    @FieldComment(value = "联系人")
    private String compLinkman;
    @FieldComment(value = "联系电话")
    private String compLinkmanTel;

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
     * 支付备注
     */
    private String payRemark;

    /**
     * 0：测试用户 1：线上用户
     */
    private Integer onlineOrTest;
    /**
     * 销售单是否通知供应商
     */
    private Integer orderSellerNotify;
    /**
     * 采购单是否通知供应商
     */
    private Integer orderBuyerNotify;

    @Override
    public void validation() {
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (compShortName != null && compShortName.length() > ValidatorConstans.MAX_ORGANIZATION_NAME_LENGTH) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    GREATER_THAN_MAX_ORGANIZATION_NAME_LENGTH.getErrCode(),
                    CompanyErrorCodeEnum.GREATER_THAN_MAX_ORGANIZATION_NAME_LENGTH.getErrMsg());
        }
        if (compLinkman != null && compLinkman.length() > ValidatorConstans.MAX_INDIVIDUAL_NAME_LENGTH) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    GREATER_THAN_MAX_INDIVIDUAL_NAME_LENGTH.getErrCode(),
                    CompanyErrorCodeEnum.GREATER_THAN_MAX_INDIVIDUAL_NAME_LENGTH.getErrMsg());
        }
        setUpdateTime(new Date());
    }

    public Integer getAllowNegativeOnHandSell() {
        return allowNegativeOnHandSell;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public void setAllowNegativeOnHandSell(Integer allowNegativeOnHandSell) {
        this.allowNegativeOnHandSell = allowNegativeOnHandSell;
    }

    public Integer getOrderSellerNotify() {
        return orderSellerNotify;
    }

    public void setOrderSellerNotify(Integer orderSellerNotify) {
        this.orderSellerNotify = orderSellerNotify;
    }

    public Integer getOrderBuyerNotify() {
        return orderBuyerNotify;
    }

    public void setOrderBuyerNotify(Integer orderBuyerNotify) {
        this.orderBuyerNotify = orderBuyerNotify;
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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompShortName() {
        return compShortName;
    }

    public void setCompShortName(String compShortName) {
        this.compShortName = compShortName;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
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

    public String getPrintWarn() {
        return printWarn;
    }

    public void setPrintWarn(String printWarn) {
        this.printWarn = printWarn;
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

    public String getCompLinkmanTel() {
        return compLinkmanTel;
    }

    public void setCompLinkmanTel(String compLinkmanTel) {
        this.compLinkmanTel = compLinkmanTel;
    }

    public Integer getOnlineOrTest() {
        return onlineOrTest;
    }

    public void setOnlineOrTest(Integer onlineOrTest) {
        this.onlineOrTest = onlineOrTest;
    }
}
