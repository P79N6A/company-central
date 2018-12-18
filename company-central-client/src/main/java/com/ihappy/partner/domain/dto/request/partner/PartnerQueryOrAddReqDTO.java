package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.common.util.StringUtil;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.exception.PartnerException;

/**
 * @program: company-central
 * @description: ${description}
 * @author: wangzheng
 * @create: 2018-11-01 19:45
 **/
public class PartnerQueryOrAddReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -5287655807200478805L;

    /**
     *  合伙人企业id
     */
    private Long partnerCompId;

    /**
     *  手机号
     */
    private String mobile;

    /**
     *
     *  合伙人类型  '0、供应商 1、客户 2、消费者
     */
    private Integer partnerType;

    /**
     * 公司ID
     */
    private Long compId;

    /**
     * 查询类型  1、上游供应商查询合伙人（合伙人为下游客户） 2、下游客户查询合伙人（合伙人为上游供应商）
     */
    private Integer type;

    public Long getPartnerCompId() {
        return partnerCompId;
    }

    public void setPartnerCompId(Long partnerCompId) {
        this.partnerCompId = partnerCompId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public void validation() {
        if(partnerCompId == null || partnerCompId <= 0l){
            throw new PartnerException(PartnerErrorCodeEnum.PARTNER_COMPANY_ID_IS_NULL);
        }
        if(StringUtil.isEmpty(mobile)){
            throw new PartnerException(PartnerErrorCodeEnum.PARTNER_MOBILE_IS_NULL);

        }
        if(partnerType == null || partnerType < 0){
            throw new PartnerException(PartnerErrorCodeEnum.PARTNER_TYPE_IS_NULL);
        }
        if(compId == null || compId <= 0l){
            throw new PartnerException(PartnerErrorCodeEnum.COMPANY_ID_IS_NULL);

        }
        if(type == null || type < 0){
            throw new PartnerException(PartnerErrorCodeEnum.QUERY_TYPE_IS_NULL);

        }
    }
}