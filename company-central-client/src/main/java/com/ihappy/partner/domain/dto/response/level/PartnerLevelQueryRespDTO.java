package com.ihappy.partner.domain.dto.response.level;

import com.ihappy.gateway.dto.ICallResponseBaseDTO;

/**
 * Created by sunjd on 2018/4/26.
 */
public class PartnerLevelQueryRespDTO extends ICallResponseBaseDTO {
    private static final long serialVersionUID = -7616359105350389603L;
    /**
     * 客户等级id
     */
    private Long partnerLevelId;
    /**
     * 企业id 0表示默认折扣率
     */
    private Integer compId;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 会员等级
     */
    private String partnerLevel;
    /**
     * 会员等级说明
     */
    private String partnerMemo;
    /**
     * 伙伴分类 0、供应商 1、客户
     */
    private Integer partnerType;
    /**
     * 折扣率 1-99 整数
     */
    private Integer discount;

    /**
     * 是否默认 1-是默认，0-不是默认
     */
    private Integer isDefault;
    /**
     * 是否可编辑，0-不可以，1-可以
     */
    private Integer isCanEdit;

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getIsCanEdit() {
        return isCanEdit;
    }

    public void setIsCanEdit(Integer isCanEdit) {
        this.isCanEdit = isCanEdit;
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPartnerLevel() {
        return partnerLevel;
    }

    public void setPartnerLevel(String partnerLevel) {
        this.partnerLevel = partnerLevel;
    }

    public String getPartnerMemo() {
        return partnerMemo;
    }

    public void setPartnerMemo(String partnerMemo) {
        this.partnerMemo = partnerMemo;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
