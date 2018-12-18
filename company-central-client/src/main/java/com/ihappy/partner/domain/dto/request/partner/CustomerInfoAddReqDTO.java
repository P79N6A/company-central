package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/1.
 */
public class CustomerInfoAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 7990079937539289676L;

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
            throw new PartnerException(PartnerErrorCodeEnum.
                    UPDATE_PERSON_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.UPDATE_PERSON_ID_IS_NULL.getErrMsg());
        }
    }

    /**
     * 企业id
     */
    private Integer compId;
    /**
     * 企业名称
     */
    private String compName;
    /**
     * 伙伴企业名
     */
    private String partnerName;
    /**
     * 0、供应商 1、客户
     */
    private Integer partnerType;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 创建人ID
     */
    private Integer createdPersonId;
    /**
     * 联系人
     */
    private String partnerLinkman;
    /**
     * 伙伴公司省
     */
    private String province;
    /**
     * 伙伴公司市
     */
    private String city;
    /**
     * 伙伴公司区县
     */
    private String zone;
    /**
     * 伙伴公司详细地址
     */
    private String partnerAddress;
    /**
     * 开户银行
     */
    private String bankName;
    /**
     * 银行账户
     */
    private String bankAccountName;
    /**
     * 银行账号
     */
    private String bankAccountNumber;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 传真
     */
    private String fax;
    /**
     * 伙伴备注
     */
    private String partnerMemo;
    /**
     * 头像地址
     */
    private String headPortraitAddress;

    /**
     * 欠款-单位分
     */
    private Long partnerArrears;
    /**
     * 电话
     */
    private String tel;
    /**
     * 合伙人等级
     */
    private Long partnerLevelId;
    @FieldComment(value = "微信号")
    private String wechatAccountName;

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
    }

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
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

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Integer createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public String getPartnerLinkman() {
        return partnerLinkman;
    }

    public void setPartnerLinkman(String partnerLinkman) {
        this.partnerLinkman = partnerLinkman;
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

    public String getPartnerAddress() {
        return partnerAddress;
    }

    public void setPartnerAddress(String partnerAddress) {
        this.partnerAddress = partnerAddress;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPartnerMemo() {
        return partnerMemo;
    }

    public void setPartnerMemo(String partnerMemo) {
        this.partnerMemo = partnerMemo;
    }

    public String getHeadPortraitAddress() {
        return headPortraitAddress;
    }

    public void setHeadPortraitAddress(String headPortraitAddress) {
        this.headPortraitAddress = headPortraitAddress;
    }

    public Long getPartnerArrears() {
        return partnerArrears;
    }

    public void setPartnerArrears(Long partnerArrears) {
        this.partnerArrears = partnerArrears;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public void validation() {
        if (compId == null) {
            throw new PartnerException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if(StringUtil.isEmpty(partnerLinkman)
                && StringUtil.isEmpty(partnerName)
                && StringUtil.isEmpty(mobile)
                && StringUtil.isEmpty(wechatAccountName)){
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_MOBILE_LINKMAN_NAME_WECHAT_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_MOBILE_LINKMAN_NAME_WECHAT_IS_NULL.getErrMsg());
        }
        if (partnerArrears == null) {
            partnerArrears = 0L;
        }
        //
        /**
         * 若保存时姓名字段为空，则依次按照以下规则或取名字：
         * 1，“客户”+手机号；
         * 2，“客户”+微信号；
         * 3，“客户”+联系人
         */
        if (StringUtil.isEmpty(partnerName) && !StringUtil.isEmpty(mobile)) {
            partnerName = "客户(" + mobile + ")";
        } else if (StringUtil.isEmpty(partnerName) && StringUtil.isEmpty(mobile) && !StringUtil.isEmpty(wechatAccountName)) {
            partnerName = "客户(" + wechatAccountName + ")";
        } else if (StringUtil.isEmpty(partnerName)
                && StringUtil.isEmpty(mobile)
                && StringUtil.isEmpty(wechatAccountName)
                && !StringUtil.isEmpty(partnerLinkman)) {
            partnerName = "客户(" + partnerLinkman + ")";
        }

        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
