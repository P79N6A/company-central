package com.ihappy.partner.domain.bo.partner;

import com.esotericsoftware.kryo.NotNull;

/**
 * Created by sunjd on 2018/6/5.
 * 判断Partner mobile是否重复service入参BO
 *
 * 当添加时 入参 mobile、partnerType、operate
 *   修改时 入参 compId、mobile、operate、partnerId、partnerType
 */
public class PartnerMobileIsRepetitionBO {
    /**
     * 公司id
     */
    @NotNull
    private Integer compId;
    /**
     * 电话
     */
    @NotNull
    private String mobile;
    /**
     * 操作类型
     * update  修改
     * add     添加
     */
    @NotNull
    private String operate;
    /**
     * partnerId
     */
    private Long partnerId;
    /**
     * 伙伴类型
     */
    private Integer partnerType;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }
}
