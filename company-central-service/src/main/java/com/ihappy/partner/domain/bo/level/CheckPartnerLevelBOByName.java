package com.ihappy.partner.domain.bo.level;

/**
 * Created by liuhc on 2018/8/8.
 */
public class CheckPartnerLevelBOByName {

    /**
     * 公司ID
     */
    private Long compId;

    /**
     * 名称
     */
    private String partnerLevel;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    private Long partnerLevelId;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getPartnerLevel() {
        return partnerLevel;
    }

    public void setPartnerLevel(String partnerLevel) {
        this.partnerLevel = partnerLevel;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }
}
