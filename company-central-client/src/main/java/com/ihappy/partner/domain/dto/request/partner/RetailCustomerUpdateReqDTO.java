package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.exception.PartnerException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/5/14.
 */
public class RetailCustomerUpdateReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = 184927810250535873L;
    @FieldComment(value = "会员名称", defaultValue = "", required = false)
    private String partnerName;
    @FieldComment(value = "会员id", defaultValue = "", required = true)
    private Long partnerId;
    @FieldComment(value = "手机号", defaultValue = "", required = true)
    private String mobile;
    @FieldComment(value = "头像地址", defaultValue = "", required = false)
    private String headPortraitAddress;
    @FieldComment(value = "开卡导购员id", defaultValue = "", required = true)
    private Long shoppingGuideId;
    @FieldComment(value = "门店id", defaultValue = "", required = true)
    private Long storeId;
    @FieldComment(value = "微信号", defaultValue = "", required = false)
    private String wechatAccountName;

    private String compName;

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

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadPortraitAddress() {
        return headPortraitAddress;
    }

    public void setHeadPortraitAddress(String headPortraitAddress) {
        this.headPortraitAddress = headPortraitAddress;
    }

    public Long getShoppingGuideId() {
        return shoppingGuideId;
    }

    public void setShoppingGuideId(Long shoppingGuideId) {
        this.shoppingGuideId = shoppingGuideId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
    }

    @Override
    public void validation() {
        if (partnerId == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_ID_IS_NULL.getErrMsg());
        }
        setUpdateTime(new Date());
        if (getLoginCompId() == null || getLoginCompId() <= 0 || getLoginPersonId() == null || getLoginPersonId() <= 0) {
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        if (mobile == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    MOBILE_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.MOBILE_IS_NULL.getErrMsg());
        }
        //会员名称为空的时候是会员加手机号
        if (StringUtil.isBlank(partnerName)) {
            partnerName = "会员" + "(" + mobile + ")";
        }
        //手机号为11位
        if (mobile.length() != 11) {
            throw new CompanyException(CompanyErrorCodeEnum.MOBILE_IS_NOT_ELEVEN_BITS);
        }
        //会员名称小于等于15位
        if (partnerName.length() > 15) {
            throw new CompanyException(CompanyErrorCodeEnum.PARTNER_NAME_LENTH_GREATER_THAN_15_BITS);
        }
        //微信号小于等于20字
        if (wechatAccountName.length() > 20) {
            throw new CompanyException(CompanyErrorCodeEnum.WECHAT_ACCOUNT_NAME_GREATER_THAN_20_BITS);
        }
    }
}
