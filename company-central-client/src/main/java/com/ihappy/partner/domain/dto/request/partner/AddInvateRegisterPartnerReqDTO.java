package com.ihappy.partner.domain.dto.request.partner;

import com.ihappy.partner.exception.PartnerException;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.gateway.dto.ICallRequestBaseDTO;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;

import java.util.Date;

/**
 * Created by sunjd on 2018/6/12.
 * 添加邀请注册的 供应商/客户
 */
public class AddInvateRegisterPartnerReqDTO extends ICallRequestBaseDTO {
    private static final long serialVersionUID = -4152529590227121069L;
    /**
     * 发起邀请公司di
     */
    private Long compId;

    /**
     * 接受邀请注册公司id
     */
    private Long partnerCompId;

    /**
     * 0、供应商 1、客户 2、零售会员
     */
    private Integer partnerType;
    /**
     * 被邀请注册公司手机号
     */
    private String registerCompanyMobile;
    /**
     * 伙伴名称
     */
    private String partnerName;
    /**
     * 消息发送用户
     */
    private Long receiveUserId;

    /**
     * 1.已存在（不需要设置密码）2.不存在（密码必传）
     */
    private Integer registType;

    public Integer getRegistType() {
        return registType;
    }

    public void setRegistType(Integer registType) {
        this.registType = registType;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getPartnerCompId() {
        return partnerCompId;
    }

    public void setPartnerCompId(Long partnerCompId) {
        this.partnerCompId = partnerCompId;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getRegisterCompanyMobile() {
        return registerCompanyMobile;
    }

    public void setRegisterCompanyMobile(String registerCompanyMobile) {
        this.registerCompanyMobile = registerCompanyMobile;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    @Override
    public void validation() {
        if (compId == null) {
            throw new PartnerException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (partnerCompId == null) {
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_COMPANY_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_COMPANY_ID_IS_NULL.getErrMsg());
        }
        if (partnerType == null){
            throw new PartnerException(PartnerErrorCodeEnum.
                    PARTNER_TYPE_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_TYPE_IS_NULL.getErrMsg());
        }
        if (registType == null){
            registType = 1;
        }
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }
}
