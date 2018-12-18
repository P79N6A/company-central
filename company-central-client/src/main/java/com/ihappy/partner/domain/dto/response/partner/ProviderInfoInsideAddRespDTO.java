package com.ihappy.partner.domain.dto.response.partner;

import com.ihappy.common.util.StringUtil;
import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by Administrator on 2018/5/7.
 */
public class ProviderInfoInsideAddRespDTO extends ICallResponseBaseDTO {

    private static final long serialVersionUID = 1162969155005967360L;

    /**
     * 合伙人ID redis序列 和 后四位有comp_id组成
     */
    private Long partnerId;

    /**
     *合伙人企业名称
     */
    private String partnerName;

    /**
     * 0、供应商 1、客户
     */
    private Integer partnerType;

    /**
     * 合伙人等级
     */
    private Long partnerLevelId;

    /**
     * 合伙人等级等级
     */
    private String partnerLevelName;
    /**
     * 联系人
     */
    private String partnerLinkman;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 折扣
     */
    private Integer partnerDiscount;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
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

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }

    public String getPartnerLevelName() {
        return partnerLevelName;
    }

    public void setPartnerLevelName(String partnerLevelName) {
        this.partnerLevelName = partnerLevelName;
    }


    public String getPartnerLinkman() {
        if(partnerType==1){
            if(StringUtil.isBlank(partnerLinkman)){
                return partnerName;
            }
        }

        return partnerLinkman;
    }

    public void setPartnerLinkman(String partnerLinkman) {
        this.partnerLinkman = partnerLinkman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getPartnerDiscount() {
        return partnerDiscount;
    }

    public void setPartnerDiscount(Integer partnerDiscount) {
        this.partnerDiscount = partnerDiscount;
    }
}
