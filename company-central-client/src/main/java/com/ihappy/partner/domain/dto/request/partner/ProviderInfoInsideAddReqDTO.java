package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;

/**
 * Created by Administrator on 2018/5/7.
 */
public class ProviderInfoInsideAddReqDTO extends ICallRequestBaseDTO {

    private static final long serialVersionUID = -5287655807200478805L;

    /**
     * 企业id comp_id
     */
    private  Integer buyerCompId;

    /**
     * 合伙人企业id  partner_comp_id
     */
    private Integer partnerCompId;

    /**
     * 合伙人企业名称
     */
    private String partnerName;

    /**
     * 创建人
     */
    private Long createdPersonId;

    /**
     * 0、供应商 1、客户
     */
    private Integer partnerType;
    /**
     *联系人
     */
    private String partnerLinkman;
    /**
     * 电话
     */
    private String mobile;

    public Integer getBuyerCompId() {
        return buyerCompId;
    }

    public void setBuyerCompId(Integer buyerCompId) {
        this.buyerCompId = buyerCompId;
    }

    public Integer getPartnerCompId() {
        return partnerCompId;
    }

    public void setPartnerCompId(Integer partnerCompId) {
        this.partnerCompId = partnerCompId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }


    public Long getCreatedPersonId() {
        return createdPersonId;
    }

    public void setCreatedPersonId(Long createdPersonId) {
        this.createdPersonId = createdPersonId;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getPartnerLinkman() {
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

    @Override
    public void validation() {
        if(createdPersonId == null || createdPersonId.longValue() < 0L
                || partnerCompId == null || partnerCompId.intValue() < 0L
                || buyerCompId == null || buyerCompId.intValue() <0L
                || partnerType == null || partnerType .intValue()<0L || partnerType >=2){
            throw new PartnerException(PartnerErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    PartnerErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
    }
}
