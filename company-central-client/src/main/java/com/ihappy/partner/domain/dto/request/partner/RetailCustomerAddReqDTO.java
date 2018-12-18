package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;
import com.konglong.dubbo.annotation.FieldComment;

import java.util.Date;

/**
 * Created by sunjd on 2018/5/14.
 * 添加零售会员
 */
public class RetailCustomerAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -4717554327157959331L;
    @FieldComment(value = "会员名称", defaultValue = "", required = false)
    private String partnerName;
    @FieldComment(value = "手机号", defaultValue = "", required = true)
    private String mobile;
    @FieldComment(value = "头像地址",defaultValue = "",required = false)
    private String headPortraitAddress;
    @FieldComment(value = "微信号",defaultValue = "",required = false)
    private String wechatAccountName;
    @FieldComment(value = "门店id",defaultValue = "",required = false)
    private Long storeId;
    @FieldComment(value = "开卡导购id",defaultValue = "",required = false)
    private Long shoppingGuideId;

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

    public String getWechatAccountName() {
        return wechatAccountName;
    }

    public void setWechatAccountName(String wechatAccountName) {
        this.wechatAccountName = wechatAccountName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getShoppingGuideId() {
        return shoppingGuideId;
    }

    public void setShoppingGuideId(Long shoppingGuideId) {
        this.shoppingGuideId = shoppingGuideId;
    }

    @Override
    public void validation() {
        if (getLoginCompId() == null || getLoginCompId() <= 0 || getLoginPersonId() == null || getLoginPersonId() <= 0) {
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        //如果手机号为空，抛出异常
        if (mobile == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    MOBILE_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.MOBILE_IS_NULL.getErrMsg());
        }
        //会员名称为空的时候是会员加手机号
        if (StringUtil.isBlank(partnerName)){
            partnerName = "会员"+"("+mobile+")";
        }
        //手机号为11位
        if (mobile.length() != 11){
            throw new CompanyException(CompanyErrorCodeEnum.MOBILE_IS_NOT_ELEVEN_BITS);
        }
        //会员名称小于等于15位
        if (partnerName.length()>15){
            throw new CompanyException(CompanyErrorCodeEnum.PARTNER_NAME_LENTH_GREATER_THAN_15_BITS);
        }
        //微信号小于等于20字
        if (wechatAccountName.length()>20){
            throw new CompanyException(CompanyErrorCodeEnum.WECHAT_ACCOUNT_NAME_GREATER_THAN_20_BITS);
        }
    }
}
